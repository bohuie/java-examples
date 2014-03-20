import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountWord
{
  String inputFileName;
  
  public CountWord( String fileName )
  {
    inputFileName = fileName;
  }
  
  private int countNumWords()
  {
    Scanner inFile;
    int count = 0;
    try
    {
      inFile = new Scanner( new File( inputFileName ) );
      // count words inside file
      String word;
      while( inFile.hasNext() )
      {
        word = inFile.next();
        System.out.println( word );
        count++;
      }
      System.out.println( "Number of words is " + count );
    }
    catch( FileNotFoundException e )
    {
      System.err.println( "Cound not find file: " + inputFileName );
      count = -1;
      e.printStackTrace();
    }
    return count;
  }
  
  public void writeStats( String outputFileName )
  {
    int numWords = countNumWords();
    
    // print processing results to another file
    PrintWriter outFile = null;
    try
    {
      outFile = new PrintWriter( outputFileName );
      outFile.println( "ANALYSIS for " + inputFileName );
      if( numWords == -1 )
        outFile.print( "Unable to read file, words not counted." );
      else
        outFile.print( "Number of words is " + numWords );
      outFile.println( "" );
    }
    catch( FileNotFoundException e )
    {
      System.err.println( "Cound not find file: " + outputFileName );
      e.printStackTrace();
    }
    finally
    {
      outFile.close();
    }
  }
}
