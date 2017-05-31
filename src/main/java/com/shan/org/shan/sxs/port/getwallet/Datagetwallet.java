package com.shan.org.shan.sxs.port.getwallet;

import java.io.Serializable;
import java.util.List;

public class Datagetwallet implements Serializable{
	private String errCode;
	private GetWallet[] data;
	private String msg;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public GetWallet[] getData() {
		return data;
	}
	public void setData(GetWallet[] data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
