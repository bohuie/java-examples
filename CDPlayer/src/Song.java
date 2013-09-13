/**
 * this class models a song inside a CD
 * 
 * design questions: 
 * - what info do we need for a song? 
 * - should this info be stored in a song, or in a CD, or both?
 * - does the class need any methods for operating on this info?
 * 
 * a song should have info that can be displayed when played
 * some info (e.g. artist) should be stored at both levels
 * most song info (e.g. size, title) are song-specific
 * some info needs to be accessible by other classes
 * 
 * implementation questions: 
 * - what format is the song data? 
 * - what is the difference between size and duration?
 * 
 * @author bohuie
 */
public class Song
{
  private String title;
  private String artist;
  private int    duration; // number of seconds
  private double size;    // in MB
  private String data;    // realistically, data is not a String

  /**
   * constructor method
   * 
   * @param title
   * @param artist
   * @param duration
   * @param size
   */
  public Song( String tstr, String astr, int time, double sz )
  {
    title = tstr;
    artist = astr;
    duration = time;

    // realistically, we should give it the data, and then set the size
    // based on it
    size = sz;
    data = "";
  }

  /**
   * accessor for size of song
   * 
   * @param void
   * @return size
   */
  public double getSize()
  {
    return size;
  }
  
  /**
   * accessor for song duration
   * 
   * @param void
   * @return duration
   */
  public int getDuration()
  {
    return duration;
  }

  /**
   * prints song info in short, abstract form
   * 
   * @param void
   * @return shortened song info
   */
  public String getAbstract()
  {
    String str = "";
    str += title + " by " + artist + " (" + size + " MB)";
    return str;
  }
  
  /**
   * takes the number of seconds and formats into mm:ss
   * assume it won't be longer than 99 minutes
   * 
   * @param number of seconds
   * @return formatted time
   */
  private String convertTime( int numSec )
  {
    // calculate the minutes and seconds of the song
    int numMin = numSec / 60;
    int remSec = numSec % 60;
    
    String str = "";
    
    // format minutes into two digits
    if( numMin < 10 )
      str += "0";
    str += numMin + ":";

    // format seconds into two digits
    if( remSec < 10 )
      str += "0";
    str += remSec;
    
    return str;
  }

  /**
   * prints the song info
   * 
   * @param void
   * @return detailed song info
   */
  public String toString()
  {
    String str = "";
    str += "Artist:   " + artist + "\n";
    str += "Title:    " + title + "\n";
    str += "Duration: " + convertTime( duration ) + "\n";
    str += "Size:     " + size + "\n";
    str += "Data:     ...\n";
    return str;
  }
}
