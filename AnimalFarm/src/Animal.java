public abstract class Animal
{
  protected int    numLegs;               // number of legs an animal has
  protected String name;                  // name of the animal

  public String getName()    { return name; }
  public abstract String speak();
}
