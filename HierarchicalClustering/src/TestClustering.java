import java.util.Random;

public class TestClustering
{
  public static void main( String[] args )
  {
    // generate some random points
    Random generator = new Random();
    int maxPoints = 5;
    Point[] S = new Point[maxPoints];
    for( int i=0; i<maxPoints; i++ )
    {
      int x = generator.nextInt( 10 );
      int y = generator.nextInt( 10 );
      Point p = new Point( x, y );
      S[i] = p;
    }
    
    HierarchicalAgglomerative ha = new HierarchicalAgglomerative( S );
    ha.clustering();
  }
}
