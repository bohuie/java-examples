import java.util.Random;

public class TestActivity
{
  public static void main( String[] args )
  {
    Random generator;
    Activity nextNum; 

    int MAXNUM = 500;

    generator = new Random();
    nextNum = new Activity();
    nextNum.setInstructions( "What is the next number after this one?" );

    int num = generator.nextInt( MAXNUM );
    nextNum.setupReplay( num, num + 1 );
    nextNum.play();

    Activity tellTime;
    int MAXMINUTES = 3600;

    tellTime = new Activity();
    tellTime.setInstructions( "How many minutes are there if in the following number of seconds?" );

    num = generator.nextInt( MAXMINUTES );
    tellTime.setupReplay( num, (num / 60) );
    tellTime.play();
  }
}
