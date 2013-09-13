import java.util.Random;

public class Topic
{
  private int      activation;
  private String   label;
  private String[] associations;
  private int      numAssocs;
  private String   response1;
  private String   response2;
  private String   response3;
  private double   probability1;
  private double   probability2;
  private double   probability3;
  private Random   generator;

  /**
   * constructor - sets up topic attributes 
   * 
   * @param name of this topic
   */
  public Topic( String title )
  {
    activation = 0;
    label = title;
    associations = new String[100];
    numAssocs = 0;
    response1 = "";
    response2 = "";
    response3 = "";
    probability1 = -1;
    probability2 = -1;
    probability3 = -1;
    generator = new Random();
  }
  
  /**
   * adds words to the topic as associations that will help 
   * upgrade or downgrade activation levels later on 
   * 
   * @param list of strings associated to this topic
   * @return void 
   */
  public void setupAssociations( String ... list )
  {
    if( list.length != 0 )
    {
      for( String word : list )
      {
        associations[numAssocs] = word;
        numAssocs++;
      }
    }
  }

  /**
   * create one of three  possible responses that can be generated when 
   * this topic is triggered 
   * each response has a probability so some responses are more likely
   * 
   * @param item = the i'th response
   * @param resp = the actual response to be stored
   * @param pr   = the probability associated to resp
   * @return void 
   */
  public void setResponseAndProb( int item, String resp, double pr )
  {
    if( item == 1 )
    {
      response1 = resp;
      probability1 = pr;
    }
    else if( item == 2 )
    {
      response2 = resp;
      probability2 = pr;
    }
    else if( item == 3 )
    {
      response3 = resp;
      probability3 = pr;
    }
  }

  /**
   * accessor for returning the current activation level of this topic
   * 
   * @param void
   * @return activation level
   */
  public int getActivation()
  {
    return activation;
  }
  
  /**
   * checks if a given word matches one of the associations created earlier
   * if so, upgrade this topic's activation level 
   * 
   * @param a specific word
   * @return void 
   */
  public void match( String word )
  {  
    for( int i=0; i<numAssocs; i++ )
      if( word.equalsIgnoreCase( associations[i] ) )
      {
        incrActivation();
//        System.out.println( this.toString() + " from processing " + word );
      }
  }
  
  private void incrActivation()
  {
    activation++;
  }

  private void decrActivation()
  {
    activation--;
  }

  /**
   * randomly generates one of the three possible responses 
   * once generated, downgrade this topic's activation level
   * 
   * @param void
   * @return response
   */
  public String genTopicResponse()
  {
    String str = "";

    double pr = generator.nextDouble();
    if( pr <= probability1 )
      str += response1;
    else if( pr <= (probability1 + probability2) )
      str += response2;
    else 
      str += response3;

    decrActivation();
    return str;
  }
 
  /**
   * puts together the topic info, e.g., topic name, id, activation level
   * 
   * @param void
   * @return topic info
   */
  public String toString()
  {
    String str = "";
    str += "topic: " + label + ", at activation level " + activation + "\n";
   
    str += "\t" + response1 +"\n";
    str += "\t" + response2 +"\n";
    str += "\t" + response3 +"\n";
   
    return str;
  }
}
