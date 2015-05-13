
public class Deposit extends Transaction {
    
    private Account account;
    private double depositAmount;   
     
    public Deposit(Account a, double amount){
        super();
        account = a;
        depositAmount = amount;
    }

    public void run(){

        /*
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {}

        System.out.println("Depositing $" + depositAmount +" into Account#" + account.getAccountNumber());
        */

        transactionStartTime = System.nanoTime();
        makeTransaction();
    } 
     
    public synchronized void makeTransaction(){
        account.setBalance(account.getBalance() + depositAmount); 
        transactionEndTime = System.nanoTime();
    }
    
}
