import java.util.Random;

/**
 * make a class that creates a bunch of random numbers, figures out if each
 * one is odd or even, then counts the number of odds, and prints them out
 * 
 * @author bohuie
 */
public class Example
{
  private Random generator;
  private int max;
  
  public Example()
  {
    generator = new Random();
    max = 10;
  }
  
  public void checkNumbers()
  {
    int count = 0;
    for( int i=0; i<max; i++ )
    {
      int x = generator.nextInt();
      if( isOdd( x ) )
      {
        count++;
        System.out.println( x );
      }
    }
    System.out.println( "There are " + count + " odd numbers generated" );
  }
  
  private boolean isOdd( int num )
  {
    if( num % 2 == 0 )
      return false;
    else
      return true;
  }
}
