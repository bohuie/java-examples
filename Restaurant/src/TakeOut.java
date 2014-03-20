/**
 * this class models a takeout system to be used in a restaurant
 * 
 * when a TakeOut object is instantiated from this class, the menu prices
 * will be set
 * 
 * methods are available to record customer info in a Customer object when
 * an order is about to begin
 * 
 * methods are available to order an item off the menu, and that item is
 * added to the Order object
 * 
 * method is available to end an order and to gather information together
 * 
 * @author bowen hui
 */
class TakeOut
{
  // attributes
  int      edamame;
  int      gyoza;
  int      uniNigiri;
  int      sakeMaki;
  int      unagiDon;
  Customer customerInfo;
  Order    orderInfo;

  /**
   * constructor method
   * 
   * @param eprice
   * @param gprice
   * @param uniprice
   * @param sprice
   * @param uprice
   */
  TakeOut( int eprice, int gprice, int uniprice, int sprice, int uprice )
  {
    edamame   = eprice;
    gyoza     = gprice;
    uniNigiri = uniprice;
    sakeMaki  = sprice;
    unagiDon  = uprice;

    customerInfo = null;
    orderInfo    = null;
  }

  /**
   * create a new customer object with the info in the input parameters
   * create a new order object associated with this customer 
   */
   void makeNewCustomer( String name, int phone )
  {
    customerInfo = new Customer( name, phone );
    orderInfo    = new Order();
  }

   /**
    * add edamame as an order item in the Order object
    */
  void orderEdamame()
  {
    orderInfo.setItem1( "edamame", edamame );
  }

  /**
   * add gyoza as an order item in the Order object
   */
  void orderGyoza()
  {
    orderInfo.setItem2( "gyoza", gyoza );
  }

 /**
  * add uni nigiri as an order item in the Order object
  */
  void orderUniNigiri()
  {
    orderInfo.setItem3( "uni", uniNigiri );
  }

  
  /**
   * add sake maki as an order item in the Order object
   */
  void orderSakeMaki()
  {
    orderInfo.setItem4( "sake", sakeMaki );
  }

  /**
   * add unagi don as an order item in the Order object
   */
  void orderUnagiDon()
  {
    orderInfo.setItem5( "unagi don", unagiDon );
  }

 /**
  * make sure the Order object in the Customer object is the same as
  * the Order object that is created here 
  */
  void completeOrder()
  {
    customerInfo.setOrder( orderInfo );
  }

  /**
   * gather information together so we can print it out for debugging
   * purposes
   * 
   * @return takeout info
   */
  String gatherInfo()
  {
    String str = "";
    str += customerInfo.gatherInfo();
    str += orderInfo.gatherInfo();
    str += "Total: " + orderInfo.getTotal() + "\n";
    return str;
  }
}
