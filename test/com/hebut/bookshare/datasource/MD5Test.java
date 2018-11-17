package com.hebut.bookshare.datasource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {

	public static void main(String[] args) {
		String password = "juwenzhe";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(password.getBytes());
			byte[] newbytes = md.digest();
			for (int i = 0; i < newbytes.length; i++) {
				System.out.println(newbytes[i]);
			}
			
			String newStr = new String(newbytes);
			System.out.println(newStr);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
