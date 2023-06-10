package Exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This program enables Processing Daily Rainfall Data from Selected Station using Byte-Based Stream
 * The data is read in byte-based using DataInputStream class. 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * @author Aina Khaliesa binti Moslee (B032120017)
 *
 */
public class rainFallByteReader {

	public static void main(String[] args) {

		// 1. Declare source file 
		String outputFile = "rainfallByte.txt";
		System.out.println("Reading data from " + outputFile + "\n");
		
		try {

			// 2. Create input stream to read data
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(outputFile));

			int id = 0;
			
			// Station Name and District
			String station = " ", district = " ";
			
			// Daily rainfall readings from 1 June 2023 to 6 June 2023
			double value1 = 0.0, value2 = 0.0, value3 = 0.0;
			double value4 = 0.0, value5 = 0.0, value6 = 0.0;
			
			// Variable declaration for calculation
			// List of Total number of records read from the source file
			int noOfRecords = 0;
			
			// List of Total daily rainfall readings for each station
			double sum = 0.0;
			
			ArrayList <Double> totalRainfall = new ArrayList<Double>();
			
		
			ArrayList<String> stations = new ArrayList<String>();
						
			// HashSet to store distinct district for calculation purpose
			HashSet<String> districtCount = new HashSet<String>();
			
			
			// 3. Process data until end-of-file
			while(dataInputStream.available() > 0) {
				
				// Read data
				
				// station id
				id = dataInputStream.readInt();
				
				// station name
				station = dataInputStream.readUTF();
				
				// district
				district = dataInputStream.readUTF();
				
				// daily rainfall readings for 4 June 2023
				value1 = dataInputStream.readDouble();
				
				// daily rainfall readings for 5 June 2023
				value2 = dataInputStream.readDouble();
				
				// daily rainfall readings for 6 June 2023
				value3 = dataInputStream.readDouble();
				
				// daily rainfall readings for 7 June 2023
				value4 = dataInputStream.readDouble();
				
				// daily rainfall readings for 8 June 2023
				value5 = dataInputStream.readDouble();
				
				// daily rainfall readings for 9 June 2023
				value6 = dataInputStream.readDouble();
				
				System.out.println( id + "\t" + station + "\t" + district
						+ "\t" + value1 + "\t" + value2 + "\t" + value3 
						+ "\t" + value4 + "\t" + value5 + "\t" + value6 );
				
				// calculate total daily rainfall readings for each station
				sum = value1 + value2 + value3 + value4 + value5 + value6;
				
				// the sum save into the arraylist, totalRainfall
				totalRainfall.add(sum);
				
				// station names save into the arraylist, stations
				stations.add(station);
				
				// the distinct district save into hashSet, districtCount
				districtCount.add(district);
				
				// Auto update for current number of records
				noOfRecords ++;
			}
			
			System.out.println("\n");
			
			// Calculation for average daily rainfall readings in each station
			for(int index = 0; index < stations.size(); index++)
			{
				// Calculation for average daily rainfall readings in each station
				double average = totalRainfall.get(index) / noOfRecords;
				
				// format the average in one decimal places
				String formattedAverage = String.format("%.1f", average);
				
				// display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall readings in " + stations.get(index) + " : " 
						+ totalRainfall.get(index) );
				System.out.println("The average daily rainfall readings in " + stations.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			
			System.out.println("There are " + stations.size() + " stations and "
						+ districtCount.size() + " districts in Melaka.");
			
			// 4. Close stream
			dataInputStream.close();
	
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// End of program
		System.out.println("\nEnd of program.");
	}
}