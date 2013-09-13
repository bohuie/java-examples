
/**
 * Interface to hold common constants.
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public interface Commons {

	/**
	 * Width of the game frame.
	 */
	public static final int BOARD_WIDTH = 1000;
	/**
	 * Height of the game frame.
	 */
	public static final int BOARD_HEIGHT = 800;
	/**
	 * Width/height of a sprite.  All sprites are square.
	 */
	public static final int SPRITE_WIDTH = 60;

	public static final int OFFSET = 5;
	/**
	 * Number for top collisions.
	 */
	public static final int TOP_COLLISION = 1;
	/**
	 * Number for right collisions.
	 */
	public static final int RIGHT_COLLISION = 2;
	/**
	 * Number for bottom collisions.
	 */
	public static final int BOTTOM_COLLISION = 3;
	/**
	 * Number for left collisions.
	 */
	public static final int LEFT_COLLISION = 4;
	/**
	 * Time, in milliseconds, that a level can run.
	 */
	public static final int GAME_TIME = 240000;
	/**
	 * String containing a level layout.
	 */
	public static final String levelOne =
			 "WSSSWWWWWWWWWWWW\n"
			+"W...T     T    W\n"
			+"W   T $   $$TT W\n"
			+"W   T       TT W\n"
			+"WT@TTTT        W\n"
			+"W       TTTT$  W\n"
			+"W       TTTT   W\n"
			+"W       TTTT   W\n"
			+"W            TTW\n"
			+"W TT TT$      .S\n"
			+"W     $  TT   .S\n"
			+"W       TTT   .S\n"
			+"WWWWWWWWWWWWWWWW";
}
