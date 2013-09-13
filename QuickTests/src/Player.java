
public class Player
{
  int    id;
  String name;
  
  Player( int uniqueId, String n )
  {
    id   = uniqueId;
    name = n;
  }
  
  public String toString()
  {
    String str = "";
    str += id;
    str += ": " + name;
    return str;
  }
}
