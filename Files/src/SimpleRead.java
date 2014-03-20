import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleRead
{
  Scanner filein;
  
  public SimpleRead( String fileName )
  {
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
  }

  public void processByLine()
  {
    if( filein != null )
    {
      while( filein.hasNextLine() )
      {
        System.out.println( filein.nextInt() );
        filein.nextLine();  // read rest of line
      }
    }
  }
}
