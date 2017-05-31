package com.shan.org.shan.sxs.utils;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.apache.commons.codec.digest.DigestUtils;

public class PortUtils {

	public static String getSign(SortedMap<String, String> signParams) throws Exception {
		StringBuffer sb = new StringBuffer();
		Set es = signParams.entrySet();
		Iterator it = es.iterator();
		String random="";
		while (it.hasNext()) {			
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey().toString().toLowerCase();
			String v = (String) entry.getValue().toString().toLowerCase();
			//获取f参数,为32位一下的小写字母和数字的组成
			if(k=="f"){
				random=v;
			}
			sb.append(URLEncoder.encode(k) + "=" + URLEncoder.encode(v) + "&");
		}
		String p = sb.substring(0, sb.lastIndexOf("&"));
		return DigestUtils.md5Hex("%$#!ewq321@cgfd"+p+random);
	}
}
