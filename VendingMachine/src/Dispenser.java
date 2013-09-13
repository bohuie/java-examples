/**
 * this class models the dispenser inside a vending machine
 * 
 * design questions:
 * - what should a dispenser do?
 * - what classes does it need to interact with?
 * - can a user interact with the dispenser class directly?
 * 
 * a dispenser is responsible for knowing which category and value match to
 * which product so that product item can be dispensed to the customer
 * an employee user may load up products into the dispenser
 * this dispenser should model the physical space limitations of a real world dispenser
 * 
 * implementation questions:
 * - how do we translate the categories into array indices?
 * - how many items per product can we load?
 * - what happens if different products are loaded to the same slot? 
 * 
 * @author bohuie
 * 
 */
public class Dispenser
{
  // each product has an associated category and numeric value
  // e.g. an aero chocolate bar is located in A-2
  private char[]          categories;
  private int[]           values;
  
  // dispenser variables
  private int[][]         slots;    // indicates number of items available for purchase
  private Product[][]     stock;    // indicates the product in each category-value combo

  // constants
  public final static int NUMCATS  = 2;
  public final static int NUMVALS  = 3;
  public final static int NUMAVAIL = 4;
  public final static int EMPTY    = 0;
  public final static int FULL     = NUMAVAIL;

  /**
   * constructor method
   */
  public Dispenser()
  {
    // predefine the possible categories
    categories = new char[NUMCATS];
    categories[0] = 'A';
    categories[1] = 'B';

    // predefine the possible values in each category
    values = new int[NUMVALS];
    for( int i = 0; i < NUMVALS; i++ )
      values[i] = i + 1;

    // initialize all slots to be empty
    slots = new int[NUMCATS][NUMVALS];
    for( int cat = 0; cat < NUMCATS; cat++ )
      for( int val = 0; val < NUMVALS; val++ )
        slots[cat][val] = EMPTY;

    // initialize an empty stock of items
    stock = new Product[NUMCATS][NUMVALS];
  }

  /**
   * maps category character to array index integer
   * 
   * @param category
   * @return array index
   */
  private int cat2int( char cat )
  {
    if( cat == 'A' )
      return 0;
    else if( cat == 'B' )
      return 1;
    else
      return -1;  // undefined
  }

  /**
   * loads one product item into the slot if there's still room left
   * 
   * @param product
   * @param category
   * @param value
   * @return result if successfully loaded
   */
  public boolean loadup( Product p, char cat, int val )
  {
    boolean isFull;
    int c = cat2int( cat );
    int v = val - 1;

    if( slots[c][v] == FULL )
    {
      isFull = true;
      System.out.println( "Product " + p.toString() + " not added to inventory" );
    }
    else
    {
      isFull = false;
      System.out.println( "Product " + p.toString() + " added to " + c + "," + v );
      slots[c][v]++;
      stock[c][v] = p;
    }
    return isFull;
  }

  /**
   * lets panel retrieves an item if it's available
   * 
   * @param category
   * @param value
   * @return retrieved product or null
   */
  public Product retrieve( char cat, int val )
  {
    Product p = null;
    int c = cat2int( cat );
    int v = val - 1;

    // if the item is available, retrieve it
    // once it's been retrieve, update inventory
    if( slots[c][v] != EMPTY )
    {
      p = stock[c][v];
      slots[c][v]--;
    }
    return p;
  }

  /**
   * prints the availability of slots
   * 
   * @param void
   * @return dispenser info
   */
  public String toString()
  {
    String str = "";
    for( int cat = 0; cat < NUMCATS; cat++ )
      for( int val = 0; val < NUMVALS; val++ )
        if( slots[cat][val] != EMPTY )
          str += "c" + cat + ",v" + val + ": " + slots[cat][val] + " of "
              + stock[cat][val].toString() + "\n";
        else 
          str += "c" + cat + ",v" + val + ": " + slots[cat][val] + "\n";
    return str;
  }
}
