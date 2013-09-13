
public class Recursion
{
  private long x0, p1, p2, N, xi;
  
  public Recursion( long seed )
  {
    x0 = System.currentTimeMillis();
    x0 = seed;
    p1 = 234;
    p2 = 83;
    N = 100;
    xi = ( p1*x0 + p2 ) % N;
  }

  public long computeAgain( long new_x0 )
  {
    x0 = new_x0;
    xi = ( p1*x0 + p2 ) % N;
    System.out.println( xi );
    return xi;
  }
  
  public long showX0()
  {
    System.out.println( x0 );
    return x0;
  }

  public long showXi()
  {
    System.out.println( xi );
    return xi;
  }
}
