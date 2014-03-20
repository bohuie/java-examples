/**
 * very simple analysis on several patterns that exhibit one's positive or
 * negative opinion about a product
 * 
 * @author bohuie
 */
public class SentimentAnalysis
{
  private String         phrase;

  // constants
  private final String[] posWords = { "awesome", "good", "cool", "great", "useful" };
  private final String[] negWords = { "awful", "bad", "annoying", "crap", "horrible" };

  /**
   * constructor
   * @param opinion to be processed
   */
  public SentimentAnalysis( String opinion )
  {
    phrase = opinion;
  }

  /**
   * compares the positive and negative counts by simply subtracting the
   * negative count from the positive to determine the overall sentiment of
   * the phrase
   * 
   * check if phrase fits in any one of the known positive patterns:
   * - not NEG
   * - ...n't NEG
   * - is POS
   * - POS
   * - NEG not
   * 
   * check if phrase fits in any one of the known negative patterns:
   * - not POS
   * - ...n't POS
   * - is NEG
   * - NEG 
   * - POS not
   * - could/can be POS if  
   * - wouldn't be so NEG if
   * 
   * @param void
   * @return overall sentiment score
   */
  public int computeSentiment()
  {
    int posCount = 0;
    int negCount = 0;
    
    // check for more specific cases in the beginning
    if( phrase.contains( " can be " ) )
    {
      int pos = phrase.indexOf( " can be " );
      String after = phrase.substring( pos );
      String[] words = after.split( "\\s" );
      System.out.println( "has: can be, substring = " + after + ", word0 = " + words[3] );
      
      if( containsOneOf( words[3], posWords ) && words[4].equals( "if" ) )
        negCount++;
    }
    else if( phrase.contains( " could be " ) )
    {
      int pos = phrase.indexOf( " could be " );
      String after = phrase.substring( pos );
      String[] words = after.split( "\\s" );
      System.out.println( "has: could be, substring = " + after + ", word0 = " + words[3] );

      if( containsOneOf( words[3], posWords ) && words[4].equals( "if" ) )
        negCount++;
    }
    else if( phrase.contains( " wouldn't be so " ) )
    {
      int pos = phrase.indexOf( " wouldn't be so " );
      String after = phrase.substring( pos );
      String[] words = after.split( "\\s" );
      System.out.println( "has: wouldn't be so, substring = " + after + ", word0 = " + words[4] );

      if( containsOneOf( words[4], negWords ) && words[5].equals( "if" ) )
        posCount++;
    }
    else if( phrase.contains( " not " ) )
    {
      int pos = phrase.indexOf( " not " );
      String after = phrase.substring( pos );
      System.out.println( "has: not, substring = " + after );
      
      if( containsOneOf( after, posWords ) )
        negCount++;
      else if( containsOneOf( after, negWords ) )
        posCount++;
      else
      {
        String before = phrase.substring( 0, pos );
        System.out.println( "has: not, substring = " + before );

        if( containsOneOf( before, posWords ) )
          negCount++;
        else if( containsOneOf( before, negWords ) )
          posCount++;
      }
    }
    else if( phrase.contains( "n't " ) )
    {
      int pos = phrase.indexOf( "n't " );
      String after = phrase.substring( pos );
      System.out.println( "has: n't, substring = " + after );

      if( containsOneOf( after, posWords ) )
        negCount++;
      else if( containsOneOf( after, negWords ) )
        posCount++;
    }
    // case: "is good"     -> pos (here)
    // case: "is not good" -> neg (above) 
    //       as long as the "not" pattern is checked before this, we're ok
    else if( phrase.contains( " is " ) )
    { 
      int pos = phrase.indexOf( " is " );
      String after = phrase.substring( pos );
      System.out.println( "has: is, substring = " + after );

      if( containsOneOf( after, posWords ) )
        posCount++;
      else if( containsOneOf( after, negWords ) )
        negCount++;
    }
    // check for general cases at the end
    else if( containsOneOf( phrase, posWords ) )
    {
      System.out.println( "has: positive word, string = " + phrase );
      posCount++;
    }
    else if( containsOneOf( phrase, negWords ) )
    {
      System.out.println( "has: positive word, string = " + phrase );
      negCount++;      
    }

    int overall = posCount - negCount;
    return overall;
  }

   /**
   * checks to see if str has a potential target word in it
   * @param str
   * @param targets
   * @return whether str has a word that was in the set of targets
   */
  private boolean containsOneOf( String str, String[] targets )
  {
    String[] words = str.split( "\\s" ); // \\s = [ \\t\\n\\x0B\\f\\r]
    boolean found = false;
    // check each word in str
    for( int i = 0; i < words.length; i++ )
    {
      // check each target word
      for( int j = 0; j < targets.length; j++ )
        if( words[i].equalsIgnoreCase( targets[j] ) )
        {
          found = true;
          break;
        }
      if( found )
        break;
    }
    return found;
  }
}
