
public class Withdrawal extends Transaction {

    private Account account;
    private double amount;

    public Withdrawal(Account a, double amnt) {
        super();
        account = a;
        amount = amnt;
    }

    public void run(){

        /*
        try{
            Thread.sleep(20000);
        } catch (InterruptedException e) {}

        System.out.println("Withdrawing $" + amount +" from Account#" + account.getAccountNumber());
        */

        transactionStartTime = System.nanoTime();
        makeTransaction();
    } 

    public synchronized void makeTransaction() {

        if(account.getBalance() - amount >= 0){
            account.setBalance(account.getBalance() - amount);
            //System.out.println("--Withdrawal successfull: Account#" + account.getAccountNumber() + " new balance: $" + account.getBalance());
        }
        else {
            //System.out.println("--Withdrawal of $" + amount +" from Account#" + account.getAccountNumber() + " failed.");
        }  

        transactionEndTime = System.nanoTime();
    }

}
