public class MyUtils
{
  public static int minVecIndex( double[] vec )
  {
    int    dex = 0;
    double val = vec[dex];
    for( int i=1; i<vec.length; i++ )
    {
      if( vec[i] < val )
      {
        val = vec[i];
        dex = i;
      }
    }
    return dex;
  }

  public static double minVecValue( double[] vec )
  {
    int    dex = 0;
    double val = vec[dex];
    for( int i=1; i<vec.length; i++ )
    {
      if( vec[i] < val )
      {
        val = vec[i];
        dex = i;
      }
    }
    return val;
  }
}