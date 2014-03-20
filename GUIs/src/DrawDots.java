import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class DrawDots extends JPanel
{
  private static final int NUMDRAW = 500;
  private static final int MAX     = 20;
  public DrawDots() {}
  
  public void paint( Graphics g )
  {
    super.paint( g );
    Graphics2D g2d = ( Graphics2D )g;
    
    BasicStroke pen = new BasicStroke( 2 );
    g2d.setStroke( pen );
    
    Random generator = new Random();
    int x, y;
    for( int num=0; num < NUMDRAW; num++ )
    {
      x = generator.nextInt( TestDots.WIDTH );
      y = generator.nextInt( TestDots.HEIGHT );
      
      int c = generator.nextInt( MAX );
      if( c < 1 )
        g2d.setColor( Color.BLACK );
      else if( c < 3 )
        g2d.setColor( Color.BLUE );
      else if( c < 5 )
        g2d.setColor( Color.CYAN );
      else if( c < 7 )
        g2d.setColor(  Color.GREEN );
      else if( c < 9 )
        g2d.setColor( Color.MAGENTA );
      else if( c < 11 )
        g2d.setColor( Color.ORANGE );
      else if( c < 13 )
        g2d.setColor( Color.PINK );
      else if( c < 16 )
        g2d.setColor( Color.RED );
      else
        g2d.setColor( Color.YELLOW );
      
      g2d.drawLine( x, y, x, y );
    }
  }
}
