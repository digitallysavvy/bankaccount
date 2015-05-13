
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class GenerateTransactions {

	private String accountsFile;
	private String transactionsFile;
	private int numAccounts = 10;
	private int numTransactions = 100000;
	double maxBDWs = numTransactions * .8997;
	double maxTransfers = numTransactions * .1;
	double maxBatches = numTransactions * .0003;
	int numBDWs = 0;
	int numBatches = 0;
	int numTransfers = 0;
	Random randNum = new Random(); //random number generation


	public GenerateTransactions(String aFile, String tFile){

		accountsFile = aFile;
		transactionsFile = tFile;

	}


	public void addAccounts() throws IOException {

		FileOutputStream outputStream = new FileOutputStream(accountsFile);
		
		//open the file and write to it
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))){

			double randBalance = 0.0;

			for(int i = 1; i <= numAccounts; i++){
				
				/*
				randBalance = randNum.nextDouble() * 100 + 100; //random balance to initialize account
				String balanceAmount = String.format("%.2f", randBalance);

				String account = i + ", " + balanceAmount;
				*/
				
				String account = i + ", 1000.00";

				//write the transaction string to the file
				writer.write(account);
				if(i != numAccounts){
					writer.newLine();
				}

			}

			//close the file
			writer.close();
		}

	}



	public void addTransactions() throws IOException {
		
		FileOutputStream outputStream = new FileOutputStream(transactionsFile);
		
		//open the file and write to it
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))){

			double randTransactionAmount = 0.0;
			
			for(int i=1; i <= numTransactions; i++){
				
				randTransactionAmount = randNum.nextDouble() * 10 + 20 + randNum.nextInt(171); //random ammount to be used in transaction
				int randomTransactionType = randNum.nextInt(5); //randomly select a transaction

				int accountNumber = randNum.nextInt(numAccounts);
				accountNumber ++;
				String transactionAmount = String.format("%.2f", randTransactionAmount);
				
				String transaction = "";

				if(numBatches >= maxBatches && randomTransactionType == 0){
					randomTransactionType = randNum.nextInt(5) + 1;
				}

				if(numTransfers >= maxTransfers && randomTransactionType == 1){
					randomTransactionType = randNum.nextInt(5) + 2;
				}

				if(numBDWs >= maxBDWs && randomTransactionType > 1){
					randomTransactionType = randNum.nextInt(2);
				}


				switch(randomTransactionType){
					
					case 0:
						transaction = "Batch";
						numBatches++;
						break;

					case 1:
						transaction = "Transfer, " + accountNumber + ", " + (randNum.nextInt(10) + 1) + ", "+ transactionAmount;
						numTransfers++;
						break;

					case 2:
						transaction = "Deposit, " + accountNumber + ", " + transactionAmount;
						numBDWs++;
						break;
					
					case 3:
						transaction = "Withdrawal, " + accountNumber + ", " + transactionAmount;
						numBDWs++;
						break;

					default:
						transaction = "BalanceInquiry, " + accountNumber;
						numBDWs++;
						break;

				}

				//write the transaction string to the file
				writer.write(transaction);
				if(i != numTransactions){
					writer.newLine();
				}
			}
			//close the file
			writer.close();
		}

	}
	
}