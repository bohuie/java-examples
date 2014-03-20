public class TestMatrix2D
{
  public static void main( String[] args )
  {
    Matrix2D A = new Matrix2D( 2, 3 );
    Matrix2D B = new Matrix2D( 2, 3 );
    System.out.println( A.toString() );
    System.out.println( B.toString() );
    
    int[][] AB = Matrix2D.matrixSum( A.getMatrix(), B.getMatrix() );
    A.setMatrix( AB );
    System.out.println( A.toString() );
  }
}
