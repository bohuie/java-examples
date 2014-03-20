/**
 * Basic Interface for a Word Processor. The Data structure is to be a
 * doubly-linked list, with both queue and stack behaviours.
 * 
 * @author Rodney Earl
 * 
 */
public interface WordProcessorInterface
{
  /**
   * Add a word to the processor. "Enqueue/Push".
   * 
   * @param word
   *          New word that has been typed.
   * @return Return true if successfully added to the word processor.
   */
  public boolean type( String word );

  /**
   * Remove a word from the processor. "Pop".
   * 
   * @return Return true if successfully removed from the word processor.
   */
  public boolean undo();

  /**
   * Print a word from the processor. "Dequeue".
   * 
   * @return The first word to be printed.
   */
  public String print();

  /**
   * Boolean method to determine if a word processor is empty.
   * 
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty();
}
