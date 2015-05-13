
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Transaction extends Thread {

	private static final AtomicInteger count = new AtomicInteger(0);
	protected int transactionID;
	protected long transactionStartTime = 0;
	protected long transactionEndTime = 0;

	public Transaction(){
		transactionID = count.incrementAndGet();
	}

	public abstract void makeTransaction(); 

	public long getRunTime(){
		return transactionEndTime - transactionStartTime;
	}
    
}
