import java.util.Random;

public class Batch extends Transaction {

	Random randNum = new Random(); //random number generation


	public Batch() {
		super();
	}


	public void run(){
		transactionStartTime = System.nanoTime();
		makeTransaction();
	}


	public void makeTransaction(){
		
		long startTime = System.currentTimeMillis();
		boolean exit = false;
		int randAmountOfTime = randNum.nextInt(30) + 30;

		/*
		System.out.println("Batch Transaction");
		*/
		
		while(!exit){

			if((startTime - System.currentTimeMillis())/1000 < randAmountOfTime){
				exit = true;
			}

		}

		transactionEndTime = System.nanoTime();
	}


}