package Exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * Lab 12 - Programming using Java I/O Streams
 * Exercise 5: Processing Daily Rainfall Data A Station
 * 
 * Task D
 * 
 * This programme generates data for 6 days of daily rainfall readings
 * from Simpang Ampat station in Alor Gajah district * and writes these 
 * data into a specific output file named "rainFall.txt"
 * 
 * @author Aina Khaliesa binti Moslee (B032120017)
 * 
 */
public class rainFallReader {
	
	public static void main(String[] args) {

		// 1. Declare output file 
		String outputFile = "rainfall.txt";
		
		// Display the sentence for reading data
		System.out.println("Reading data from " + outputFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(outputFile));
			
			// 3. Read values from the stream
			// variables to handle data read from the source file
			
			// receive daily rainfall reading
			double dailyRainfall = 0;
			
			// variables to count number of daily reading in the source file
			int dailyRecords = 0;
			
			// variable to calculate total daily rainfall
			double totalRainfall = 0.0;
			
			// Read values from the stream
			dailyRainfall = dataInputStream.read();
			
			System.out.println("The 6 days readings of daily rainfall from station Simpang Ampat in Alor Gajah district: ");
			
			// -1: read until end of file/stream
			while (dailyRainfall != -1) {
				
				// Display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				// Calculate total daily rainfall
				totalRainfall = totalRainfall + dailyRainfall;
				
				// Auto update current number of records read from the source file
				dailyRecords ++;
				
				// Read next value for the daily rainfall reading
				dailyRainfall = dataInputStream.read();
	
			} 
			
			// List of total number of records for the daily rainffall readings from the source file
			System.out.println("\nTotal Records: " + dailyRecords);
			
			// List of total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			// Average daily rainfall
			double averageRainfall = totalRainfall / Double.valueOf(dailyRecords);
			
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + dailyRecords					+ " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
			
			
			// 4. Close stream
			dataInputStream.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// End of program
		System.out.println("\nEnd of program.");
		

	}
}