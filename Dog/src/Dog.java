import java.util.Random;
import java.util.Scanner;

/**
 * this class models a pet dog that lives happily in a nice home
 * 
 * design questions:
 * - what do dogs do?
 * - how does it interact with the user?
 * 
 * a pet dog basically eats, sleeps, and plays
 * while there is a biological system, a random model is easiest to create here
 * a pet dog should also follow some basic commands
 * 
 * implementation questions:
 * - do any attributes change based on the different moods the dog is in?
 * - how does the dog respond to commands in this model?
 * 
 * @author bohuie
 */
public class Dog
{
  private String          name;
  private int             stomach;
  private int             mood;
  private int             pose;
  private Random          generator;

  // constants for mood
  public static final int SLEEPY   = 1;
  public static final int HUNGRY   = 2;
  public static final int BORED    = 3;
  public static final int WANTOUT  = 4;
  public static final int HAPPY    = 5;

  // constants for position
  public static final int STANDING = 1;
  public static final int SITTING  = 2;
  public static final int LAYING   = 3;
  public static final int JUMPING  = 4;

  /**
   * constructor method
   * 
   * @param name of dog
   */
  public Dog( String n )
  {
    name = n;
    stomach = 0;
    generator = new Random();
    mood = generator.nextInt( HAPPY ) + 1;
    pose = STANDING;
  }

  /**
   * make a comment according to the mood it's in just for fun - change
   * mood every time this method is called
   * 
   * @param void
   * @return mood phrase
   */
  public String getMood()
  {
    String moodStr = "What mood is this?";
    mood = generator.nextInt( HAPPY ) + 1;
    if( mood == SLEEPY )
      moodStr = "I'm sleeeepy *yawn*";
    else if( mood == HUNGRY )
      moodStr = "Time to feed me already!";
    else if( mood == BORED )
      moodStr = "Let's play!";
    else if( mood == WANTOUT )
      moodStr = "Gotta go potty";
    else if( mood == HAPPY )
      moodStr = "You're the best owner ever!";
    return moodStr;
  }

  /**
   * only two states need to be acted upon: hungry -> eat, wantout -> do
   * business
   * 
   * @param void
   * @return void
   */
  public void actOnMood()
  {
    if( mood == HUNGRY )
    {
      stomach += 3;
      System.out.println( "Milkbones are my favourite" );
    }

    if( mood == WANTOUT )
    {
      stomach = Math.max( stomach - 4, 0 );
      System.out.println( "I got out just in time!" );
    }

    // if the stomach is near full then change mood
    if( stomach > 7 )
      mood = WANTOUT;
  }

  /**
   * this method takes a user command and translates it something we
   * understand
   * 
   * @param void
   * @return void
   */
  public void command()
  {
    int cmd = -1;
    Scanner sysin = new Scanner( System.in );
    String userInput = sysin.nextLine();

    if( userInput.equals( "up" ) )
      cmd = JUMPING;
    else if( userInput.equals( "sit" ) )
      cmd = SITTING;
    else if( userInput.equals( "down" ) )
      cmd = LAYING;

    System.out.println( "I heard you say '" + cmd + "'" );
    setPose( cmd );
  }

  /**
   * this method takes a command and sets the position if we understand the
   * command otherwise dog will just stand and look confused
   * 
   * @param command index
   * @return void
   */
  private void setPose( int cmd )
  {
    if( cmd == SITTING )
      pose = SITTING;
    else if( cmd == LAYING )
      pose = LAYING;
    else if( cmd == JUMPING )
      pose = JUMPING;
    else
      pose = STANDING;
  }

  /**
   * a helper method to print out the mood in words
   * 
   * @param void
   * @return mood word
   */
  private String prMood()
  {
    String mstr = "";
    if( mood == HAPPY )
      mstr = "happy";
    else if( mood == WANTOUT )
      mstr = "want out";
    else if( mood == BORED )
      mstr = "bored";
    else if( mood == HUNGRY )
      mstr = "hungry";
    else if( mood == SLEEPY )
      mstr = "sleepy";

    return mstr;
  }

  /**
   * a helper method to print out the position in words
   * 
   * @param void
   * @return position word
   */
  private String prPose()
  {
    String pstr = "";

    if( pose == STANDING )
      pstr = "standing";
    else if( pose == SITTING )
      pstr = "sitting";
    else if( pose == LAYING )
      pstr = "laying down";
    else if( pose == JUMPING )
      pstr = "jumping up";

    return pstr;
  }

  public void bark()
  {
    System.out.println( "woof" );
  }
  
  private void ignore() {}
  
  public void respond( String dogName )
  {
    if( dogName.equals( name ) )
      bark();
    else
      ignore();
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName( String newName )
  {
    name = newName;
  }
  
  /**
   * gives basic attributes about the dog
   * 
   * @param void
   * @return string
   */
  public String toString()
  {
    String str = "";
    str += name + "'s state: \n";
    str += "  mood:     " + prMood() + "\n";
    str += "  stomach:  " + stomach + "\n";
    str += "  position: " + prPose() + "\n";
    return str;
  }
}
