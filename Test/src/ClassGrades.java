import java.util.Random;

public class ClassGrades
{
  private int[][] allGrades;
  private int numStudents;
  private int numExams;
  
  public ClassGrades( int numStuds, int numEx )
  {
    numStudents = numStuds;
    numExams = numEx;
    allGrades = new int[ numStudents ][ numExams ];
    for( int e=0; e<numExams; e++ )
      genScores( e );    
  }
  
  private void genScores( int exam )
  {
    Random generator = new Random();
    
    for( int s=0; s<allGrades.length; s++ )
      allGrades[ s ][ exam ] = generator.nextInt( 100 )+1;
  }
  
  public int[] getOneStudent( int i )
  {
    // ensure i is a sensible value
    if( i < 0 || i > allGrades.length )
      return null;
    else
      return allGrades[ i ];
  }
  
  public int[] getOneExam( int i )
  {
    // ensure i is a sensible value
    if( i < 0 || i > allGrades[0].length )
      return null;
    else
    {
      // manually build a column of data
      int[] examColumn = new int[ allGrades.length ];
      for( int s=0; s<allGrades.length; s++ )
        examColumn[ s ] = allGrades[ s ][ i ];
      return examColumn;      
    }
  }
  
  public void printEverything()
  {
    for( int s=0; s<allGrades.length; s++ )
    {
      // print all exam grades for one student on the same line
      for( int e=0; e<allGrades[0].length; e++ )
        if( e == allGrades[0].length-1 )
          System.out.print( allGrades[s][e] );
        else
          System.out.print( allGrades[s][e] + ", " );
      System.out.println();
    }
  }
  
  public String toString()
  {
    String str = "";
    str += "numStudents = " + numStudents + "\n";
    str += "numExams = " + numExams + "\n";
    str += "allGrades.length = " + allGrades.length + "\n";
    str += "allGrades[0].length = " + allGrades[0].length + "\n";
    return str;
  }
}
