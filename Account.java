
public class Account {

    private final int accountNumber;
    private double accountBalance;
    
    public Account(int n, double balance){
        accountNumber = n;
        accountBalance = balance;
    }
    
    public int getAccountNumber(){
        return accountNumber;
    }
    
    public double getBalance(){
        return accountBalance;
    }
    
    public void setBalance(double balance){
        accountBalance = balance;
    }
    
    

    
}
