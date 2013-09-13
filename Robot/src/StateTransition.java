import java.util.Random;

public class StateTransition
{
  // attributes
  private int        numStates;
  private String[]   states;
  private double[][] transMat;
  private int        currState;
  private Random     generator;
  
  // constants
  public final int   START_STATE = 0;
  public final int   GOAL_STATE  = 3;

  /**
   * constructor
   */
  public StateTransition()
  {
    // initialize non-array related attributes
    generator = new Random();
    currState = START_STATE;
    numStates = 4;
    
    // initialize states with proper names
    states    = new String[numStates];
    states[0] = "Begin";
    states[1] = "Attempt";
    states[2] = "Retry";
    states[3] = "Succeed";
    
    // initialize transition matrix - use helper method for its values
    transMat  = new double[numStates][numStates];
    initTransMat();
  }
  
  /**
   * initialize the transition probability matrix so that:
   * - probability of going from begin   to begin   is 0.3
   * -    "              "       begin   to attempt is 0.7
   * -    "              "       attempt to attempt is 0.05
   * -    "              "       attempt to retry   is 0.15
   * -    "              "       attempt to succeed is 0.80
   * -    "              "       retry   to begin   is 1.0
   * -    "              "       succeed to succeed is 1.0
   * - everything else is 0
   * @param void
   * @return void
   */
  private void initTransMat()
  {
    // from begin to ...
    transMat[0][0] = 0.3;
    transMat[0][1] = 0.7;
    transMat[0][2] = 0;
    transMat[0][3] = 0;

    // from attempt to ...
    transMat[1][0] = 0;
    transMat[1][1] = 0.05;
    transMat[1][2] = 0.15;
    transMat[1][3] = 0.80;

    // from retry to ...
    transMat[2][0] = 1;
    transMat[2][1] = 0;
    transMat[2][2] = 0;
    transMat[2][3] = 0;

    // from succeed to ...
    transMat[3][0] = 0;
    transMat[3][1] = 0;
    transMat[3][2] = 0;
    transMat[3][3] = 1;
  }
 
  /**
   * keep transitioning until we arrive at GOAL_STATE
   * @param void
   * @return void
   */
  public void start()
  {
    int nextState;
    // so long as the current state isn't GOAL_STATE
    while( currState != GOAL_STATE )
    {
      // get the next state using the helper method
      // print out where we moved from and where we're moving to
      // update the current state
      nextState = sampleNextState();
      System.out.println( "moved from " + states[currState] 
                               + " to " + states[nextState] );
      currState = nextState;
    }
  }
  
  /**
   * gets the next state based on the current state and 
   * the probabilities associated
   * @param void
   * @return index to the next state
   */
  private int sampleNextState()
  {
    // get the 1d array of probabilities based on currState
    // note that one row of probabilities sum up to 1.0
    double[] vec = transMat[currState];
    
    // generate random probability
    double pr = generator.nextDouble();
    
    // check which state pr corresponds to next
    // if our randomly generator probability < what's in the 1d array
    // then try another state
    int nextState = -1;
    double temp = 0.0;
    for( int i=0; i<numStates; i++ )
    {
      temp += vec[i];
      if( pr <= temp )
      {
        nextState = i;
        break;
      }
    }
    
    // error handling - was nextState set?
    if( nextState == -1 )
      System.err.println( "nextState not set in loop" );
    
    // return nextState
    return nextState;
  }
  
  /**
   * gathers the transition matrix info into a nicely formatted table
   * @param void
   * @return matrix info
   */
  public String toString()
  {
    String str = "\t";
    // print header
    for( int i=0; i<numStates; i++ )
      str += states[i].charAt(0) + "\t";
    str += "\n";
    
    // print contents
    for( int i=0; i<numStates; i++ )
    {
      // print one row starting with state name
      str += states[i].charAt(0) + ":\t";
      for( int j=0; j<numStates; j++ )
        str += transMat[i][j] + "\t";
      str += "\n";
    }
    return str;
  }
}
