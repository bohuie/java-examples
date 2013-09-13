/**
 * this class is a super basic model of a lamb (noise only)
 * 
 * @author bohuie
 */
public class Lamb
{
  String name;

  /**
   * constructor method
   */
  public Lamb()
  {
    name = "lamb";
  }

  /**
   * gives sound of animal
   * 
   * @param void
   * @return sound
   */
  public String noise()
  {
    return "baa";
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
