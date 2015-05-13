
public class Account {

    private int accountNumber;
    private double accountBalance;
    
    public Account(int n, double balance){
        accountNumber = n;
        accountBalance = balance;
    }
    
    public int getAccounctNumber(){
        return accountNumber;
    }
    
    public double getAccountBalance(){
        return accountBalance;
    }
    
    public void setAccountBalance(double balance){
        accountBalance = balance;
    }
    
    

    
}
