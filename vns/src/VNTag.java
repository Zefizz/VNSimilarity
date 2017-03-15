package vns;

//these tags will containg the tag name,
//and the relavece to the VN

/* note that tags are given as [id,score,spointer] array of intgers
 * we will need to retrive the tag data from the API and populate a
 * dictionary on which to map id's to strings */

/* furthermore, we need to have more room in our buffer when getting tags */

public class VNTag {
  private int tag;
  private float relavence;  //how relavent the tag is to the related VN

  public VNTag() {
    tag       = 0;
    relavence = 0;
  }
  public VNTag(int tagId, float rel) {
    tag  = tagId;
    relavence = rel;
  }

  public String toString() {
    return (tag + " " + relavence);
  }
}
