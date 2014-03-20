import java.io.FileWriter;
import java.io.IOException;

public class SimpleWrite
{
  FileWriter fileout;
  
  public SimpleWrite( String fileName, boolean shouldAppend )
  {
    try
    {
      fileout = new FileWriter( fileName, shouldAppend );
      fileout.write( "some text here" );
    }
    catch( IOException e )
    {
      e.printStackTrace();
    }
    finally
    {
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
}
