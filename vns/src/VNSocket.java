package vns;

import java.net.Socket;
import java.io.*;

class VNSocket {
  private Socket sock          = null;
  private InputStream istream  = null;
  private OutputStream ostream = null;

  private static final char END_CHAR =  (char)0x04;
  private static final String client = "Ottawa_CU";
  private static final int MAX_RELPY_NORMAL = 1024;
  private static final int MAX_RELPY_TAGS   = 2048;

  //attempt to connect to the server upon creation
  public VNSocket() {
    try {
      sock = new Socket("api.vndb.org",19534);
      //connect an output stream to the socket
      ostream = sock.getOutputStream();
      //connect an input stream to the socket
      istream = sock.getInputStream();
    } catch(IOException e) {}
  }

  public String getVN(String options, String id) {
    return sendMessage("get vn "+options+" (id = " + id + ")");
  }

  //returns the DB stats
  public String stats() {
    return sendMessage("dbstats");
  }

  //send the login message to the server
  public boolean login(String user, String pass) {
    String message = "login {\"protocol\":\"1\",\"client\":";
    message += "\"" + client + "\"";
    message += ",\"clientver\":0.1}";

    String res = sendMessage(message);

    if(res.contains("error"))
      return false;
    return true;
  }

  //send a message to the server
  //return the response
  //TODO: check error responses
  private String sendMessage(String message) {
    //convert message into byte array. terminate with END_CHAR
    byte[] messageBytes = new byte[message.length()+1];
    for(int i=0; i<message.length();i++)
      messageBytes[i] = (byte)message.charAt(i);
    messageBytes[message.length()] = (byte)END_CHAR;

    String reply = "";
    try{
      //send the message to the server via the OutputStream
      ostream.write(messageBytes);

      //receive the reply via the InputStrea
      byte[] response;
      if(message.contains("tags"))
        response = new byte[MAX_RELPY_TAGS]; //tags can be vary large
      else
        response = new byte[MAX_RELPY_NORMAL];

      istream.read(response);

      //convert bye array into string (ty Java)
      reply = new String(response);

    } catch (IOException e) { System.out.println(e); }

    return reply;
  }
}
