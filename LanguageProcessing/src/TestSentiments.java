
public class TestSentiments
{
  public static void main( String[] args )
  {
    SentimentAnalysis sa;
    
    System.out.println( "********** testing the longer, specific patterns" );
    sa = new SentimentAnalysis( "this shop can be good if it weren't so small" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "this shop could be awesome if it weren't so small" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "this guy wouldn't be so annoying if it weren't monday" );
    System.out.println( sa.computeSentiment() );

    System.out.println( "********** testing the NOT patterns" );
    sa = new SentimentAnalysis( "bad is not crap" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "winter is not good" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "cool not " );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "awful not " );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "this ain't cool" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "this ain't half bad" );
    System.out.println( sa.computeSentiment() );
    
    System.out.println( "********** testing the simple patterns" );
    sa = new SentimentAnalysis( "this shop is pretty awesome" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "this tank is pretty horrible" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "letters are still cool" );
    System.out.println( sa.computeSentiment() );
    sa = new SentimentAnalysis( "bad attitude" );
    System.out.println( sa.computeSentiment() );
  }
}
