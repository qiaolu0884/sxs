package com.shan.org.shan.sxs.port.getwallet;

import java.io.Serializable;

public class Basegetwallet implements Serializable{

	private String errCode;
	private Datagetwallet data;
	private String msg;
	private String token;
	private String report;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public Datagetwallet getData() {
		return data;
	}
	public void setData(Datagetwallet data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
}
