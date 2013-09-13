import java.util.Scanner;

public class Board
{
  // the board keeps track of two jokes
  // each joke has a tally of votes
  private String  joke1;
  private int     tally1;
  private String  joke2;
  private int     tally2;
  private Scanner sysin;

  /**
   * constructor
   * @param first joke
   * @param second joke
   */
  public Board( String str1, String str2 )
  {
    joke1  = str1;
    joke2  = str2;
    tally1 = 0;
    tally2 = 0;
    sysin  = new Scanner( System.in );
    postJokes();
  }
  
  /**
   * helper method that displays the jokes to be voted on
   * 
   * @param void
   * @return void
   */
  public void postJokes()
  {
    System.out.println( "\nMath jokes of the week:" );
    System.out.println( "1. " + joke1 );
    System.out.println( "2. " + joke2 );
    System.out.println( "Vote for your favourite one!" );
  }
  
  /**
   * lets user vote towards one of the two jokes
   * 
   * @param num
   * @return void
   */
  public void vote( int num )
  {
    if( num == 1 )
      tally1++;
    else if( num == 2 )
      tally2++;
    else
      System.out.println( "Vote number unknown. Vote not counted." );
  }

  /**
   * reports voting results
   * 
   * @param void
   * @return void
   */
  public void reportResults()
  {
    // print out details
    System.out.println( "Vote results:" );
    System.out.println( "        Num. of Votes " );
    System.out.println( "Joke 1:     " + tally1 );
    System.out.println( "Joke 2:     " + tally2 );

    // summarize result
    if( tally1 > tally2 )
      System.out.println( "Joke 1 was best!" );
    else if( tally1 < tally2 )
      System.out.println( "Joke 2 was best!" );
    else
      System.out.println( "It was a tie!" );
  }
}
