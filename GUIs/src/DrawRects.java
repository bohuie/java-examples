import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;


public class DrawRects extends JPanel
{
  private Random generator;
  
  // constants
  private final static int NUMDRAW = 200;
  private final static int MAXNUM  = 300;
  private final static int SIZE    = 20;
  
  public DrawRects()
  {
    generator = new Random();
  }
  
  public void paint( Graphics g )
  {
    super.paint( g );
    Graphics2D g2d = ( Graphics2D )g;
    
    g2d.setColor( Color.MAGENTA );
    int x, y, width, height;
    for( int num=0; num < NUMDRAW; num++ )
    {
      x = generator.nextInt( MAXNUM ) + 1;
      y = generator.nextInt( MAXNUM ) + 1;
      width  = generator.nextInt( SIZE ) + 1;
      height = generator.nextInt( SIZE ) + 1;
      
      g2d.drawRect( x, y, width, height );
    }
  }
}
