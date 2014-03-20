import java.util.Scanner;

public class MessageBuddy
{
  private String          user;
  private String          msg;
  private String          inbox;
  private Scanner         sysin;

  /*
   * constructor
   */
  public MessageBuddy( String name )
  {
    user  = name;
    msg   = "";
    inbox = "";
    sysin = new Scanner( System.in );
    System.out.println( "Welcome to Message Buddy, " + user );
  }

  /**
   * lets user type in a message
   * 
   * @param void
   * @return void
   */
  public void createMessage()
  {
    System.out.println( user + ", type the message you want to send:" );
    String userInput = sysin.nextLine();
    msg = userInput;
  }

  /**
   * sends a typed message to friend
   * 
   * @param friend
   * @return void
   */
  public void sendMessage( MessageBuddy friend )
  {
    System.out.println( user + ", your message has been sent" );
    friend.receiveMessage( msg, user );
  }

  /**
   * receives the message from a friend
   * 
   * @param friendMessage
   * @return void
   */
  private void receiveMessage( String friendMessage, String senderName )
  {
    inbox = friendMessage;
    System.out.println( user + ", you have a new message from " + senderName + ":" );
    viewMessage();
  }

  /**
   * lets user view the message received
   * @param void
   * @return void
   */
  private void viewMessage()
  {
    System.out.println( inbox );
    inbox = "";
  }
}
