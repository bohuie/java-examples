/**
 * this class tests the Player and Table classes
 * 
 * @author bohuie
 */
public class TestBets
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "***** Testing Player and Table ...");
    Table host = new Table();
    Player one = new Player( "Casper", 100 );
    Player two = new Player( "Bitzy", 50 );
    System.out.println( one.toString() );
    System.out.println( two.toString() );
    
    host.collectBets( one, 20 );
    host.collectBets( two, 10 );
    boolean rez = host.showOutcome();
    if( rez )
    {
      host.distributeMoney( one, 20 );
      host.distributeMoney( two, 10 );
    }
    System.out.println( "***** after betting:");
    System.out.println( one.toString() );
    System.out.println( two.toString() );
    
    two.borrowFrom( 10, one );
    System.out.println( "***** after borrowing:");
    System.out.println( one.toString() );
    System.out.println( two.toString() );
  }

}
