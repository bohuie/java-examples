/**
 * this class is an improved version of SimpleCar.java so the car doesn't
 * have negative gas value
 * 
 * design questions:
 * - what should the car do when the trip requires more gas than the amount
 *   that is available?
 *   
 * the trip should not be made at all
 * 
 * implementation questions:
 * - how do we know if a trip requires more gas than is available?
 * 
 * @author bohuie
 */
public class BetterCar
{
  private int    currMileage;
  private double gasAvail;

  /**
   * constructor method - same as SimpleCar
   */
  public BetterCar()
  {
    currMileage = 0;    // start as new car
    gasAvail = 40;      // start with 40 litres of full tank
  }

  /**
   * helper method to see if there's enough gas in the tank
   * 
   * @param distance to travel
   * @return whether there's enough gas or not
   */
  private boolean enoughGas( int distance )
  {
    boolean enough = false;
    double usage = (distance / 10) + 0.5;
    if( gasAvail > usage )
      enough = true;
    return enough;
  }

  /**
   * improved version of makeTrip() in SimpleCar only makes a trip if
   * there's enough gas in advance... kinda unrealistic still
   * 
   * @param distance to travel
   * @return was trip successful?
   */
  public boolean makeTrip( int distance )
  {
    boolean success = false;
    if( enoughGas( distance ) )
    {
      // update mileage
      currMileage = currMileage + distance;

      // update gas usage
      // every time a car starts, it uses some amount of gas
      // gas used as a function of distance, say 10L per 100km
      gasAvail = gasAvail - 0.5;
      gasAvail = gasAvail - (distance / 10);

      success = true;
    }

    // can make this method more sophisticated by using up the portion of
    // gas that will get the tank to be low and then "signal" a low gas
    // alert
    return success;
  }

  /**
   * this method calculates the efficiency - same as SimpleCar
   * 
   * @param void
   * @return fuel efficiency
   */
  public double calcEfficiency()
  {
    double eff = 0;
    eff = currMileage / (40 - gasAvail);
    return eff;
  }

  /**
   * this method just displays info about the car
   * 
   * @param void
   * @return string
   */
  public String toString()
  {
    String str = "";
    str += "car attributes:\n";
    str += "  mileage at = " + currMileage + "\n";
    str += "  gas available = " + gasAvail + "\n";
    return str;
  }
}