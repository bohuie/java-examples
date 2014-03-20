import java.util.Random;

public class Changes
{
  public Changes()
  {
  }

  public void makeChanges( int x, Num n1, int[] a1 )
  {
    x = a1[0];
    n1.setValue( 0 );
    a1[2] = -1;
  }
  
  public int findInArray( int[] someNumbers, int target )
  {
    int location = -1;
    for( int i=0; i<someNumbers.length; i++ )
    {
      int num = someNumbers[ i ];
      if( num == target )
      {
        location = i;
        System.out.println( "found at index " + i );
        break;
      }
    }
    if( location == -1 )
      System.out.println( "target " + target + " was never found" );
    return location;
  }
  
  public static String changeWord( String[] words, int index )
  {
    String oldWord = words[index];
    words[index] = "tomato";
    return oldWord;
  }
}
