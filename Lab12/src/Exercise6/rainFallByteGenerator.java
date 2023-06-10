package Exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program enables Processing  Daily  Rainfall Data  from Selected Station using Byte-Based Stream
 * The data is written in byte-based using DataOutputStream class. 
 * 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * @author Aina Khaliesa binti Moslee (B032120017)
 *
 */
public class rainFallByteGenerator {
	
	public static void main (String [] args)
	{
		// 1. Declare output file 
		String outputFile = "rainfallByte.txt";
		
		// Data declaration
		// Station id
		int id[] = {2421003, 2322006, 2321006, 2222002, 2324032, 2324033};
		
		// Station name
		String stations[] = {"Simpang Ampat", "Melaka Pindah", "Ladang Lendu", "Durian Tunggal", "Ldg. Sing Lian di Bkt. Senggeh Melaka", "Hospital Jasin"};
		
		// district name
		String district[] = {"Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah", "Jasin", "Jasin"};
		
		// readings on 4 June 2023
		double value1[] = {1.0, 0.0, 0.0, 0.0, 0.0, 14.0};
		
		// readings on 5 June 2023
		double value2[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 6 June 2023
		double value3[] = {6.0, 2.0, 3.0, 37.0, 0.5, 11.0};
		
		// readings on 7 June 2023
		double value4[] = {19.0, 18.5, 4.0, 6.0, 4.5, 15.0};
		
		// readings on 8 June 2023
		double value5[] = {1.0, 2.5, 0.0, 9.0, 0.0, 31.0};
		
		// readings on 9 June 2023
		double value6[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		try {
			
			// 2. Create output stream to read data
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outputFile));
			
			// Process data
			for (int index = 0; index < stations.length; index++) {
				
				// 3. Write data into data stream
				dataOutputStream.writeInt(id[index]);
				dataOutputStream.writeUTF(stations[index]);
				dataOutputStream.writeUTF(district[index]);
				dataOutputStream.writeDouble(value1[index]);
				dataOutputStream.writeDouble(value2[index]);
				dataOutputStream.writeDouble(value3[index]);
				dataOutputStream.writeDouble(value4[index]);
				dataOutputStream.writeDouble(value5[index]);
				dataOutputStream.writeDouble(value6[index]);
				
				// 4. Flush for each writing
				dataOutputStream.flush();
			}
			
			// 5. Close stream
			dataOutputStream.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outputFile); 
	}
}