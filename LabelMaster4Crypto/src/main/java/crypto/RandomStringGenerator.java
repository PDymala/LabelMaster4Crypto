package crypto;


import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {
	public RandomStringGenerator() {
		
	}
	public String getRandomStringOnlyUpperCase (int length) {

	 
	
	    final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
	  
	    //Use cryptographically secure random number generator
	    Random random = new SecureRandom();

	    StringBuilder password = new StringBuilder(); 

	  
	    //Ensure password policy is met by inserting required random chars in random positions
	 
	    
	    
	    for (int i = 0; i < length; i++) {
	        password.append(uppercase[random.nextInt(uppercase.length)]);
	    }
	    
	    
	    
	    
	    
	    
	    
	   // password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
	
	    

	    return password.toString();

	    }
	
	public String getRandomStringOnlyUpperCaseAtoL (int length) {

		 
		
	    final char[] uppercase = "ABCDEFGJKL".toCharArray();
	  
	    //Use cryptographically secure random number generator
	    Random random = new SecureRandom();

	    StringBuilder password = new StringBuilder(); 

	  
	    //Ensure password policy is met by inserting required random chars in random positions
	 
	    
	    
	    for (int i = 0; i < length; i++) {
	        password.append(uppercase[random.nextInt(uppercase.length)]);
	    }
	    
	    
	    
	    
	    
	    
	    
	   // password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
	
	    

	    return password.toString();

	    }
	public String getRandomString (int length) {

		 
//	    final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//	    final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
//	    final char[] numbers = "0123456789".toCharArray();
//	    final char[] symbols = "^$?!@#%&".toCharArray();
	    final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789^$?!@#%&".toCharArray();

	    //Use cryptographically secure random number generator
	    Random random = new SecureRandom();

	    StringBuilder password = new StringBuilder(); 

	    for (int i = 0; i < length; i++) {
	        password.append(allAllowed[random.nextInt(allAllowed.length)]);
	    }
	    

	    return password.toString();

	    }
}
