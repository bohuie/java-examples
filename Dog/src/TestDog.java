/**
 * this class tests Dog.java
 * 
 * @author bohuie
 */
public class TestDog
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing Dog..." );
    Dog casper = new Dog( "Casper" );
    System.out.println( casper.toString() );

    // repeatedly check mood and see how capser responds
    int numHours = 10;
    for( int i=0; i<numHours; i++ )
    {
      System.out.println( "** Time: " + (i+1) );
      System.out.println( casper.getMood() );
      casper.actOnMood();
    }
    System.out.println( casper.toString() );
    
    // test with three commands
    casper.command();
    System.out.println( casper.toString() );
    casper.command();
    System.out.println( casper.toString() );
    casper.command();
    System.out.println( casper.toString() );
  }

}
