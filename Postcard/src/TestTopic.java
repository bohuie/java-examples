
public class TestTopic
{
  public static void main( String[] args )
  {
    // create three topics
    Topic topic1, topic2, topic3;
    
    // setup topic1
    topic1 = new Topic( "dogs" );
    topic1.setupAssociations( "animal", "cat", "bone", "sit", "outside", "park", "doctor" );
    topic1.setupAssociations( "sleep", "beg", "play", "cookies", "run", "chase", "jump" );
    topic1.setupAssociations( "friend", "pet", "love", "buddy", "fun", "fast", "dogs" );
    topic1.setResponseAndProb( 1, "Casper will eat anything, Bitzy only eats meat.", 0.2 );
    topic1.setResponseAndProb( 2, "My dogs are the best.", 0.4 );
    topic1.setResponseAndProb( 3, "We go to the dog park everyday", 0.4 );
    
    // setup topic2
    topic2 = new Topic( "school" );
    topic2.setupAssociations( "friends", "class", "homework", "boring", "school", "teacher" );
    topic2.setupAssociations( "lunch", "break", "recess", "reading", "play", "study", "party" );
    topic2.setResponseAndProb( 1, "School is far away, but I have to go.", 0.3 );
    topic2.setResponseAndProb( 2, "What's your favourite subject?", 0.2 );
    topic2.setResponseAndProb( 3, "There are lots of people everywhere.", 0.5 );
    
    // setup topic3
    topic3 = new Topic( "cards" );
    topic3.setupAssociations( "game", "gambling", "suits", "competitive", "fun", "fast", "cards" );
    topic3.setupAssociations( "pass time", "entertainment", "hobby", "friends", "money" );
    topic3.setResponseAndProb( 1, "What's your favourite game?", 0.2 );
    topic3.setResponseAndProb( 2, "I like to play cards with my friends.", 0.1 );
    topic3.setResponseAndProb( 3, "Games are tons of fun!", 0.7 );
    
    // print out each topic
    System.out.println( topic1.toString() );
    System.out.println( topic2.toString() );
    System.out.println( topic3.toString() );
  }

}
