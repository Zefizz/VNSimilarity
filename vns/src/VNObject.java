package vns;

import java.util.ArrayList;

/* the list of tags should contain only the tag w/ score  */

public class VNObject {
  private String             name;
  private int                id;
  private ArrayList<VNTag>  tags;

  public VNObject() {
    name = "";
    id   = 0;
  }
  public VNObject(String reply, int id) {
    tags = VNParser.parseTags(reply);
    name = VNParser.parseTitle(reply);
    this.id = id;
  }
  public String toString() {
    return ("name:\t" + name + "\nid:\t" + id + "\ntags:\t" + tags);
  }

}
