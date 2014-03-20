
public class TestMessaging
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    MessageBuddy sara = new MessageBuddy( "Sara" );
    MessageBuddy tori = new MessageBuddy( "Tori" );
    
    sara.createMessage();
    sara.sendMessage( tori );
    
    tori.createMessage();
    tori.sendMessage( sara );
  }
}
