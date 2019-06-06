package com.example.demo.util;

import java.security.MessageDigest;

public class PasswordEncrypt {

	public static String ecryptMD5(String param) {
		String encryptParam = "";
		byte[] byteparam = new byte[param.length()];
		for (int i = 0; i < param.length(); i++) {
			byteparam[i] = (byte) (param.charAt(i) & 255);
		}
		try {
			MessageDigest md5pw = MessageDigest.getInstance("MD5");
			byte[] rethash = md5pw.digest(byteparam);
			StringBuffer sb = new StringBuffer(32);
			for (int i = 0; i < rethash.length; i++) {
				encryptParam = Integer.toHexString(rethash[i] & 255).toUpperCase();
				if(encryptParam.length() < 2) {
					sb.append("0");
					sb.append(encryptParam);
					continue;
				}
				sb.append(encryptParam);
			}
			encryptParam = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptParam;
	}
}
