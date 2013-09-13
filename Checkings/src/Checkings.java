import java.util.Random;
import java.util.Scanner;

/**
 * this class models a checkings bank account with basic operations
 * 
 * design questions: 
 * - what should the account be able to do? 
 * - what information does the account need to store?
 * 
 * it needs to be able to keep track of money 
 * we should be able to make deposits and withdrawals 
 * it should know who the account holder is and how to verify that
 * 
 * implementation questions:
 * - how do we create an account number?
 * - how do we store and verify passwords?
 * - when do we need to verify passwords?
 * 
 * @author bohuie
 */
public class Checkings
{
  private String  holderName;
  private int     accountNumber;
  private int     password;
  private double  balance;
  private boolean newAccount;
  private Scanner sysin;

  /**
   * constructor method
   * @param account holder's name
   */
  public Checkings( String name )
  {
    holderName = name;
    Random generator = new Random();
    accountNumber = generator.nextInt( 999999 );
    password = generator.nextInt( 9999 );
    balance = 0;
    newAccount = true;
    sysin = new Scanner( System.in );
  }

  /**
   * this method deposits money into the account
   * we will let anyone who wants to give us money be able to do so!
   * 
   * @param amount to deposit
   * @return void
   */
  public void deposit( double amount )
  {
    balance = balance + amount;
  }

  /**
   * this method takes out money from account if funds sufficient
   * only those with the proper access can withdraw money
   * 
   * @param amount to withdraw
   * @return void
   */
  public void withdraw( double amount )
  {
    System.out.println( "Enter the password: " );
    String userInput = sysin.nextLine();
    int pwd = Integer.parseInt( userInput );
    if( pwd == password )
    {
      if( balance >= amount )
        balance = balance - amount;
      else
      {
        System.out.println( "Error: Insufficient funds" );
        System.out.println( "You only have $" + balance );
      }      
    }
    else
      System.out.println( "Incorrect password" );
  }

  /**
   * this method prints out the password only if the account has just been
   * newly created
   * 
   * @param void
   * @return void
   */
  public void showPassword()
  {
    if( newAccount )
      System.out.println( "Initial password: " + password );
    else
      System.out.println( "Cannot display private passwords" );
  }

  /**
   * this method changes the account password by asking the user to type in
   * the new password twice as a method of verification the password will
   * only be changed if the user enters it right both times
   * 
   * @param void
   * @return void
   */
  public void changePassword()
  {
    System.out.println( "Enter current password: " );
    String userInput = sysin.nextLine();
    int curr = Integer.parseInt( userInput );
    if( curr == password )
    {
      System.out.println( "Enter new password: " );
      userInput = sysin.nextLine();
      int pwd1 = Integer.parseInt( userInput );

      System.out.println( "Type it again: " );
      userInput = sysin.nextLine();
      int pwd2 = Integer.parseInt( userInput );

      if( pwd1 == pwd2 )
        setPassword( pwd1 );
      else
        System.out.println( "Error: Passwords do not match." );
    }
    else
      System.out.println( "Error: Incorrect password." );
  }

  /**
   * this method is a mutator that sets the password to a new one, and once
   * a password has been set, it is no longer considered as a new account
   * anymore
   * 
   * @param new password to set to
   * @return void
   */
  private void setPassword( int pwd )
  {
    password = pwd;
    newAccount = false;
    System.out.println( "Your password has been changed." );
  }
  
  /**
   * transfer money from this account to another account
   * this method is modeled after the withdrawl method
   * 
   * @param account to transfer money to
   * @param amount to transfer
   * @return void
   */
  public void transfer( Checkings acct, double amount )
  {
    System.out.println( "Enter the password: " );
    String userInput = sysin.nextLine();
    int pwd = Integer.parseInt( userInput );
    if( pwd == password )
    {
      if( balance >= amount )
      {
        balance = balance - amount;
        acct.deposit( amount );        
      }
      else
      {
        System.out.println( "Error: Insufficient funds" );
        System.out.println( "You only have $" + balance );
      }      
    }
    else
      System.out.println( "Incorrect password" );    
  }

  /**
   * this method displays info about the account
   * 
   * @param void
   * @return string
   */
  public String toString()
  {
    String str = "";
    str += "Name:    " + holderName + "\n";
    str += "Account: " + accountNumber + "\n";
    str += "Balance: $" + balance + "\n";
    return str;
  }
}
