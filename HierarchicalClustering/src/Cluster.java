/**
 * a cluster contains one or more points in an n-dimensional space
 * 
 * supporting methods for calculating the distance between clusters
 * and merging clusters are provided
 * 
 * @author bohuie
 */
public class Cluster
{
  // attributes
  private int             id;
  private Point[]         members;
  private int             numMembers;
  private double[]        distVec;
  private double          closestVal;
  private int             closestDex;

  // constants
  public final static int MAXPERCLUSTER = 100;
  public final static int MAXPOINTS     = 100;
  public final static int UNDEF         = 9999999;

  /**
   * constructor 
   * 
   * @param id of this cluster
   * @param the first point in this cluster
   */
  public Cluster( int num, Point x )
  {
    id = num;
    numMembers = 0;
    members = new Point[MAXPERCLUSTER];
    
    // a cluster can only be created with one and only one data point
    addMember( x );
    
    // distVec not initialized here because its size will change
    // every time it is used - so only initialize before use
    distVec = null;
    
    resetClosest();
  }

  /**
   * adds one point to this cluster as a new memebr
   * 
   * @param point p
   * @return void
   */
  private void addMember( Point p )
  {
    members[numMembers] = p;
    numMembers++;
  }

  /**
   * (re)initializes the values of the closest cluster
   * 
   * @param void
   * @return void
   */
  private void resetClosest()
  {
    closestVal = UNDEF;
    closestDex = -1;
  }

  /**
   * accesses the distance value of the closest cluster
   * 
   * @param void
   * @return closestVal
   */
  public double getClosestVal()
  {
    return closestVal;
  }

  /**
   * accesses the index of the closest cluster 
   * 
   * @param void
   * @return closestDex
   */
  public int getClosestDex()
  {
    return closestDex;
  }

  /**
   * accesses the number of members that this cluster has
   * 
   * @param void
   * @return numMembers
   */
  public int getNumMembers()
  {
    return numMembers;
  }

  /**
   * accesses the i'th member of this cluster
   * 
   * @param index i
   * @return the i'th point in this cluster or null if i is bad index
   */
  public Point getOneMember( int i )
  {
    if( i <= numMembers )
      return members[i];
    else
      return null;
  }
  
  /**
   * mutates the i'th value in distVec to be the new value given
   * 
   * @param index i
   * @param new value to assign
   */
  private void setDistVecVal( int i, double val )
  {
    distVec[i] = val;
  }
  
  /**
   * retrieves the i'th cluster stored in the set of clusters given
   * 
   * @param index i
   * @param set of clusters given
   * @return the cluster stored at index i
   */
  private Cluster getOneCluster( int i, Cluster[] others )
  {
    return others[i];
  }

  /**
   * calculate the distance between itself and all other clusters
   * store this set of distances in distVec
   * 
   * @param a set of other clusters to compare my distance with
   * @return void
   */
  public void calcAllDistances( Cluster[] others )
  {
    distVec = new double[others.length];
    resetClosest();

    for( int i = 0; i < others.length; i++ )
    {
      if( ( getOneCluster(i,others) == null) || (i == id) )
        setDistVecVal( i, UNDEF );
      else
        setDistVecVal( i, calcDistanceTo( getOneCluster(i,others) ));
    }
  }

  /**
   * average linkage clustering uses the distance between any two clusters,
   * D( ci, cj ), to be the average distance from any member of one cluster
   * to any member of the other cluster
   * 
   * let d(a,b) = distance between two points a and b
   * 
   * D( ci, cj ) = 1/(|ci||cj|) * \sum_{a\in ci,b\in cj} d(a,b)
   * 
   * @param another cluster
   * @return distance from this cluster to that other cluster
   */
  private double calcDistanceTo( Cluster y )
  {
    int ci_size = this.getNumMembers();
    int cj_size = y.getNumMembers();

    double summed_distance = 0.0;

    for( int i = 0; i < ci_size; i++ )
    {
      Point a = this.getOneMember( i );
      // sum over the distance to every other member in cj
      for( int j = 0; j < cj_size; j++ )
      {
        Point b = y.getOneMember( j );
        double d = manhattan( a, b );
        summed_distance += d;
      }
    }

    // multiply by cluster sizes
    double dist = 1.0 / (ci_size * cj_size) * summed_distance;
    return dist;
  }

  /**
   * \sum_{dim} (a_dim - b_dim)
   * 
   * @param a 2d point
   * @param another 2d point
   * @return the Manhattan distance between two 2d points
   */
  private double manhattan( Point a, Point b )
  {
    double dist = 0.0;
    dist += Math.abs( a.getDim1() - b.getDim1() );
    dist += Math.abs( a.getDim2() - b.getDim2() );
    return dist;
  }

  /**
   * check distVec and return the index of cluster with smallest distance
   * 
   * @param void
   * @return void
   */
  public void findClosest()
  {
    resetClosest();
    closestVal = MyUtils.minVecValue( distVec );
    closestDex = MyUtils.minVecIndex( distVec );
  }

  /**
   * copy all of the incoming cluster's members to this one
   * 
   * @param a new cluster whose contents are to be added here
   * @return void
   */
  public void integrate( Cluster c )
  {
    for( int i = 0; i < c.getNumMembers(); i++ )
    {
      Point p = c.getOneMember( i );
      addMember( p );
    }
  }

  /**
   * gather info about the cluster so to view its id and members
   * 
   * @param void
   * @return cluster info
   */
  public String toString()
  {
    String str = "";
    str += id + ": cluster (" + numMembers + "): \n";
    for( int i = 0; i < numMembers; i++ )
      str += "  " + getOneMember(i).getDim1() 
          + "," + getOneMember(i).getDim2() + "\n";
    return str;
  }
}
