import java.util.Random;

/**
 * this is a Player class for a game
 */
public class Player
{
  private int id;
  private int year;
  private int month;
  private int day;
// stores the player’s unique ID
// stores the player’s birth year
// stores the player’s birth month
// stores the player’s birth day
  private static final int RANGE = 10000;
  // constructor
  public Player( int dd, int mm, int yyyy )
  {
    year  = yyyy;
    month = mm;
    day   = dd;
    Random generator = new Random();
    id = generator.nextInt( RANGE );
}
  /**
   * accessors for the corresponding attribute
   * @param void
   * @return the corresponding attribute
   */
  public int getYear()  { return year; }
  public int getMonth() { return month; }
  public int getDay()   { return day; }
  public int getId()    { return id; }
  
  /**
   * Two Player objects are the same if and only if they have the same birthdate 
   * (year, month, and day) and the same identifier. 
   * A Player object is bigger than another if it has an earlier birthdate. 
   * This method takes one input parameter only, a Player object, and returns 0 
   * if the two objects are the same, -1 if this object is smaller than the input object, 
   * and 1 otherwise.
   */
  public int compareToAnotherPlayer( Player other )
  {
    if( year == other.getYear() && month == other.getMonth() && day == other.getDay() 
        && id == other.getId() )
      return 0;
    else
      // i'm older if (i) i was born in an earlier year, 
      // (ii) or same year but earlier month,
      // (iii) or same year, same month, but earlier day
      if( year < other.getYear() )
        return 1;
      else if( year == other.getYear() && month < other.getMonth() )
        return 1;
      else if( year == other.getYear() && month == other.getMonth() && day < other.getDay() )
        return 1;
      else
        return -1;
  }
}