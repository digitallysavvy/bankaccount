
import java.io.IOException;
import java.util.ArrayList;

public class AccountTest {   
    
    public ArrayList<Account> main(String[] args){
        
        GenerateTransactions fileGenerator = new GenerateTransactions("accounts.csv", "transactions.csv");

        try {
            fileGenerator.addAccounts();
            fileGenerator.addTransactions();
        } catch (IOException ex) {}


        ArrayList<Account> accounts = new ArrayList<Account>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        //RunTime Arrays
        ArrayList<Long> balanceInquiryRunTimes = new ArrayList<Long>();
        ArrayList<Long> depositRunTimes = new ArrayList<Long>();
        ArrayList<Long> withdrawalRunTimes = new ArrayList<Long>();
        ArrayList<Long> transferRunTimes = new ArrayList<Long>();
        ArrayList<Long> batchRunTimes = new ArrayList<Long>();


        ReadTransactions fileReader = new ReadTransactions("accounts.csv", "transactions.csv");

        try{
            fileReader.loadAccounts(accounts);
            fileReader.loadTransactions(transactions, accounts);
        }catch (IOException ex) {}



        for(Account a: accounts){
            BalanceInquiry balance = new BalanceInquiry(a);
            balance.makeTransaction();
        }
        

        
        System.out.println("\nTransactions:\n");


        for(Transaction t: transactions){
            t.start();
        }

        for(Transaction t: transactions){
            
            long runTime = t.getRunTime();

            if(t instanceof BalanceInquiry){
                balanceInquiryRunTimes.add(runTime);
            }

            else if(t instanceof Deposit){
                depositRunTimes.add(runTime);
            }

            else if(t instanceof Withdrawal){
                withdrawalRunTimes.add(runTime);
            }

            else if(t instanceof Transfer){
                transferRunTimes.add(runTime);
            }

            else if(t instanceof Batch){
                batchRunTimes.add(runTime);
            }
        }


        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {}

        //RunTime Avgs
        CalculateRunTimes bICalcs = new CalculateRunTimes(balanceInquiryRunTimes);
        CalculateRunTimes dCalcs = new CalculateRunTimes(depositRunTimes);
        CalculateRunTimes wCalcs = new CalculateRunTimes(withdrawalRunTimes);
        CalculateRunTimes tCalcs = new CalculateRunTimes(transferRunTimes);
        CalculateRunTimes baCalcs = new CalculateRunTimes(batchRunTimes);

        System.out.println("The average runTime for BalanceInquiries is: " + bICalcs.calcAvg() + " nano seconds");
        System.out.println("-- with a standard deviation of: " + bICalcs.calcStdDev() + " nano seconds");

        System.out.println("The average runTime for Deposits is: " + dCalcs.calcAvg() + " nano seconds");
        System.out.println("-- with a standard deviation of: " + dCalcs.calcStdDev() + " nano seconds");

        System.out.println("The average runTime for Withdrawals is: " + wCalcs.calcAvg() + " nano seconds");
        System.out.println("-- with a standard deviation of: " + wCalcs.calcStdDev() + " nano seconds");

        System.out.println("The average runTime for Transfers is: " + tCalcs.calcAvg() + " nano seconds");
        System.out.println("-- with a standard deviation of: " + tCalcs.calcStdDev() + " nano seconds");

        System.out.println("The average runTime for Batch transactions is: " + baCalcs.calcAvg() + " nano seconds");
        System.out.println("-- with a standard deviation of: " + baCalcs.calcStdDev() + " nano seconds");


        System.out.println();        

        
        return accounts;
        

    }
    
}
