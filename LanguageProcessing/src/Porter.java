/**
 * this class models the porter stemmer algorithm. each step is explained
 * with the methods below.
 * 
 * design questions:
 * - how to translate the Porter rules into methods?
 * - should the class be able to process a phrase or just a word at a time?
 * - which helper methods are shared among these steps?
 * 
 * each step should be a method
 * more general if the program can process more than a word
 * 
 * implementation questions:
 * - how to manage and reduce redundant code?
 * - how to avoid hardcoding strings multiple times?
 * 
 * @author bohuie
 * 
 */
public class Porter
{
  String phrase;

  /**
   * constructor method
   * 
   * @param phrase
   */
  public Porter( String p )
  {
    // set everything to one case for simpler comparison situations
    phrase = p.toLowerCase();
  }

  /**
   * mutator for phrase
   * 
   * @param phrase
   * @return void
   */
  public void setPhrase( String p )
  {
    phrase = p.toLowerCase();
  }

  /**
   * splits the phrase by whitespace and stems each word in it
   * 
   * @param void
   * @return void
   */
  public void stem()
  {
    String rez = "";
    String[] words = phrase.split( "\\s" );
    for( int i = 0; i < words.length; i++ )
    {
      System.out.println( "stemming: " + words[i] + " ..." );
      rez += stemWord( words[i] ) + " ";
    }
    phrase = rez;
  }

  /**
   * stems the given word according to the Porter algorithm
   * 
   * @param original word
   * @return stemmed word
   */
  private String stemWord( String word )
  {
    String rez = "";
    
    // a word goes through all of these steps in the process
    rez = step1a( word );
    rez = step1b( rez );
    rez = step1c( rez );
    rez = step2( rez );
    rez = step3( rez );
    rez = step4( rez );
    rez = step5a( rez );
    rez = step5b( rez );
    return rez;
  }

  /**
   * changes plural endings via several cases
   * 
   * @param word
   * @return processed word
   */
  private String step1a( String word )
  {
    String rez = word;
    if( word.endsWith( "sses" ) )
      rez = word.substring( 0, word.length() - 2 );
    else if( word.endsWith( "ies" ) )
      rez = word.substring( 0, word.length() - 2 );
    else if( word.endsWith( "ss" ) )
      rez = word;
    else if( word.endsWith( "s" ) )
      rez = word.substring( 0, word.length() - 1 );
    return rez;
  }

  /**
   * removes past participles
   * 
   * @param word
   * @return processed word
   */
  private String step1b( String word )
  {
    String rez = word;
    String stem;
    int condition = 0;

    // condition 1: (m>0)EED -> EE
    if( word.endsWith( "eed" ) )
    {
      stem = word.substring( 0, word.length() - 3 );
      if( countM( stem ) > 0 )
        rez = stem + "ee";
    }
    // condition 2: (*v*)ED -> null
    else if( word.endsWith( "ed" ) )
    {
      stem = word.substring( 0, word.length() - 2 );
      if( hasVowel( stem ) )
      {
        rez = stem;
        condition = 2;
      }
    }
    // condition 3: (*v*)ING -> null
    else if( word.endsWith( "ing" ) )
    {
      stem = word.substring( 0, word.length() - 3 );
      if( hasVowel( stem ) )
      {
        rez = stem;
        condition = 3;
      }
    }

    // if the word went through condition 2 or 3, we patch things up
    if( condition == 2 || condition == 3 )
      rez = patch1b( rez );
    return rez;
  }

  /**
   * helper method for step1b to do patching for -ed and -ing cases
   * 
   * @param word
   * @return processed word
   */
  private String patch1b( String word )
  {
    String rez = word;
    if( word.endsWith( "at" ) || word.endsWith( "bl" )
        || word.endsWith( "iz" ) )
      rez = word + "e";
    else if( endsWithDouble( word ) )
    {
      // get rid of double letter only if word doesn't end in l,s,z
      if( word.endsWith( "l" ) || word.endsWith( "s" )
          || word.endsWith( "z" ) )
        rez = word;
      else
        rez = word.substring( 0, word.length() - 1 );
    }
    else if( countM( word ) == 1 && isOcvc( word ) )
      rez = word + "e";
    return rez;
  }

