
public class Deposit extends Transaction {
    
    private Account account;
    private double depositAmount;   
     
    public Deposit(Account a, double amount){
        super();
        account = a;
        depositAmount = amount;
    }

    public void run(){
        
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        System.out.println("Depositing $" + depositAmount +" into Account#" + account.getAccountNumber());
        makeTransaction();
    } 
     
    public void makeTransaction(){
        account.setBalance(account.getBalance() + depositAmount);
    }
    
}
