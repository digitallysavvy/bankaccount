
public final class Transfer extends Transaction {
    
    Account fromAccount;
    Account toAccount;
    double transferAmount;
    
    public Transfer(int tNum, Account fA, Account tA, double amount){
        super(tNum);
        fromAccount = fA;
        toAccount = tA;
        transferAmount = amount;
    }
    
    public void makeTransaction(){
        
        if(fromAccount.getBalance() - transferAmount >= 0){          

            fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
            toAccount.setBalance(toAccount.getBalance() + transferAmount);
        }
        
        else {
            System.out.println("Transfer failed.");
        }
        
    }
    
    
}
