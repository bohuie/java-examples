import java.util.Random;

/**
 * a triangular matrix is a special case of a square matrix
 * 
 * @author bohuie
 * 
 */
public class TriangularMatrix
{
  private int       mySize;
  private int[][]   matrix;
  private Random    generator;
  private final int MAX = 10;

  public TriangularMatrix( int num )
  {
    mySize = num;
    matrix = new int[mySize][mySize];
    generator = new Random();
    initMatrix();
  }

  private void initMatrix()
  {
    for( int i = 0; i < mySize; i++ )
      for( int j = 0; j < mySize; j++ )
      {
        matrix[i][j] = generator.nextInt( MAX );
        while( matrix[i][j] == 0 )
          matrix[i][j] = generator.nextInt( MAX );
      }
  }

  /**
   * a lower triangular matrix is a square matrix where all the entries
   * above the main diagonal are zero
   */
  public void convertToLower()
  {
    // change all elements above main diagonal to be 0
    for( int i=0; i<mySize; i++ )
      for( int j=(i+1);j<mySize; j++ )
        matrix[i][j] = 0;
  }
  
  public void convertToUpper()
  {
    for( int j=0; j<mySize; j++ )
      for( int i=(j+1); i<mySize; i++ )
        matrix[i][j] = 0;
  }
  
  public String toString()
  {
    String str = "";
    for( int i=0; i<mySize; i++ )
    {
      // print elems in one row
      for( int j=0; j<mySize; j++ )
        str += matrix[i][j] + " ";
      str += "\n";
    }
    return str;
  }
}
