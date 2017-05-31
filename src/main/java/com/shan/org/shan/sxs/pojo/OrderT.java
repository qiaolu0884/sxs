package com.shan.org.shan.sxs.pojo;

public class OrderT {
	
	 private Long status;
	 private Long beginTime;
	 private Long endTime;
	 private Long order_number;
	 private Double money;
	 private Long sxb;
	 private Long szz;

	 private String beginDate;
	 private String endDate;
	 private String dateType;
	 
	 private Long create_time;
	 
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getOrder_number() {
		return order_number;
	}
	public void setOrder_number(Long order_number) {
		this.order_number = order_number;
	}
	
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Long getSxb() {
		return sxb;
	}
	public void setSxb(Long sxb) {
		this.sxb = sxb;
	}
	public Long getSzz() {
		return szz;
	}
	public void setSzz(Long szz) {
		this.szz = szz;
	}
	
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	
	public Long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "OrderT [status=" + status + ", beginTime=" + beginTime + ", endTime=" + endTime + ", order_number="
				+ order_number + ", money=" + money + ", sxb=" + sxb + ", szz=" + szz + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", dateType=" + dateType + "]";
	}
	
	 
}
