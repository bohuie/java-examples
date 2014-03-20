public class Example
{
  public static String hello = "hi";
  private String name;
  
  public Example( String n )
  {
    name = n;
  }
  
  public void changeStr()
  {
    hello += " " + name;
  }
}
