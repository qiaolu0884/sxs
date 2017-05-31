package com.shan.org.shan.sxs.port;


import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Cipher;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.assertj.core.util.Lists;

import com.shan.org.shan.sxs.utils.Base64;
import com.shan.org.shan.sxs.utils.BatchDateUtil;
import com.shan.org.shan.sxs.utils.PortUtils;

public class LoginPort {

	public static String login(String username) {
		String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvLSDII/m0La8yRolTzMZyoXRQ4CHgEZOhzpsfnWBlzF5eDXHiHlCQ8GgdJ6AMb0STFUQYU08XglexyZh0IlUSpCbQJ7IFb7SRk7JoKSDw6gKb/xxOiHx2bcfpLHjLRcNcWiLeV6bevoQlD/eLRmbybhlLeDtKLfpizQsftAjXaQIDAQAB";
		String key = "";
		try {
			byte[] encryptByPublicKey = encryptByPublicKey(username.getBytes("utf-8"), pubkey);
			key = Base64.encode(encryptByPublicKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String urlNameString = "http://106.14.77.191:8666/app/index/index";
		String body = null;
		String p = "";
		String a = "shanxinshu.login";
		String b = "test#123";
		String k = "app_shanxinshu";
		String s = "";
		String v = "1";
		String f = "sfafdsfdasdsadsa";
		String t = BatchDateUtil.getBatch(new Date()).toString();
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			List<NameValuePair> params = new ArrayList();  
			// 创建post方式请求对象
			HttpPost httpPost = new HttpPost(urlNameString);
		    params.add(new BasicNameValuePair("a", a));
		    params.add(new BasicNameValuePair("b", b));
		    params.add(new BasicNameValuePair("k", k));
		    params.add(new BasicNameValuePair("s", s));
		    params.add(new BasicNameValuePair("v", v));
		    params.add(new BasicNameValuePair("f", f));
		    params.add(new BasicNameValuePair("t", t));
		    params.add(new BasicNameValuePair("key", key));
		    
		    SortedMap map = new TreeMap<>();
		    map.put("a", a);
		    map.put("b", b);
		    map.put("k", k);
		    map.put("s", s);
		    map.put("v", v);
		    map.put("f", f);
		    map.put("t", t);
		    map.put("key", key);
		     p = PortUtils.getSign(map);
		    params.add(new BasicNameValuePair("p", p));
			//转换参数并设置编码格式  
		    httpPost.setEntity(new UrlEncodedFormEntity(params,Consts.UTF_8));  
		    // 获取当前客户端对象
		    CloseableHttpResponse response = client.execute(httpPost);
		    HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity);
			}
			EntityUtils.consume(entity);
			// 释放链接
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(body);
		
		return body;
	}

	public static byte[] encryptByPublicKey(byte[] data, String publicKey)  
            throws Exception {  
        byte[] keyBytes = Base64.decode(publicKey);  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
        Key publicK = keyFactory.generatePublic(x509KeySpec);  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, publicK);  
        int inputLen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > 117) {  
                cache = cipher.doFinal(data, offSet, 117);  
            } else {  
                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * 117;  
        }  
        byte[] encryptedData = out.toByteArray();  
        out.close();  
        return encryptedData;  
    }  
}
