public class CozaLozaWoza
{
  public CozaLozaWoza() {}
  
  public void printNumbers()
  {
    int i = 1;
    while( i <= 110 )
    {
      // #1: print something
      if( i % 3 == 0 )
      {
        if(( i % 5 == 0 )&&( i % 7 == 0 ))
          System.out.print( "cozalozawoza " );
        else if( i % 5 == 0 )
          System.out.print( "cozaloza " );
        else if( i % 7 == 0 )
          System.out.print(  "cozawoza " );
        else
          System.out.print( "coza ");
      }
      else if( i % 5 == 0 )
      {
        if( i % 7 == 0 )
          System.out.print(  "lozawoza " );
        else
          System.out.print(  "loza " );
      }
      else if( i % 7 == 0 )
        System.out.print( "woza ");
      else
        System.out.print( i + " " );
      
      // #2: every 11th number, do an extra println
      if( i % 11 == 0 )
      {
        System.out.println();
      }
      
      // #3: increment counter
      i++;
    }
  }
}
