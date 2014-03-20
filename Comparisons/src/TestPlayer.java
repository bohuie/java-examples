public class TestPlayer
{
  public static void main( String[] args )
  {
    Player p1 = new Player( 12, 9, 1976 );
    Player p2 = new Player( 31, 7, 1978 );
    Player p3 = new Player( 12, 12, 1976 );
    Player p4 = new Player( 24, 9, 1976 );
    
    System.out.println( "all bigger cases should return 1" );
    System.out.println( p1.compareToAnotherPlayer( p2 ) );
    System.out.println( p1.compareToAnotherPlayer( p3 ) );
    System.out.println( p1.compareToAnotherPlayer( p4 ) );
    
    System.out.println( "identical case should return 0" );
    System.out.println( p1.compareToAnotherPlayer( p1 ) );
    
    System.out.println( "all smaller cases should return -1" );
    System.out.println( p2.compareToAnotherPlayer( p1 ) );
    System.out.println( p3.compareToAnotherPlayer( p1 ) );
    System.out.println( p4.compareToAnotherPlayer( p1 ) );
  }
}
