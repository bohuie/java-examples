import java.util.Scanner;

/**
 * this class models the front panel of a vending machine
 * 
 * design questions:
 * - what are the responsibilities of the panel?
 * - how does it communicate with other classes?
 * - does user make selection first, or put money in first? does it matter?
 * - should the panel let user load products into its dispenser?
 * - should the panel let user load coins into its cashbox?
 * 
 * the front panel of a vending machine is responsible for interacting with the customer
 * any specific command should then be handled by another class 
 * we will fix the purchase order as: first select item, then give money
 * 
 * implementation questions:
 * - which class should do error handling of bad user input?
 * - do we have to keep track of the current product selection?
 * - do we have to keep track of the price of the selected product?
 * 
 * @author bohuie
 * 
 */
public class Panel
{
  private Dispenser myDispenser;
  private Cashbox   myCashbox;
  private Scanner   sysin;

  /**
   * constructor method
   * 
   * @param dispenser that has been loaded with items
   * @param cashbox that has been loaded with coins
   */
  public Panel( Dispenser dp, Cashbox cb )
  {
    myDispenser = dp;
    myCashbox   = cb;
    sysin       = new Scanner( System.in );

    // start program
    dispMenu();
  }

  /**
   * starting instructions for user
   * 
   * @param void
   * @return void
   */
  private void dispMenu()
  {
    String userInput;
    char   cat = ' ';
    int    val = -1;
    
    System.out.println( "Select an item for purchase" );
    
    // make sure user input is one of two possible categories
    while( cat != 'A' && cat != 'B' )
    {
      System.out.println( "Press 'A' for snacks and 'B' for drinks" );
      userInput = sysin.nextLine();
      cat = userInput.charAt( 0 );      
    }
    
    // make sure user input is one of NUMVALS possible values
    while( val < 1 || val > Dispenser.NUMVALS )
    {
      System.out.println( "Press 1 to " + Dispenser.NUMVALS + " for the item" );
      userInput = sysin.nextLine();
      val = Integer.parseInt( userInput );      
    }

    // handle selection
    makeSelection( cat, val );
  }

  /**
   * gives a selection to the dispenser to handle
   * 
   * @param selected category
   * @param selected value
   * @return void
   */
  private void makeSelection( char cat, int val )
  {
    Product p = myDispenser.retrieve( cat, val );
    if( p == null )
      System.err.println( "Error: product out of stock" );
    else
    {
      // product was successfully retrieved
      // now collect money
      System.out.println( p.toString() + " selected" );
      myCashbox.setPrice( p.getPrice() );
      dispMoneyInstructions();
    }
  }

  /**
   * repeated ask user to enter money until cashbox amount is paid
   * 
   * @param void
   * @return void
   */
  private void dispMoneyInstructions()
  {
    double amt;
    
    // keep asking for money until enough has been inserted
    while( myCashbox.getPrice() > 0 )
    {
      System.out.printf( "Please insert: $%.2f\n" , myCashbox.getPrice() );
      amt = sysin.nextDouble();
      acceptCoin( amt );
    }
    
    // if user entered more than needed, then give change back
    if( myCashbox.getPrice() < 0 )
    {
      generateChange();
    }

    System.out.println( "Enjoy your item. Have a nice day." );
    prDispenserStatus();
    prCashboxStatus();
  }

  /**
   * lets user enter a coin and gives it to the cashbox
   * 
   * @param coin received from user
   * @return void
   */
  public void acceptCoin( double coinAmount )
  {
    myCashbox.accept( coinAmount );
  }

  /**
   * asks cashbox for required change amount
   * 
   * @param void
   * @return void
   */
  private void generateChange()
  {
    double changeNeeded = Math.abs( myCashbox.getPrice() );
    System.out.printf( "Change: $%.2f\n" , changeNeeded );
    myCashbox.giveChange();
  }
  
  /**
   * prints dispenser info
   * 
   * @param void
   * @return void
   */
  private void prDispenserStatus()
  {
    System.out.println( "***** Dispenser Status:" );
    System.out.println( myDispenser.toString() );
  }
  
  /**
   * prints cashbox info
   * 
   * @param void
   * @return void
   */
  private void prCashboxStatus()
  {
    System.out.println( "***** Cashbox Status:" );
    System.out.println( myCashbox.toString() );
  }
}
