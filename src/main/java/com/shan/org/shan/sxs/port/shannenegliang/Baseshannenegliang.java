package com.shan.org.shan.sxs.port.shannenegliang;

import java.io.Serializable;

public class Baseshannenegliang implements Serializable{

	private String errCode;
	private Datashannenegliang data;
	private String msg;
	private String token;
	private String report;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public Datashannenegliang getData() {
		return data;
	}
	public void setData(Datashannenegliang data) {
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
