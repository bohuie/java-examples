/**
 * this class models a CD
 * 
 * design questions: 
 * - what info do we need to get from a CD when it's used?
 * - should all CDs have the same number of songs on them?
 * 
 * a (legit) CD has the same artist but different songs
 * for simplicity, all CDs have the same max num of songs
 * 
 * implementation questions:
 * - what happens if some info isn't initialized?
 * - which accessors and mutators are needed?
 * 
 * @author bohuie
 */
public class CD
{
  private String          albumTitle;
  private String          artist;
  private String          producer;
  private Song[]          songs;
  private int             currSongs;

  // constants
  public static final int MAXSONGS = 2; // should be 15, but use 2 for testing

  /**
   * constructor method
   */
  public CD()
  {
    albumTitle = "";
    artist = "";
    producer = "";
    songs = new Song[MAXSONGS];
    currSongs = 0;
  }

  /**
   * constructor method
   * 
   * @param title
   * @param band
   * @param company
   */
  public CD( String title, String band, String company )
  {
    albumTitle = title;
    artist = band;
    producer = company;
    songs = new Song[MAXSONGS];
    currSongs = 0;
  }
  
  /**
   * mutator for album title
   * @param title
   */
  public void setAlbum( String title )
  {
    albumTitle = title;
  }

  /**
   * mutator for artist
   * @param band
   */
  public void setArtist( String band )
  {
    artist = band;
  }
  
  /**
   * mutator for producer
   * @param company
   */
  public void setProducer( String company )
  {
    producer = company;
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
   * checks if CD has the max number of songs on it already or not
   * 
   * @param void
   * @return full?
   */
  private boolean isFull()
  {
    if( currSongs < MAXSONGS )
      return false;
    else
      return true;
  }

  /**
   * adds one song to the CD
   * 
   * @param song
   * @return void
   */
  public void addSong( Song s )
  {
    if( !isFull() )
    {
      songs[currSongs] = s;
      currSongs++;
    }
    else
      System.err.println( "Error: CD is full" );
  }

  /**
   * prints the list of songs
   * @param void
   * @return songs
   */
  public String prSongs()
  {
    String str = "";
    for( int i = 0; i < MAXSONGS; i++ )
    {
      str += (i+1) + ". " + songs[i].toString() + "\n";
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
    str += "Artist:   " + artist + "\n";
    str += "Album:    " + albumTitle + "\n";
    str += "Producer: " + producer + "\n";
    str += prSongs();
    return str;
  }
}
