public class BarStool implements Furniture
{
  private int legLength;
  
  public BarStool()
  {
    legLength = Furniture.BAR_HEIGHT;
  }
  
  public String toString()
  {
    String str = "";
    str += "a bar stool is " + legLength + " high\n";
    return str;
  }

  public int getHeight()
  {
    return legLength;
  }
}
