public class TestExample
{
  public static void main( String[] args )
  {
    System.out.println( Example.hello );
    
    Example one = new Example( "casper" );
    Example two = new Example( "bitzy" );

    System.out.println( Example.hello );
    
    one.changeStr();
    
    System.out.println( Example.hello );
  }
}