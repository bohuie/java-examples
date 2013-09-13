import java.awt.*; 
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer; 
import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * this class controls the overall game
 * all the major game pieces are created in this class
 * the graphical user interface is setup here as well
 * 
 * @author bohuie
 *
 */
public class Board extends JPanel implements ActionListener
{
  private Timer    timer;          // a timer to handle events
  private Sprite   monster;        // the dog that eats everything
  private Drop     dropper;        // manages when food items drop from sky
  private Image    bkgrd;          // background image 
  private int      score;          // keeps track of game score
  private boolean  gameOver;       // keeps track of when game is over

  // constants
  public static final int BOARD_HEIGHT = 800;     // game board height
  public static final int BOARD_WIDTH  = 920;     // game board width

  /**
   * constructor method
   */
  public Board() 
  {
    // setup basic GUI layout
    setLayout( null ); 
    setFocusable( true );
    setDoubleBuffered( true );

    // apply my own event handler  
    MyKeyAdapter myListener = new MyKeyAdapter();
    addKeyListener( myListener ); 

    // setup background 
    ImageIcon ii = new ImageIcon( getClass().getResource( "sky.png" ) );
    bkgrd        = ii.getImage();

    // initialize the game pieces  
    gameOver = false;
    score    = 0; 
    dropper  = new Drop( 3 );          // items fall at 3 seconds apart
    monster  = new Sprite();           // create monster eater
    timer    = new Timer( 5, this );   // 5ms delay, "this" as the listener object
    timer.setInitialDelay( 5 );        // 5ms initial delay before timer starts 
    timer.setDelay( 30 );              // 3ms delay between checks 
    timer.start(); 
  }

  /**
   * all the drawing is done in this method
   * 
   * @param the graphics context to draw to
   * @return void
   */
  public void paint( Graphics g )
  {
    // setup basic panel for drawing
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( bkgrd, 0, 0, null ); 

    // draw the corresponding monster image depending on whether he's happy or not
    if( monster.getHappy() )
      g2d.drawImage( monster.getHappyImage(), monster.getX(), monster.getY(), this );
    else
      g2d.drawImage( monster.getImage(), monster.getX(), monster.getY(), this );

    // draw each food item at given locations
    ArrayList<Apple> food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      Apple a = food.get( i );
      g2d.drawImage( a.getImage(), a.getX(), a.getY(), this );
    }

    // change drawing to ending scene if game is over
    // ending scene will display credits, game score, and stops the music
    if( gameOver )
    {
      g2d.setColor( Color.WHITE ); 
      g2d.setFont( new Font( "Comic Sans MS", Font.BOLD, 48 ));
      g2d.drawString( "Game Over", 370, 350 );
      g2d.drawString( "Your Score: " + score + " / " + dropper.getMax(), 280, 400 );

      g2d.setColor( Color.GRAY ); 
      g2d.setFont( new Font( "Comic Sans MS", Font.BOLD, 24 ));
      g2d.drawString( "Game made by Bowen Hui", 20, 20 ); 
      g2d.drawString( "Music from Kevin MacLeod", 20, 50 ); 
      g2d.drawString( "Sound effects from MediaCollege.com", 20, 80 ); 

      SoundEffect.SONG.stoploop();
    }
  }

  /**
   * animate sprite according to the timer event
   * execute this method every time an event is detected
   *  
   * @param event that triggered this method to be called
   * @return void
   */
  public void actionPerformed( ActionEvent e ) 
  {
    monster.move();                    // move monster accordingly

    // remove item from arraylist if not visible, else let it fall
    ArrayList<Apple> food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      Apple a = food.get( i );
      if( a.isVisible() )
        a.move(); 
      else 
        food.remove( i ); 
    }

    checkCollision();                  // check if monster collides with food item
    checkGameOver();                   // check if game is over
    repaint();                         // effectively, calls paint()
  }

  /**
   * if nothing is left to drop then game is over
   * 
   * @param void
   * @return void
   */
  private void checkGameOver()  
  {
    ArrayList<Apple> food = dropper.getTargets();
    if( food.size() == 0 )
      gameOver = true;
  }

  /** 
   * if the bounding boxes of two items intersect, then there is a collision
   * 
   * @param void
   * @return void
   */
  private void checkCollision() 
  {
    // get bounding box of monster
    Rectangle r1   = monster.getBounds();

    // get bounding box of all possible food items
    ArrayList<Apple> food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      Apple a      = food.get( i );
      Rectangle r2 = a.getBounds(); 

      // checks intersection - if so, monster eats food item
      if( r1.intersects( r2 ) )
      {
        a.setVisible( false );
        SoundEffect.EAT.play();
        monster.setHappy( true );
        score++; 
      }
    }
  }
  
  /**
   * an inner class private to the Board class
   * my own listener to handle keyboard events 
   * when a KeyEvent is detected, let the sprite handle it directly
   */
  private class MyKeyAdapter extends KeyAdapter 
  {
    /**
     * send the event to the same method in the sprite
     * 
     * @param event
     * @return void
     */
    public void keyReleased( KeyEvent e ) 
    {
      monster.keyReleased( e );
    }

    /**
     * send the event to the same method in the sprite
     * 
     * @param event
     * @return void
     */
    public void keyPressed( KeyEvent e ) 
    {
      monster.keyPressed( e );
    }
  }
}