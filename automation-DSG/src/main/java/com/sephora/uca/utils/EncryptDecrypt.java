/*
 * This is an utility file which does Encryption and Decryption using Base64
 */
package com.sephora.uca.utils;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

/**
 * The Class EncryptDecrypt.
 */
public class EncryptDecrypt {

	/**
	 * Encrypt the given string.
	 * @param decoded the decoded string
	 * @return the encrypted string
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static String encrypt(String decoded) throws UnsupportedEncodingException {
		//return Base64.getEncoder().encodeToString( decoded.trim().getBytes("UTF8") );
		String encoded = Base64.encodeBase64String(decoded.getBytes());
		return encoded;  
	}

	/**
	 * Decrypt the given string.
	 * @param encoded the encoded string
	 * @return the decrypted string
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static String decrypt(String encoded) throws UnsupportedEncodingException {
		return new String(Base64.decodeBase64( encoded.trim() ), "UTF8");
	}

}
