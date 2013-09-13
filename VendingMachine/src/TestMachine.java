/**
 * this classs tests Panel, Dispenser, Product, Cashbox classes
 * 
 * @author bohuie
 */
public class TestMachine
{

  /**
   * @param args
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing Product" );
    Product aero     = new Product( "Aero", 1.50 );
    Product mars     = new Product( "Mars", 1.50 );
    Product smarties = new Product( "Smarties", 1.25 );
    Product coke     = new Product( "Coke", 2.00 );
    Product sprite   = new Product( "Sprite", 1.50 );
    Product water    = new Product( "Water", 1.00 );

    System.out.println( "********** Testing Dispenser" );
    Dispenser dispzer = new Dispenser();
    System.out.println( dispzer.toString() );
    boolean isFull;
    
    // load up chocolates
    isFull = dispzer.loadup( aero, 'A', 1 );
    while( !isFull )
      isFull = dispzer.loadup(  aero, 'A', 1 );
    isFull = dispzer.loadup( mars, 'A', 2 );
    while( !isFull )
      isFull = dispzer.loadup(  mars, 'A', 2 );
    isFull = dispzer.loadup( smarties, 'A', 3 );
    while( !isFull )
      isFull = dispzer.loadup(  smarties, 'A', 3 );
    System.out.println( dispzer.toString() );

    // load up drinks
    isFull = dispzer.loadup( coke, 'B', 1 );
    while( !isFull )
      isFull = dispzer.loadup(  coke, 'B', 1 );
    isFull = dispzer.loadup( sprite, 'B', 2 );
    while( !isFull )
      isFull = dispzer.loadup(  sprite, 'B', 2 );
    isFull = dispzer.loadup( water, 'B', 3 );
    while( !isFull )
      isFull = dispzer.loadup(  water, 'B', 3 );
    System.out.println( dispzer.toString() );

    System.out.println( "********** Testing CashBox" );
    Cashbox cashb = new Cashbox();
    System.out.println( cashb.toString() );
    cashb.loadCoins( 200, 2 );
    cashb.loadCoins( 100, 2 );
    cashb.loadCoins( 25, 5 );
    cashb.loadCoins( 10, 10 );
    cashb.loadCoins( 5, 10 );
    System.out.println( cashb.toString() );

    System.out.println( "********** Testing Panel" );
    Panel vendor = new Panel( dispzer, cashb );

    System.out.println( "********** Testing Pass by Reference" );
    System.out.println( dispzer.toString() );
    System.out.println( cashb.toString() );
  }

}
