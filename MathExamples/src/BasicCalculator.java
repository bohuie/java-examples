/**
 * this is a class that does a few math operations on two numbers
 */
public class BasicCalculator
{
  private int oprd1;
  private int oprd2;
  
  /**
   * constructor method
   * initialize the attributes
   * 
   * @param one number
   * @param a second number
   */
  public BasicCalculator( int num1, int num2 )
  {
    oprd1 = num1;
    oprd2 = num2;
  }
  
  /**
   * mutate the first operand to the new value specified 
   * 
   * @param the new number
   */
  public void setOprd1( int num )
  {
    oprd1 = num;
  }
  
  /**
   * mutate the second operand to the new value specified 
   * 
   * @param the new number
   */  
  public void setOprd2( int num )
  {
    oprd2 = num;
  }
  
  /**
   * add oprd1 to oprd2
   * 
   * @return the calculated result
   */
  public int add()
  {
    return oprd1 + oprd2;
  }
  
  /**
   * multiply oprd1 with oprd2
   * 
   * @return the calculated result
   */
  public int multiply()
  {
    return oprd1 * oprd2;
  }
  
  /**
   * take the absolute value of the first operand
   * 
   * @return the calculated result
   */
  public int absFirst()
  {
    return Math.abs( oprd1 );
  }
  
  /**
   * take the square root of the second operand
   * 
   * @return the calculated result
   */
  public double sqrtSecond()
  {
    return Math.sqrt( oprd2 );
  }
}