  /**
   * checks if the word ends in two identical letters
   * 
   * @param word
   * @return result
   */
  private boolean endsWithDouble( String word )
  {
    boolean rez = false;
    if( word.length() > 2 )
    {
      char last = word.charAt( word.length() - 1 );
      char secondlast = word.charAt( word.length() - 2 );
      if( last == secondlast )
        rez = true;
    }
    return rez;
  }

  /**
   * checks if the word ends in cvc, where the second c is not w,x,y
   * 
   * @param word
   * @return result
   */
  private boolean isOcvc( String word )
  {
    boolean rez = false;

    // check for cvc structure
    boolean cvc = false;
    if( word.length() == 3 )
    {
      char last = word.charAt( word.length() - 1 );
      char secondlast = word.charAt( word.length() - 2 );
      char thirdlast = word.charAt( word.length() - 3 );
      if( !isAEIOU( thirdlast ) && isVowel( secondlast, thirdlast )
          && !isVowel( last, secondlast ) )
        cvc = true;
    }
    else if( word.length() > 3 )
    {
      char last = word.charAt( word.length() - 1 );
      char secondlast = word.charAt( word.length() - 2 );
      char thirdlast = word.charAt( word.length() - 3 );
      char before = word.charAt( word.length() - 4 );
      if( !isVowel( thirdlast, before ) && isVowel( secondlast, thirdlast )
          && !isVowel( last, secondlast ) )
        cvc = true;
    }

    if( cvc )
    {
      // check to make sure second c doesn't end in w,x,y
      if( !word.endsWith( "w" ) && !word.endsWith( "x" )
          && !word.endsWith( "y" ) )
        rez = true;
    }
    return rez;
  }

  /*
   * parse the word according to the expression [C](VC)^m[V] and count the
   * number of times (VC) repeats itself
   * 
   * @param word
   * @return m
   */
  public int countM( String word )
  {
    int m = 0;

    // use a flag to denote:
    // 0 = haven't started counting yet
    // 1 = counting vowels
    // 2 = counting consonants
    int flag = 0;

    // for the first letter, if it's a consonant, do nothing
    // switch flag if it's a vowel
    char first = word.charAt( 0 );
    if( isAEIOU( first ) )
      flag = 1;

    // go through remaining letters in the word
    // only increment m if we were at flag=1 and now we see consonant
    for( int i = 1; i < word.length(); i++ )
    {
      char letter = word.charAt( i );
      char before = word.charAt( i - 1 );
      if( isVowel( letter, before ) )
        flag = 1;
      else
      {
        // if letter is not a vowel, it must be a consonant
        // check value of flag
        if( flag == 1 )
          m++;
        // otherwise, flag was 0 or 2, in which case, don't increment

        // change flag to show we're counting consonants
        flag = 2;
      }
    }
    return m;
  }

  /**
   * condition for handling y
   * 
   * @param word
   * @return processed word
   */
  private String step1c( String word )
  {
    String rez = word;

    // if condition is met, then change ending
    if( word.endsWith( "y" ) )
    {
      // check if stem contains a vowel
      String stem = word.substring( 0, word.length() - 1 );
      if( hasVowel( stem ) )
        rez = stem + "i";
    }
    return rez;
  }

  /**
   * helper method to check if a word contains a vowel or not
   * 
   * @param word
   * @return result
   */
  private boolean hasVowel( String word )
  {
    boolean rez = false;
    // check each letter of the word to see if it is a vowel
    if( isAEIOU( word.charAt( 0 ) ) )
    {
      rez = true;
      // don't bother checking the rest if the first letter is a vowel
    }
    else
    {
      for( int i = 1; i < word.length(); i++ )
      {
        if( isVowel( word.charAt( i ), word.charAt( i - 1 ) ) )
        {
          // once we find the letter, stop checking
          rez = true;
          break;
        }
      }
    }
    return rez;
  }

