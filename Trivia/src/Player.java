/**
 * this class models simple information of a player in a game
 * 
 * design questions:
 * - what does the game need to know/store about the player?
 * 
 * keep it simple and just store player name and hi score
 * a running average would be good to add
 * 
 * implementation questions:
 * - what kind of on-going game statistic should we keep track of, and how?
 * 
 * @author bohuie
 */
public class Player
{
  private String name;
  private double hiScore;
  
  /**
   * constructor method
   * @param player name
   */
  public Player( String n )
  {
    name = n;
    hiScore = 0;
  }
  
  /**
   * this method updates the player's best score
   * @param new score to be entered
   * @return void
   */
  public void addNewScore( int score )
  {
    if( score > hiScore )
      hiScore = score;
  }
  
  /**
   * displays player statistics
   * @param void
   * @return string of player info
   */
  public String toString()
  {
    String str = "";
    str += "Player: " + name + "\n";
    str += "Best Score: " + hiScore + "\n";
    return str;
  }
}
