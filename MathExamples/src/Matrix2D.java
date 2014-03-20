import java.util.Random;


public class Matrix2D
{
  private int numrows;
  private int numcols;
  private int[][] matrix;
  private Random gen;
  
  // constant
  private final int MAX = 10;
  
  public Matrix2D( int rows, int cols )
  {
    gen = new Random();
    numrows = rows;
    numcols = cols;
    matrix = new int[numrows][numcols];
    initMatrix();
  }
  
  private void initMatrix()
  {
    for( int i=0; i<numrows; i++ )
      for( int j=0; j<numcols; j++ )
        matrix[i][j] = gen.nextInt( MAX );
  }
  
  public int[][] getMatrix() { return matrix; }
  public void    setMatrix( int[][] newMatrix ) { matrix = newMatrix; }
  
  /**
   * adds two input matrices 
   * If mat1 and mat2 have different dimensions
   */
  public static int[][] matrixSum( int[][] mat1, int[][] mat2 )
  {
    int[][] rez;
    
    // check matrix dimensions
    int dim11 = mat1.length;
    int dim12 = mat1[1].length;
    int dim21 = mat2.length;
    int dim22 = mat2[1].length;

    rez = new int[ dim11 ][ dim12 ];
    
    if( dim11 == dim21 && dim12 == dim22 )
    {
      // add
      for( int i=0; i<dim11; i++ )
        for( int j=0; j<dim12; j++ )
          rez[i][j] = mat1[i][j] + mat2[i][j];
    }
    else
      System.out.println( "Cannot add matrices with different dimensions" );
    return rez;
  }
  
  public String toString()
  {
    String str = "";
    for( int i=0; i<numrows; i++ )
    {      
      for( int j=0; j<numcols; j++ )
        str += matrix[i][j] + ", ";
      str += "\n";
    }
    return str;
  }
}
