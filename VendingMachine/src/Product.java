/**
 * this class models an item in a vending machine
 * 
 * design questions:
 * - what info does the product need to store?
 * 
 * a product should know it's item and price
 * it should not need to do anything else
 * 
 * implementation questions:
 * - which accessor and mutators are needed?
 * 
 * @author bohuie
 * 
 */
public class Product
{
  private String item;
  private double price;

  /**
   * constructor method
   * 
   * @param name
   * @param amount
   */
  public Product( String name, double amount )
  {
    item  = name;
    price = amount;
  }

  /**
   * accessor for product price
   * 
   * @param void
   * @return price
   */
  public double getPrice() { return price; }

  /**
   * prints product info
   * 
   * @param void
   * @return info
   */
  public String toString()
  {
    String str = "";
    str += item + " ($" + price + ")";
    return str;
  }
}
