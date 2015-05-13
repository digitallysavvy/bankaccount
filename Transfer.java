
public final class Transfer extends Transaction {
    
    private Account fromAccount;
    private Account toAccount;
    private double transferAmount;
    
    public Transfer(Account fA, Account tA, double amount){
        super();
        fromAccount = fA;
        toAccount = tA;
        transferAmount = amount;
    }

    public void run(){

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        System.out.println("Transferring $" + transferAmount + " from Account#" + fromAccount.getAccountNumber() + " to Account#" + toAccount.getAccountNumber());
        makeTransaction();
    } 
    
    public void makeTransaction(){
        
        if(fromAccount.getBalance() - transferAmount >= 0){          
           
            Withdrawal withdrawal = new Withdrawal(fromAccount, transferAmount);
            Deposit deposit = new Deposit(toAccount, transferAmount);
            
            deposit.makeTransaction();
            withdrawal.makeTransaction();
        }
        
        else {
            System.out.println("--Transfer of $" + transferAmount + " from Account#" + fromAccount.getAccountNumber() + " to Account#" + toAccount.getAccountNumber() + " failed.");
        }
        
    }
    
    
}
