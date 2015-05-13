
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Transaction extends Thread {

	private static final AtomicInteger count = new AtomicInteger(0);
	protected int transactionID;

	public Transaction(){
		transactionID = count.incrementAndGet();;
	}

	public abstract void makeTransaction();  
    
}
