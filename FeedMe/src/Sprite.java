import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * the apple eating monster is a sprite object
 * this class manages the sprite's images, positions, movements, and collisions
 * 
 * @author bohuie
 *
 */
public class Sprite
{
  private Image   myImage;             // sprite image (monster dog)
  private Image   fullImage;           // sprite image when catches item
  private int     x;                   // x coordinate on the board
  private int     y;                   // y coordinate on the board
  private int     dx;                  // change in x when moved 
  private int     incr;                // animation pixel increment
  private boolean visible;             // my visibility 
  private int     width, height;       // my bounding box dimensions
  private boolean happy;               // happy when full

  /** 
   * constructor method 
   */
  public Sprite() 
  {
    // initialize private variables
    ImageIcon ii = new ImageIcon( getClass().getResource( "dogopen.png" ) );
    myImage      = ii.getImage();
    width        = myImage.getWidth( null );
    height       = myImage.getHeight( null );
    visible      = true;
    ii           = new ImageIcon( getClass().getResource( "doghappy.png" ) );
    fullImage    = ii.getImage();

    // start off the sprite at the bottom middle of the board
    x  = 460;
    y  = 700;

    // initially, there's no change in x
    dx = 0;

    // changes in pixel animation 
    incr = 5;

    // initially, empty stomach 
    setHappy( false ); 
  }

  /**
   * this method will be called by the Board's event listener
   * the dog will move by dx pixels
   */
  public void move() 
  {
    x += dx;

    // try to catch more food when moving
    if( dx != 0 )
      setHappy( false ); 
  }

  /**
   * accessors for various class attributes
   * 
   * @param void
   * @return specific class attributes
   */
  public int     getX()          { return x; } 
  public int     getY()          { return y; } 
  public Image   getImage()      { return myImage; }
  public boolean isVisible()     { return visible; }
  public Image   getHappyImage() { return fullImage; }
  public boolean getHappy()      { return happy; }

  /**
   * returns the bounding box of the dog
   * 
   * @param void
   * @return rectangle object that bounds the dog
   */
  public Rectangle getBounds()
  {
    Rectangle box = new Rectangle( x, y, width, height );
    return box;
  }

  /**
   * mutator for the dog's state
   * if dog eats item, dog becomes happy
   * if dog is waiting for food, dog becomes not happy (just trying to catch food)
   * 
   * @param state
   * @return void
   */ 
  public void setHappy( boolean state ) 
  { 
    happy = state; 
  }

  /**
   * mutator for dog's visibility
   * if collision happens, the food item disappears
   * 
   * @param val - the new visibility value
   * @return void
   */
  public void setVisible( boolean val ) 
  {
    visible = val; 
  }

  /**
   * when keys are pressed, set the change in pixels accordingly
   *  
   * @param event detected
   * @return void
   */
  public void keyPressed( KeyEvent e ) 
  {
    int key = e.getKeyCode();
    if( key == KeyEvent.VK_LEFT )  
    {
      if( x > 0 )
        dx = -incr;
      else 
        dx = 0; 
    }

    if( key == KeyEvent.VK_RIGHT ) 
    {
      if( x < Board.BOARD_WIDTH )
        dx = incr;
      else 
        dx = 0; 
    }
    
    // as a future feature, make sprite jump if key == KeyEvent.VK_UP
  }

  /**
   * when keys are released, set all changes to 0 so that there's no movement
   *  
   * @param event detected
   * @return void
   */
  public void keyReleased( KeyEvent e ) 
  {
    int key = e.getKeyCode();
    if( key == KeyEvent.VK_LEFT )  dx = 0;
    if( key == KeyEvent.VK_RIGHT ) dx = 0;
    
    // reset sprite so it always stays within the board
    if( x < 0 )   x = 0;
    if( x > Board.BOARD_WIDTH ) x = Board.BOARD_WIDTH;
  }
}