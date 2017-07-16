package vns;

import java.util.Scanner;
import java.util.ArrayList;

public class VNView {
  VNSocket vns = null;
  //VNTree vnt   = null;
  /*to implement - adding to the tree chould be based on a similarity of tags*/
  /*the relative depth of VNs should represent their (dis)simmilarity*/


  public VNView() {
    vns = new VNSocket();
    launch();
  }

  private void launch() {
    /*login*/
    //don't put your login in the source moron!!

  public void inputLoop() {

    Scanner key = new Scanner(System.in);
    String usrIn = "";
    String reply = "";

    /*input loop*/
    while(!usrIn.equals("quit")) {
      usrIn = key.nextLine();
      String[] tokens = usrIn.split(" ");

      if(tokens[0].equals("get")) {
        /*get VN*/
        if(tokens[1].equals("vn")) {
          if(tokens.length<4) {
            System.out.println("Insufiicient args");
            continue;
          }
          if(!tokens[2].contains("tags"))
            tokens[2] += ",tags"; //allways get tags

          reply = vns.getVN(tokens[2], tokens[3]).trim();
          VNObject nextVN = new VNObject(reply,Integer.parseInt(tokens[3]));
          System.out.println(reply);
          System.out.println("made new VN:\n" + nextVN);
        }
        else
          System.out.println(" get method not implemented");
      }
      else if(tokens[0].equals("set"))
        System.out.println("set method not implemented");
      else
        System.out.println("lolwut?");
    }
    System.out.println("Shutting down..");
  }



  public static void main(String[] args) {
    /*start the input loop*/
    VNView vnv = new VNView();
    vnv.inputLoop();
  }
}