  /**
   * helper method to see if a letter is definitely a true vowel
   * 
   * @param letter
   * @return result
   */
  private boolean isAEIOU( char letter )
  {
    boolean rez = false;
    if( letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o'
        || letter == 'u' )
      rez = true;
    return rez;
  }

  /**
   * a letter is a vowel if it is a,e,i,o,u or if it is y preceded by a
   * consonant
   * 
   * @param letter
   * @param before
   * @return result
   */
  private boolean isVowel( char letter, char before )
  {
    boolean rez = false;
    if( isAEIOU( letter ) )
      rez = true;
    else if( letter == 'y' && isAEIOU( before ) != true )
      rez = true;
    return rez;
  }

  /**
   * conditions for simplifying multiple suffixes
   * 
   * @param word
   * @return processed word
   */
  private String step2( String word )
  {
    String rez = word;
    int m = 0;

    if( word.compareTo( "conditional" ) == 0 )
      System.out.println( "here" );

    if( word.endsWith( "ational" ) )
      rez = removeSuffix( rez, "ational", m ) + "ate";
    else if( word.endsWith( "tional" ) )
      rez = removeSuffix( rez, "tional", m ) + "tion";
    else if( word.endsWith( "enci" ) )
      rez = removeSuffix( rez, "enci", m ) + "ence";
    else if( word.endsWith( "anci" ) )
      rez = removeSuffix( rez, "anci", m ) + "ance";
    else if( word.endsWith( "izer" ) )
      rez = removeSuffix( rez, "izer", m ) + "ize";
    else if( word.endsWith( "abli" ) )
      rez = removeSuffix( rez, "abli", m ) + "able";
    else if( word.endsWith( "alli" ) )
      rez = removeSuffix( rez, "alli", m ) + "al";
    else if( word.endsWith( "entli" ) )
      rez = removeSuffix( rez, "entli", m ) + "ent";
    else if( word.endsWith( "eli" ) )
      rez = removeSuffix( rez, "eli", m ) + "e";
    else if( word.endsWith( "ousli" ) )
      rez = removeSuffix( rez, "ousli", m ) + "ous";
    else if( word.endsWith( "ization" ) )
      rez = removeSuffix( rez, "ization", m ) + "ize";
    else if( word.endsWith( "ation" ) )
      rez = removeSuffix( rez, "ation", m ) + "ate";
    else if( word.endsWith( "ator" ) )
      rez = removeSuffix( rez, "ator", m ) + "ate";
    else if( word.endsWith( "alism" ) )
      rez = removeSuffix( rez, "alism", m ) + "al";
    else if( word.endsWith( "iveness" ) )
      rez = removeSuffix( rez, "iveness", m ) + "ive";
    else if( word.endsWith( "fulness" ) )
      rez = removeSuffix( rez, "fulness", m ) + "ful";
    else if( word.endsWith( "ousness" ) )
      rez = removeSuffix( rez, "ousness", m ) + "ous";
    else if( word.endsWith( "aliti" ) )
      rez = removeSuffix( rez, "aliti", m ) + "al";
    else if( word.endsWith( "iviti" ) )
      rez = removeSuffix( rez, "iviti", m ) + "ive";
    else if( word.endsWith( "biliti" ) )
      rez = removeSuffix( rez, "biliti", m ) + "ble";

    return rez;
  }

  /**
   * conditions for simplifying various suffixes
   * 
   * @param word
   * @return processed word
   */
  private String step3( String word )
  {
    String rez = word;
    int m = 0;

    if( word.endsWith( "icate" ) )
      rez = removeSuffix( rez, "icate", m ) + "ic";
    else if( word.endsWith( "ative" ) )
      rez = removeSuffix( rez, "ative", m );
    else if( word.endsWith( "alize" ) )
      rez = removeSuffix( rez, "alize", m ) + "al";
    else if( word.endsWith( "iciti" ) )
      rez = removeSuffix( rez, "iciti", m ) + "ic";
    else if( word.endsWith( "ical" ) )
      rez = removeSuffix( rez, "ical", m ) + "ic";
    else if( word.endsWith( "ful" ) )
      rez = removeSuffix( rez, "ful", m );
    else if( word.endsWith( "ness" ) )
      rez = removeSuffix( rez, "ness", m );

    return rez;
  }

