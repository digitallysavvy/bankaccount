
import java.util.ArrayList;

public class AccountTest {   
    
    public double[] main(String[] args){
        
        Account[] account = new Account[5];
        ArrayList<Transaction> transactions = new ArrayList();
        double [] results = new double[5];
        
        for(int i = 0; i < 5; i++){
            account[i] = new Account(i+1, Double.parseDouble(args[i]));
        }
        
        
        transactions.add(new Deposit(1, account[0],350.00));
        transactions.add(new Withdrawal(2, account[0], 200.00));
        transactions.add(new Transfer(3, account[0],account[1], 100.00));
        
        transactions.add(new Deposit(4, account[1],200.00));
        transactions.add(new Withdrawal(5, account[1], 150.00));
        transactions.add(new Transfer(6, account[1],account[2], 200.00));
        
        transactions.add(new Deposit(7, account[2], 100.00));
        transactions.add(new Withdrawal(8, account[2], 150.00));
        transactions.add(new Transfer(9, account[2],account[3], 200.00));
        
        transactions.add(new Deposit(10, account[3],100.00));
        transactions.add(new Withdrawal(11, account[3], 200.00));
        transactions.add(new Transfer(12, account[3],account[4], 300.00));
       
        transactions.add(new Deposit(13, account[4],100.00));
        transactions.add(new Withdrawal(14, account[4], 150.00));
        transactions.add(new Transfer(15, account[4],account[0], 200.00));


        for(Transaction t: transactions){         
            t.makeTransaction();
        }
        
        
        for(int i = 0; i < 5; i++){       
            results[i] = account[i].getBalance();
        }
        
        return results;
        

    }
    
}
