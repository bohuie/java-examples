
public class TestPostcard
{

  /**
   * @param args
   */
  public static void main( String[] args )
  {
    Topic topic1, topic2, topic3;
    topic1 = new Topic( "dogs" );
    topic1.setupAssociations( "animal", "cat", "bone", "sit", "outside", "park", "doctor" );
    topic1.setupAssociations( "sleep", "beg", "play", "cookies", "run", "chase", "jump" );
    topic1.setupAssociations( "friend", "pet", "love", "buddy", "fun", "fast", "dogs" );
    topic1.setResponseAndProb( 1, "Casper will eat anything, Bitzy only eats meat.", 0.2 );
    topic1.setResponseAndProb( 2, "My dogs are the best.", 0.4 );
    topic1.setResponseAndProb( 3, "We go to the dog park everyday", 0.4 );
    
    topic2 = new Topic( "school" );
    topic2.setupAssociations( "friends", "class", "homework", "boring", "school", "teacher" );
    topic2.setupAssociations( "lunch", "break", "recess", "reading", "play", "study", "party" );
    topic2.setResponseAndProb( 1, "School is far away, but I have to go.", 0.3 );
    topic2.setResponseAndProb( 2, "What's your favourite subject?", 0.2 );
    topic2.setResponseAndProb( 3, "There are lots of people everywhere.", 0.5 );
    
    topic3 = new Topic( "cards" );
    topic3.setupAssociations( "game", "gambling", "suits", "competitive", "fun", "fast", "cards" );
    topic3.setupAssociations( "pass time", "entertainment", "hobby", "friends", "money" );
    topic3.setResponseAndProb( 1, "What's your favourite game?", 0.2 );
    topic3.setResponseAndProb( 2, "I like to play cards with my friends.", 0.1 );
    topic3.setResponseAndProb( 3, "Games are tons of fun!", 0.7 );

    Penpal viv = new Penpal( "Viv", 12, topic1, topic2, topic3 );
    Penpal lil = new Penpal( "Lil", 9, topic1, topic2, topic3 );
    System.out.println( lil.toString() );    
    lil.receivePostcard( "Life is fun here, how are your dogs doing? Should I buy a bone and cookies today? Made any friends yet?" );
    System.out.println( lil.toString() );    
    lil.createPostcard();
    System.out.println( lil.toString() ); 
    
    // viv's topics also got changed
//    System.out.println( viv.toString() );  
    
    // what if we create a new penpal now?
//    Penpal peg = new Penpal( "Peg", 8, topic1, topic2, topic3 );
//    System.out.println( peg.toString() );  
  }

}
