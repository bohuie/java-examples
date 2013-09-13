/**
 * this class checks to see if a word is a palindrome. a word is a
 * palindrome if it is the same when read forwards and backwards.
 * 
 * design questions:
 * - how do we check if a word is a palindrome?
 * - do whitespaces count as part of the word?
 * - what happens if there are even or odd number of letters?
 * 
 * need to point to both front and back, then move until they cross
 * whitespaces shouldn't count, but easier in the code if they do
 * shouldn't matter even or odd
 * 
 * implementation questions:
 * - does the word need to be stored in this class?
 * - how do we count backwards and forwards at the same time?
 * - what is the stopping condition?
 * 
 * @author bohuie
 * 
 */
public class Palindrome
{
  private String word;

  /**
   * constructor method
   * 
   * @param word
   * @return void
   */
  public Palindrome( String wd )
  {
    word = wd;
  }

  /**
   * accessor method for word
   * 
   * @param void
   * @return word
   */
  public String getWord()
  {
    return word;
  }

  /**
   * checks to see if word is the same forwards and backwards
   * 
   * improvement: 
   * - how to make this method more efficient? (hint: twice as fast) 
   * - how to get it to skip spaces and consider non-whitespace
   *   characters only?
   * 
   * @param void
   * @return result
   */
  public boolean isPalindrome()
  {
    boolean rez = false;

    // setup two counters: one at the front, one at the back
    int first = 0;
    int last = word.length() - 1;

    // repeatedly check if the letters at the counters are the same
    while( first < word.length() )
    {
      // if word has an odd number of letters, then stop at the middle
      if( first == last )
      {
        rez = true;
        break;
      }
      else
      {
        // check if letters at the counters are the same
        if( word.charAt( first ) == word.charAt( last ) )
        {
          // letters are the same, continue checking
          System.out.println( "first = " + first + ": "
                                         + word.charAt( first ) );
          System.out.println( "last  = " + last + ": "
                                         + word.charAt( last ) );
          rez = true;
        }
        else
        {
          // letters are not the same, don't bother checking the rest
          rez = false;
          break;
        }

        // advance counters
        first++;
        last--;
      }
    }
    return rez;
  }
}
