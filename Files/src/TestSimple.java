public class TestSimple
{
  public static void main( String[] args )
  {
    // works with javac and java
    SimpleRead ex1 = new SimpleRead( "nums.txt" );
    ex1.processByLine();
    
    // need to specify folder path for eclipse
    // current directory is project folder, not src or bin
    SimpleRead ex2 = new SimpleRead( "src/nums.txt" );
    ex2.processByLine();
    
    // create a new file
    SimpleWrite ex3 = new SimpleWrite( "myFile.txt", false );
    
    // append to the given file
    SimpleWrite ex4 = new SimpleWrite( "myFile.txt", true );
  }
}
