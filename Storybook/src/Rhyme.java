/**
 * this class stores animal nursery rhymes
 * 
 * design questions:
 * - how to model multiple rhymes in one class?
 * - how should animal classes interact with this class?
 * - how to get the different rhymes to share animal objects?
 * 
 * use a flag to "switch" between rhymes
 * animals are simple here, just use them to min code redudancy
 * reduce animal code by creating animal classes
 * 
 * implementation questions:
 * - how do we enumerate through each animal object?
 * - how do we eliminate redundant code?
 * 
 * @author bohuie
 */
public class Rhyme
{
  private int             nursery;
  private Cow             a1;
  private Pig             a2;
  private Lamb            a3;
  private Duck            a4;
  private Chicken         a5;
  private Horse           a6;

  // constants
  public static final int OMACDONALD = 1;
  public static final int SOUNDSOF   = 2;

  /**
   * constructor method
   * 
   * @param void
   * @return void
   */
  public Rhyme()
  {
    nursery = OMACDONALD;
    createAnimals();
  }

  /**
   * initialize animals
   * 
   * @param void
   * @return void
   */
  private void createAnimals()
  {
    a1 = new Cow();
    a2 = new Pig();
    a3 = new Lamb();
    a4 = new Duck();
    a5 = new Chicken();
    a6 = new Horse();
  }

  /**
   * mutator for nursery rhyme to generate
   * 
   * @param flag
   * @return void
   */
  public void setNursery( int flag )
  {
    nursery = flag;
  }

  /**
   * helper method for lyrics
   * 
   * @param void
   * @return line
   */
  private String getOMacLine()
  {
    return "Old MacDonald had a farm E-I-E-I-O\n";
  }

  /**
   * makes a verse in the old mac song
   * 
   * @param animal
   * @param sound
   * @return verse
   */
  private String makeOldMacVerse( String animal, String sound )
  {
    String str = "";
    str += getOMacLine();
    str += "And on that farm he had a " + animal + " E-I-E-I-O\n";
    str += "With a " + sound + " " + sound + " here ";
    str += "and a " + sound + " " + sound + " there\n";
    str += "Here a " + sound + ", there a " + sound;
    str += ", everywhere a " + sound + " " + sound + "\n";
    str += getOMacLine();
    return str;
  }

  /**
   * makes the entire song based on verses with different animals
   * 
   * @param void
   * @return song
   */
  private String makeOldMac()
  {
    String str = "";
    str += makeOldMacVerse( a1.getName(), a1.noise() );
    str += "\n";
    str += makeOldMacVerse( a2.getName(), a2.noise() );
    str += "\n";
    str += makeOldMacVerse( a3.getName(), a3.noise() );
    str += "\n";
    str += makeOldMacVerse( a4.getName(), a4.noise() );
    str += "\n";
    str += makeOldMacVerse( a5.getName(), a5.noise() );
    str += "\n";
    str += makeOldMacVerse( a6.getName(), a6.noise() );
    return str;
  }

  /**
   * helper method for lyrics
   * 
   * @param void
   * @return line
   */
  private String getSoundsLine()
  {
    return "These are the sounds that the animals make\n";
  }

  /**
   * makes the animal specific part of the rhyme
   * 
   * @param animal
   * @param sound
   * @return verse
   */
  private String getSoundsAnimal( String animal, String sound )
  {
    String str = "";
    str += "The " + animal + " goes " + sound + ", ";
    str += sound + ", " + sound + ", " + sound + "\n";
    return str;
  }

  /**
   * makes the entire song based on different animals
   * 
   * @param void
   * @return song
   */
  private String makeSoundsOf()
  {
    String str = "";
    str += getSoundsLine();
    str += getSoundsLine();
    str += getSoundsLine();
    str += getSoundsAnimal( a1.getName(), a1.noise() );
    str += getSoundsAnimal( a2.getName(), a2.noise() );
    str += getSoundsAnimal( a3.getName(), a3.noise() );
    str += "\n";
    str += getSoundsLine();
    str += getSoundsLine();
    str += getSoundsLine();
    str += getSoundsAnimal( a4.getName(), a4.noise() );
    str += getSoundsAnimal( a5.getName(), a5.noise() );
    str += getSoundsAnimal( a6.getName(), a6.noise() );
    str += "\n";
    str += getSoundsLine();
    return str;
  }

  /**
   * prints the lyrics
   * 
   * @param void
   * @return song
   */
  public String toString()
  {
    String str = "";
    if( nursery == OMACDONALD )
      str = makeOldMac();
    else if( nursery == SOUNDSOF )
      str = makeSoundsOf();
    // otherwise, rhyme unknown
    return str;
  }
}
