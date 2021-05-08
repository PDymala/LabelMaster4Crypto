package crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class createPrintableFileDb {

	public createPrintableFileDb(int from, int to) {
		
	
		try (PrintWriter writer = new PrintWriter(new File("ML4-DatabaseToBePrinted.csv"))) {

		StringBuilder sb = new StringBuilder();
		
		for (int x = from; x < from+(to-from); x++) {
			

			String str = String.format("%" + 9 + "s", x);
			str = str.replace(' ', '0');
			Hash hash = new Hash(); // MD5, UTF-8, 32 symbols

			String hashedString = hash.getHash(str, 32);

			for (int y = 0; y < 9; y++) {

				sb.append(str.charAt(y));
				sb.append('-');

			}
		
			for (int y = 0; y < 32; y++) {

				
				if (y == 31) {
					sb.append((int) hashedString.charAt(y));
				} else {
					sb.append((int) hashedString.charAt(y));
					sb.append('-');
				}
				
				
				

			}

			sb.append('\n');

			
			
		
		
		}
		
		
		
			
		writer.write(sb.toString());
		} catch (FileNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}}
