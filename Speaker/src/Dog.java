public class Dog implements Speaker
{

  public void speak()
  {
    System.out.println( "inside Dog:speak()" );
  }
  
  public void announce( String str )
  {
    System.out.println( "inside Dog:announce()" );
  }
}
