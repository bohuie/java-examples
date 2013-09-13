/**
 * this class models an online catalogue of books across multiple libraries
 * 
 * design questions:
 * - what is the responsibility of an online catalogue?
 * - how does it interact with other libraries?
 * - should it store it's own collection of books?
 * 
 * an online catalogue is an aggregate of collections of books from several libraries
 * users should be able to search this catalogue and know where books are from
 * it's more efficient to store its own set of books
 * 
 * implementation questions:
 * - what is the capacity of the collection of books?
 * - how does it integrate books that already exist in libraries objects?
 * - what if there are multiple books of the same title?
 * - how should the books be ordered so that subsequent searches can be more efficient?
 * - how should new books be added to the collection in order to preserve this order?
 * 
 * @author bohuie
 * 
 */
public class Catalogue
{
  private Book[]          books;
  private int             numBooks;

  // constants
  public static final int CAPACITY = 100;
  public static final int UNDEF    = -1;
  
  /**
   * constructor method
   */
  public Catalogue()
  {
    books = new Book[CAPACITY];
    numBooks = 0;
  }
  
  /**
   * lets us add a book to the catalogue
   * 
   * @param book
   * @param location
   */
  public void addBook( Book bk, String location )
  {
    if( numBooks < CAPACITY )
    {
      books[numBooks] = bk;
      books[numBooks].setBranch( location );
      numBooks++;
    }
  }
  
  /**
   * adds an entire library collection of books to the online catalogue
   * 
   * @param collection of books
   * @param library location
   * @return void
   */
  public void addCollection( Book[] collec, String location )
  {
    // add each book in the collection to the online catalogue one at a time
    for( int i=0; i<collec.length; i++ )
    {
      if( numBooks < CAPACITY )
      {
        Book oneBook = collec[i];
        books[numBooks] = oneBook;
        books[numBooks].setBranch( location );
        numBooks++;
      }
    }
  }
  
  /**
   * searches for a book by title and returns corresponding array indices
   * 
   * @param book title
   * @return search result indices
   */
  public int[] searchBook( String title )
  {
    int[] result = new int[numBooks];
    int   count  = 0;
    System.out.println( "You searched for: " + title );
   
    // initialize results to undefined value
    for( int i=0; i<numBooks; i++ )
      result[i] = UNDEF;
    
    // search through each book in the collection to see if there's a match or not
    for( int i=0; i<numBooks; i++ )
    {
      if( books[i].getTitle().equalsIgnoreCase( title ) )
      {
        result[count] = i;
        count++;
      }
    }
    System.out.println( "Your search has " + count + " matches" );
    return result;
  }

  /**
   * processes the search results by printing them out to the user
   * 
   * @param search results indices
   * @return void
   */
  public void prMatches( int[] indices )
  {
    if( indices[0] == UNDEF )
      System.out.println( "No matches to display." );
    else
    {
      String str = "";
      for( int i=0; i<indices.length; i++ )
      {
        int indexValue = indices[i];
        if( indexValue != UNDEF )
          str += "  " + books[indexValue].getBranch() + ": "+ books[indexValue].toString() + "\n";
      }
      System.out.println( str );
    }
  }
  
  /**
   * prints catalogue of books with branch info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += "Online catalogue has the following books:\n";
    for( int i=0; i<numBooks; i++ )
      str += "  " + books[i].getBranch() + ": "+ books[i].toString() + "\n";
    return str;
  }

}
