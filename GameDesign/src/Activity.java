import java.util.Scanner;

/**
 * stand alone number activities can be created as objects of this class,
 * as long as each activity has the same structure (e.g., they all have
 * instructions, they all have one number, they all take a number answer
 * from the user)
 * 
 * @author bowen hui
 */
public class Activity
{
  private int     number, answer;
  private Scanner sysin;
  private String  instructions;

  /**
   * constructor method to initialize all attributes
   */
  public Activity()
  {
    number = -1;
    answer = -1;
    sysin = new Scanner( System.in );
    instructions = "";
  }

  /**
   * mutator for setting the instructions for this activity
   * 
   * @param words
   * @return void
   */
  public void setInstructions( String words )
  {
    instructions = words;
  }

  /**
   * display instructions for a number game
   * 
   * @param void
   * @return void
   */
  public void play()
  {
    System.out.println( instructions );
    System.out.println( number );
    getUserResponse();
  }

  /**
   * process user response to see if answer is correct or not
   * 
   * @param void
   * @return void
   */
  private void getUserResponse()
  {
    int userInput = sysin.nextInt();
    if( userInput == answer )
      win();
    else
      lose();
  }

  /**
   * display feedback when user wins
   * 
   * @param void
   * @return void
   */
  private void win()
  {
    System.out.println( "Horray! That's correct! Good job!" );
  }

  /**
   * display feedback when user loses
   * 
   * @param void
   * @return void
   */
  private void lose()
  {
    System.out.print( "That doesn't sound right. " );
    System.out.print(  "It should be " + answer );
    System.out.println( " Better luck next time!" );
  }

  /**
   * mutator for both number and answer in case the game is played again
   * 
   * @param num
   * @param ans
   * @return void
   */
  public void setupReplay( int num, int ans )
  {
    number = num;
    answer = ans;
  }
}
