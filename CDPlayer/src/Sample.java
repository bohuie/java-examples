class Sample
{
  // CD attributes 
  String albumTitle;
  String artist; 
  String producer;
  Song[] songs; 
  int    numSongs;

  /** 
   * construct a new CD object with specific info given
   * @param title - the title of the CD album 
   * @param band  - the name of the band or artist of the album
   * @param company - the producer of the CD 
   */
  Sample( String title, String band, String company ) {}

  /**
   * gathers the info of this CD (e.g., title, artist, producer) and 
   * puts them together so it can be displayed when another object 
   * (e.g. a CD player) calls for it 
   * @param void 
   * @return true if CD is full, false otherwise
   */
  String getInfo() { return "info"; } 

  /**
   * returns the set of songs stored on this CD so it can be played 
   * when another object calls it 
   * @param void 
   * @return set of songs stored 
   */
  Song[] getSongs() { return songs; } 

  /**
   * adds the specified song to the album
   * @param s - the song to be added 
   * @return void 
   */
  void addSong( Song s ) {} 

  /**
   * checks if the CD reached the max number of songs that can go on it
   * @param void 
   * @return true if CD is full, false otherwise
   */
  boolean isFull() { return false; } 
}
