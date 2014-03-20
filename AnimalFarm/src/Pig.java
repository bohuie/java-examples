public class Pig extends Animal
{
  public Pig( String myName, int n )
  {
    name = myName;
    numLegs = n;
  }
  
  public String speak()
  {
    return "oink";
  }
}
