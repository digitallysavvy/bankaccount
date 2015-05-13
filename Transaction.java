
public abstract class Transaction {

	protected int transactionID;

	public Transaction(int tNumber){
		transactionID = tNumber;
	}

	public abstract void makeTransaction();  
    
}
