public class ClassC implements InterfaceA, InterfaceB
{
  public void test( int i )
  {
    System.out.println( "In C: test() due to A: " + i );
  }
  
  public void test( String s )
  {
    System.out.println( "In C: test() due to B: " + s );
  }
}
