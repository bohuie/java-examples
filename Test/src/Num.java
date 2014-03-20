
public class Num
{
  private int value;
  
  public Num( int val ) { value = val; }  
  public void setValue( int newValue ) { value = newValue; }  
  public String toString()
  {
    String str = "";
    str += value;
    return str;
  }
}