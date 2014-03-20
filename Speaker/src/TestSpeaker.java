public class TestSpeaker
{
  public static void main( String[] args )
  {
    Speaker first = new Dog();
    first.speak();
    Philosopher second = new Philosopher();
    second.pontificate();
    first = second;
    first.speak();
    Dog third = new Dog();
    third.speak();
    third = ( Dog ) first;
    // third.speak();
    // third = second;
  }
}
