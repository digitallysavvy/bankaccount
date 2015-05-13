
import java.util.ArrayList;

public class AccountTest {   
    
    public double[] main(String[] args){
        
        Account[] accounts = new Account[5];
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        double [] results = new double[5];
        int transactionLoop = 1;
        
        for(int i = 0; i < 5; i++){
            accounts[i] = new Account(i+1, Double.parseDouble(args[i]));
        }

        for(Account a: accounts){
            BalanceInquiry balance = new BalanceInquiry(a);
            balance.makeTransaction();
        }
        
        for(int i = 0; i < transactionLoop; i++){
            transactions.add(new Deposit(accounts[0],350.00));
            transactions.add(new Withdrawal(accounts[0], 200.00));
            transactions.add(new Transfer(accounts[0],accounts[1], 100.00));
            
            transactions.add(new Deposit(accounts[1],200.00));
            transactions.add(new Withdrawal(accounts[1], 150.00));
            transactions.add(new Transfer(accounts[1],accounts[2], 200.00));
            
            transactions.add(new Deposit(accounts[2], 100.00));
            transactions.add(new Withdrawal(accounts[2], 150.00));
            transactions.add(new Transfer(accounts[2],accounts[3], 200.00));
            
            transactions.add(new Deposit(accounts[3],100.00));
            transactions.add(new Withdrawal(accounts[3], 200.00));
            transactions.add(new Transfer(accounts[3],accounts[4], 300.00));
           
            transactions.add(new Deposit(accounts[4],100.00));
            transactions.add(new Withdrawal(accounts[4], 150.00));
            transactions.add(new Transfer(accounts[4],accounts[0], 200.00));            
        }
        

        
        System.out.println("\nTransactions:\n");

        for(Transaction t: transactions){
            t.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) { }

        System.out.println();        
        
        for(int i = 0; i < 5; i++){       
            results[i] = accounts[i].getBalance();
        }
        
        return results;
        

    }
    
}
