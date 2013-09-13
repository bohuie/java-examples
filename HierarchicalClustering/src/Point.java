/**
 * a two dimensional point
 * @author bohuie
 *
 */
public class Point
{
  private int x1;
  private int x2;
  
  public Point( int dim1, int dim2 )
  {
    x1 = dim1;
    x2 = dim2;
  }
  
  public int getDim1()
  {
    return x1;
  }
  
  public int getDim2()
  {
    return x2;
  }
}
