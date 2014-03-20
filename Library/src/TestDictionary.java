
public class TestDictionary
{
  public static void main( String[] args )
  {
    Dictionary webster = new Dictionary( 1234, 50000 );
    System.out.println( "This has " + webster.getPages() + " pages" );
    System.out.println( "This has " + webster.getNumDefs() + " definitions" );
    System.out.println( "This has " + webster.getNumEntries() + " entries" );
    
    webster.addEntry( "key", "ki", "tool used to unlock something" );
    System.out.println( "This has " + webster.getNumEntries() + " entries" );
  }
}
