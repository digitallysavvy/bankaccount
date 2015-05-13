
public class Deposit extends Transaction {
    
     private Account account;
     private double depositAmount;
     
     public Deposit(int tNum, Account a, double amount){
         super(tNum);
         account = a;
         depositAmount = amount;
     }
     
     public void makeTransaction(){
         account.setBalance(account.getBalance() + depositAmount);
     }
    
}
