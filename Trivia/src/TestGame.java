import java.util.Scanner;

/**
 * this class tests Game.java which also uses Question.java
 * 
 * @author bohuie
 */
public class TestGame
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  { 
    System.out.println( "********** Testing Trivia Game ...");
    Scanner sysin = new Scanner( System.in );
    String userInput;
    int score;
    int choice = 1;

    Game canadianTrivia = new Game();
    // canadianTrivia.prQuestions();
    
    // create new player
    System.out.println( "What is your name?" );
    userInput = sysin.nextLine();
    Player user = new Player( userInput );
    
    // play multiple rounds of the game until user wants to stop
    System.out.println( "Let's get started!" );
    while( true )
    {
      score = canadianTrivia.playTrivia();
      user.addNewScore( score );
      
      // determine if we play another round or not
      System.out.println( "\nWould you like to play again? (1) yes, (2) no" );
      userInput = sysin.nextLine();
      choice = Integer.parseInt( userInput );
      if( choice == 2 )
        break;
    }    
    System.out.println( "Final Game Statistics:" );
    System.out.println( user.toString() );
    System.out.println( "See you next time!" );
  }
}
