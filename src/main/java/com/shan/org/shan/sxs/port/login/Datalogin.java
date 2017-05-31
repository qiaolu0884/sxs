package com.shan.org.shan.sxs.port.login;

import java.io.Serializable;
import java.util.List;

public class Datalogin implements Serializable{
	private String errCode;
	private Login data;
	private String msg;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public Login getData() {
		return data;
	}
	public void setData(Login data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
