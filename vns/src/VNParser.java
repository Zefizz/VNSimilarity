package vns;

import java.util.ArrayList;

public class VNParser {

  /*returns the tags in an arrrayList
   *@param: str should be the string containing the tags array*/
  public static ArrayList<VNTag> parseTags(String str) {
    /*cut the extra info out of the string*/
    String sub = str.substring(str.indexOf("[["),str.indexOf("]]")+2);
    String[] star = sub.split("]");
    ArrayList<VNTag> tagList = new ArrayList<VNTag>();

    for(String s : star) {  //first elem has [[, others have ,[
      s = s.substring(2);
      //System.out.println(s);
      //split it even further - push it to the limit!
      String[] temp = s.split(",");
      /*create the new tag*/
      VNTag nextTag = new VNTag(Integer.parseInt(temp[0]),Float.parseFloat(temp[1]) );
      tagList.add(nextTag); //append to end of list
    }
    return tagList;
  }

  /*parse the basic out of the supplied JSON string
   *@return: String array of the form [name,id]*/
  public static String parseTitle(String str) {
    /*get the title*/
    if(!str.contains("\"title\":")) //if we did not request basic info
      return "";
    String title = str.substring(str.indexOf("\"title\":\"")+9); //start from here
    return title.substring(0,title.indexOf("\"")); //until the next "
  }
  /*parse the name out of the supplied JSON string*/
  public static void parseId(String str) {
    //..
  }

}
