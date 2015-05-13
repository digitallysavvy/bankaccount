
public class Withdrawal extends Transaction {

    private Account account;
    private double amount;

    public Withdrawal(Account a, double amnt) {
        super();
        account = a;
        amount = amnt;
    }

    public void run(){

        try{
            Thread.sleep(20000);
        } catch (InterruptedException e) {}

        System.out.println("Withdrawaling $" + amount +" from Account#" + account.getAccountNumber());
        makeTransaction();
    } 

    public synchronized void makeTransaction() {

        if(account.getBalance() - amount >= 0){
            account.setBalance(account.getBalance() - amount);
        }
        else {
            System.out.println("--Withdrawal of $" + amount +" from Account#" + account.getAccountNumber() + " failed.");
        }  
    }

}
