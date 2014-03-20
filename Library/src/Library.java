/**
 * this class models a library with books
 * 
 * design questions:
 * - what does a library store?
 * - what kinds of operations are possible?
 * - do libraries interact with each other? if so, how?
 * - what is the process for borrowing a book here vs. from another library?
 * - what is the process for returning a book here vs. to another library?
 * 
 * a library has books and keeps track of their availability
 * it can be searched by title and possibly by other info like authors
 * books can be borrowed and returned locally, as well as via interlibrary loans
 * 
 * implementation questions:
 * - should the book's status be kept as an attribute of a book or of the library?
 * - should the library attributes (e.g. books, statuses) but public or private?
 * 
 * @author bohuie
 */
public class Library
{
  private String          name;
  private Book[]          books;
  private int             numBooks;             // index of current book

  // constants
  public final static int CAPACITY   = 2;       // a really small library!
  public final static int AVAILABLE  = 1;
  public final static int OUT        = 0;
  public final static int NOSUCHBOOK = 2;

  /**
   * constructor method
   * 
   * @param branch
   */
  public Library( String branch )
  {
    name = branch;
    books = new Book[CAPACITY];
    numBooks = 0;
  }

  /**
   * adds a book to the library
   * 
   * @param book
   * @return void
   */
  public void addBook( Book bk )
  {
    if( numBooks < CAPACITY )
    {
      bk.setBranch( name );
      books[numBooks] = bk;
      numBooks++;
    }
    // nothing happens if the library is full - just can't add anymore books
  }

  /**
   * print library books info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += "Library: " + name + "\n";
    for( int i = 0; i < numBooks; i++ )
      str += "  " + books[i].toString();
    return str;
  }
  
  /*************** methods above are for Q2 ***************/

  /**
   * helper method to print the status of a book
   * 
   * @param status
   * @return status
   */
  public static String prStatus( int val )
  {
    String str = "Unknown";
    if( val == AVAILABLE )
      str = "Available";
    else if( val == OUT )
      str = "Borrowed";
    else if( val == NOSUCHBOOK )
      str = "Not in library";
    return str;
  }
  
  /*************** methods above are for Q3 ***************/

  /**
   * search through all the books to see if the title is in the library
   * 
   * @param book title
   * @return index at which the book is found in the array or -1 if not found
   */
  private int findBook( String title )
  {
    int index = -1;

    // find the index of the book
    for( int i = 0; i < numBooks; i++ )
      if( books[i].getTitle().equalsIgnoreCase( title ) )
      {
        index = i;
        break;
      }

    return index;
  }

  /**
   * checks if a book is available to be borrowed and lets user do so if it is
   * 
   * @param title
   * @return void
   */
  public void borrowBook( String title )
  {
    int index = findBook( title );
    if( index < 0 ) 
      System.out.println( "The book you want is not in this library. Try another library." );
    else
    {
      if( books[index].getStatus() == AVAILABLE )
      {
        // change status of the book to be borrowed
        books[index].setStatus( OUT );
        System.out.println( "Please return the book in two weeks" );
        System.out.println( toString() );
      }
      else
        System.out.println( "The book you want is currently on loan. Try another time." );
    }
  }
  
  /**
   * returns a book back onto the library shelf
   * 
   * @param title
   * @return void
   */
  public void returnBook( String title )
  {
    int index = findBook( title );
    if( index < 0 )
      System.out.println( "We have no records of this book in this library. Try another library." );
    else
    {
      // change status of the book to be available
      books[index].setStatus( AVAILABLE );
      System.out.println( "Thank you for returning the book" );
      System.out.println( toString() );
    }
  }
  
  /*************** methods above are for Q4 ***************/
  
  /**
   * lets another class change the status of books in this library
   * 
   * @param bookIndex
   * @param status
   * @return void
   */
  private void changeStatus( int bookIndex, int status )
  {
    if( bookIndex >= 0 && bookIndex < numBooks )
      books[bookIndex].setStatus( status );    
  }

  /**
   * borrows a book from another library, so the code is modeled after borrowBook()
   * 
   * @param title
   * @param library
   * @return void
   */
  public void interlibraryLoan( String title, Library other )
  {
    // assure that the title is available in friend's collection
    int index = other.findBook( title );
    if( index < 0 )
      System.out.println( "The book you want is not at " + other.getName() );
    else
    {
      if( checkStatus( index ) == AVAILABLE )
      {
        // change status of the book to be borrowed
        other.changeStatus( index, OUT );
        System.out.println( "You are borrowing the book from " + other.getName() );
        System.out.println( "Please return the book in two weeks" );
        System.out.println( other.toString() );
      }
      else
        System.out.println( "The book you want is currently on loan. Try another library." );
    }
  }

  /**
   * returns a book to another library 
   * 
   * @param title
   * @param library
   * @return void
   */
  public void returnInterlibraryLoan( String title, Library other )
  {
    // check to make sure it really belongs to that library
    int index = other.findBook( title );
    if( index < 0 )
      System.out.println( "This book does not belong to that library. Try another library." );
    else
    {
      // change status of the book to be available
      other.changeStatus( index, AVAILABLE );
      System.out.println( "Thank you for returning the book to " + other.getName() );
      System.out.println( other.toString() );
    }
  }
  
  /*************** methods above are for Q5 ***************/

  /**
   * accessor for library name
   * 
   * @param void
   * @return name
   */
  public String getName()
  {
    return name;
  }

  /**
   * accessor for books in the library
   * 
   * @param void
   * @return books
   */
  public Book[] getBooks()
  {
    return books;
  }

  /**
   * lets other classes check the status of books in this library
   * 
   * @param bookIndex
   * @return status
   */
  private int checkStatus( int bookIndex )
  {
    int i = -1;
    if( bookIndex >= 0 && bookIndex < numBooks )
      i = books[bookIndex].getStatus();
    return i;
  }
}
