import java.util.Scanner;

public class MessagingV2
{
  private String          user;
  private String          msg;
  private String          inbox;
  private Scanner         sysin;

  // constant
  public static final int MAXLEN = 50;

  /*
   * constructor
   */
  public MessagingV2( String name )
  {
    user = name;
    msg = "";
    inbox = "";
    sysin = new Scanner( System.in );
    System.out.println( "Welcome to Message Buddy, " + user );
  }

  /**
   * lets user type in a message but stores only MAXLEN of message
   * 
   * @param void
   * @return void
   */
  public void createMessage()
  {
    System.out.println( user + ", type the message you want to send:" );
    String userInput = sysin.nextLine();
    if( userInput.length() <= MAXLEN )
      msg = userInput;
    else
      msg = userInput.substring( 0, MAXLEN );

  }

  /**
   * sends a typed message to friend
   * 
   * @param friend
   * @return void
   */
  public void sendMessage( MessagingV2 friend )
  {
    if( msg.length() == 0 )
      System.err.println( "There is no message to send" );
    else
    {
      System.out.println( user + ", your message has been sent" );
      friend.receiveMessage( msg, user );
      msg = "";
    }
  }

  /**
   * receives the message from a friend
   * 
   * @param friendMessage
   * @return void
   */
  public void receiveMessage( String friendMessage, String senderName )
  {
    inbox = friendMessage;
    System.out.println( user + ", you have a new message from "
        + senderName + ". Would you like to view it?" );
    String userInput = sysin.nextLine();
    if( userInput.equalsIgnoreCase( "yes" ) )
    {
      System.out.println( user + ", here's your message:" );
      viewMessage();
    }
  }

  /**
   * lets user view the message received
   * 
   * @param void
   * @return void
   */
  private void viewMessage()
  {
    System.out.println( inbox );
    inbox = "";
  }
}
