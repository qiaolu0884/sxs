package com.shan.org.shan.sxs.utils;

public class ConvertNum {

	public static String getTel(Long tel){
		if(tel != null){
			String telphone = tel.toString();
			String te = telphone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
			return te;
		}
		return null;
	}
	
	public static String getCardNo(Long cardNo){
		if(cardNo != null){
			String c = cardNo.toString();
			int t = c.length()-4;
			c = c.substring(t,c.length());
			String e = "";
			for (int i=0; i < t ;i++) {
				e = e + "*";
			}
			return e+c;
		}
		return null;
	}
}
