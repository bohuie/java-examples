import java.awt.Color;
import java.io.FileNotFoundException;
import javax.swing.JFrame;


public class TestTextProc extends JFrame
{
  public TestTextProc() throws FileNotFoundException
  {
    TextProcessing myBoard = new TextProcessing();
    myBoard.procFile();
    myBoard.prNumVowels();
    add( myBoard );
    setTitle( "Vowels App" );
    setSize( 500, 150 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false );
    setBackground( Color.white );
  }
  
  /**
   * longer header due to file handling
   * @param args
   * @throws FileNotFoundException
   */
  public static void main( String[] args ) throws FileNotFoundException 
  {
    TestTextProc tp = new TestTextProc();
    tp.setVisible( true );
  }
}
