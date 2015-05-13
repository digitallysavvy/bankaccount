
public class TransactionController {
    
    public final Account transactionAccount;
    
    
    public TransactionController(Account tAccount) {
        transactionAccount = tAccount;
    }
    
    public void makeDeposit(double amount){
        transactionAccount.setAccountBalance(transactionAccount.getAccountBalance() + amount);
    }
    
    public int makeWidthdrawal(double amount){
        if(transactionAccount.getAccountBalance() - amount <= 0){
            System.out.println("There are insufficient funds to complete this transaction – transaction voided.");
            return 1;
        }
        else {
            transactionAccount.setAccountBalance(transactionAccount.getAccountBalance() - amount);    
        }
        
        return 0;
    }
    
}
