package crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
/**
 * Following application is a part of Label Master 4 package. It's purpose is to create a database (CSV) with values having 3 parameters: standard number, 
 * hashed number and correctness of the pair. Those are grouped into 3 categories: good pair of values, incorrect pair (wrong hash) and incorrect (random value).
 * Those are mixed and put into the file. Next is to change this file from CSV into ARFF (WEKA machine learning file) CscToArff.class.
 * The same CSV file has to be changed into printable group of codes (those to be printed as QR code) and possible to verify by Android app. 
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2021-05-06
 */

public class Mltrainingsetproduction {
 
	public static void main(String[] args) {

		int standardStringLenght = 9; // standard number
		int secureStringLenght = 32;
		int numberOfYesAndNoIterations = 50000;
		int rangeOfRandomNumbers = 1000000000; // must be -1 or less than standard string lenght
		String nameOfTheNewFile = "Trainingset_hash" + "_" + numberOfYesAndNoIterations + "_" + standardStringLenght
				+ "_" + secureStringLenght;

		RandomStringGenerator rsg = new RandomStringGenerator();
		Random random = new Random();

		try (PrintWriter writer = new PrintWriter(new File(nameOfTheNewFile + "mixOfHashes" + ".csv"))) {

			StringBuilder sb = new StringBuilder();

			// creating table labels, each symbol is in separate column
			// standard number
			for (int y = 0; y < standardStringLenght; y++) {

				sb.append("Standard_string" + y);
				sb.append(',');

			}
			// secure number
			for (int y = 0; y < secureStringLenght; y++) {

				sb.append("Secure_string" + y);
				sb.append(',');
			}
			// if it's correct or not
			sb.append("IsCorrect");
			sb.append('\n');

			for (int f = 0; f < numberOfYesAndNoIterations; f++) {

				Random randomCase = new Random();

				switch (randomCase.nextInt(3)) {

				// creating database of correct pairs of number
				case 0: {
					int x = random.nextInt(rangeOfRandomNumbers);
					String str = String.format("%" + standardStringLenght + "s", x);
					str = str.replace(' ', '0');
					Hash hash = new Hash(); // MD5, UTF-8, 32 symbols

					String hashedString = hash.getHash(str, secureStringLenght);

					for (int y = 0; y < standardStringLenght; y++) {

						sb.append(str.charAt(y));
						sb.append(',');

					}
					for (int y = 0; y < secureStringLenght; y++) {

						sb.append((int) hashedString.charAt(y));
						sb.append(',');

					}

					sb.append("YES");
					sb.append('\n');

					break;
				}
				// creating database of real number and hash but not valid pair
				case 1: {

					int x = random.nextInt(rangeOfRandomNumbers);
					int g = random.nextInt(rangeOfRandomNumbers);
					String str = String.format("%" + standardStringLenght + "s", x);
					str = str.replace(' ', '0');
					
					String strG = String.format("%" + standardStringLenght + "s", g);
					strG = strG.replace(' ', '0');
					
					Hash hash = new Hash(); // MD5, UTF-8, 32 symbols

					String hashedString = hash.getHash(str, secureStringLenght);

					for (int y = 0; y < standardStringLenght; y++) {

						sb.append(strG.charAt(y));
						sb.append(',');

					}
					for (int y = 0; y < secureStringLenght; y++) {

						sb.append((int) hashedString.charAt(y));
						sb.append(',');

					}

					sb.append("YES");
					sb.append('\n');

					break;
				}

				// creating database of not correct pairs of numbers
				case 2: {
					int x = random.nextInt(rangeOfRandomNumbers);
					String randomString = rsg.getRandomString(secureStringLenght);

					String str = String.format("%" + standardStringLenght + "s", x);
					str = str.replace(' ', '0');

					for (int y = 0; y < standardStringLenght; y++) {

						sb.append(str.charAt(y));
						sb.append(',');

					}

					for (int y = 0; y < secureStringLenght; y++) {

						sb.append((int) randomString.charAt(y));
						sb.append(',');

					}

					sb.append("NO");
					sb.append('\n');

					break;
				}

				}

			}

			writer.write(sb.toString());
			writer.flush();
			writer.close();

			System.out.println("done!");

		} catch (FileNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
	}
}
