
public class NYCountdown
{
  private int secToGo;
  
  public NYCountdown( int timeLeft )
  {
    secToGo = timeLeft;
    startCount();
  }
  
  private void startCount()
  {
    int i;
    for( i=secToGo; i>0; i-- )
      System.out.println( i );
  }

}
