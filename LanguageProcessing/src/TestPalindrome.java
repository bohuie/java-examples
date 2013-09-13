/**
 * this class tests the Palindrome class
 * 
 * @author bohuie
 * 
 */
public class TestPalindrome
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    Palindrome tester = new Palindrome( "alla" );
    System.out.println( tester.getWord() + ": " + tester.isPalindrome() );

    tester = new Palindrome( "aloha" );
    System.out.println( tester.getWord() + ": " + tester.isPalindrome() );
    
    tester = new Palindrome( "yay" );
    System.out.println( tester.getWord() + ": " + tester.isPalindrome() );

    // if the method knows how to skip whitespaces, 
    // this output would have been true
    tester = new Palindrome( "niagara o roar again" );
    System.out.println( tester.getWord() + ": " + tester.isPalindrome() );
  }

}
