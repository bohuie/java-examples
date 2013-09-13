/**
 * this class tests the Rhyme and animals classes
 * 
 * @author bohuie
 * 
 */
public class TestRhyme
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing Rhyme ..." );
    Rhyme olmac = new Rhyme();
    olmac.setNursery( Rhyme.OMACDONALD );
    System.out.println( olmac.toString() );

    Rhyme anisounds = new Rhyme();
    anisounds.setNursery( Rhyme.SOUNDSOF );
    System.out.println( anisounds.toString() );
  }

}
