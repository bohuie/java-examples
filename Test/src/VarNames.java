
public class VarNames
{
  private int size;
  private int age;
  
  public VarNames( int size, int age )
  {
    size = size;
    age = age;
  }
  
  public String toString()
  {
    String str = "";
    str += "my size is " + size + " and i'm " + age + " years old\n";
    return str;
  }
}
