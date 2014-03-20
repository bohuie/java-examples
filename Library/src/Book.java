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
 * @author bowen hui
 */
public class Book
{
  private String title;
  private String author;
  private String publisher;
  private int    year;
  private String branch;
  private int    status;

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
    status    = Library.AVAILABLE;
  }

  /**
   * constructor method
   * 
   * @param title
   * @param author
   * @param publisher
   * @param year of publication
   * @param branch name
   * @param status
   */
  public Book( String t, String a, String p, int y, String b, int s )
  {
    title     = t;
    author    = a;
    publisher = p;
    year      = y;
    branch    = b;
    status    = s;
  }
  
  /**
   * mutators for class attributes
   * 
   * @param new value for class attribute
   * @return void
   */
  public void setBranch( String location ) { branch = location;  }
  public void setStatus( int newStatus )   { status = newStatus; }

  /**
   * accessors for class attributes
   * 
   * @param void
   * @return associated class attribute
   */
  public String getBranch() { return branch; }  
  public int    getStatus() { return status; }
  public String getTitle()  { return title;  }
  
  /**
   * gathers book info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += title + " (" + author + ", " + year + ") -- " + publisher;
    str += " [" + Library.prStatus( status );
    if( branch.equals( "" ) )
      str += "]\n";
    else
      str += " at " + branch + "]\n";
    return str;
  }
}