
public class AccountTest {   
    
    public double[] main(String[] args){
        
        Account[] accounts = new Account[5];
        double [] results = new double[5];
        
        for(int i = 0; i < 5; i++){
            accounts[i] = new Account(i+1, Double.parseDouble(args[i]));
        }
        
        TransactionController transaction = new TransactionController(accounts[0]);
        transaction.makeDeposit(350.00);
        transaction.makeWidthdrawal(200.00);
        makeTransfer(accounts[0], accounts[1], 100);
        
        transaction = new TransactionController(accounts[1]);
        transaction.makeDeposit(200.00);
        transaction.makeWidthdrawal(150.00);
        makeTransfer(accounts[1], accounts[2], 200);
        
        transaction = new TransactionController(accounts[2]);
        transaction.makeDeposit(100.00);
        transaction.makeWidthdrawal(150.00);
        makeTransfer(accounts[2], accounts[3], 200);
       
        transaction = new TransactionController(accounts[3]);
        transaction.makeDeposit(100.00);
        transaction.makeWidthdrawal(200.00);
        makeTransfer(accounts[3], accounts[4], 300);
        
        transaction = new TransactionController(accounts[4]);
        transaction.makeDeposit(100.00);
        transaction.makeWidthdrawal(150.00);
        makeTransfer(accounts[4], accounts[0], 200);
        
        for(int i = 0; i < 5; i++){
            results[i] = accounts[i].getAccountBalance();
        }
        
        return results;
        

    }
    
    public void makeTransfer(Account fromAccount, Account toAccount, double transactionAmount){
        TransactionController[] transaction = new TransactionController[2];
        transaction[0] = new TransactionController(fromAccount);
        transaction[1] = new TransactionController(toAccount);
        
        if(transaction[0].makeWidthdrawal(transactionAmount) == 0){
            transaction[1].makeDeposit(transactionAmount);
           // System.out.println("Transfer from Account" + transaction[0].transactionAccount.getAccounctNumber() + " to Account " + transaction[1].transactionAccount.getAccounctNumber() + " successfull.");
        }
    }
    
}
