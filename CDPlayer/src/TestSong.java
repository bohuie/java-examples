/**
 * this class tests the Song class
 * 
 * @author bohuie
 */
public class TestSong
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing Song ..." );
    // create song
    Song done = new Song( "Done", "The Band Ferry", 221, 4.97 );
    Song clarity = new Song( "Clarity", "Zedd feat. Foxes", 276, 6.32 );
    Song never = new Song( "Here's to never growing up", "Avril Lavigne", 225, 5.14 );
    Song cups = new Song( "Cups", "Anna Kendrick", 77, 1.59 );
    Song werenot = new Song( "Something we're not", "Demi Lovato", 198, 7.60 );
    Song wings = new Song( "Wings", "Little Mix", 220, 3.35 );
    
    // check info
    System.out.println( done.toString() );
    System.out.println( clarity.toString() );
    System.out.println( never.toString() );

    // get size
    System.out.println( done.getSize() );
    System.out.println( clarity.getSize() );
    System.out.println( never.getSize() );
  }

}
