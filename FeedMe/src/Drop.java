import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;

/**
 * this class manages when apples drop from the sky, 
 * as well as how many apples are supposed to be dropped and how many have been dropped 
 * @author bohuie
 *
 */
public class Drop 
{
  private Timer            timer;           // timer for doing scheduled task
  private int              count;           // counts number of targets dropped
  private ArrayList<Apple> targets;         // maintains set of targets
  private int[]            locs;            // maintains set of locations

  // constants
  public  final static int MAX    = 5;
  private final static int NUMPOS = 6;
  private final static int OFFSET = 90; 
  private final static int INCR   = 150;

  /**
   * constructor method
   * @param seconds
   */
  public Drop( int seconds ) 
  {
    // initialize all private variables
    locs       = new int[ NUMPOS ]; 
    targets    = new ArrayList<Apple>();
    count      = 0;
    timer      = new Timer();

    // create specific spots on the board to drop targets from
    for( int i=0; i<NUMPOS; i++ )
      locs[i] = OFFSET + ( i * INCR );

    // schedule a target to be dropped at fixed intervals
    RepeatTask dropTask = new RepeatTask(); 
    timer.scheduleAtFixedRate( dropTask, 0, seconds*1000 );
  }

  /**
   * accessors for various class attributes
   * 
   * @param void
   * @return specific class attribute
   */
  public ArrayList<Apple> getTargets() { return targets; }
  public int              getMax()     { return MAX; }

  /**
   * drops one apple at a randomly chosen location that is evenly 
   * spread out across the board
   * once an apple is dropped, it will be added to the collection of targets
   */
  private void dropIt()
  {
    // position the item somewhere at the top of the board (one of possible locs)
    Random r    = new Random();
    int    xpos = locs[ r.nextInt( NUMPOS ) ];
    Apple  a    = new Apple( xpos, -100 );
    targets.add( a );
  }
  
  /**
   * an inner class private to the Drop class
   * my own timer class that repeats tasks at set intervals for a number of times 
   */
  class RepeatTask extends TimerTask 
  {
    /**
     * execute this method every time the timer sets off
     * 
     * @param void
     * @return void
     */
    public void run() 
    {
      dropIt();
      count++; 

      // terminate the timer if MAX is reached 
      if( count >= MAX )
      {
        timer.cancel();
      }
    }
  }
}