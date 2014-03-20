public class Philosopher implements Speaker
{

  public void pontificate()
  {
    System.out.println( "inside Philosopher:pontificate()" );    
  }

  public void speak()
  {
    System.out.println( "inside Philosopher:speak()" );
  }
  
  public void announce( String str )
  {
    System.out.println( "inside Philosopher:announce()" );
  }
}
