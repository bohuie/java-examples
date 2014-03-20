public class Post extends Entry
{
  private Comment clist;
  private int     numComments;

  public Post( String n, String t )
  {
    author = n;
    text = t;
    clist = null;
    numComments = 0;
  }

  // adds a node to end of clist
  public void add( Comment node )
  {
    Comment curr = clist;
    if( clist == null )
    {
      clist = node;
      numComments++;
    }
    else
    {
      while( curr.getNext() != null )
      {
        // go to next node
        curr = curr.getNext();
      }
      curr.setNext( node );
      numComments++;
    }
  }

  // deletes given node from clist if found
  public void delete( Comment node )
  {
    System.out.println( "***** inside delete() " );
    if( clist != null )
    {
      System.out.println( clist2str() );
            
      // look for target node
      Comment curr = clist;
      Comment prev = null;
      while( curr != null )
      {
        System.out.println( "Target Node: " + node.toString() );
        System.out.println( "Curr Node: " + curr.toString() );
        if( curr.compareTo( node ) != 0 )
        {
          // keep traversing
          prev = curr;
          curr = curr.getNext();
        }
        else
        {
          // found target node, delete it
          if( prev == null )            // case: target at beginning
            clist = curr.getNext();
          else
            prev.setNext( curr.getNext() );

          // must break out of loop
          numComments--;
          break;
        }
      }
    }
    // otherwise do nothing
    System.out.println( "***** leaving delete() " );
  }

  private String clist2str()
  {
    String str = "";
    str += "Comments (" + numComments + "):\n";
    Comment curr = clist;
    while( curr != null )
    {
      str += curr.toString() + "\n";
      curr = curr.getNext();
    }  
    return str;
  }

  public String toString()
  {
    String str = super.toString() + "\n";
    str += clist2str();
    return str;
  }

  // accessors required due to Entry class
  public String getAuthor() { return author; }
  public String getText() { return text; }
}
