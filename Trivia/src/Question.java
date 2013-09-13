/**
 * this class models a multiple choice question
 * 
 * design questions:
 * - what goes into a multiple choice question?
 * 
 * question, options, answer
 * 
 * implementation questions:
 * - what if different questions have different number of options?
 * - how to store the real answer?
 * 
 * @author bohuie
 */
public class Question
{
  private String          wording;    // actual question
  private String[]        options;    // possible answers
  private int             answer;     // real answer

  // constant
  public static final int NUMOPTS = 4;

  /**
   * constructor method
   */
  public Question()
  {
    wording = "";
    options = new String[NUMOPTS];
    answer = -1;
  }

  /**
   * mutates the question wording to what's given
   * 
   * @param question part of the question
   * @return void
   */
  public void setQuestion( String q )
  {
    wording = q;
  }

  /**
   * mutates the list of options to given values
   * 
   * @param option 1
   * @param option 2
   * @param option 3
   * @param option 4
   * @return void
   */
  public void setOptions( String o1, String o2, String o3, String o4 )
  {
    options[0] = o1;
    options[1] = o2;
    options[2] = o3;
    options[3] = o4;
  }

  /** 
   * mutates the answer to what's given, so long as it's within range
   * 
   * @param index to actual answer
   * @return void
   */
  public void setAnswer( int option )
  {
    if( option >= 0 && option < NUMOPTS )
      answer = option;
  }

  /**
   * accessor for question's real answer
   * 
   * @return option index
   */
  public int getAnswer()
  {
    return answer;
  }
  
  /**
   * this method prints the question portion without the real answer
   * 
   * @param void
   * @return question text
   */
  public String prQuestion()
  {
    String str = "";
    str += ">> " + wording + "\n";
    for( int i=0; i<NUMOPTS; i++ )
    {
      str += "   * " + options[i] + "\n";
    }
    return str;
  }
  
  /**
   * this method displays the attributes of the question
   * 
   * @param void
   * @return question and answer
   */
  public String toString()
  {
    String str = prQuestion();
    str += "   ANSWER: " + (answer+1) + "\n";
    return str;
  }
}
