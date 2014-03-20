/**
 * Basic class for a word node.
 * 
 * @author Rodney Earl
 * 
 */
public class WordNode
{
  /**
   * Pointer to the next node.
   */
  protected WordNode next;
  /**
   * Pointer to the previous node.
   */
  protected WordNode previous;
  /**
   * String containing the word for this node.
   */
  protected String   word;

  /**
   * Constructor for a word node.
   * 
   * @param word
   *          The word stored in this node.
   */
  public WordNode( String word )
  {
    this.word = word;
    this.next = null;
    this.previous = null;
  }

  /**
   * Mutator for the node's word.
   * 
   * @param newWord
   *          The new word to be stored.
   */
  public void setWord( String newWord )
  {
    this.word = newWord;
  }

  /**
   * Accessor for the node's word.
   * 
   * @return The word in the node.
   */
  public String getWord()
  {
    return word;
  }

  /**
   * To string method for the node. Note: It is the same as the accessor,
   * but a good habit to get into making them.
   * 
   * @return A string containing the node's information.
   */
  public String toString()
  {
    return word;
  }
}
