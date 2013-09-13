/**
 * this class is a super basic model of a chicken (noise only)
 * 
 * @author bohuie
 */
public class Chicken
{
  String name;

  /**
   * constructor method
   */
  public Chicken()
  {
    name = "chicken";
  }

  /**
   * gives sound of animal
   * 
   * @param void
   * @return sound
   */
  public String noise()
  {
    return "cluck";
  }

  /**
   * accessor for name
   * 
   * @param void
   * @return name
   */
  public String getName()
  {
    return name;
  }
}
