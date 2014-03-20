
public class TestParams
{
  public static void main( String[] args )
  {
    ParameterModifier modifier = new ParameterModifier();
    
    int a1 = 111;
    Num a2 = new Num( 222 );
    Num a3 = new Num( 333 );
    
    System.out.println( "before changing values: ");
    System.out.println( "a1\t a2\t a3" );
    System.out.println( a1 + "\t " + a2 + "\t " + a3 + "\n" );

    modifier.changeValue( a1, a2, a3 );
    
    System.out.println( "after changing values: ");
    System.out.println( "a1\t a2\t a3" );
    System.out.println( a1 + "\t " + a2 + "\t " + a3 + "\n" );
  }
}