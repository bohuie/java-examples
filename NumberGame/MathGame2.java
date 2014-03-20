import java.util.Scanner;

public class MathGame2
{
  private Scanner scanner1;
  private int number;

  // everything in this method is executed first
  public MathGame2() 
  {
    // create scanner object - tells me where to read data from
    scanner1 = new Scanner( System.in );
    number = 0;
  }

  // everything in this method is executed second
  public void startGame()
  {
    // display instructions to user
    System.out.println( "let's start" );
    System.out.println( "enter a number between 1 and 10" );

    // read in integer from that location and store into variable called number
    number = scanner1.nextInt();

    // do calculations and display result back to user
    System.out.println( Math.sqrt( number ) );
  }

  // if we were to create other methods 
  // those methods can all use the attributes scanner1 and number
  // because all the methods within the class have access to the class's
  // attributes
}
