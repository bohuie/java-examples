public class ESL
{
  private String myWord;
  
  /**
   * constructor
   * @param word
   */
  public ESL( String word )
  {
    myWord = word.toLowerCase();
  }
  
  /**
   * lets user change the word to a new word
   * @param newWord
   * @return void
   */
  public void setWord( String newWord )
  {
    myWord = newWord.toLowerCase();
  }
  
  /**
   * say the word after applying appropriate rules
   * @param void
   * @return void 
   */
  public void speak()
  {
    char letter1 = myWord.charAt( 0 );
    char letter2 = myWord.charAt( 1 );
    applyRules( letter1, letter2 );
    System.out.println( myWord );
  }
  
  /**
   * helper method to determine which rule to apply if any
   * @param firstLetter
   * @param secondLetter
   * @return void
   */
  private void applyRules( char firstLetter, char secondLetter )
  {
    if( !isVowel( firstLetter ) )
    {
      if( firstLetter == 'p' )
      {
        // handle this case with rule 40
        if( secondLetter == 'l' )
          handlePL();
      }
      else
      {
        // handle this case with rule 39
        if( secondLetter == 'r' )
          swapRL( firstLetter );
        else if( secondLetter == 'l' )
          swapLR( firstLetter );        
      }
    }
  }

  /**
   * helper method to replace r with l
   * @param letter
   * @return void
   */
  private void swapRL( char letter )
  {
    myWord = letter + "l" + myWord.substring( 2 );
  }
  
  /** 
   * helper method to replace l with r
   * @param letter
   * @return void
   */
  private void swapLR( char letter )
  {
    myWord = letter + "r" + myWord.substring( 2 );
  }

  /**
   * helper method to delete l
   * @param void
   * @return void
   */
  private void handlePL()
  {
    String tmp = "";
    tmp = "p" + myWord.substring( 2 );
    myWord = tmp;   
  }

  /**
   * checks if the given letter is one of a,e,i,o,u 
   * @param letter
   * @return true if letter is a vowel, false otherwise
   */
  private boolean isVowel( char letter )
  {
    boolean rez = false;
    if( letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o'
        || letter == 'u' )
      rez = true;
    return rez;
  }
}