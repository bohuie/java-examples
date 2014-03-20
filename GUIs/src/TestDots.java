import javax.swing.JFrame;

public class TestDots extends JFrame
{
  public static final int WIDTH  = 300;
  public static final int HEIGHT = 280;
  
  public TestDots()
  {
    DrawDots myBoard = new DrawDots();
    add( myBoard );
    
    setTitle( "Draw Dots App" );
    setSize( WIDTH, HEIGHT );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false );
  }
  
  public static void main( String[] args )
  {
    TestDots ex = new TestDots();
    ex.setVisible( true );
  }
}
