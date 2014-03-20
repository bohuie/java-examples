import java.util.Random;
import java.util.Scanner;

/**
 * class to control overall flow of a game and user interaction for activity selection
 * this class requires Activity class and is tested via TestGameDesign
 * (TestActivity is not used anymore)
 * 
 * @author bowen hui
 */
public class Game
{
  private Random  generator;
  private Activity nextNum, tellTime;
  private Scanner sysin, sysin2;
  
  // constants
  public static final int MAXNUM = 500;
  public static final int MAXMINUTES = 3600;
  
  /**
   * constructor
   */
  public Game()
  {
    generator = new Random();
    sysin = new Scanner( System.in );
    sysin2 = new Scanner( System.in );
    
    nextNum = new Activity();
    nextNum.setInstructions( "What is the next number after this one?" );
    
    tellTime = new Activity();
    tellTime.setInstructions( "How many minutes are there if the following number is in seconds?" );
    
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
    
    int userInput = sysin.nextInt();
    System.out.println( "You entered: " + userInput );
    playActivity( userInput );
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
    
    System.out.println( "\nDo you want to play again? (Type: y/n)" );
    String userInput = sysin2.nextLine();
    
    System.out.println( "You entered: " + userInput );
    if( userInput.charAt( 0 ) == 'y' )
      beginGame();
    else
      System.out.println( "See you next time!" );
  }
}
