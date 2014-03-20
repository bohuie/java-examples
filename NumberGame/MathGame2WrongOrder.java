import java.util.Scanner;

public class MathGame2WrongOrder
{
  private Scanner scanner1;
  private int number;

  // everything in this method is executed first
  public MathGame2WrongOrder() 
  {
    // create scanner object - tells me where to read data from
    scanner1 = new Scanner( System.in );

    // read in the number now (just cut/paste from TestMath1)
    // this will occur before displaying instructions to the user
    number = scanner1.nextInt();
  }

  // everything in this method is executed second
  public void startGame()
  {
    // display instructions to user
    System.out.println( "let's start" );
    System.out.println( "enter a number between 1 and 10" );

    // read in integer from that location and store into variable called number
    // read in integer again for the second time 
    number = scanner1.nextInt();

    // do calculations and display result back to user
    System.out.println( Math.sqrt( number ) );
  }
}
