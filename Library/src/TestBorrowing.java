public class TestBorrowing
{
  public static void main( String[] args )
  {
    Book b1 = new Book( "Computer Networks", "A. Tanenbaum", "Prentice Hall", 2010 );
    Book b2 = new Book( "Software Engineering", "I. Sommerville", "Addison Wesley", 2010 );
    Book b3 = new Book( "Introduction to Algorithms", "CLR", "The MIT Press", 2009 );
    Book b4 = new Book( "Artificial Intelligence: A Modern Approach", "S. Russell", "Prentice Hall", 2009 );

    Library ubc = new Library( "UBC" );
    Library sfu = new Library( "SFU" );

    sfu.addBook( b1 );
    sfu.addBook( b2 );
    ubc.addBook( b3 );

    System.out.println( ubc.toString() );
    System.out.println( sfu.toString() );

    System.out.println( "********* Testing Borrowing Scenario #1: book doesn't exist ..." );
    System.out.println( "Checking '" + b1.getTitle() + "' at UBC: " );
    ubc.borrowBook( b1.getTitle() );

    System.out.println( "********* Testing Borrowing Scenario #2: book exist and available ..." );
    System.out.println( "Checking '" + b3.getTitle() + "' at UBC: " );
    ubc.borrowBook( b3.getTitle() );

    System.out.println( "********* Testing Borrowing Scenario #3: book exist but not available ..." );
    System.out.println( "Checking '" + b3.getTitle() + "' at UBC: " );
    ubc.borrowBook( b3.getTitle() );

    System.out.println( "********* Testing Returning Scenario #1: book belongs to library and it is returned ..." );
    ubc.returnBook( b3.getTitle() );

    System.out.println( "********* Testing Returning Scenario #2: book doesn't belong to library ..." );
    ubc.returnBook( b1.getTitle() );

    System.out.println( "********* Testing Interlibrary loan: borrowing ..." );
    System.out.println( "UBC will borrow '" + b1.getTitle() + "' from SFU: " );
    ubc.interlibraryLoan( b1.getTitle(), sfu );

    System.out.println( "********* Testing Interlibrary loan: returning ..." );
    System.out.println( "UBC will return '" + b1.getTitle() + "' to SFU: " );
    ubc.returnInterlibraryLoan( b1.getTitle(), sfu );
  }
}
