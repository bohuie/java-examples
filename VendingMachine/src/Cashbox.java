/**
 * this class models a cashbox inside a vending machine
 * 
 * design questions:
 * - what is the cashbox supposed to do?
 * - what does it need to interact with?
 * - what info does it need to keep track of?
 *  
 * a cashbox is responsible for managing the money
 * once it knows the product price, it needs how much has been deposited and how much to give back
 * we can load it up with various coins, so change is given back in terms of these coins too
 * 
 * implementation questions:
 * - how many coins of each coin type can it store up to? how is this represented?
 * - how does the cashbox generate change of coins?
 * 
 * @author bohuie
 *
 */
public class Cashbox
{
  private double price;
  private int    num200;
  private int    num100;
  private int    num25;
  private int    num10;
  private int    num5;
  
  /**
   * constructor method
   */
  public Cashbox()
  {
    price  = 0;
    num200 = 0;
    num100 = 0;
    num25  = 0;
    num10  = 0;
    num5   = 0;
  }

  /**
   * lets user loads one roll of coins in at a time (assume it's never full)
   * 
   * @param coin
   * @param num
   * @return void
   */
  public void loadCoins( int coin, int num )
  {
    if( coin == 200 )
      num200 += num;
    else if( coin == 100 )
      num100 += num;
    else if( coin == 25 )
      num25 += num;
    else if( coin == 10 )
      num10 += num;
    else if( coin == 5 )
      num5 += num;
  }
  
  /**
   * mutator for price 
   * 
   * @param amount
   * @return price
   */
  public void setPrice( double amount )
  {
    price = amount;
  }
  
  /**
   * accessor for price
   * 
   * @param void
   * @return price
   */
  public double getPrice()
  {
    return price;
  }
  
  /**
   * accepts one coin amount from the panel to add to the cashbox
   * 
   * @param amount deposited by user via panel
   * @return void
   */
  public void accept( double amount )
  {
    int coin = ( int )(amount * 100);
    
    // add coin to collection
    loadCoins( coin, 1 );
    
    // update price owing
    price -= amount;
  }
  
  /**
   * keep generating change based on available coins until all is given
   * assumes amount in cashbox is always greater than change needed to be returned
   * 
   * @param void
   * @return void
   */
  public void giveChange()
  {
    int total = ( int )(Math.abs( price ) * 100);
    // anything less than 5 cents won't get returned
    while( total > 4 )
    {
      while( total >= 200 && num200 > 0 )
      {
        total -= 200;
        num200--;
        System.out.println( "$2.00" );
      }
      while( total >= 100 && num100 > 0 )
      {
        total -= 100;
        num100--;
        System.out.println( "$1.00" );
      }
      while( total >= 25 && num25 > 0 )
      {
        total -= 25;
        num25--;
        System.out.println( "$0.25" );
      }
      while( total >= 10 && num10 > 0 )
      {
        total -= 10;
        num10--;
        System.out.println( "$0.10" );
      }
      while( total >= 5 && num5 > 0 )
      {
        total -= 5;
        num5--;
        System.out.println( "$0.05" );
      }
    }
  }
  
  /**
   * cashbox coin info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += "2.00: " + num200 + "\n";
    str += "1.00: " + num100 + "\n";
    str += "0.25: " + num25  + "\n";
    str += "0.10: " + num10  + "\n";
    str += "0.05: " + num5   + "\n";
    return str;
  }
}
