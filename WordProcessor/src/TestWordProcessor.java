public class TestWordProcessor
{
  public static void main( String[] args )
  {
    WordProcessor wp = new WordProcessor();
    String word1 = "Hello ";
    String word2 = "Jane.";
    String word3 = "John.";

    System.out.println( "test case: check if empty processor" );
    System.out.println( wp.isEmpty() );

    System.out.println( "test case: print on empty processor" );
    System.out.println( wp.print() );

    System.out.println( "test case: undo on empty processor" );
    wp.undo();

    System.out.println( "test case: type word into empty processor" );
    wp.type( word1 );
    System.out.println( wp.print() );
    
    System.out.println( "test case: type multiple words into processor" );
    wp.type( word1 );
    wp.type( word2 );
    System.out.println( wp.print() );
    System.out.println( wp.print() );
    
    System.out.println( "test case: add word after printing word" );
    wp.type( word1 );
    System.out.println( wp.print() );
    wp.type( word2 );
    System.out.println( wp.print() );
         
    System.out.println( "test case: add word after undo" );
    wp.type( word1 );
    wp.type( word2 );
    wp.undo();
    wp.type( word3 );
    System.out.println( wp.print() );
    System.out.println( wp.print() );
    
  }
}
