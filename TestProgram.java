
import java.util.ArrayList;

public class TestProgram
{
  public static void main(String [] args)
  {
    // AccountTest Test
    {
    AccountTest program = new AccountTest();

    System.out.println("\n" + "Start AccountTest Test by Dave Mudgett" + "\n");

    // Declare and initialize arguments to main()
    String [] arg =  new String [5];
    arg[0]="100.0"; arg[1]="300.0"; arg[2]="200.0"; arg[3]="400.0"; arg[4]="150.0";

    ArrayList<Account> testResults = new ArrayList<Account>();

    long startTime = System.currentTimeMillis();
    testResults = program.main(arg);
    long endTime = System.currentTimeMillis();

    System.out.println("Transactions took: " + (endTime - startTime)/1000 + "seconds to run.");

    for(Account result: testResults)
    {
      System.out.println("Result: Account Number " + result.getAccountNumber() + " - Final Balance: " + result.getBalance()); 
    } 

    System.out.println("End of AccountTest Test" + "\n");
    }
  }
}
