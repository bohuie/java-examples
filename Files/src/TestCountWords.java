public class TestCountWords
{
  public static void main( String[] args )
  {
    CountWord cw = new CountWord( "myFile.txt" );
    cw.writeStats( "results.txt" );
  }
}
