package Exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/*
 * Lab 12 - Programming using Java I/O Streams
 * Exercise 5: Processing Daily Rainfall Data A Station
 * 
 * Task B
 * 
 * This programme generates data for 6 days of daily rainfall readings
 * from Simpang Ampat station in Alor Gajah district * and writes these 
 * data into a specific output file named "rainFall.txt"
 * 
 * @author Aina Khaliesa binti Moslee (B032120017)
 * 
 */
public class rainFallGenerator {

	public static void main (String [] args)
	{
		// 1. Declare output file
		String outputFile = "rainfall.txt";
		
		try
		{
			// 2. Create an output stream between this program and the output file, outFile
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outputFile));
			
			// 3. Enter the 6 days of daily rainfall readings (from 31 May 2023 to 5 June 2023) 
			// from station Simpang Ampat in the Alor Gajah district into the output file.		
			
			dataOutputStream.write(1);
			dataOutputStream.write(0);
			dataOutputStream.write(6);
			dataOutputStream.write(19);
			dataOutputStream.write(1);
			dataOutputStream.write(0);
			
			// 4. Clear the stream
			dataOutputStream.flush();
			
			// 5. Close the stream
			dataOutputStream.close(); 
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		// End of program
		System.out.println("End of program. Check out " + outputFile); 
	}
}