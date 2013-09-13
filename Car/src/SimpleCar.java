/**
 * this class models a car that only has simple things like mileage and a
 * gas tank
 * 
 * design questions: 
 * - what do we want to know about this car?
 * - what should this car be able to do?
 * 
 * a car should be able to go somewhere
 * in order to do that, we want to keep track of gas
 * we also want to know about its efficiency of fuel usage
 * so we need to keep track of mileage as well
 * 
 * implementation questions:
 * - how do we get the car to "go somewhere" in the code?
 * - how is fuel efficiency calculated?
 * 
 * @author bohuie
 */
public class SimpleCar
{
  private int    currMileage;
  private double gasAvail;

  /**
   * constructor method
   */
  public SimpleCar()
  {
    currMileage = 0;    // start as new car
    gasAvail = 40;      // start with 40 litres of full tank
  }

  /**
   * this is an accessor
   * 
   * @param void
   * @return current mileage
   */
  public int getCurrMileage()
  {
    return currMileage;
  }

  /**
   * this method updates the car attributes after making a trip of a given
   * distance in kilometres
   * 
   * @param distance to travel
   * @return void
   */
  public void makeTrip( int distance )
  {
    // update mileage
    currMileage = currMileage + distance;

    // update gas usage
    // every time a car starts, it uses some amount of gas
    // gas used as a function of distance, say 10L per 100km
    gasAvail = gasAvail - 0.5;
    gasAvail = gasAvail - (distance / 10);
  }

  /**
   * this method calculates the efficiency of the car based on the mileage
   * used and the gas available in kilometres per litre
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
