public class TestInter
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
    ubc.addBook( b4 );

    System.out.println( ubc.toString() );
    System.out.println( sfu.toString() );

    /*
    System.out.println( "********* Testing Catalogue ..." );
    Catalogue onlineSys = new Catalogue();
    
    // add books one at a time
    onlineSys.addBook( b1, sfu.getName() );
    onlineSys.addBook( b2, sfu.getName() );
    System.out.println( onlineSys.toString() );
    
    // add an entire library's collection at a time
    onlineSys.addCollection( ubc.getBooks(), ubc.getName() );
    onlineSys.addCollection( ubco.getBooks(), ubco.getName() );
    System.out.println( onlineSys.toString() );
    
    // search for books in the catalogue
    int[] rez;
    rez = onlineSys.searchBook( "Artificial Intelligence" );
    onlineSys.prMatches( rez );
    rez = onlineSys.searchBook( "Software Engineering" );
    onlineSys.prMatches( rez );
    */

    System.out.println( "********* Testing Borrowing Scenario #1: book doesn't exist ..." );
    System.out.println( "Checking '" + b1.getTitle() + "' at UBC: " );
    ubc.borrowBook( b1.getTitle() );

    System.out.println( "********* Testing Borrowing Scenario #2: book exist and available ..." );
    System.out.println( "Checking '" + b3.getTitle() + "' at UBC: " );
    ubc.borrowBook( b3.getTitle() );

    System.out.println( "********* Testing Borrowing Scenario #3: book exist but not available ..." );
    System.out.println( "Checking '" + b3.getTitle() + "' at UBC: " );
    ubc.borrowBook( b3.getTitle() );

    /*
    System.out.println( "********* Testing Returning Scenario #1 ..." );
    System.out.println( ubc.toString() );
    ubc.returnBook( b6.getTitle() );
    */

    /*
    System.out.println( "********* Testing Borrowing Scenario #3 ..." );
    rez = onlineSys.searchBook( b1.getTitle() );
    onlineSys.prMatches( rez );
    System.out.println( "Checking '" + b1.getTitle() + "' at SFU: " );
    sfu.getStatus( b1.getTitle() );
    ubc.interlibraryLoan( b1.getTitle(), sfu );

    System.out.println( "********* Testing Returning Scenario #2 ..." );
    System.out.println( sfu.toString() );
    // can return interlibrary loaned out book in person
    sfu.returnBook( b1.getTitle() );

    System.out.println( "********* Testing Returning Scenario #3 ..." );
    ubc.interlibraryLoan( b1.getTitle(), sfu );
    // or return book via interlibrary loan
    ubc.returnInterlibraryLoan( b1.getTitle(), sfu );
    */
  }
}
