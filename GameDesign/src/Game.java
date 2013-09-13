import java.util.Random;
import java.util.Scanner;

public class Game
{
  private Random  generator;
  private Activity nextNum, tellTime;
  private Scanner sysin;
  
  // constants
  public static final int MAXNUM = 500;
  public static final int MAXMINUTES = 3600;
  
  /**
   * constructor
   */
  public Game()
  {
    generator = new Random();
    nextNum = new Activity();
    nextNum.setInstructions( "What is the next number after this one?" );
    
    tellTime = new Activity();
    tellTime.setInstructions( "How many minutes are there if the following number is in seconds?" );
    
    sysin = new Scanner( System.in );
    beginGame();
  }
  
  /**
   * let the user pick one of the two activities to play
   * @param void
   * @return void
   */
  private void beginGame()
  {
    System.out.println( "Which activity would you like to play?" );
    System.out.println( "Activity 1: One, two, thre, ..." );
    System.out.println( "Activity 2: How many minutes is it?" );
    
    String userInput = sysin.nextLine();
    int activityNum = Integer.parseInt( userInput );
    playActivity( activityNum );
  }
  
  /**
   * lets user choose which activity they want to play
   * @param activity number
   * @return void
   */
  private void playActivity( int choice )
  {
    if( choice == 1 )
    {
      int num = generator.nextInt( MAXNUM );
      nextNum.setupReplay( num, num+1 );
      nextNum.play();      
    }
    else
    {
      int num = generator.nextInt( MAXMINUTES );
      tellTime.setupReplay( num, (num/60) );
      tellTime.play();      
    }
    
    System.out.println( "\nDo you want to play again? (y/n)" );    
    String userInput = sysin.nextLine();
    if( userInput.charAt( 0 ) == 'y' )
      beginGame();
    else
      System.out.println( "See you next time!" );
  }
}
