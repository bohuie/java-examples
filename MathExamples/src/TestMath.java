
public class TestMath
{
  public static void main( String[] args )
  {
    BasicCalculator toyCalc = new BasicCalculator( -9, 4 );
    int sum = toyCalc.add();
    System.out.println( sum );
    
    int val = toyCalc.absFirst();
    System.out.println( val );
    
    double sqrtVal = toyCalc.sqrtSecond();
    System.out.println( sqrtVal );
    
    CozaLozaWoza clw = new CozaLozaWoza( 1, 110 );
    clw.prNums();
    
    TimeTable tt = new TimeTable( 9 );
    tt.prTable();
  }

}
