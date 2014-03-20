public class TimeTable
{
  private int num;
  
  // in the test class, when we create the new object and call the constructor with 9,
  // this program will print the times table from 1 to 9
  public TimeTable( int N )
  {
    num = N;
  }
  
  public void prTable()
  {
    int i, j;
    
    for( i=1; i<=num; i++ )
    {
      for( j=1; j<=num; j++ )
      {
        if( i*j < 10 )
          System.out.print( " " + i*j + " " );
        else
          System.out.print( i*j + " " );        
      }
      System.out.println();
    }
  }
}
