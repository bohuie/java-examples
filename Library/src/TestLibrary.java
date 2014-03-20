/**
 * this class tests the book and library
 * 
 * @author bowen hui
 */
public class TestLibrary
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    Book b1 = new Book( "Computer Networks", "A. Tanenbaum", "Prentice Hall", 2010 );
    Book b2 = new Book( "Software Engineering", "I. Sommerville", "Addison Wesley", 2010 );
    Book b3 = new Book( "Introduction to Algorithms", "CLR", "The MIT Press", 2009 );
    Book b4 = new Book( "Artificial Intelligence: A Modern Approach", "S. Russell", "Prentice Hall", 2009 );

    Library ubco = new Library( "UBCO" );
    Library ubc = new Library( "UBC" );
    Library sfu = new Library( "SFU" );

    // note that if we only had 4 books and add them to multiple libraries,
    // they only show up as references (not distinct objects) in the online
    // catalogue so the catalogue will have fewer than 6 actual (unique) books

    sfu.addBook( b1 );
    sfu.addBook( b2 );
    System.out.println( sfu.toString() );
    ubc.addBook( b3 );
    ubc.addBook( b4 );
    System.out.println( ubc.toString() );
    ubco.addBook( b2 );    
    ubco.addBook( b4 );    
    System.out.println( ubco.toString() );

    System.out.println( "********* Printing again ..." );
    System.out.println( sfu.toString() );
    System.out.println( ubc.toString() );
    System.out.println( ubco.toString() );
  }
}
