import java.util.ArrayList;

public class CalculateRunTimes {

	ArrayList<Long> transactionRunTimes = new ArrayList<Long>();

	public CalculateRunTimes(ArrayList<Long> tRunTimes){

		transactionRunTimes = tRunTimes;

	}

	public long calcAvg(){

		long totalRunTimes = 0;

		for(long rt: transactionRunTimes){
            		totalRunTimes += rt;
        	}

        	return totalRunTimes / transactionRunTimes.size();

	}


	public double calcStdDev(){

		long runAvg = calcAvg();
		double vTemp = 0;

		for(long rt: transactionRunTimes){
            		vTemp += (runAvg - rt) * (runAvg - rt);
        	}

        	double variance = vTemp/transactionRunTimes.size();

        	return Math.sqrt(variance);

	}


}
