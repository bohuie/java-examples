import java.util.Random;


public class MidtermStats
{
  private int[] scores;
  
  public MidtermStats( int numStudents )
  {
    scores = new int[ numStudents ];
  }
  
  public void enterScores()
  {
    Random generator = new Random();
    int MAX = 101;
    for( int i=0; i<scores.length; i++ )
      scores[ i ] = generator.nextInt( MAX );
  }
  
  public double calcAverage()
  {
    int x = 0;
    for( int i=0; i<scores.length; i++ )
    {
      x = x + scores[i];
    }
    return( x / scores.length );
  }
}
