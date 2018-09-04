package com.example.demo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.demo.utils.AES;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {

	private static final String KEY = "MySuperSecretKey";

	public String convertToDatabaseColumn(String ccNumber) {
		try {
			return AES.encrypt(ccNumber, KEY).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String convertToEntityAttribute(String dbData) {
		return dbData;
//		try {
//			return AES.decrypt(dbData, KEY);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}
}