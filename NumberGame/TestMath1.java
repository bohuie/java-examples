import java.util.Scanner;

public class TestMath1
{
  public static void main( String[] args )
  {
    MathGame1 game1;
    game1 = new MathGame1();           // uses MathGame1 class

    // version 1: when everything is inside TestMath
    System.out.println( "let's start" );
    System.out.println( "enter a number between 1 and 10" );
    Scanner scanner1 = new Scanner( System.in );
    int number = scanner1.nextInt();
    double srnum = Math.sqrt( number );
    System.out.println( srnum );
  }
}
