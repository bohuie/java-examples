/**
 * Class that implements a basic word processor. Uses doubly-linked lists
 * and a queue/stack data structure.
 * 
 * @author Rodney Earl
 * 
 */
public class WordProcessor implements WordProcessorInterface
{
  /**
   * Pointer for the start of the word processor.
   */
  private WordNode wordProcessorStart;
  /**
   * Pointer for the end of the word processor.
   */
  private WordNode wordProcessorEnd;

  /**
   * Constructor for the word processor.
   */
  public WordProcessor()
  {
    wordProcessorStart = null;
    wordProcessorEnd = null;
  }

  @Override
  /**
   * Add a new word to the word processor.  Enqueue/Push.
   * @param word The word that is being typed/added.
   * @return True if successfully added to the processor.
   */
  public boolean type( String word )
  {
    boolean pass = false;
    WordNode newWord = new WordNode( word );
    // Case1: Empty Word Processor
    if( this.isEmpty() )
    {
      wordProcessorStart = newWord;
      wordProcessorEnd = newWord;
      pass = true;
    }
    // Case2: New first element
    else
    {
      wordProcessorStart.previous = newWord;
      newWord.next = wordProcessorStart;
      wordProcessorStart = newWord;
      pass = true;
    }

    return pass;
  }

  @Override
  /**
   * Removed the last word typed.  Pop.
   * @return True if successfully deleted from the processor.
   */
  public boolean undo()
  {
    boolean pass = false;
    // Case1: Empty node, do nothing
    if( this.isEmpty() )
    {
      pass = true;
    }
    // Case2: One Word
    else if( wordProcessorStart == wordProcessorEnd )
    {
      wordProcessorStart = null;
      wordProcessorEnd = null;
      pass = true;
    }
    // Case3: Delete first element
    else
    {
      wordProcessorStart = wordProcessorStart.next;
      wordProcessorStart.previous.next = null;
      wordProcessorStart.previous = null;
      pass = true;
    }

    return pass;
  }

  @Override
  /**
   * Print the first word in the word processor.  Dequeue.
   * @return String of the word being printed.
   */
  public String print()
  {
    String wordToPrint = null;
    // Case1: Empty, do nothing
    if( this.isEmpty() )
    {
      return "";
    }
    // Case2: One Word
    else if( wordProcessorStart == wordProcessorEnd )
    {
      wordToPrint = wordProcessorEnd.getWord();
      wordProcessorStart = null;
      wordProcessorEnd = null;
      return wordToPrint;
    }
    // Case3: "Dequeue" the word and remove it
    else
    {
      wordToPrint = wordProcessorEnd.getWord();
      wordProcessorEnd = wordProcessorEnd.previous;
      wordProcessorEnd.next.previous = null;
      wordProcessorEnd.next = null;
      return wordToPrint;
    }
  }

  @Override
  /**
   * Method to determine if the word processor is empty or not.
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty()
  {
    if( null == wordProcessorStart )
      return true;
    else
      return false;
  }

}
