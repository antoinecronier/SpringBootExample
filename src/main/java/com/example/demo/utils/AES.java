package com.example.demo.utils;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static final String KEY_ALGORITHM = "SunJCE";
	private static final String SECRET_KEY_ALGORITHM = "AES";
	private static final String ALGORITHM = "AES/CBC/NoPadding";
	private static final String IV = "AAAAAAAAAAAAAAAA";
	private static final String ENCODING = "UTF-8";

	public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
		plainText = completData16Mult(plainText);
		Cipher cipher = Cipher.getInstance(ALGORITHM, KEY_ALGORITHM);
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(ENCODING), SECRET_KEY_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes(ENCODING)));
		return cipher.doFinal(plainText.getBytes(ENCODING));
	}

	public static String decrypt(String cipherText, String encryptionKey) throws Exception {
		cipherText = completData16Mult(cipherText);
		Cipher cipher = Cipher.getInstance(ALGORITHM, KEY_ALGORITHM);
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(ENCODING), SECRET_KEY_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes(ENCODING)));
		return new String(cipher.doFinal(cipherText.getBytes()), ENCODING);
	}

	private static String completData16Mult(String plainText) {
		// Check encoded sizes
		try {
			while (plainText.getBytes(ENCODING).length % 16 != 0) {
				plainText += "a";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return plainText;
	}
}
