
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

public class ReadTransactions {

	private String accountsFile;
	private String transactionsFile;
	private final String DELIMETER = ", ";


	public ReadTransactions(String aFile, String tFile){

		accountsFile = aFile;
		transactionsFile = tFile;

	}

	public void loadAccounts(ArrayList<Account> accountList) throws IOException {

        //open the file and read from it
        try(BufferedReader readFile = new BufferedReader(new FileReader(accountsFile))){
        	String line;
        	while ((line = readFile.readLine()) != null) {
        		String[] accountDetails = line.split(DELIMETER);
        		int accountNum = Integer.parseInt(accountDetails[0]);
        		double accountBalance = Double.parseDouble(accountDetails[1]);
        		accountList.add(new Account(accountNum, accountBalance));
        	}

        	//Close CSV File
            readFile.close();
        }

	}

	public void loadTransactions(ArrayList<Transaction> transactions, ArrayList<Account> accounts) throws IOException {
		
		//open the file and read from it
        try(BufferedReader readFile = new BufferedReader(new FileReader(transactionsFile))){
        	String line;
        	while ((line = readFile.readLine()) != null) {
        		String[] accountDetails = line.split(DELIMETER);
        		String transactionType = accountDetails[0];
        		int accountNum = 0;
                double transactionAmount = 0;
        		int transferAccountIndex = 0;
        		if(accountDetails.length > 1){
                    accountNum = Integer.parseInt(accountDetails[1]);

                    if(accountDetails.length > 2){
            			transactionAmount = Double.parseDouble(accountDetails[2]);
            		
            			if(accountDetails.length > 3){
            				int transferAccount = Integer.parseInt(accountDetails[2]);
            				transactionAmount = Double.parseDouble(accountDetails[3]);
            				transferAccountIndex = transferAccount - 1;
            			}
                    }
        		}

        		int accountIndex = accountNum - 1;

        		
        		switch (transactionType){
        			case "Batch":
                        transactions.add(new Batch());
                        break;

                    case "BalanceInquiry":
        				transactions.add(new BalanceInquiry(accounts.get(accountIndex)));
        				break;

        			case "Deposit":
        				transactions.add(new Deposit(accounts.get(accountIndex), transactionAmount));
        				break;

        			case "Withdrawal":
        				transactions.add(new Withdrawal(accounts.get(accountIndex), transactionAmount));
        				break;
        			
        			case "Transfer":
        				transactions.add(new Transfer(accounts.get(accountIndex), accounts.get(transferAccountIndex), transactionAmount));
        				break;
        			
        			default:
        				System.out.println("Error Creating transaction: " + line);	
        		}
        	}

        	//Close CSV File
            readFile.close();
        }
	}
}