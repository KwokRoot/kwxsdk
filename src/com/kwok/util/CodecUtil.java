package com.kwok.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CodecUtil {

	public String sha1(String str){
		
		// JDK方式实现 SHA1签名
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();
			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("SHA1签名错误！");
			e.printStackTrace();
		}
		return null;
	}
	
}
