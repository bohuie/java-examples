/**
 * this class models a book
 * 
 * design questions: 
 * - what info does this class need to store?
 * 
 * implementation questions: 
 * - are any accessors or mutators needed?
 * - if we wanted to store a 13-digit ISBN number, how would we store it?
 * 
 * @author bohuie
 */
public class Book
{
  private String title;
  private String author;
  private String publisher;
  private int    year;
  private String branch;

  /**
   * constructor method
   * 
   * @param title
   * @param author
   * @param publisher
   * @param year of publication
   */
  public Book( String t, String a, String p, int y )
  {
    title     = t;
    author    = a;
    publisher = p;
    year      = y;
    branch    = "";
  }

  /**
   * mutator for library branch
   * 
   * @param location
   * @return void
   */
  public void setBranch( String location )
  {
    branch = location;
  }

  /**
   * accessor for library branch
   * 
   * @param void
   * @return location
   */
  public String getBranch()
  {
    return branch;
  }
  
  /**
   * accessor for book title 
   * 
   * @param void
   * @return title
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * prints book info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += title + " (" + author + ", " + year + ") -- " + publisher;
    return str;
  }
}
