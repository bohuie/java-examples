/**
 * this class models an order that a customer makes at the takeout
 * restaurant. it keeps track of the items that have been placed in an
 * order, along with the associated prices, so that it can be summed up
 * 
 * assume an order can only handle a maximum of 5 items, and only one
 * quantity only per item
 * 
 * @author bowen hui
 */
class Order
{
  // attributes
  String item1, item2, item3, item4, item5;         // items in an order
  int    price1, price2, price3, price4, price5;    // corresponding prices
  int    total;                                     // total cost of an order

  /**
   * constructor method
   */
  Order()
  {
    // initially, we don't know what the customer will order yet
    // so give all of these default values
    item1  = "";
    item2  = "";
    item3  = "";
    item4  = "";
    item5  = "";
    price1 = 0;
    price2 = 0;
    price3 = 0;
    price4 = 0;
    price5 = 0;
    total  = 0;
  }

  /**
   * sets the first item to be ordered
   * 
   * @param item
   * @param price
   */
  void setItem1( String item, int price )
  {
    item1  = item;
    price1 = price;
    total  = total + price1;
  }

  /**
   * sets the second item to be ordered
   * 
   * @param item
   * @param price
   */
  void setItem2( String item, int price )
  {
    item2  = item;
    price2 = price;
    total  = total + price2;
  }

  /**
   * sets the third item to be ordered
   * 
   * @param item
   * @param price
   */
  void setItem3( String item, int price )
  {
    item3  = item;
    price3 = price;
    total  = total + price3;
  }

  /**
   * sets the fourth item to be ordered
   * 
   * @param item
   * @param price
   */
  void setItem4( String item, int price )
  {
    item4  = item;
    price4 = price;
    total  = total + price4;
  }

  /**
   * sets the fifth item to be ordered
   * 
   * @param item
   * @param price
   */
  void setItem5( String item, int price )
  {
    item5  = item;
    price5 = price;
    total  = total + price5;
  }

  /**
   * returns the total cost of an order based on the items that have been
   * ordered used by other classes, for communication purposes
   * 
   * @return total cost of an order
   */
  int getTotal()
  {
    return total;
  }

  /**
   * gather information together so we can print it out for debugging
   * purposes
   * 
   * @return order info
   */
  String gatherInfo()
  {
    String str = "";
    str += "Item: " + item1 + ", ";
    str += "Item: " + item2 + ", ";
    str += "Item: " + item3 + ", ";
    str += "Item: " + item4 + ", ";
    str += "Item: " + item5 + "\n";
    return str;
  }
}
