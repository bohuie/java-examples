import java.util.Random;

public class ArrayHistogram
{
  private int[]  numbers;
  private int[]  frequencies;
  // private int    count0, count1, count2, count3, count4, count5;
  private Random generator;

  public ArrayHistogram()
  {
    generator = new Random();
    numbers = new int[20];
    /*
    count0 = 0;
    count1 = 0;
    count2 = 0;
    count3 = 0;
    count4 = 0;
    count5 = 0;
    */
    frequencies = new int[ 6 ];  // range from 0 to 5 inclusive

    for( int i = 0; i < numbers.length; i++ )
    {
      // option 1: count frequency when num is generated
      numbers[i] = generator.nextInt( 6 );

      // typically, should initialize frequencies first
      
      // frequencies[ numbers[i] ] = frequencies[ numbers[i] ] + 1;
      frequencies[ numbers[i] ]++;
      /*
      if( numbers[i] == 0 )
        count0++;
      else if( numbers[i] == 1 )
        count1++;
      else if( numbers[i] == 2 )
        count2++;
      else if( numbers[i] == 3 )
        count3++;
      else if( numbers[i] == 4 )
        count4++;
      else if( numbers[i] == 5 )    // can just use else with no condition
        count5++;
      */
    }
  }

  public String toString()
  {
    String str = "";
    // put what's in numbers in str
    for( int i = 0; i < numbers.length; i++ )
      if( i == numbers.length - 1 )
        str = str + numbers[i];
      else
        str = str + numbers[i] + ", ";
    str += "\n";
    
    // put what's in frequencies in str
    for( int i = 0; i < frequencies.length; i++ )
      str = str + "number = " + i + ": " + frequencies[i] + "\n"; 
    return str;
  }
}
