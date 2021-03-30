package pakages;



public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		for(int i = 0; i < plainText.length();i++) {
			if(Character.isUpperCase(plainText.charAt(i))) {
				if (plainText.charAt(i) > UPPER_BOUND) return false;
				if (plainText.charAt(i) < LOWER_BOUND) return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		 String encrypt = "";
	        for(int i = 0;i < plainText.length();i++) {
	            if(((int)plainText.charAt(i) + key%64)%64 < 32)
	                encrypt += (char)(64 + ((int)plainText.charAt(i) + key%64)%64);
	            else encrypt += (char)(((int)plainText.charAt(i) + key%64)%64);
	        }
	        return encrypt;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encrypt = "";
		for(int i = 0; i < plainText.length(); i++)
        {
            if((int)(plainText.charAt(i) + bellasoStr.charAt(i%bellasoStr.length())) - RANGE > UPPER_BOUND)
                encrypt += (char) ( ((int)(plainText.charAt(i) + bellasoStr.charAt(i%bellasoStr.length())) - RANGE)%RANGE );
            else if ((int)(plainText.charAt(i) + bellasoStr.charAt(i%bellasoStr.length())) - RANGE < LOWER_BOUND)
                encrypt += (char) ( (int)(plainText.charAt(i) + bellasoStr.charAt(i%bellasoStr.length())) );
            else encrypt += (char) ( (int)(plainText.charAt(i) + bellasoStr.charAt(i%bellasoStr.length())) - RANGE);
        }
		return encrypt;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decrypt = "";
	       
        for(int i = 0;i < encryptedText.length();i++){
            if (((int)encryptedText.charAt(i) - key%64)%64 < 32)
                decrypt += (char)(64 + ((int)encryptedText.charAt(i) - key%64)%64);
            else decrypt += (char)(((int)encryptedText.charAt(i) - key%64)%64);
        }
        return decrypt;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decrypt = "";
		for(int i = 0;i < encryptedText.length();i++)
        {

            if((int)(encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length())) + RANGE < LOWER_BOUND)
                decrypt +=  (char)( (int)(encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length())) + 2*RANGE );
            else if((int)(encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length())) + RANGE > UPPER_BOUND)
                decrypt +=  (char)( (int)(encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length())) );
            else decrypt +=  (char)( (int)(encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length())) + RANGE );
        }  
		return decrypt;
	}
}