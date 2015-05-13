
public class AccountNumberInquiry extends Transaction{
    
    private Account account;

    public AccountNumberInquiry(int tNum, Account a) {
        super(tNum);
        account = a;
    }
    
    public void makeTransaction(){
         System.out.println("The Account Number of is account is " + account.getAccountNumber());
    }


    
}
