import javax.swing.JFrame;

public class TestRectangles extends JFrame
{
  private static final int WINDOWSIZE = 300;
  
  public TestRectangles()
  {
    DrawRects myBoard = new DrawRects();
    add( myBoard );
    
    setTitle( "Draw Rectangles App" );
    setSize( WINDOWSIZE, WINDOWSIZE );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false );
  }
  
  public static void main( String[] args )
  {
    TestRectangles ex = new TestRectangles();
    ex.setVisible( true );
  }
}
