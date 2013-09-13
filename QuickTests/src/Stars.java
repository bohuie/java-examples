
public class Stars
{
  private int maxRows;
  
  public Stars( int numRows )
  {
    maxRows = numRows;
  }
  
  public void drawStars()
  {
    int row;
    for( row=1; row<maxRows; row++ )
    {
      int star;
      for( star=1; star<=row; star++ )
        System.out.print( "*" );      
      System.out.println();
    }
  }
  
  public void drawArrowHead()
  {
    int row;
    for( row=1; row<maxRows/2; row++ )
    {
      int star;
      for( star=1; star<=row; star++ )
        System.out.print( "*" );      
      System.out.println();
    }
    for( row=maxRows/2; row>0; row-- )
    {
      int star;
      for( star=1; star<=row; star++ )
        System.out.print( "*" );      
      System.out.println();
    }
  }
}
