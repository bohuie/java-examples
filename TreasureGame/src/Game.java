import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

/**
 * Class to run the game.
 */
public class Game extends JFrame implements Commons
{
  // game constructor
  public Game()
  {
    // initialize the board and add to JFrame
    Board board = new Board();
    add( board, BorderLayout.CENTER );

    // Set frame attributes.
    setTitle( "Treasure Hunt" );
    setSize( Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false );
  }

  public static void main( String[] args )
  {
    Game ex = new Game();
    ex.setVisible( true );
  }
}
