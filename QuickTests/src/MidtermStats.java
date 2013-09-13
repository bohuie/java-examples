import java.util.Random;


public class MidtermStats
{
  int[] scores;
  public MidtermStats( int numStudents )
  {
    scores = new int[numStudents];
  }
  
  public void enterScores()
  {
    Random generator = new Random();
    for( int i=0; i<scores.length; i++ )
      scores[i] = generator.nextInt( 100 ) + 1;
  }
  
  public double calcAverage()
  {
    double total = 0.0;
    for( int i=0; i<scores.length; i++ )
      total += scores[i];
    return total/scores.length;
  }
}
