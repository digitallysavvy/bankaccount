
public class BalanceInquiry extends Transaction {
    
    private Account account;

    public BalanceInquiry(Account a) {
        super();
        account = a;
    }

    public void run(){

        /*
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
        */

        transactionStartTime = System.nanoTime();
    	makeTransaction();
    }   
    
    public void makeTransaction(){
        
        /*
        System.out.println("Account#" + account.getAccountNumber() + " has a balance of $" + account.getBalance());
        */
        account.getBalance();
        transactionEndTime = System.nanoTime();
    }
    
}
