/**
 * this class tests the porter stemmer class
 * 
 * @author bohuie
 * 
 */
public class TestPorter
{

  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    Porter tester = new Porter( "" );
    System.out.println( "********** Testing Porter Stemmer ..." );

    System.out.println( "********** Testing 1a ..." );
    tester.setPhrase( "CAResses ponies ties caress cats" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    System.out.println( "********** Testing 1c ..." );
    tester.setPhrase( "happy sky" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    System.out.println( "********** Testing countM ..." );
    System.out.println( "tr: " + tester.countM( "tr" ) );
    System.out.println( "ee: " + tester.countM( "ee" ) );
    System.out.println( "tree: " + tester.countM( "tree" ) );
    System.out.println( "y: " + tester.countM( "y" ) );
    System.out.println( "by: " + tester.countM( "by" ) );
    System.out.println( "trouble: " + tester.countM( "trouble" ) );
    System.out.println( "oats: " + tester.countM( "oats" ) );
    System.out.println( "trees: " + tester.countM( "trees" ) );
    System.out.println( "ivy: " + tester.countM( "ivy" ) );
    System.out.println( "troubles: " + tester.countM( "troubles" ) );
    System.out.println( "private: " + tester.countM( "private" ) );
    System.out.println( "oaten: " + tester.countM( "oaten" ) );
    System.out.println( "orrery: " + tester.countM( "orrery" ) );

    System.out.println( "********** Testing 1b ..." );
    tester.setPhrase( "feed agreed plastered bled motoring sing" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    tester.setPhrase( "hopping tanned falling hissing fizzed failing filing" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    System.out.println( "********** Testing 2 ..." );
    tester.setPhrase( "relational conditional rational valenci hesitanci" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
    tester.setPhrase( "digitizer conformabli radicalli differentli vileli" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
    tester.setPhrase( "analogousli vietnamization predication operator feudalism" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
    tester.setPhrase( "decisiveness hopefulness callousness formaliti sensitiviti sensibiliti" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
    
    System.out.println( "********** Testing 3 ..." );
    tester.setPhrase( "triplicate formative formalize electriciti electrical hopeful goodness" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
    
    System.out.println( "********** Testing 4 ..." );
    tester.setPhrase( "revival allowance inference airliner gyroscopic adjustable defensible irritant replacement adjustment" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
    tester.setPhrase( "dependent adoption homologou communism activate angulariti homologous effective bowdlerize" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    System.out.println( "********** Testing 5a ..." );
    tester.setPhrase( "probate rate cease" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    System.out.println( "********** Testing 5b ..." );
    tester.setPhrase( "controll roll" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );

    System.out.println( "********** Testing general ..." );
    tester.setPhrase( "connect connected connecting connection connections" );
    System.out.println( "before: " + tester.toSring() );
    tester.stem();
    System.out.println( "after:  " + tester.toSring() );
  }
}
