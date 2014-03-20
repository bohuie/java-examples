
public class ParameterModifier
{
  public void changeValue( int f1, Num f2, Num f3 )
  {
    System.out.println( "before changing values: ");
    System.out.println( "f1\t f2\t f3" );
    System.out.println( f1 + "\t " + f2 + "\t " + f3 + "\n" );
    
    f1 = 999;
    f2.setValue( 888 );
    f3 = new Num( 777 );
    
    System.out.println( "after changing values: ");
    System.out.println( "f1\t f2\t f3" );
    System.out.println( f1 + "\t " + f2 + "\t " + f3 + "\n" );    
  }
}