import java.util.Random;


public class TestPRNG
{
  public static void main( String[] args )
  {
    Random generator = new Random();
    int num = generator.nextInt();
    // long time = System.currentTimeMillis();
    PRNG ex = new PRNG( num, 100 );
    ex.showX0();
    ex.showXi();

    int xi = ex.getXi();
    ex.computeAgain( xi );
    ex.showXi();
    
    xi = ex.getXi();
    ex.computeAgain( xi );
    ex.showXi();
    
    xi = ex.getXi();
    ex.computeAgain( xi );
    ex.showXi();
  }
}
