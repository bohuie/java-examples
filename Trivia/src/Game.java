import java.util.Random;
import java.util.Scanner;

/**
 * this class is the game that has a set of trivia questions and players
 * 
 * design questions:
 * - what does it mean to play a trivia game?
 * - how do we check if questions are answered correctly?
 * - how many players can play? 
 * - do players play against each other together? or do they take turns?
 * - what happens when the game is over?
 * 
 * a session asks multiple questions, and a player can play as many
 * sessions as desired. each session counts as a game. 
 * would be good to have multiple players, but start with just one now.
 * when game is over, report score, let user decide if play again.
 * 
 * implementation questions:
 * - how do we make use of Question and Player classes here?
 * - how do we encode actual trivia questions?
 * - how do we play multiple trivia games that have multiple questions?
 * 
 * @author bohuie
 */
public class Game
{
  private Question[]      qSet;
  private Random          generator;
  private Scanner         sysin;

  // constant
  public static final int MAXQUESTIONS = 10;
  public static final int NUMQUESTIONS = 5;

  /**
   * constructor method
   */
  public Game()
  {
    qSet = new Question[MAXQUESTIONS];
    setupQuestions();
    generator = new Random();
    sysin     = new Scanner( System.in );
  }

  /**
   * repeatedly pull random questions from question set to ask player
   * keep track of player's score as we go through each question
   * display score when session is over
   * 
   * @param void
   * @return score at the end of the game
   */
  public int playTrivia()
  {
    // randomly take some questions from our data set and ask them
    String userInput;
    int userChoice;
    int score = 0;
    int count = 0;
    while( count < NUMQUESTIONS )
    {
      // ask question
      int qdex = generator.nextInt( MAXQUESTIONS );
      Question q = qSet[qdex];
      System.out.println( q.prQuestion() );
      System.out.println( "Enter your answer: " );
      
      // check answer
      userInput = sysin.nextLine();
      userChoice = Integer.parseInt( userInput );
      if( (userChoice-1) == q.getAnswer() )
      {
        score++;
        System.out.println( "Correct!" );
      }
      else
        System.out.println( "That's not right. Better luck next time." );
      
      // update counter
      count++;
    }

    // report game stats
    System.out.println( "Game over!" );
    System.out.println( "Your score: " + score );
    
    return score;
  }
  
  /**
   * this method hardcodes all the trivia used in the game (from canadianliving.com)
   *  
   * improvement: is there a better alternative than hardcoding everything here?
   * 
   * @param void
   * @return void
   */
  private void setupQuestions()
  {
    Question q = new Question();
    q.setQuestion( "How many oceans border Canada?" );
    q.setOptions( "1", "2", "3", "4" );
    q.setAnswer( 2 );
    qSet[0] = q;

    q = new Question();
    q.setQuestion( "Where does the word 'Canada' come from?" );
    q.setOptions( "Jacques Cartier", "Winston Churchill", "Jean Nicollet",
        "Samuel Jackson" );
    q.setAnswer( 0 );
    qSet[1] = q;

    q = new Question();
    q.setQuestion( "Whose face is on the Canadian ten dollar bill?" );
    q.setOptions( "Wilfrid Laurier", "John A. MacDonald",
        "Queen Elizabeth II", "William Lyon Mackenzie King" );
    q.setAnswer( 1 );
    qSet[2] = q;

    q = new Question();
    q.setQuestion( "What are the two most multicultural cities in Canada?" );
    q.setOptions( "Toronto and Montreal", "Vancouver and Toronto",
        "Montreal and Vancouver", "Vancouver and Calgary" );
    q.setAnswer( 1 );
    qSet[3] = q;

    q = new Question();
    q.setQuestion( "What is Canada's national summer sport?" );
    q.setOptions( "Street hockey", "Basketball", "Curling", "Lacrosse" );
    q.setAnswer( 3 );
    qSet[4] = q;
    
    q = new Question();
    q.setQuestion( "When did 'O, Canada' officially become the national anthem?" );
    q.setOptions( "1980", "1920", "1950", "1880" );
    q.setAnswer( 0 );
    qSet[5] = q;
    
    q = new Question();
    q.setQuestion( "What is the oldest walled city that still exists north of Mexico?" );
    q.setOptions( "Vancouver", "Halifax", "Montreal", "Quebec City" );
    q.setAnswer( 3 );
    qSet[6] = q;
    
    q = new Question();
    q.setQuestion( "Canada is a bilingual country, but what is the only official bilingual province?" );
    q.setOptions( "Quebec", "New Brunswick", "Ottawa", "Ontario" );
    q.setAnswer( 1 );
    qSet[7] = q;
    
    q = new Question();
    q.setQuestion( "What major sporting event was held in Canada in 2010?" );
    q.setOptions( "Winter Olympics", "Summer Olympics", "World Cup", "Commonwealth Games" );
    q.setAnswer( 0 );
    qSet[8] = q;
    
    q = new Question();
    q.setQuestion(  "What is the world's tallest free-standing structure?" );
    q.setOptions( "Tokyo Tower", "Burj Dubai", "Emprire State Building", "CN Tower" );
    q.setAnswer( 3 );
    qSet[9] = q;
  }

  /**
   * prints the set of questions in this game
   * 
   * @param void
   * @return void
   */
  public void prQuestions()
  {
    for( int i = 0; i < MAXQUESTIONS; i++ )
    {
      System.out.println( qSet[i].toString() );
    }
  }
}
