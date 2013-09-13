import java.util.Random;

/**
 * this class models the table that holds the bets
 * 
 * design questions:
 * - what kind of bets should it take?
 * - what determines if a player wins?
 * - what happens when a player wins?
 * - who can participate in a bet?
 * 
 * anyone who places an initial amount can bet
 * a simple game of hi/low numbers determines if the player wins or not
 * if the player wins, the bet amount is doubled
 * 
 * implementation questions:
 * - does this class have to keep track of placed bets?
 * - how does it know how much money to give for winnings?
 * - should it keep track of all the players? if so, how?
 * 
 * @author bohuie
 * 
 */
public class Table
{
  private int             hidden;
  private Random          generator;
  private double          total;

  // constant
  public static final int MAX = 10;

  /**
   * constructor method
   */
  public Table()
  {
    generator = new Random();
    hidden = generator.nextInt( MAX ) + 1;
    total = 1000;
  }

  /**
   * collects a bet amount from a player
   * 
   * @param player
   * @param amount
   * @return void
   */
  public void collectBets( Player p, double amount )
  {
    p.placeBet( amount );
    total += amount;
  }

  /**
   * shows the outcome of the hidden number
   * 
   * @param void
   * @return winning result
   */
  public boolean showOutcome()
  {
    boolean youwin = false;
    if( hidden < (MAX/2) )
    {
      System.out.println( "You win: number is " + hidden + "!" );
      youwin = true;
    }
    else
      System.out.println( "You lose: number is " + hidden + "!" );
    return youwin;
  }
  
  /**
   * gives out winnings if user won
   * 
   * @param player
   * @param amount
   * @return void
   */
  public void distributeMoney( Player p, double amount )
  {
    p.win( 2*amount );
    total -= 2*amount;
  }
}
