import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestWriteStats
{
  public static void main( String[] args ) throws IOException
  {
    // do some input file processing
    String inFileName = "myFile.txt";
    Scanner inFile = new Scanner( new File( inFileName ) );
    int count = 0;
    String word;
    while( inFile.hasNext() )
    {
      word = inFile.next();
      System.out.println( word );
      count++;
    }
    System.out.println( "Number of words is " + count );

    // print processing results to another file
    PrintWriter outFile = new PrintWriter( "results.txt" );
    outFile.println( "ANALYSIS for " + inFileName );
    outFile.print( "Number of words is " + count );
    outFile.println( "" );

    outFile.close();
  }
}
