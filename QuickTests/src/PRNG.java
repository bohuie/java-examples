
public class PRNG
{
  private int x0, p1, p2, N, xi;
  
  public PRNG( int seed, int maxN )
  {
    x0 = seed;
    p1 = 234;
    p2 = 83;
    N  = maxN;
    xi = ( p1*x0 + p2 ) % N;
  }

  public int computeAgain( int prevXi )
  {
    x0 = prevXi;
    xi = ( p1*x0 + p2 ) % N;
    return xi;
  }
  
  public void showX0()
  {
    System.out.println( "x0 = " + x0 );
  }

  public void showXi()
  {
    System.out.println( "xi = " + xi );
  }
  
  public int getXi()
  {
    return xi;
  }
}
