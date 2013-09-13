/**
 * this class tests the CD and BlankCD classes
 * 
 * @author bohuie
 */
public class TestCD
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    // create songs
    Song done = new Song( "Done", "The Band Ferry", 221, 4.97 );
    Song clarity = new Song( "Clarity", "Zedd feat. Foxes", 276, 6.32 );
    Song never = new Song( "Here's to never growing up", "Avril Lavigne",
        225, 5.14 );
    Song cups = new Song( "Cups", "Anna Kendrick", 77, 1.59 );
    Song werenot = new Song( "Something we're not", "Demi Lovato", 198,
        7.60 );
    Song wings = new Song( "Wings", "Little Mix", 220, 3.35 );
    Song howya = new Song( "How ya", "Little Mix", 214, 9.40 );
    Song change = new Song( "Change Your Life", "Little Mix", 212, 5.12 );

    // make blank cd
    System.out.println( "********** Testing Blank CD ..." );
    BlankCD partyMusic = new BlankCD( "Best of 2013" );
    // add songs until full, then print songs
    partyMusic.addSong( never );
    partyMusic.addSong( wings );
    partyMusic.addSong( cups );
    partyMusic.addSong( done );
    partyMusic.addSong( werenot );
    partyMusic.addSong( clarity );
    System.out.println( partyMusic.toString() );

    // make regular cd
    System.out.println( "********** Testing CD ..." );
    CD littleMix = new CD();
    littleMix.setAlbum( "DNA" );
    littleMix.setArtist( "Little Mix" );
    littleMix.addSong( howya );
    littleMix.addSong( change );
    littleMix.addSong( wings );
    System.out.println( littleMix.toString() );
    
    // make cd player
    System.out.println( "********** Testing CD Player ..." );
    CDPlayer boombox = new CDPlayer( littleMix );
    boombox.play();
    boombox.playSelection( 2 );
  }
}
