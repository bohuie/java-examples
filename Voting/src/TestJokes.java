
public class TestJokes
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    // create voters
    Voter ann = new Voter( "Ann" );
    Voter bob = new Voter( "Bob" );
    Voter cam = new Voter( "Cam" );
    Voter dan = new Voter( "Dan" );
    Voter eve = new Voter( "Eve" );

    // create board
    Board ballot1 = new Board( "Life is complex. It has real and imaginary components.",
        "What's a dilemma? A lemma that proves two results." );

    // make votes for the first ballot
    ann.castVote( ballot1, 1 );
    bob.castVote( ballot1, 1 );
    cam.castVote( ballot1, 2 );
    dan.castVote( ballot1, 1 );
    eve.castVote( ballot1, 2 );

    // show results
    ballot1.reportResults();

    // create board
    Board ballot2 = new Board( "What's a polar bear? A rectangular bear after a coordinate transform.",
        "What's your favouriate part of Math? Knot theory, really, NOT theory." );

    // make votes for the second ballot
    ann.castVote( ballot2, 1 );
    bob.castVote( ballot2, 3 );
    cam.castVote( ballot2, 2 );
    dan.castVote( ballot2, 1 );
    eve.castVote( ballot2, 2 );

    // show results
    ballot2.reportResults();

    // create board
    Board ballot3 = new Board( "Did you hear the story about the statistician? Probably.",
        "How many mathematicians does it take to screw in a light bulb? None, it's left to the reader as an exercise." );

    // make votes for the third ballot
    ann.castVote( ballot3, 1 );
    bob.castVote( ballot3, 2 );
    cam.castVote( ballot3, 2 );
    dan.castVote( ballot3, 1 );
    eve.castVote( ballot3, 2 );

    // show results
    ballot3.reportResults();
  }

}
