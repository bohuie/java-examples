public class TestESL
{
  public static void main( String[] args )
  {
    ESL learner = new ESL( "free" );
    learner.speak();
    learner.setWord( "slew" );
    learner.speak();
    learner.setWord( "please" );
    learner.speak();
  }
}