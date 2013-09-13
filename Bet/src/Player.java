/**
 * this class models a player who participates in a bet
 * 
 * design questions:
 * - what should the player be able to do?
 * - how might it interact with another player?
 * 
 * a player can place bets and either lose or win
 * a player can also borrow money from another player,
 * which means a player can loan out money, return money, receive money
 * depending on the perspective of the player
 * 
 * implementation questions:
 * - which methods need to take another player object as a parameter?
 * - do any methods take the table object as a parameter?
 * - how to we reduce replicate code for similar meaning methods like
 *   receive money and win money?
 * 
 * @author bohuie
 * 
 */
public class Player
{
  String name;
  double dollars;

  /**
   * constructor method
   * 
   * @param name
   * @param initial money
   */
  public Player( String n, double money )
  {
    name = n;
    dollars = money;
  }

  /**
   * places a bet so loses that amount from total
   * 
   * @param amount
   * @return void
   */
  public void placeBet( double amount )
  {
    if( hasEnough( amount ) )
      dollars = dollars - amount;
    else
      System.err.println( "Error: not enough money" );
  }

  /**
   * wins money and gains that amount
   * 
   * @param amount
   * @return void
   */
  public void win( double amount )
  {
    dollars = dollars + amount;
  }

  /**
   * checks to see if there's enough in the total first
   * 
   * @param amount
   * @return result
   */
  public boolean hasEnough( double amount )
  {
    return dollars >= amount;
  }

  /**
   * when low on money, can borrow from another player
   * 
   * @param amount
   * @param friend
   * @return void
   */
  public void borrowFrom( double amount, Player friend )
  {
    if( friend.hasEnough( amount ) )
    {
      friend.loan( amount );
      win( amount );
    }
  }

  /**
   * can loan money to another player
   * 
   * @param amount
   * @return void
   */
  public void loan( double amount )
  {
    dollars = dollars - amount;
  }

  /**
   * can return borrowed money to another player
   * 
   * @param amount
   * @param friend
   * @return void
   */
  public void giveBack( double amount, Player friend )
  {
    if( dollars > amount )
    {
      dollars = dollars - amount;
      friend.receive( amount );
    }
  }

  /**
   * can receive money 
   * 
   * @param amount
   * @return void
   */
  public void receive( double amount )
  {
    win( amount );
  }

  /**
   * prints player info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += "Name:   " + name + "\n";
    str += "Amount: " + dollars + "\n";
    return str;
  }
}
