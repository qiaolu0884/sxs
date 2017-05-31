package com.shan.org.shan.sxs.port;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

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

import com.shan.org.shan.sxs.utils.BatchDateUtil;
import com.shan.org.shan.sxs.utils.PortUtils;

public class ShannengliangPort {
	
	public static String shannengliang(String user_id) {
		String urlNameString = "http://106.14.77.191:8666/app/index/index";
		String body = null;
		String p = "";
		String a = "shanxinshu.shannengliang";
		String b = "test#123";
		String k = "app_shanxinshu";
		String s = "";
		String v = "1";
		String f = "0232032147387443";
		String t = BatchDateUtil.getBatch(new Date()).toString();
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			List<NameValuePair> params = new ArrayList<>();  
			// 创建post方式请求对象
			HttpPost httpPost = new HttpPost(urlNameString);
		    params.add(new BasicNameValuePair("a", a));
		    params.add(new BasicNameValuePair("b", b));
		    params.add(new BasicNameValuePair("k", k));
		    params.add(new BasicNameValuePair("s", s));
		    params.add(new BasicNameValuePair("v", v));
		    params.add(new BasicNameValuePair("f", f));
		    params.add(new BasicNameValuePair("t", t));
		    params.add(new BasicNameValuePair("user_id", user_id));
		    
		    SortedMap map = new TreeMap<>();
		    map.put("a", a);
		    map.put("b", b);
		    map.put("k", k);
		    map.put("s", s);
		    map.put("v", v);
		    map.put("f", f);
		    map.put("t", t);
		    map.put("user_id", user_id);
		     p = PortUtils.getSign(map);
		    params.add(new BasicNameValuePair("p", p));
			//转换参数并设置编码格式  
		    httpPost.setEntity(new UrlEncodedFormEntity(params,Consts.UTF_8));  
		    // 获取当前客户端对象
		    // HttpClient httpClient = new HttpClient();
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
		
		return body;
	}

}
