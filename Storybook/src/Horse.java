/**
 * this class is a super basic model of a horse (noise only)
 * 
 * @author bohuie
 */
public class Horse
{
  String name;

  /**
   * constructor method
   */
  public Horse()
  {
    name = "horse";
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

  /**
   * gives sound of animal
   * 
   * @param void
   * @return sound
   */
  public String noise()
  {
    return "neigh";
  }
}
