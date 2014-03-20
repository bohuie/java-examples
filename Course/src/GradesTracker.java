import java.util.Scanner;

/**
 * this class helps a student keep track of his/her course grade so far.
 * the data we keep track of will be modeled based on the cosc121
 * evaluation criteria. that is, 3 assignments that are worth 20%, 9 labs
 * that are worth 20%, 1 midterm that is worth 20%, and a final exam that
 * is worth 40%.
 * 
 * assumption:
 * 
 * - all grades will be entered so that there are no missed grades with 
 * valid medical notes
 * 
 * @author bohuie
 * 
 */
public class GradesTracker
{
  // various course components with evaluation criteria for one student
  private double[]  assignments;
  private double[]  labs;
  private double    midterm;
  private double    finalExam;
  private double    courseGrade;
  private Scanner   sysin;

  // constants
  private final int    NUMASGNS = 3;
  private final int    NUMLABS  = 9;
  private final int    UNDEF    = -1;
  private final double ASGN_WORTH  = 0.20;
  private final double LABS_WORTH  = 0.20;
  private final double MT_WORTH    = 0.20;
  private final double FINAL_WORTH = 0.40;

  // constructor
  public GradesTracker()
  {
    // finish declaring arrays
    assignments = new double[ NUMASGNS ];
    labs = new double[ NUMLABS ];
    
    // initialize marks to unmeaningful default values
    // note that 0 is not a good choice because it is possible to have a mark of 0 
    for( int i=0; i<assignments.length; i++ )
      assignments[i] = UNDEF;
    for( int i=0; i<labs.length; i++ )
      labs[i] = UNDEF;
    midterm     = 0;
    finalExam   = 0;
    courseGrade = UNDEF;
    
    // initialize scanner object
    sysin = new Scanner( System.in );
  }
  
  // accessor for courseGrade
  public double getCourseGrade()
  {
    return courseGrade;
  }

  // ask user to enter available marks
  public void enterGrades()
  {
    System.out.println( "Do you have any assignment marks? (y/n)" );
    if( sysin.nextLine().equalsIgnoreCase( "y" ) )
    {
      enterAsgns();
    }

    System.out.println( "Do you have any lab marks? (y/n)" );
    if( sysin.nextLine().equalsIgnoreCase( "y" ) )
    {
      enterLabs();
    }

    System.out.println( "Do you have a midterm mark? (y/n)" );
    if( sysin.nextLine().equalsIgnoreCase( "y" ) )
    {
      System.out.println( "Enter your midterm mark (out of 100%): " );
      midterm = sysin.nextDouble();
      sysin.nextLine();
    }

    System.out.println( "Do you have a final exam mark? (y/n)" );
    if( sysin.nextLine().equalsIgnoreCase( "y" ) )
    {
      System.out.println( "Enter your final exam mark (out of 100%): " );
      finalExam = sysin.nextDouble();
      sysin.nextLine();
    }
  }

  // helper method to ask user to enter assignment marks
  // assumes if mark for assignment n is not available, then all marks after it
  // are also unavailable (e.g., if A2 mark is unavailable, then there
  // is no point in asking about the mark for A3)
  private void enterAsgns()
  {
    double score  = -1.0;
    int asgnIndex = 0;
    String answer = "";

    System.out.print( "Do you have a mark for A" + (asgnIndex + 1) + "? (y/n) " );
    answer = sysin.nextLine();
    while( answer.equalsIgnoreCase( "y" ) )
    {
      System.out.print( "Enter your A" + (asgnIndex + 1) + " mark (out of 100%): " );
      score = sysin.nextDouble();
      sysin.nextLine();
      assignments[asgnIndex] = score;
      asgnIndex++;
      if( asgnIndex == assignments.length )
        break;
      System.out.print( "Do you have a mark for A" + (asgnIndex + 1) + "? (y/n) " );
      answer = sysin.nextLine();
    }
    System.out.println( "There are no marks left to enter for assignments" );
  }

  // helper method to ask user to enter lab marks
  // assumes if mark for lab n is not available, then all marks after it
  // are also unavailable (e.g., if lab 2 mark is unavailable, then there
  // is no point in asking about the marks for labs 3-9)
  private void enterLabs()
  {
    double score = -1.0;
    int labIndex = 0;

    // illustrates another way to loop through the array to enter lab marks
    while( true )
    {
      System.out.print( "Do you have a mark for lab " + (labIndex + 1) + "? (y/n) " );
      if( sysin.nextLine().equalsIgnoreCase( "n" ) )
      {
        break;
      }

      System.out.print( "Enter your lab " + (labIndex + 1) + " mark (out of 100%): " );
      score = sysin.nextDouble();
      sysin.nextLine();
      labs[labIndex] = score;
      labIndex++;
      if( labIndex == labs.length )
      {
        System.out.println( "There are no marks left to enter for labs" );
        break;        
      }
    }
  }

  // calculate course grade based on what marks have been entered by the user
  public void calculateGrade()
  {
    double pctA = calcAsgns();
    double pctL = calcLabs();
    double pctMT = calcMT();
    double pctFE = calcFinal();
    courseGrade = pctA + pctL + pctMT + pctFE;
  }
  
  // helper method to calculate midterm portion of the course
  private double calcMT()
  {
    // if a mark exists, convert it to make it out of 20%
    // e.g. 78% on the midterm means you got 15.6% out of 20% in the course
    return midterm * MT_WORTH;
  }
  
  // helper method to calculate final exam portion of the course
  private double calcFinal()
  {
    return finalExam * FINAL_WORTH;
  }
  
  // helper method to calculate assignment portion of the course
  // assume all assignments are weighted equally
  private double calcAsgns()
  {
    double score  = 0.0;
    int asgnIndex = 0;
    
    // tally up all the available marks
    while( assignments[ asgnIndex ] != UNDEF )
    {
      score += assignments[ asgnIndex ];
      asgnIndex++;
      if( asgnIndex >= assignments.length )
        break;
    }

    // average the available marks then convert to make it out of 20%
    return ( score/NUMASGNS ) * ASGN_WORTH;
  }

  // helper method to calculate assignment portion of the course
  // assume all labs are weighted equally
  private double calcLabs()
  {
    double score = 0.0;
    int labIndex = 0;
    
    // tally up all the available marks
    while( labs[ labIndex ] != UNDEF )
    {
      score += labs[ labIndex ];
      labIndex++;
      if( labIndex >= labs.length )
        break;
    }

    // average the available marks then convert to make it out of 20%
    return ( score/NUMLABS ) * LABS_WORTH;
  }
}
