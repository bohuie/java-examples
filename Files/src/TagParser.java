import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TagParser
{
  Scanner filein;
  FileWriter fileout;
  String[] tagBuffer;
  int tagCount;
  
  public TagParser( String fileName )
  {
    // initialize input file
    File readFrom = new File( fileName );
    try
    {
      filein = new Scanner( readFrom );
    }
    catch( FileNotFoundException e )
    {
      System.err.println( fileName + " not found" );
      e.printStackTrace();
    }
    
    // initialize output file
    String outName = fileName.substring( 0, fileName.length()-5 );
    outName += "-tagsOnly.txt";
    try
    {
      fileout = new FileWriter( outName, true );
    }
    catch( IOException e )
    {
      e.printStackTrace();
    }
    
    // initialize string array and tagCount
    tagBuffer = new String[100];
    for( int i=0; i<tagBuffer.length; i++ )
      tagBuffer[i] = "-1";
    tagCount = 0;
  }

  public void parseTT()
  {
    String startTag = "<tt>";
    String endTag = "</tt>";
    if( filein != null )
    {
      String line;
      while( filein.hasNextLine() )
      {
        line = filein.nextLine();
        // check if startTag is in this line
        if( line.indexOf( startTag ) >= 0 )
        {
          int startPos = line.indexOf( startTag ) + 4;
          int endPos = line.indexOf( endTag );
          System.out.println( line.substring( startPos, endPos ) );
          tagBuffer[ tagCount ] = line.substring( startPos, endPos );
          tagCount++;
        }
      }
    }
  }
  
  public void storeTT()
  {
    for( int i=0; i<tagBuffer.length; i++ )
      if( tagBuffer[i].equals( "-1" ) )
        break;
      else
        try
        {
          fileout.write( tagBuffer[i] + "\n" );
        }
        catch( IOException e )
        {
          e.printStackTrace();
        }
    
    // close after loop
    try
    {
      fileout.close();
    }
    catch( IOException e )
    {
      System.err.println( fileout + " could not be closed" );
      e.printStackTrace();
    }
  }
}
