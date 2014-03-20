public class TestShoeSizes
{
  public static void main( String[] args )
  {
    Shoe m3 = new Shoe( 0, 3 );
    Shoe m5 = new Shoe( 0, 5 );
    Shoe m7 = new Shoe( 0, 7 );
    Shoe f5 = new Shoe( 1, 5 );
    Shoe f7 = new Shoe( 1, 7 );
    Shoe f9 = new Shoe( 1, 9 );
    
    System.out.println( f5.compareTo( f7 ) ); // f5 is smaller
    System.out.println( m5.compareTo( f7 ) );
    System.out.println( m5.compareTo( f5 ) ); // m5 is bigger
    System.out.println( m5.compareTo( f9 ) ); // m5 is smaller
    System.out.println( f7.compareTo( m5 ) );
    System.out.println( f7.compareTo( m3 ) ); // f7 is bigger
    System.out.println( f7.compareTo( m7 ) ); // f7 is smaller
  }
}
