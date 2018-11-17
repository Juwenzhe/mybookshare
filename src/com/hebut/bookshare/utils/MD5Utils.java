package com.hebut.bookshare.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	public static String toMD5String(String str) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			return new String(md.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			return str;
		}
	}
}
