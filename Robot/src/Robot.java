import java.util.Random;
import java.util.Scanner;

/**
 * this class is a delivery robot that navigates around a map and retrieves
 * the items that it is told
 * 
 * assumptions: 
 * - assume the robot always knows where these items are 
 * - assume there is an endless supplies of these items in the designated
 *   locations
 * 
 * design questions:
 * - what should the robot be able to deliver?
 * - where can a robot go?
 * - what actions or moves can a robot take?
 * 
 * this robot should handle chores
 * it can be called and be told to do something
 * it can make tea or pick up newspaper
 * we don't have to tell it where to go, it should figure that out on its own
 * 
 * implementation questions:
 * - how to model the different rooms in a house as a map for the robot?
 * - how does the robot navigate in this map?
 * - how does it know when it has arrived in the right location?
 * - what should the robot do after it has completed its chore?
 * 
 * @author bohuie
 */
public class Robot
{
  private int             currLoc;
  private Random          generator;

  // constants for move directions
  public static final int NORTH   = 1;
  public static final int EAST    = 2;
  public static final int SOUTH   = 3;
  public static final int WEST    = 4;

  // constants for locations
  public static final int OFFICE  = 1;
  public static final int KITCHEN = 2;
  public static final int LIBRARY = 3;
  public static final int HALLWAY = 4;
  public static final int DOOR    = 5;

  /**
   * constructor method
   */
  public Robot()
  {
    generator = new Random();
    currLoc = LIBRARY;
  }

  /**
   * this method encodes all possible moves given the following map
   * a successful move will update robot's location
   * 
   * map: 
   * - kitchen (K) - tea 
   * - door (D) - newspaper 
   * - office (O) - where the master is 
   * - library (L) 
   * - hallway (H) 
   * O - K -L 
   *     |            NORTH is up 
   *     H - D
   * 
   * @param direction to move in
   * @return void
   */
  private void possibleMoves( int dir )
  {
    // O, EAST, K
    // K, WEST, O
    // K, EAST, L
    // K, SOUTH, H
    // L, WEST, K
    // H, NORTH, K
    // H, EAST, D
    // D, WEST, H
    if( currLoc == OFFICE && dir == EAST )
      currLoc = KITCHEN;
    else if( currLoc == KITCHEN )
    {
      if( dir == WEST )
        currLoc = OFFICE;
      else if( dir == EAST )
        currLoc = LIBRARY;
      else if( dir == SOUTH )
        currLoc = HALLWAY;
    }
    else if( currLoc == LIBRARY && dir == WEST )
      currLoc = KITCHEN;
    else if( currLoc == HALLWAY )
    {
      if( dir == NORTH )
        currLoc = KITCHEN;
      else if( dir == EAST )
        currLoc = DOOR;
    }
    else if( currLoc == DOOR && dir == WEST )
      currLoc = HALLWAY;
  }

  /**
   * this method calls the robot to the office location, listens for a
   * command, then executes it
   * 
   * @param void
   * @return void
   */
  public void comeHere()
  {
    // display current location
    System.out.println( toString() );

    if( currLoc != OFFICE )
      gotoLoc( OFFICE );

    // display command prompt for user to select
    String cmd = prMenu();

    // respond to prompt
    if( cmd.equals( "1" ) )
      getPaper();
    else if( cmd.equals( "2" ) )
      getTea();
    else
      goBack();
  }

  /**
   * this method randomly picks a direction to try to move to in attempt to
   * get to the given destination
   * @param locaction to go to
   * @return void
   */
  private void gotoLoc( int loc )
  {
    while( currLoc != loc )
    {
      int oldLoc = currLoc;
      int move = generator.nextInt( WEST ) + 1;
      possibleMoves( move );
      System.out.println( "move: " + prLoc( oldLoc ) + ", " 
                                   + prMove( move ) + ", "
                                   + prLoc( currLoc ) );
    }
  }

  /**
   * this method navigates from the current location to the door, then back
   * to the office to deliver the paper
   * 
   * @param void
   * @return void
   */
  private void getPaper()
  {
    gotoLoc( DOOR );
    System.out.println( "pick up newspaper" );
    gotoLoc( OFFICE );
    System.out.println( "here's your newspaper" );
    goBack();
  }

  /**
   * this method navigates from the current location to the kitchen, then
   * back to the office to deliver the tea
   * 
   * @param void
   * @return void
   */
  private void getTea()
  {
    gotoLoc( KITCHEN );
    System.out.println( "make tea" );
    gotoLoc( OFFICE );
    System.out.println( "here's your tea" );
    goBack();
  }

  /**
   * this method navigates from the current location back to the library
   * 
   * @param void
   * @return void
   */
  private void goBack()
  {
    gotoLoc( LIBRARY );
    System.out.println( "back to cleaning the shelves" );
  }

  /**
   * displays a menu of options for user to select from
   * 
   * @param void
   * @return command selected by user
   */
  private String prMenu()
  {
    System.out.println( ">> Please select a command:" );
    System.out.println( ">> 1. Pick up the newspaper" );
    System.out.println( ">> 2. Make me some tea" );
    System.out.println( ">> 3. Return to your own work" );
    Scanner sysin = new Scanner( System.in );
    String userInput = sysin.nextLine();
    return userInput;
  }

  /**
   * displays robot attributes
   * 
   * @param void
   * @return string to print
   */
  public String toString()
  {
    String str = "loc: " + prLoc();
    return str;
  }

  /**
   * prints the move direction in words
   * @param direction index
   * @return direction string
   */
  private String prMove( int dir )
  {
    String str = "";
   
    if( dir == NORTH )
      str = "north";
    else if( dir == EAST )
      str = "east";
    else if( dir == SOUTH )
      str = "south";
    else if( dir == WEST )
      str = "west";
    
    return str;
  }
  
  /**
   * prints the given location in words
   * @param locaction index
   * @return location string
   */
  private String prLoc( int loc )
  {
    String str = "";
    if( loc == OFFICE )
      str = "office";
    else if( loc == KITCHEN )
      str = "kitchen";
    else if( loc == LIBRARY )
      str = "library";
    else if( loc == HALLWAY )
      str = "hallway";
    else if( loc == DOOR )
      str = "door";
    return str;
  }

  /**
   * prints the robot's current location in words
   * 
   * @param void
   * @return location string
   */
  private String prLoc()
  {
    String str = "";
    
    if( currLoc == OFFICE )
      str = "office";
    else if( currLoc == KITCHEN )
      str = "kitchen";
    else if( currLoc == LIBRARY )
      str = "library";
    else if( currLoc == HALLWAY )
      str = "hallway";
    else if( currLoc == DOOR )
      str = "door";
    
    return str;
  }
}
