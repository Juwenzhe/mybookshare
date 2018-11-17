package com.hebut.bookshare.utils;

import java.util.Date;

public class GetYesterday {

	public static Date getYesterday(Date date){
		
		long ms1 = date.getTime()-1000*60*60*24;//获取毫秒
		return new Date(ms1);
	}
	
//	public static void main(String[] args) {
//		Date date = new Date();
//		for (int i = 0; i < 15; i++) {
//			date = GetYesterday.getYesterday(date);
//			System.out.println(date);
//		}
//	}
}
