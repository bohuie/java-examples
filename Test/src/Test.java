public class Test
{
  public static void main( String[] args )
  {
    int[][] multi = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    System.out.println( multi.length );
    System.out.println( multi[1].length );

    int timeInSeconds = 9999;
    int seconds = timeInSeconds % 60;
    int minutes = (timeInSeconds / 60) % 60;
    int hours = timeInSeconds / 60 / 60;
    System.out.print( timeInSeconds + " seconds is " );
    System.out.println( hours + " hours, " + minutes + " minutes, and "
        + seconds + " seconds" );

    int i = 5;
    for( i = 0; i < 10; i++ )
      if( i % 2 == 1 )
        break;
    int y = i;
    System.out.println( "y = " + y );

    /*
    int x = 5;
    y = 10;
    boolean z = true;
    System.out.println( ((x < y) && (y > x)) );
    System.out.println( !(x == y) );
    System.out.println( (z || !z) );
    System.out.println( ((x + 5) >= y) );

    int num1 = 2;
    int num2 = 10;
    if( num1 < num2 )
      System.out.print( "1 " );
    if( (num1 + 5) < num2 )
      System.out.print( "2 " );
    else
      System.out.print( "3 " );
    System.out.print( "4 " );

    num1 = 4;
    num2 = 5;
    if( num1 < num2 )
      num1 += num1;
    if( (num1 + 5) < num2 )
      num1 += 1;
    else
      num1 += 2;
    System.out.println( num1 );

    System.out.println( "Final MC Question 7 start:\n" );
    int j;
    for( i = 1; i <= 5; i++ )
      for( j = 1; j <= 10; j++ )
      {
        System.out.println( "i = " + i + ", j = " + j );
        j = i * j;
        if( j % 5 == 0 )
          System.out.println( "i = " + i + ", j = " + j + ", here" );
      }
    System.out.println( "Final MC Question 7 end\n" );

    int[][] arr2d;
    arr2d = new int[3][5];
    System.out.println( arr2d.length );

    Dog casper = new Dog( "Casper" );
    Dog bitzy  = new Dog( "Bitzy" );
    Dog minnie = new Dog( "Minnie" );
    System.out.print( casper.count + ", " + bitzy.count + "\n" );
    
    Changes cobject = new Changes();
    y = 5;
    Num n = new Num( 10 );
    int[] array1 = new int[ y ];
    for( i=0; i<array1.length; i++ )
      array1[ i ] = 20;
    cobject.makeChanges( y, n, array1 );
    System.out.println( y + ", " + n.toString() + ", " + array1[2] );

    System.out.println( "***** part 2 *****" );
    
    int count = 2;
    int MAX = 10;
    String xx = "abba";
    String yy = "abba";
    boolean done = true;
    System.out.println( xx.charAt( 1 ) == yy.charAt( 2 ) );
    System.out.println( !!!done );
    System.out.println( done || MAX < count );
    System.out.println( ( count*5 > MAX )||( xx.equals( yy ) && !done ) );
    System.out.println( xx.toLowerCase().equals( yy ) && (count*count > MAX*count) );

    count = 0;
    while( count < 5 )
      for( i = 0; i < 10; i++ )
      {
        // System.out.println( "count = " + count + ", i = " + i );
        if( i % 2 == 1 )
        {
          i = i * i;
          System.out
              .println( "count = " + count + ", i = " + i + ", here" );
        }
        count++;
      }
    
    MAX = 5;
    j = 0;
    for( i=0; i<MAX; i++ )
    {
      System.out.println( "i = " + i );
      for( j=MAX; j>i; j-- )
      {
        System.out.println( "   j = " + j );
        if( i == j )
          break;
      }
    }
    System.out.println( "final value: i = " + i );    
    System.out.println( "final value: j = " + j );    
    
    MAX = 5;
    i = 0;
    j = 0;
    while( i<MAX )
    {
      System.out.println( "i = " + i );
      j=MAX;
      while( j>i )
      {
        System.out.println( "   j = " + j );
        if( i == j )
          break;
        j--;
      }
      i++;
    }
    System.out.println( "final value: i = " + i );    
    System.out.println( "final value: j = " + j );    
    
    String[] fruits = { "apple", "banana", "cranberry", "daikon" };
    System.out.println( Changes.changeWord( fruits, 2 ) );
    for( i=0; i<fruits.length; i++ )
      System.out.println( "i = " + i + ": " + fruits[i] );
      */
  }
}
