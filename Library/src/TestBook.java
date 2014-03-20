/**
 * this class tests the book class
 * 
 * @author bowen hui
 */
public class TestBook
{
  public static void main( String[] args )
  {
    Book b1 = new Book( "Computer Networks", "A. Tanenbaum", "Prentice Hall", 2010 );
    System.out.println( b1.toString() );

    b1.setBranch( "UBCO" );
    b1.setStatus( Library.NOSUCHBOOK );
    System.out.println( b1.toString() );
    
    Book b2 = new Book( "Software Engineering", "I. Sommerville", "Addison Wesley", 2010, "UBCO", Library.AVAILABLE );
    System.out.println( b2.toString() );
  }
}
