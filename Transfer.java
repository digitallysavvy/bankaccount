
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
            Thread.sleep(10000);
        } catch (InterruptedException e) {}

        Thread.yield();

        System.out.println("Transferring $" + transferAmount + " from Account#" + fromAccount.getAccountNumber() + " to Account#" + toAccount.getAccountNumber());
        makeTransaction();
    } 
    
    public synchronized void makeTransaction(){
        
        if(fromAccount.getBalance() - transferAmount >= 0){         
            
            try{
                Thread.sleep(10000);
            } catch (InterruptedException e) {}

            fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
            toAccount.setBalance(toAccount.getBalance() + transferAmount);
        }
        
        else {
            System.out.println("--Transfer of $" + transferAmount + " from Account#" + fromAccount.getAccountNumber() + " to Account#" + toAccount.getAccountNumber() + " failed.");
        }
        
    }
    
    
}
