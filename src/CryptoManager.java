//Assignment has been revised as per Prof. Grinberg's instructions
/* Class: CMSC203 CRN 22297
 *Program: Assignment 3
 *Instructor: Grigoriy Grinberg
 *Summary of Description: Write a Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
  The first approach is called the Caesar Cipher and is a simple “substitution cipher” where characters in a message are replaced by a substitute character.
  The second approach, due to Giovan Battista Bellaso (b 1505, d 1581), uses a key word, where each character in the word specifies the offset for the corresponding
  character in the message, with the key word wrapping around as needed.  
 *Due Date: 04OCT2021
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 *Student: Daniel Cortes Gratacos
*/

public class CryptoManager 
{
	
	private static final char UPPER_BOUND = '_';
	private static final char LOWER_BOUND = ' ';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

/**

* This method determines if a string is within the allowable bounds of ASCII codes

* according to the LOWER_BOUND and UPPER_BOUND characters

* @param plainText a string to be encrypted, if it is within the allowable bounds

* @return true if all characters are within the allowable bounds, false if any character is outside

*/

	public static boolean stringInBounds (String plainText) 
	{
	

// throw new RuntimeException("method not implemented");

		for (int index = 0; plainText.length() > index ; index++)

		{
	
			if (LOWER_BOUND > plainText.charAt(index) || UPPER_BOUND < plainText.charAt(index)) 
			{
			
				return false;
			
			}
		
		}

		return true;

	}

/**

* Encrypts a string according to the Caesar Cipher. The integer key specifies an offset

* and each character in plainText is replaced by the character \"offset\" away from it

* @param plainText an uppercase string to be encrypted.

* @param key an integer that specifies the offset of each character

* @return the encrypted string

*/

	public static String encryptCaesar(String plainText, int key)

	{

//throw new RuntimeException("method not implemented");

		String encryptedText = "";

		if (stringInBounds(plainText))

		{

			for (int index=0; plainText.length() > index; index++)

			{

				char thisChar = plainText.charAt(index);

				int encryptedCharint = ((int)thisChar+key);

				while (UPPER_BOUND < encryptedCharint)

				{

					encryptedCharint -= RANGE;

				}

				encryptedText += (char)encryptedCharint;

			}

		}

		return encryptedText;

	}

/**

* Encrypts a string according the Bellaso Cipher. Each character in plainText is offset

* according to the ASCII value of the corresponding character in bellasoStr, which is repeated

* to correspond to the length of plainText

* @param plainText an uppercase string to be encrypted.

* @param bellasoStr an uppercase string that specifies the offsets, character by character.

* @return the encrypted string

*/

	public static String encryptBellaso(String plainText, String bellasoStr)

	{

//throw new RuntimeException("method not implemented");

		int bellasoStrLength = bellasoStr.length();
		
		String encryptedText = "";

		for (int index = 0; plainText.length() > index; index++)

		{

			char thisChar = plainText.charAt(index);

			int encryptedCharint = ((int)thisChar+(int)bellasoStr.charAt(index%bellasoStrLength));

			while ((int)UPPER_BOUND < encryptedCharint)

			{

				encryptedCharint -= RANGE;

			}

			encryptedText += (char)encryptedCharint;

		}

		return encryptedText;

	}

/**

* Decrypts a string according to the Caesar Cipher. The integer key specifies an offset

* and each character in encryptedText is replaced by the character \"offset\" characters before it.

* This is the inverse of the encryptCaesar method.

* @param encryptedText an encrypted string to be decrypted.

* @param key an integer that specifies the offset of each character

* @return the plain text string

*/

	public static String decryptCaesar(String encryptedText, int key)

	{

//throw new RuntimeException("method not implemented");

		String decryptedText = "";

		for (int index =0; encryptedText.length() > index; index++)

		{

			char thisChar = encryptedText.charAt(index);

			int decryptedCharint = ((int)thisChar-key);

			while (LOWER_BOUND > decryptedCharint)

			{

				decryptedCharint += RANGE;

			}

			decryptedText += (char)decryptedCharint;

		}

		return decryptedText;

	}

/**

* Decrypts a string according the Bellaso Cipher. Each character in encryptedText is replaced by

* the character corresponding to the character in bellasoStr, which is repeated

* to correspond to the length of plainText. This is the inverse of the encryptBellaso method.

* @param encryptedText an uppercase string to be encrypted.

* @param bellasoStr an uppercase string that specifies the offsets, character by character.

* @return the decrypted string

*/

	public static String decryptBellaso(String encryptedText, String bellasoStr)

	{

// throw new RuntimeException("method not implemented");

		int bellasoStrLength = bellasoStr.length();
		
		String decryptedText = "";

		for (int index = 0; encryptedText.length() > index; index ++)

		{

			char thisChar = encryptedText.charAt(index);

			int decryptedCharint = ((int)thisChar-(int)bellasoStr.charAt(index%bellasoStrLength));

			while ((int)LOWER_BOUND > decryptedCharint)

			{

				decryptedCharint += RANGE;

			}

			decryptedText += (char)decryptedCharint;

		}

		return decryptedText;

	}

}