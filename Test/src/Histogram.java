import java.util.Random;

public class Histogram
{
  private double[] grades;      // array of student grades
  private int[]    bins;        // number of bins in histogram
  
  // constant
  private static final int MAXBINS = 5;
  
  // constructor
  public Histogram( int numStudents )
  {
    grades = new double[ numStudents ];
    bins = new int[ MAXBINS ];
  }
  
  /**
   * reads in all the grades in a class into the attribute
   */
  public void readGrades()
  {
    Random generator = new Random();
    for( int i=0; i<grades.length; i++ )
      grades[i] = generator.nextInt( 100 );
  }
  
  private double calcAverage()
  {
    double sum = 0.0;
    for( int i=0; i<grades.length; i++ )
      sum += grades[i];
    return ( sum / grades.length );
  }
  
  private void sortGradesIntoBins()
  {
    for( int i=0; i<grades.length; i++ )
    {
      double percent = grades[i];
      if( percent <= 20 )
        bins[0]++;
      else if( percent <= 40 )
        bins[1]++;
      else if( percent <= 60 )
        bins[2]++;
      else if( percent <= 80 )
        bins[3]++;
      else
        bins[4]++;
    }
  }
  
  private void prBins()
  {
    for( int i=0; i<MAXBINS; i++ )
    {
      for( int j=0; j<bins[i]; j++ )
        System.out.print( "*" );
      System.out.println();
    }
  }
  
  public String toString()
  {
    String str = "";
    str += "Number of Students: " + grades.length + "\n";
    str += "Average: " + calcAverage() + "\n";
    
    sortGradesIntoBins();
    prBins();
    return str;
  }
}