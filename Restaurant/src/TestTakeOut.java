/**
 * this is a test class to make sure the program works as a whole
 * 
 * the steps in the main() method will mimic the process for ordering
 * takeout
 * 
 * since this program is written from the perspective of the takeout
 * restaurant, the process that will be listed in the main() method will
 * mimic what a restaurant employee would enter into their takeout system
 * if someone calls in to order something
 * 
 * @author bowen hui
 */
class TestTakeOut
{
  public static void main( String[] args )
  {
    // start by setting the prices of the food items in the restaurant
    TakeOut fastFood = new TakeOut( 3, 6, 5, 4, 10 );

    // a new customer calls with the following info
    fastFood.makeNewCustomer( "Jen", 1234567 );

    // customer wants to order the following items
    fastFood.orderGyoza();
    fastFood.orderSakeMaki();

    // customer indicates that the order is done
    fastFood.completeOrder();

    // the summary info of the takeout is then printed out onto the screen
    System.out.println( fastFood.gatherInfo() );
    
    // continue here as you add new code
    fastFood.makeNewCustomer( "Ben", 9876543 );
    fastFood.orderEdamame();
    fastFood.orderUnagiDon();
    fastFood.completeOrder();
    System.out.println( fastFood.gatherInfo() );
  }

}
