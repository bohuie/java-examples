import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 * class to reads in a text file and counts the number of vowels in it
 */
public class TextProcessing extends JPanel
{
  String filename;
  Scanner fileScan;
  int numA;
  int numE;
  int numI;
  int numO;
  int numU;
  
  /**
   * constructor
   * when files are used, we have to handle specific exceptions (see next course)
   * @throws FileNotFoundException
   */
  public TextProcessing() throws FileNotFoundException
  {
    filename = "textfile.txt";
    File myFile = new File( filename );
    fileScan = new Scanner( myFile );
    numA = 0;
    numE = 0;
    numI = 0;
    numO = 0;
    numU = 0;
    System.out.println( "reading from: " + filename );
  }
  
  /**
   * counts the number of vowels in all the words in a file
   * @param void
   * @return void
   */
  public void procFile()
  {
    // int numVowels = 0;
    while( fileScan.hasNext() )
    {
      String oneWord = fileScan.next();
      // numVowels += countVowels( oneWord );
      int len = oneWord.length();
      for( int i=0; i<len; i++ )
      {
        char letter = oneWord.charAt( i );
        if( letter == 'a' || letter == 'A' )
          numA++;
        if( letter == 'e' || letter == 'E' )
          numE++;
        if( letter == 'i' || letter == 'I' )
          numI++;
        if( letter == 'o' || letter == 'O' )
          numO++;
        if( letter == 'u' || letter == 'U' )
          numU++;
      }
    }
    // System.out.println( "this file has " + numVowels + " vowels" );
  }
  
  /**
   * print out the counted vowels
   * @param void
   * @return void
   */
  public void prNumVowels()
  {
    System.out.println( "A\tE\tI\tO\tU" );
    System.out.println( numA + "\t" + numE + "\t" + numI + "\t" + numO + "\t" + numU );
  }
  
  /**
   * helper method to count the number of vowels in a given word
   * @param word
   * @return number of vowels in word
   */
  private int countVowels( String wd )
  {
    // System.out.println( wd );
    int count = 0;
    int len = wd.length();
    wd = wd.toLowerCase();
    for( int i=0; i<len; i++ )
    {
      if( isVowel( wd.charAt( i ) ) )
        count++;
    }
    return count;
  }
  
  /**
   * checks if the given letter is one of a,e,i,o,u 
   * taken from the ESL class
   * @param letter
   * @return true if letter is a vowel, false otherwise
   */
  private boolean isVowel( char letter )
  {
    boolean rez = false;
    if( letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o'
        || letter == 'u' )
      rez = true;
    return rez;
  }
  
  public void paint( Graphics g )
  {
    super.paint( g );
    Graphics2D g2d = ( Graphics2D )g;
    
    g2d.setColor( Color.blue );
    int x = 10;
    int y = 20;
    for( int i=0; i<numA; i++ )
    {
      g2d.drawString( "A", x, y );
      x += 10;
    }
    
    g2d.setColor( Color.red );
    x = 10;
    y += 20;
    for( int i=0; i<numE; i++ )
    {
      g2d.drawString( "E", x, y );
      x += 10;
    }
    
    g2d.setColor( Color.yellow );
    x = 10;
    y += 20;
    for( int i=0; i<numI; i++ )
    {
      g2d.drawString( "I", x, y );
      x += 10;
    }
    
    g2d.setColor( Color.green );
    x = 10;
    y += 20;
    for( int i=0; i<numO; i++ )
    {
      g2d.drawString( "O", x, y );
      x += 10;
    }
    
    g2d.setColor( Color.magenta );
    x = 10;
    y += 20;
    for( int i=0; i<numU; i++ )
    {
      g2d.drawString( "U", x, y );
      x += 10;
    }
  }
}
