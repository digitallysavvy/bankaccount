
public class BalanceInquiry extends Transaction {
    
    private Account account;

    public BalanceInquiry(Account a) {
        super();
        account = a;
    }

    public void run(){
    	System.out.println("--Getting balance of Account#" + account.getAccountNumber());
    	makeTransaction();
    }   
    
    public void makeTransaction(){
        System.out.println("Account#" + account.getAccountNumber() + " has a balance of $" + account.getBalance());
    }
    
}
