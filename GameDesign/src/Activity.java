import java.util.Scanner;

public class Activity
{
  private int     number, answer;
  private Scanner sysin;
  private String  instructions;

  public Activity()
  {
    number = -1;
    answer = -1;
    sysin = new Scanner( System.in );
    instructions = "";
  }

  public void setInstructions( String words )
  {
    instructions = words;
  }
  
  public void play()
  {
    System.out.println( instructions );
    System.out.println( number );
    getUserResponse();
  }
  
  private void getUserResponse()
  {
    String userInput = sysin.nextLine();
    int value = Integer.parseInt( userInput );
    if( value == answer )
      win();
    else
      lose();
  }

  private void win()
  {
    System.out.println( "Horray! That's correct! Good job!" );
  }

  private void lose()
  {
    System.out.println( "That doesn't sound right. Better luck next time!" );
  }
  
  /**
   * mutator for both number and answer
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
