/**
 * this class tests SimpleCar.java and BetterCar.java
 * 
 * @author bohuie
 */
public class TestSimpleCar
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing SimpleCar ...");
    SimpleCar mx3 = new SimpleCar();
    System.out.println( mx3.toString() );
    mx3.makeTrip( 152 );
    System.out.println( mx3.toString() );
    System.out.println( "car efficiency: " + mx3.calcEfficiency() );

    mx3.makeTrip( 237 );
    System.out.println( mx3.toString() );
    System.out.println( "car efficiency: " + mx3.calcEfficiency() );

    mx3.makeTrip( 84 );
    System.out.println( mx3.toString() );
    System.out.println( "car efficiency: " + mx3.calcEfficiency() );

    System.out.println( "\n********** Testing BetterCar ...");
    BetterCar miata = new BetterCar();
    System.out.println( miata.toString() );
    miata.makeTrip( 152 );
    System.out.println( miata.toString() );
    System.out.println( "car efficiency: " + miata.calcEfficiency() );

    miata.makeTrip( 237 );
    System.out.println( miata.toString() );
    System.out.println( "car efficiency: " + miata.calcEfficiency() );

    miata.makeTrip( 84 );
    System.out.println( miata.toString() );
    System.out.println( "car efficiency: " + miata.calcEfficiency() );
  }
}
