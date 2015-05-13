
public class BalanceInquiry extends Transaction {
    
    private Account account;

    public BalanceInquiry(int tNum, Account a) {
        super(tNum);
        account = a;
    }
    
    public void makeTransaction(){
        System.out.println("Balanace of Account#" + account.getAccountNumber() + " is $" + account.getBalance());
    }
    
}
