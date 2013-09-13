/**
 * this class models a CD player that plays a CD "in text"
 * 
 * improvement: GUI interface that allows user to play, pause, and stop
 * 
 * design questions:
 * - what should the CD player be able to do?
 * - how does the player know what type of CD classes to handle?
 * 
 * basic operations should be available, like play, stop, pause. 
 * should be able to handle any type of CD to play.
 * 
 * implementation questions:
 * - what type of CDs should it handle (CD? BlankCD? both?)
 * - how do we actually mimic "playing" of a song?
 * - can we stop or pause a song? or do other common operations like rewind?
 * 
 * @author bohuie
 * 
 */
public class CDPlayer
{
  private CD     myCD;
  private Song[] songList;
  private Song   currSong;

  public CDPlayer( CD cdToPlay )
  {
    myCD      = cdToPlay;
    songList  = myCD.getSongs();
    currSong  = null;
  }

  /**
   * go through each song in the cd 
   * 
   * @param void
   * @return void
   */
  public void play()
  {
    for( int i=0; i<CD.MAXSONGS; i++ )
    {
      playSingle( songList[i] );
    }
  }

  /**
   * plays a selected song given the track number
   * 
   * @param song track number
   * @return void
   */
  public void playSelection( int trackNum )
  {
    if( trackNum > 0 && trackNum <= CD.MAXSONGS )
    {
      playSingle( songList[trackNum-1] );
    }
    else
      System.err.println( "Error: unknown track number " + trackNum );
  }
  
  /**
   * helper method that plays a single song by writing it out in text
   * 
   * @param song
   * @return void
   */
  private void playSingle( Song s )
  {
    currSong = s;
    int counter = 0;
    while( counter < currSong.getDuration() )
    {
      System.out.println( currSong.getAbstract() + " -- " + counter );
      counter++;
    }      
  }
}
