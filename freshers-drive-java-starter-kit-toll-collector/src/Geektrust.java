import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.fastag.dto.TollCollectionSummary;
import com.fastag.service.CollectTollService;
import com.fastag.service.FastagService;
import com.fastag.service.PrintCollectionService;

//Main class of this toll collection system
public class Geektrust {
	
	//It will take input and base on the command like "FASTAG", "COLLECT_TOLL" OR "PRINT_COLLECTION" 
	//call the service class and return the answer in the form of string
	public static String inputType(String[] input, TollCollectionSummary tollCollectionSummary) {
		
		String ans = "";
		
		switch(input[0]) {
	        case "FASTAG" : {
	     	   String vehicle_number = input[1];
	     	   Integer fastag_balance = Integer.parseInt(input[2]);
	     	   FastagService fastagService = new FastagService();
	     	   fastagService.addVehicle(vehicle_number, fastag_balance, tollCollectionSummary);
	        }
	        break;
	        case "COLLECT_TOLL" : {
	        	String vehicle_type = input[1];
	        	String vehicle_number = input[2];
	        	CollectTollService collectTollService = new CollectTollService();
	        	collectTollService.addVehicle(vehicle_type, vehicle_number, tollCollectionSummary);
	        }
	        break;
	        case "PRINT_COLLECTION" : {
	     	   PrintCollectionService printCollectionService = new PrintCollectionService();
	     	   ans = printCollectionService.print(tollCollectionSummary);
	        }
	    }
		
		return ans;
	}
	
    public static void main(String[] args)  {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
        	
            Scanner sc = new Scanner(fis); // file to be scanned
            
            TollCollectionSummary tollCollectionSummary = new TollCollectionSummary();
            
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               String inputCommand = sc.nextLine();
               //Add your code here to process input commands.
               
               String[] arr = inputCommand.trim().split(" ");
               
               String output = inputType(arr, tollCollectionSummary);; //process the input command and get the output
               
               
               //Once it is processed print the output using the command System.out.println()
               if (!output.equals("")) System.out.println(output);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
	}
}
