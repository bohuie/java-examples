import java.util.Random;

/**
 * the main purpose of this class is to receive a postcard from someone and
 * respond to it by creating a postcard based on one of several topics that
 * it is aware of
 * 
 * @author bohuie
 * 
 */
public class Penpal
{
  private Topic  topic1;
  private Topic  topic2;
  private Topic  topic3;
  private String myName;
  private int    uniqueID;
  private Random generator;

  /**
   * constructor
   */
  public Penpal( String name, int id, Topic t1, Topic t2, Topic t3 )
  {
    myName = name;
    uniqueID = id;
    generator = new Random();
    topic1 = t1;
    topic2 = t2;
    topic3 = t3;
  }

  /**
   * takes some postcard message, processes it, and updates activation
   * levels accordingly
   * 
   * @param postcard
   *          content
   * @return void
   */
  public void receivePostcard( String postcard )
  {
    String[] words = postcard.split( "\\s" );
    for( int i = 0; i < words.length; i++ )
    {
      topic1.match( words[i] );
      topic2.match( words[i] );
      topic3.match( words[i] );
    }
  }

  private double normalize( double val, double sum )
  {
    double rez = 0.0;
    rez = val / sum;
    return rez;
  }

  /**
   * generates postcard content based on topics' current activation levels
   * 
   * @param void
   * @return void
   */
  public void createPostcard()
  {
    String myMessage = "";
    // check each topic's activation levels
    int act1 = topic1.getActivation();
    int act2 = topic2.getActivation();
    int act3 = topic3.getActivation();

    // convert each activation to a probability using formula: pr_i = act_i
    // / ( act1 + act2 + act3 )
    int sum123 = act1 + act2 + act3;
    double pr1 = normalize( act1, sum123 );
    double pr2 = normalize( act2, sum123 );
    double pr3 = normalize( act3, sum123 );

    // let pr be a random number between 0.0 and 1.0
    double pr = generator.nextDouble();

    // if pr is less than pr_1, call topic 1's genTopicResponse() method
    // likewise, if pr is less than pr_2 and pr_3 respectively,
    // call those topic's genTopicResponse() methods
    // e.g.: so if pr is smaller than all three pr_1,pr_2,pr_3,
    // then we will have called all three topics' genTopicResponse()
    // methods
    if( pr <= pr1 )
      myMessage += topic1.genTopicResponse();
    if( pr <= pr2 )
      myMessage += topic2.genTopicResponse();
    if( pr <= pr3 )
      myMessage += topic3.genTopicResponse();

    // print out the postcard content that was generated
    System.out.println( "[postcard content]: " + myMessage );
  }

  public String toString()
  {
    String str = "";
    str += "(" + uniqueID + ") penpal's name: " + myName + "\n";
    str += "\t" + topic1.toString();
    str += "\t" + topic2.toString();
    str += "\t" + topic3.toString();
    return str;
  }
}
