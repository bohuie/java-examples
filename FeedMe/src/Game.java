import javax.swing.JFrame;

/**
 * adapted general 2D game structure from zetcode.com
 * 
 * @author bohuie
 */
public class Game extends JFrame
{
  /**
   * constructor method
   */
  public Game() 
  { 
    // basic setup 
    Board sky = new Board();

    // pre-load all sound files
    SoundEffect.init();
    SoundEffect.vol = SoundEffect.Volume.LOW;  // un-mute
    SoundEffect.SONG.playloop();

    // add components 
    add( sky ); 

    // set frame attributes
    setTitle( "Feeeeeed Meeeeee" );
    setSize( 1000, 800 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    // create the game instance
    Game ex = new Game();
    ex.setVisible( true );
  }
}
