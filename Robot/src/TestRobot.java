/**
 * this class tests the Robot.java
 * 
 * @author bohuie
 */
public class TestRobot
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing Robot ...");
    Robot roomba = new Robot();
    roomba.comeHere();
    System.out.println( roomba.toString() );
  }

}
