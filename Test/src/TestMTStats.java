public class TestMTStats
{
  public static void main( String[] args )
  {
    MidtermStats mt2 = new MidtermStats( 153 );
    mt2.enterScores();
    System.out.println( "Avg = " + mt2.calcAverage() );
  }
}
