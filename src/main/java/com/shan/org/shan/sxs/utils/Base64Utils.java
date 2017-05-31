package com.shan.org.shan.sxs.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.sun.org.apache.xml.internal.security.utils.Base64;
/**
 * @description Base64编码解码工具包
 *
 * @author GaoMing
 * @time 2017年5月24日 下午5:52:55
 * @version 1.0.0
 */
@SuppressWarnings("all")
public class Base64Utils {

	/**
	 * 文件读取缓冲区大小
	 */
	private static final int CACHE_SIZE = 1024;
	
	/**
	 * @description base64字符串解码为二进制数据
	 *
	 * @author GaoMing
	 * @time 2017年5月24日 下午6:01:58
	 */
	public static byte[] decode(String base64) throws Exception{
		return Base64.decode(base64);
	}
	
	/**
	 * @description 二进制数据编码为base64字符串
	 *
	 * @author GaoMing
	 * @time 2017年5月24日 下午6:04:04
	 */
	public static String encode(byte[] bytes) throws Exception{
		return new String(Base64.encode(bytes));
	}
	
	/**
	 * @description 将文件爱你编码为base64字符串
	 * @param filePath 文件的绝对路径
	 * 
	 * @author GaoMing
	 * @time 2017年5月24日 下午6:06:16
	 */
	public static String encodeFile(String filePath) throws Exception{
		byte[] bytes = fileToByte(filePath);
		return encode(bytes);
	}
	
	/**
	 * @description base64字符串转回文件
	 *
	 * @author GaoMing
	 * @time 2017年5月24日 下午6:09:27
	 */
	private static void decodeToFile(String filePath,String base64) throws Exception {
		byte[] bytes = decode(base64);
		byteArrayTofile(bytes,filePath);
	}

	/**
	 * @description 二进制数据写文件
	 * @param bytes 二进制数据
	 * @param filePath 文件生成目录
	 *
	 * @author GaoMing
	 * @throws Exception 
	 * @time 2017年5月24日 下午6:16:20
	 */
	private static void byteArrayTofile(byte[] bytes, String filePath) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		File destFile = new File(filePath);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		destFile.createNewFile();
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] cache = new byte[CACHE_SIZE];
		int nRead = 0;
		while((nRead = in.read(cache)) != 1){
			out.write(cache,0,nRead);
			out.flush();
		}
		out.close();
		in.close();
	}

	/**
	 * @description 文件转换为二进制数组
	 *
	 * @author GaoMing
	 * @time 2017年5月24日 下午6:10:08
	 */
	private static byte[] fileToByte(String filePath) throws Exception{
		byte[] data = new byte[0];
		File file = new File(filePath);
		if (file.exists()) {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while((nRead = in.read(cache)) != 1){
				out.write(cache,0,nRead);
				out.flush();
			}
			out.close();
			in.close();
			data = out.toByteArray();
		}
		return data;
	}
	
	
	
	
	
	
	
	
}
