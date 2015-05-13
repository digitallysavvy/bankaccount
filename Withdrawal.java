
public class Withdrawal extends Transaction {

    private Account account;
    private double amount;

    public Withdrawal(int tNum, Account a, double amnt) {
        super(tNum);
        account = a;
        amount = amnt;
    }


    public void makeTransaction() {
       
        if(account.getBalance() - amount >= 0){
            account.setBalance(account.getBalance() - amount);
        }
        else{
            System.out.println("Withdrawal of $" + amount +" from Account#" + account.getAccountNumber() + " failed.");
        }
    }

}
