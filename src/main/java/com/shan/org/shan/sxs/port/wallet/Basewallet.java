package com.shan.org.shan.sxs.port.wallet;

import java.io.Serializable;

public class Basewallet implements Serializable{

	private String errCode;
	private Datawallet data;
	private String msg;
	private String token;
	private String report;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public Datawallet getData() {
		return data;
	}
	public void setData(Datawallet data) {
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
