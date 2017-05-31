package com.shan.org.shan.sxs.port.shannenegliang;

import java.io.Serializable;
import java.util.List;

public class Datashannenegliang implements Serializable{
	private String errCode;
	private Shannenegliang data;
	private String msg;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public Shannenegliang getData() {
		return data;
	}
	public void setData(Shannenegliang data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
