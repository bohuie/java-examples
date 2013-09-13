

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

/**
 * Class to run the game.
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Game extends JFrame implements Commons {

	/**
	 * Constructor for the game.
	 */
	public Game() {
		//Initialize the board.
		Board board = new Board();
		//Start sounds.
		SoundEffect.init();
		SoundEffect.vol = SoundEffect.Volume.LOW;
		SoundEffect.SONG.playloop();
		//Add board to the JFrame.
		add(board, BorderLayout.CENTER);
		//Set JFrame attributes.
		setTitle("Treasure Hunt");
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	/**
	 * Main method to run the game.
	 * 
	 * @param args
	 *            Any extra arguments passed to the program.
	 */
	public static void main(String[] args) {
		Game ex = new Game();
		ex.setVisible(true);
	}
}
