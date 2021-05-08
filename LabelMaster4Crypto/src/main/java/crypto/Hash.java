package crypto;



import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public Hash(){

    }

    public String getHash(String text, int lenght) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        // Creating the MessageDigest object
        MessageDigest md = MessageDigest.getInstance("MD5");
//CHARACTER SET ascii
        // Passing data to the created MessageDigest Object
        md.update(text.getBytes(StandardCharsets.UTF_8));

        // Compute the message digest
        byte[] digest = md.digest();

        // Converting the byte array in to HexString format
	/*	StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < digest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
		}
*/

        String hex = String.format("%032x", new BigInteger(1, digest));

        //return hexString.toString();
        return hex.substring(32-lenght);
    }}