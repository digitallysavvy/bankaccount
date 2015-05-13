
public class AccountNumberInquiry extends Transaction{
    
    private Account account;

    public AccountNumberInquiry(Account a) {
        super();
        account = a;
    }

    public void run(){
    	System.out.println("--Fetching the account number.");
    	makeTransaction();
    }
    
    public void makeTransaction(){
         System.out.println("This is Account#" + account.getAccountNumber());
    }


    
}
