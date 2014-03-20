import java.util.Random;
import java.util.Scanner;

public class Testing
{
  public static void main( String[] args )
  {
    /*
     * System.out.println( "Select one:" ); System.out.println( "Coffee" );
     * System.out.println( "Tea" ); Scanner sysin = new Scanner( System.in
     * ); String userInput = sysin.nextLine(); while( !userInput.equals(
     * "coffee" ) && !userInput.equals( "tea" ) ) { System.out.println(
     * "Type coffee or tea" ); userInput = sysin.nextLine(); }
     * System.out.print( "You selected: " + userInput + "\n" );
     */

    int counter;
    for( counter = 1; counter <= 5; counter++ )
      System.out.println( counter );

    int N = 10;
    /*
     * int i = 0; while( i < N ) { System.out.println( i + ": *" ); i++; }
     * 
     * while( N > 0 ) { System.out.println( N + ": *" ); N--; }
     */

    N = 5;
    for( int i = 0; i < N; i++ )
    {
      for( int j = 0; j <= i; j++ )
        System.out.print( "*" );
      System.out.println();
    }

    N = 6;
    for( int i = 0; i < N / 2; i++ )
    {
      for( int j = 0; j <= i; j++ )
        System.out.print( "*" );
      System.out.println();
    }
    for( int i = (N / 2) - 1; i > 0; i-- )
    {
      for( int j = 0; j < i; j++ )
        System.out.print( "*" );
      System.out.println();
    }

    int MAX = 10;
    int[] numbers;
    numbers = new int[MAX];
    Random generator = new Random();
    for( int i = 0; i < MAX; i++ )
    {
      numbers[i] = generator.nextInt( MAX );
      System.out.println( numbers[i] );
    }
    for( int i = 0; i < MAX; i++ )
    {
      int value = numbers[i];
      for( int j = 0; j < value; j++ )
        System.out.print( "*" );
      System.out.println();
    }

    int count = 0;
    while( count < 5 )
    {
      for( int i = 0; i < 2; i++ )
      {
        System.out.println( "count=" + count + ",i=" + i + ": here" );
        count++;
      }
    }
    int i = 5;
    for( i = 0; i < 8; i++ )
      if( i % 2 != 0 )
        System.out.println( "i=" + i + ": here" );

    Histogram hist = new Histogram( 10 );
    hist.readGrades();
    System.out.println( hist.toString() );

    int numPeople = 5;
    String[] names;
    names = new String[numPeople];
    for( i = 0; i < names.length; i++ )
      System.out.println( names[i] );

    int max = 10;
    int[] myArray;
    myArray = new int[max];
    for( i = 0; i < max; i++ )
      myArray[i] = i * i;
    myArray[4]++;
    myArray[2] = myArray[4] + myArray[6] - myArray[9];
    myArray[0] = 1;
    myArray[5] = myArray[0] + myArray[2];
    myArray[6] = myArray[9];
    for( i = 0; i < max; i++ )
      System.out.println( "i=" + i + ": " + myArray[i] );

    System.out.println( 3 < 5 );

    String[] posWords = { "awesome", "good", "cool" };
    String opinion = "This AWESOME show is totally worth it";
    System.out.println( containsOneOf( opinion, posWords ) );
    
    Scanner sysin = new Scanner( System.in );
    System.out.println( "Type in a word" );
    String word = sysin.nextLine();
    for( int ch = word.length() - 1; ch >= 0; ch-- )
      System.out.print( word.charAt( ch ) );
    System.out.println();

    i = 5;
    for( i=0; i<8; i++ )
      if( i % 2 != 0 )
          System.out.println( "i = " + i + ": here" );
    int y = i;
    System.out.println( "i after loop is " + y );
    
    /*
    String[] namesP = {"bob", "ann", "cam" };
    System.out.println( namesP.length );
    for( int ii=0; ii<=namesP.length; ii++ )
      System.out.println( namesP[ii] );
    System.out.println( namesP.length );
    */
    
    ClassGrades cg = new ClassGrades( 100, 2 );
    System.out.println( cg.toString() );
    ClassGrades cg2 = new ClassGrades( 2, 10 );
    System.out.println( cg2.toString() );
    cg.printEverything();
    cg2.printEverything();
  }

  public static boolean containsOneOf( String str, String[] targets )
  {
    String[] words = str.split( "\\s" ); // \\s = [ \\t\\n\\x0B\\f\\r]
    boolean found = false;
    // check each word in str
    for( int i = 0; i < words.length; i++ )
    {
      // check each target word
      for( int j = 0; j < targets.length; j++ )
      {
        System.out.print( "words[" + i + "] = " + words[i] + ", " );
        System.out.println( "targets[" + j + "] = " + targets[j] );
        if( words[i].equalsIgnoreCase( targets[j] ) )
        {
          found = true;
          break;
        }
      }
      if( found )
        break;
    }
    return found;
  }
}