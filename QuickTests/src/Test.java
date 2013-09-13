import java.util.Random;
import java.util.Scanner;


public class Test
{

  public static void main( String[] args )
  {
    String greeting1 = "hello there";
    String greeting2 = "yo";
    String greeting3 = "hello";
    System.out.println( "BEFORE:" );
    System.out.println( "greeting1 = " + greeting1 );
    System.out.println( "greeting2 = " + greeting2 );
    System.out.println( "greeting3 = " + greeting3 );
    
    greeting1 = greeting3;
    greeting2 = greeting3;
    System.out.println( "AFTER:" );
    System.out.println( "greeting1 = " + greeting1 );
    System.out.println( "greeting2 = " + greeting2 );
    System.out.println( "greeting3 = " + greeting3 );
    
    greeting3 = "hey";
    System.out.println( "WHAT IF:" );
    System.out.println( "greeting1 = " + greeting1 );
    System.out.println( "greeting2 = " + greeting2 );
    System.out.println( "greeting3 = " + greeting3 );
    
    Player one = new Player( 1, "ann" );
    Player two = new Player( 2, "bob" );
    Player thr = new Player( 3, "cam" );
    System.out.println( "BEFORE:" );
    System.out.println( "one = " + one.toString() );
    System.out.println( "two = " + two.toString() );
    System.out.println( "thr = " + thr.toString() );

    one = two;
    System.out.println( "AFTER:" );
    System.out.println( "one = " + one.toString() );
    System.out.println( "two = " + two.toString() );
    System.out.println( "thr = " + thr.toString() );

    two.name = "dan";
    System.out.println( "WHAT IF:" );
    System.out.println( "one = " + one.toString() );
    System.out.println( "two = " + two.toString() );
    System.out.println( "thr = " + thr.toString() );

    one.name = "eve";
    System.out.println( "WHAT IF:" );
    System.out.println( "one = " + one.toString() );
    System.out.println( "two = " + two.toString() );
    System.out.println( "thr = " + thr.toString() );

    one = thr;
    System.out.println( "WHAT IF:" );
    System.out.println( "one = " + one.toString() );
    System.out.println( "two = " + two.toString() );
    System.out.println( "thr = " + thr.toString() );
    
    System.out.println( "Testing scanner methods" );
    Scanner sysin = new Scanner( System.in );
    /*
    System.out.println( sysin.nextInt() );
    System.out.println( sysin.nextDouble() );
    */
    
    Random generator = new Random();
    System.out.println( generator.nextDouble() );
    
    long time = System.currentTimeMillis();
    System.out.println( time );
    long x0, p1, p2, N, xi;
    x0 = time;
    p1 = 234;
    p2 = 83;
    N = 100;
    xi = p1*x0 + p2;
    xi = xi % N;
    System.out.println( xi );
    x0 = xi;
    xi = p1*x0 + p2;
    xi = xi % N;
    System.out.println( xi );
    x0 = xi;
    xi = p1*x0 + p2;
    xi = xi % N;
    System.out.println( xi );
    x0 = xi;
    xi = p1*x0 + p2;
    xi = xi % N;
    System.out.println( xi );
    x0 = xi;
    xi = p1*x0 + p2;
    xi = xi % N;
    System.out.println( xi );
    
    Recursion ex = new Recursion( time );
    x0 = ex.showX0();
    xi = ex.showXi();
    xi = ex.computeAgain( xi );
    xi = ex.computeAgain( xi );
    xi = ex.computeAgain( xi );

    int    x = 50, y = 2;
    double d = 100.0/y; 
    char c = '2';
    boolean found = false;
    if( x > y && !found )
      System.out.println( "case 1" );
    if( x == d )
      System.out.println( "case 2" );
    if( x == c )
      System.out.println( "case 3" );
    if( c == d )
      System.out.println( "case 4" );
    if( 'B' == 'b' )
      System.out.println( "case 5" );
    if( 'B' < 'b' )
      System.out.println( "case 6" );
    
    /*
    for( int count=0; count<5; x=y )
      System.out.println( count );
    */
    
    NYCountdown nycd = new NYCountdown( 10 );
    
    for( y=2;;y-- )
    {
      System.out.println( y );
      if( y < 0 )
        break;
    }
    
    Stars asciiStars = new Stars( 6 );
    asciiStars.drawStars();
    asciiStars.drawArrowHead();
    
    MidtermStats mt2 = new MidtermStats( 200 );
    mt2.enterScores();
    System.out.println( "avg = " + mt2.calcAverage() );
    
    System.out.println( "Type in a word: " );
    String aWord = sysin.nextLine();
    System.out.println( "your word spelled backwards: " );
    for( int ch=aWord.length()-1; ch>=0; ch-- )
      System.out.print(  aWord.charAt( ch ) );
    System.out.println();
    
    TriangularMatrix tm = new TriangularMatrix( 3 );
    System.out.println( tm.toString() );
    // tm.convertToLower();
    tm.convertToUpper();
    System.out.println( tm.toString() );
  }

}
