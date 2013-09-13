public class HierarchicalAgglomerative
{
  private Point[]   S;              // a set of points
  private int       N;              // size of S
  private Cluster[] clusterSet;     // a set of clusters formed so far
  private int       numActive;      // number of non-null clusters

  public HierarchicalAgglomerative( Point[] data )
  {
    S = data;
    N = data.length;
    
    // in the beginning, each data point is its own cluster
    clusterSet = new Cluster[N];
    numActive = N;    
    step1();
    System.out.println( this.toString() );
  }
  
  /**
   * assign each object to a cluster
   */
  private void step1()
  {
    for( int i = 0; i < N; i++ )
    {
      Cluster c = new Cluster( i, S[i] );
      clusterSet[i] = c;
    }
  }
  
  public void clustering()
  {
    while( numActive > 1 )
    {
      step2();
      System.out.println( this.toString() );
    }
  }

  /**
   * find two closest clusters and merge them into a new one, remove
   * combined clusters
   */
  private void step2()
  {
    // for each cluster:
    // - compute the distance from itself to everyone else
    // - find the cluster it is closest to
    // - record that cluster's distance value and index here
    double[] shortestVal = new double[N];
    int[]    shortestDex = new int[N];
    for( int i = 0; i < N; i++ )
    {
      if( clusterSet[i] != null )
      {
        clusterSet[i].calcAllDistances( clusterSet );
        clusterSet[i].findClosest();
        shortestVal[i] = clusterSet[i].getClosestVal();
        shortestDex[i] = clusterSet[i].getClosestDex();        
      }
      else
      {
        shortestVal[i] = Cluster.UNDEF;
        shortestDex[i] = Cluster.UNDEF;
      }
    }

    // get the min of shortestVal recorded
    double minVal = MyUtils.minVecValue( shortestVal );
    int    minDex = MyUtils.minVecIndex( shortestVal );
    // now, minVal stores the smallest distance between the two closest
    // clusters, and minDex stores the index of one of these clusters while
    // shortestDex[minDex] stores the index of the other cluster
    
    System.out.println( "merging ..." );
    System.out.println( "\t" + clusterSet[minDex].toString() );
    System.out.println( "\t" + clusterSet[shortestDex[minDex]].toString() );
    System.out.println( "\tdistance: " + shortestVal[minDex] );

    // add second cluster to first
    int one = minDex;
    int two = shortestDex[minDex];
    clusterSet[one].integrate( clusterSet[two] );

    // delete second
    clusterSet[two] = null;
    numActive--;
  }

  /**
   * print out each cluster in the set
   */
  public String toString()
  {
    String str = "";
    for( int i = 0; i < N; i++ )
      if( clusterSet[i] != null )
        str += clusterSet[i].toString();
    return str;
  }
}
