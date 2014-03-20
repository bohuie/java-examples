/**
 * this is a class that models the information about a customer that a
 * restaurant needs to keep track of
 * 
 * when a customer calls for takeout, the restaurant will want to know the
 * customer name and phone number, so when someone comes to do the pickup,
 * we can match the order to the right person
 * 
 * in addition, we will want to associate the actual order with this
 * customer, as well as the amount owing so the restaurant can be paid
 * 
 * not to be confused with a customer (real life person) therefore, the
 * "abilities" of a customer are very simple (a real life customer would
 * have many more abilities)
 * 
 * @author bowen hui
 */
class Customer
{
  // attributes
  String name;
  int    phone;
  Order  takeoutOrder;
  int    amountOwing;

  /**
   * constructor method
   * 
   * @param firstName
   *          - used when restaurant takes down customer info during
   *          takeout order
   * @param number
   *          - used when restaurant takes down customer info during
   *          takeout order
   */
  Customer( String firstName, int number )
  {
    name = firstName;
    phone = number;

    // don't have this information yet, so give them default values
    takeoutOrder = null;
    amountOwing = 0;
  }

  /**
   * once an order has been placed, the order can be associated with this
   * customer
   * 
   * the total cost is calculated in the Order class, so once we have an
   * order, we can also set the amountOwing
   * 
   * @param the
   *          order placed for takeout
   * @return void
   */
  void setOrder( Order food )
  {
    takeoutOrder = food;
    amountOwing = food.total;
  }

  /**
   * gather information together so we can print it out for debugging
   * purposes
   * 
   * @return customer info
   */
  String gatherInfo()
  {
    String str = "";
    str += "Name:  " + name + "\n";
    str += "Phone: " + phone + "\n";
    return str;
  }
}
