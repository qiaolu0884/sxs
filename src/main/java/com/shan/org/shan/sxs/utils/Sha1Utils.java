package com.shan.org.shan.sxs.utils;

import static org.junit.Assert.*;

import java.security.MessageDigest;

import org.junit.Test;

public class Sha1Utils {

	public static final String SECRET_KEY = "dfgc@123qwe!#$%";

    /**
     * @description sha1加密
     * 
     * @param data json数据
     * @param randomStr 随机数（32位及一下）
     *
     * @author GaoMing
     * @time 2017年5月25日 下午11:12:45
     */
    public static String encrypt(String data, String randomStr) {
        String sign = data + randomStr + SECRET_KEY;
        try {  
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");  
            messageDigest.update(sign.getBytes());  
            //获取字节数组  
            byte bytes[] = messageDigest.digest();  
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();  
            // 字节数组转换为 十六进制 数  
            for (int i = 0; i < bytes.length; i++) {  
                String shaHex = Integer.toHexString(bytes[i] & 0xFF);  
                if (shaHex.length() < 2) {  
                    hexString.append(0);  
                }  
                hexString.append(shaHex);  
            }  
            return hexString.toString();
        } catch (Exception e) {  
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }  
    } 
    
    /**
     * @description 验证
     *
     * @param sign 加密数据
     * 
     * @author GaoMing
     * @time 2017年5月25日 下午11:25:33
     */
    public static boolean verifica(String sign, String data, String randomStr){
    	String encrypt = "";
    	try {
    		encrypt = encrypt(data, randomStr);
    		encrypt.equals(sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return encrypt.equals(sign);
    }
    
  /*  @Test
	public void testName() throws Exception {
		String data = "shanxinshu";
		String randomStr = "12398745";
		String encrypt = encrypt(data, randomStr);
		System.out.println("加密后：" + encrypt);
		System.out.println(verifica(encrypt, data, randomStr));
	}*/
}
