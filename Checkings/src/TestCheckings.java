/**
 * this class tests Checkings.java
 * 
 * @author bohuie
 */
public class TestCheckings
{
  /**
   * @param args
   * @return void
   */
  public static void main( String[] args )
  {
    System.out.println( "********** Testing Checkings..." );
    Checkings acct = new Checkings( "Casper" );
    System.out.println( acct.toString() );
    
    // test password verification methods
    acct.showPassword();
    acct.changePassword();
    
    // put some money into the account
    acct.deposit(  200 );
    System.out.println( acct.toString() );
    
    // shouldn't work
    acct.withdraw( 1000 );
    
    // should work
    acct.withdraw( 40 );
    System.out.println( acct.toString() );
    
    // test transfer
    Checkings acct2 = new Checkings( "Bitzy" );
    System.out.append( acct2.toString() );
    acct.transfer( acct2, 20 );
    System.out.println( acct.toString() );
    System.out.println( acct2.toString() );
  }
}
