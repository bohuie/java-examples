/**
 * this class is a super basic model of a cow (noise only)
 * 
 * @author bohuie
 */
public class Cow
{
  String name;

  /**
   * constructor method
   */
  public Cow()
  {
    name = "cow";
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
    return "moo";
  }
}
