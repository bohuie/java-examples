
public class TestTransitions
{
  public static void main( String[] args )
  {
    // create a new StateTransition object
    StateTransition st = new StateTransition();
    
    // print out its transition matrix to see what it looks like
    System.out.println( st.toString() );
    
    // run it and see what path it takes to get to goal state
    st.start();
  }
}

// below is a sample output from running this program
/*
    B       A       R       S   
B:  0.3     0.7     0.0     0.0 
A:  0.0     0.05    0.15    0.8 
R:  1.0     0.0     0.0     0.0 
S:  0.0     0.0     0.0     1.0 

moved from Begin to Begin
moved from Begin to Begin
moved from Begin to Begin
moved from Begin to Attempt
moved from Attempt to Attempt
moved from Attempt to Succeed
*/

//below is another sample output from running this program
/*
 B       A       R       S   
B:  0.3     0.7     0.0     0.0 
A:  0.0     0.05    0.15    0.8 
R:  1.0     0.0     0.0     0.0 
S:  0.0     0.0     0.0     1.0 

moved from Begin to Attempt
moved from Attempt to Attempt
moved from Attempt to Succeed
*/