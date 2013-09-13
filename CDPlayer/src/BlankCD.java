/**
 * this class models a blank CD and is designed based on CD
 * 
 * design questions: 
 * - how is a blank CD different from a company produced CD?
 * - what is the definition of a full blank CD?
 * 
 * a blank CD is not limited by number of songs, but by data usage
 * songs on a CD don't need to be the same artist either
 * 
 * implementation questions:
 * - how do we create an array without knowing its size ahead of time?
 * - how does addSong need to change based on a different full definition?
 * 
 * @author bohuie
 */
public class BlankCD
{
  private String          albumTitle;
  private Song[]          songs;
  private int             currSongs;
  private double          dataUsed;

  // constants
  public static final int MAXSIZE = 25;    // should be 700MB of data, but use 10 for testing
  public static final int MAXSONGS = 200;

  /**
   * constructor method
   */
  public BlankCD()
  {
    albumTitle = "";
    currSongs  = 0;
    dataUsed   = 0;
    songs = new Song[MAXSONGS];
  }

  /**
   * constructor method
   * 
   * @param title
   */
  public BlankCD( String title )
  {
    albumTitle = title;
    currSongs  = 0;
    dataUsed   = 0;
    songs = new Song[MAXSONGS];
  }

  /**
   * accessor for songs
   * 
   * @param void
   * @return array of songs
   */
  public Song[] getSongs()
  {
    return songs;
  }

  /**
   * checks if CD has room for more data or not
   * 
   * @param void
   * @return full?
   */
  private boolean isFull()
  {
    if( dataUsed < MAXSIZE )
      return false;
    else
      return true;
  }

  /**
   * checks if CD has room for one more song with the given size
   * 
   * @param songSize
   * @return fits?
   */
  private boolean enoughSpace( double songSize )
  {
    if( (dataUsed+songSize) <= MAXSIZE )
      return true;
    else
      return false;
  }

  /**
   * adds one song to the CD
   * 
   * @param song
   * @return void
   */
  public void addSong( Song s )
  {
    if( enoughSpace( s.getSize() ) )
    {
      songs[currSongs] = s;
      currSongs++;
      dataUsed += s.getSize();
    }
    else
      System.err.println( "Error: could not add " + s.getAbstract() );
  }

  /**
   * prints the list of songs
   * @param void
   * @return songs
   */
  public String prSongs()
  {
    String str = "";
    for( int i = 0; i < currSongs; i++ )
    {
      str += (i+1) + ". \n" + songs[i].toString() + "\n";
    }
    return str;
  }

  /**
   * this method displays the attributes of the CD
   * 
   * @param void
   * @return CD
   */
  public String toString()
  {
    String str = "";
    str += "Album:    " + albumTitle + "\n";
    str += prSongs();
    return str;
  }
}
