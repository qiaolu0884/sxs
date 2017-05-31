package com.shan.org.shan.sxs.port.wallet;

import java.io.Serializable;
import java.util.List;

public class Datawallet implements Serializable{
	private String errCode;
	private String[] data;
	private String msg;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
