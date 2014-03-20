public class Farm
{
  public static void main( String[] args )
  {
    Animal[] pets = new Animal[3];
    pets[0] = new Pig( "Major", 4 );
    pets[1] = new Pig( "Snowball", 4 );
    pets[2] = new Raven( "Moses", 2 );
    
    for( int i=0; i<pets.length; i++ )
      System.out.println( pets[i].getName() + " says " + pets[i].speak() );
  }

}
