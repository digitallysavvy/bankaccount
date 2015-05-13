

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

    // Declare and intialize correct results array
    double [] correctResults = new double [5];
    correctResults[0] = 350.0; // compute (by hand) and put actual correct results here
    correctResults[1] = 250.0; 
    correctResults[2] = 150.0; 
    correctResults[3] = 200.0; 
    correctResults[4] = 200.0; 

    double [] testResults = new double[5];
    testResults = program.main(arg);

    for(int k = 0; k < 5; k++)
    {
      int accountNumber = k+1;
      System.out.println("Test Result: Account Number " + accountNumber + " - Actual Result: " + testResults[k]
      + "; Correct Result: " + correctResults[k]); 
    } 

    System.out.println("End of AccountTest Test" + "\n");
    }
  }
}
