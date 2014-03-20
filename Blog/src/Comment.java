public class Comment extends Entry implements Comparable
{
  private Comment next;
  
  public Comment( String n, String t )
  {
    author = n;
    text = t;
    next = null;
  }
  
  // overload default constructor
  public Comment( String t )
  {
    author = "anonymous";
    text = t;
    next = null;
  }
  
  // accessors required for compareTo() and due to Entry class
  public String getAuthor() { return author; }
  public String getText() { return text; }

  // mutator required for linked list operations
  public void setNext( Comment node ) { next = node; }
  public Comment getNext() { return next; }
  
  public int compareTo( Object second )
  {
    Comment other = ( Comment )second;
    String both = author + text;
    String otherBoth = other.getAuthor() + other.getText();
    // System.out.println( both );
    // System.out.println( otherBoth );
    return both.compareTo( otherBoth );
  }

  // don't want to override parent's toString()
}
