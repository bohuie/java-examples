/**
 * this class is a super basic model of a pig (noise only)
 * 
 * @author bohuie
 */
public class Pig
{
  String name;

  /**
   * constructor method
   */
  public Pig()
  {
    name = "pig";
  }

  /**
   * gives sound of animal
   * 
   * @param void
   * @return sound
   */
  public String noise()
  {
    return "oink";
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
