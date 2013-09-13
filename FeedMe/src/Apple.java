import java.awt.*;
import javax.swing.*;

/**
 * apples are one type of items that can be dropped
 * there could definitely be others too (as a future feature to this game)
 * 
 * this class manages the image of the item, its fall speed, and bounding box
 * 
 * @author bohuie
 *
 */
public class Apple 
{
  private int     x, y;                     // locations of apple
  private Image   myImage;                  // my image
  private boolean visible;                  // my visibility
  private int     width, height;            // my bounding box dimensions

  // constants
  private final int FALL_SPEED = 2;         // number of pixels to fall each time

  /**
   * constructor method
   * 
   * @param xpos - initial x-coordinate of the apple object
   * @param ypos - initial y-coordinate of the apple object
   */
  public Apple( int xpos, int ypos )
  {
    // initialize private variables
    ImageIcon ii = new ImageIcon( getClass().getResource( "apple.png" ) );
    myImage      = ii.getImage();
    width        = myImage.getWidth( null );
    height       = myImage.getHeight( null );
    visible      = true;
    x            = xpos;
    y            = ypos;
  }

  /**
   * accessors for various class attributes
   * 
   * @param void
   * @return specific class attribute
   */
  public Image   getImage()  { return myImage; }
  public int     getX()      { return x; }
  public int     getY()      { return y; }
  public boolean isVisible() { return visible; }

  /**
   * returns the bounding box of the apple
   * 
   * @param void
   * @return a rectangle object
   */
  public Rectangle getBounds()
  {
    Rectangle box = new Rectangle( x, y, width, height );
    return box;
  }

  /**
   * mutator for apple's visibility 
   * if collision happens, the apple disappears
   * 
   * @param val - the new visibility value to be used
   * @return void
   */
  public void setVisible( boolean val ) 
  {
    visible = val; 
  }

  /**
   * apple falls at a constant speed from top to bottom of board
   * 
   * @param void
   * @return void
   */
  public void move()
  {
    y = y + FALL_SPEED;

    // when it moves beyond the board, it becomes invisible
    if( y > Board.BOARD_HEIGHT )
      visible = false;
  }
}