  /**
   * conditions for removing various suffixes
   * 
   * @param word
   * @return processed word
   */
  private String step4( String word )
  {
    String rez = word;
    int m = 1;

    if( word.endsWith( "al" ) )
      rez = removeSuffix( rez, "al", m );
    else if( word.endsWith( "ance" ) )
      rez = removeSuffix( rez, "ance", m );
    else if( word.endsWith( "ence" ) )
      rez = removeSuffix( rez, "ence", m );
    else if( word.endsWith( "er" ) )
      rez = removeSuffix( rez, "er", m );
    else if( word.endsWith( "ic" ) )
      rez = removeSuffix( rez, "ic", m );
    else if( word.endsWith( "able" ) )
      rez = removeSuffix( rez, "able", m );
    else if( word.endsWith( "ible" ) )
      rez = removeSuffix( rez, "ible", m );
    else if( word.endsWith( "ant" ) )
      rez = removeSuffix( rez, "ant", m );
    else if( word.endsWith( "ement" ) )
      rez = removeSuffix( rez, "ement", m );
    else if( word.endsWith( "ment" ) )
      rez = removeSuffix( rez, "ment", m );
    else if( word.endsWith( "ent" ) )
      rez = removeSuffix( rez, "ent", m );
    else if( word.endsWith( "ion" ) )
    {
      String stem = word.substring( 0, word.length() - 3 );
      if( countM( stem ) > 1 )
      {
        if( stem.endsWith( "s" ) || stem.endsWith( "t" ) )
          rez = stem;
      }
    }
    else if( word.endsWith( "ou" ) )
      rez = removeSuffix( rez, "ou", m );
    else if( word.endsWith( "ism" ) )
      rez = removeSuffix( rez, "ism", m );
    else if( word.endsWith( "ate" ) )
      rez = removeSuffix( rez, "ate", m );
    else if( word.endsWith( "iti" ) )
      rez = removeSuffix( rez, "iti", m );
    else if( word.endsWith( "ous" ) )
      rez = removeSuffix( rez, "ous", m );
    else if( word.endsWith( "ive" ) )
      rez = removeSuffix( rez, "ive", m );
    else if( word.endsWith( "ize" ) )
      rez = removeSuffix( rez, "ize", m );

    return rez;
  }

  /**
   * removes suffix from word if stem has required m count, otherwise
   * return original word
   * 
   * @param word
   * @param suffix
   * @param m
   * @return processed word
   */
  private String removeSuffix( String word, String suffix, int m )
  {
    String rez = word;
    String stem = word.substring( 0, word.length() - suffix.length() );
    if( countM( stem ) > m )
      rez = stem;
    return rez;
  }

  /**
   * conditions for removing e in certain cases
   * 
   * @param word
   * @return processed word
   */
  private String step5a( String word )
  {
    String rez = word;
    String stem;
    String suffix = "e";
    if( word.endsWith( suffix ) )
    {
      stem = word.substring( 0, word.length() - suffix.length() );
      int m = countM( stem );
      if( m > 1 )
        rez = stem;
      else if( m == 1 )
      {
        if( !isOcvc( stem ) )
          rez = stem;
      }
    }
    return rez;
  }

  /**
   * conditions for changing double L's to single L
   * 
   * @param word
   * @return processed word
   */
  private String step5b( String word )
  {
    String rez = word;
    if( countM( word ) > 1 
        && endsWithDouble( word )
        && word.endsWith( "l" ) )
      rez = word.substring( 0, word.length() - 1 );
    return rez;
  }

  /**
   * prints the phrase
   * 
   * @param void
   * @return phrase
   */
  public String toSring()
  {
    return phrase;
  }
}
