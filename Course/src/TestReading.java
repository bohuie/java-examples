public class TestReading
{
  public static void main( String[] args )
  {
    // create a few reading objects
    Novel animalfarm = new Novel( "Animal Farm", 1945, 176,
        "George Orwell", "farm", "Napoleon" );
    Textbook ai = new Textbook(
        "Artificial Intelligence: A Modern Approach", 2009, 1152,
        "Computer Science", "Stuart Russell and Peter Norvig" );
    Newspaper sun = new Newspaper( "The Vancouver Sun", 2014, 12, "Pacific Newspaper Group Inc.", 59 );  

    // print them
    System.out.println( "*** Before changes:" );
    System.out.println( animalfarm.toString() );
    System.out.println( ai.toString() );
    System.out.println( sun.toString() );
    
    // make some changes
    animalfarm.setMainCharacter( "Boxer" );
    ai.setNumberOfPages( 1150 );
    sun.setNumberOfPages( 15 );
    
    // print them again
    System.out.println( "*** After changes:" );
    System.out.println( animalfarm.toString() );
    System.out.println( ai.toString() );
    System.out.println( sun.toString() );
  }
}
