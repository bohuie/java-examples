public class TestParser
{
  public static void main( String[] args )
  {
    TagParser tp = new TagParser( "src/a2.html" );
    tp.parseTT();
    tp.storeTT();
  }
}
