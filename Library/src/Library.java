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
  private int             numBooks;
  private int[]           statuses;

  // constants
  public final static int CAPACITY   = 2;        // a really small library!
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
    statuses = new int[CAPACITY];
    numBooks = 0;
  }

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
  public Book[] getCollection()
  {
    return books;
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
      statuses[numBooks] = AVAILABLE;
      numBooks++;
    }
    // nothing happens if the library is full - just can't add anymore books
  }

  /**
   * identify the status of a book being searched for
   * 
   * @param book
   * @return status
   */
  public int getStatus( String title )
  {
    int index = -1;

    // find the index of the book
    for( int i = 0; i < numBooks; i++ )
      if( books[i].getTitle().equalsIgnoreCase( title ) )
      {
        index = i;
        break;
      }

    // return the status of the book in words
    if( index < 0 )
      System.out.println( prStatus( NOSUCHBOOK ) );
    else
      System.out.println( prStatus( statuses[index] ) );
    
    return index;
  }

  /**
   * helper method to print the status of a book
   * 
   * @param status
   * @return status
   */
  private String prStatus( int val )
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
  
  /**
   * checks if a book is available to be borrowed and lets user do so if it is
   * 
   * @param title
   * @return void
   */
  public void borrowBook( String title )
  {
    int index = getStatus( title );
    if( index < 0 ) 
      System.out.println( "The book you want is not in this library. Try another library." );
    else
    {
      if( statuses[index] == AVAILABLE )
      {
        // change status of the book to be borrowed
        statuses[index] = OUT;
        System.out.println( "Please return the book in two weeks" );
        System.out.println( toString() );
      }
      else
        System.out.println( "The book you want is currently on loan. Try another library." );
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
    int index = getStatus( title );
    if( index < 0 )
      System.out.println( "We have no records of this book in this library. Try another library." );
    else
    {
      // change status of the book to be available
      statuses[index] = AVAILABLE;
      System.out.println( "Thank you for returning the book" );
      System.out.println( toString() );
    }
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
      i = statuses[bookIndex];
    return i;
  }
  
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
      statuses[bookIndex] = status;    
  }

  /**
   * borrows a book from another library, so the code is modeled after borrowBook()
   * 
   * @param title
   * @param library
   * @return void
   */
  public void interlibraryLoan( String title, Library friend )
  {
    // assure that the title is available in friend's collection
    int index = friend.getStatus( title );
    if( index < 0 )
      System.out.println( "The book you want is not at " + friend.getName() );
    else
    {
      if( checkStatus( index ) == AVAILABLE )
      {
        // change status of the book to be borrowed
        friend.changeStatus( index, OUT );
        System.out.println( "You are borrowing the book from " + friend.getName() );
        System.out.println( "Please return the book in two weeks" );
        System.out.println( friend.toString() );
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
  public void returnInterlibraryLoan( String title, Library friend )
  {
    // check to make sure it really belongs to that library
    int index = friend.getStatus( title );
    if( index < 0 )
      System.out.println( "This book does not belong to that library. Try another library." );
    else
    {
      // change status of the book to be available
      friend.changeStatus( index, AVAILABLE );
      System.out.println( "Thank you for returning the book to " + friend.getName() );
      System.out.println( friend.toString() );
    }
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
      str += "  " + books[i].toString() + " [" + prStatus( statuses[i] )
          + "]\n";
    return str;
  }
}
