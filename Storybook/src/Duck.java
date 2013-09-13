/**
 * this class is a super basic model of a duck (noise only)
 * 
 * @author bohuie
 */
public class Duck
{
  String name;

  /**
   * constructor method
   */
  public Duck()
  {
    name = "duck";
  }

  /**
   * gives sound of animal
   * 
   * @param void
   * @return sound
   */
  public String noise()
  {
    return "quack";
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
