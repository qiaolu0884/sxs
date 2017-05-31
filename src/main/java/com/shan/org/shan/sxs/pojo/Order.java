package com.shan.org.shan.sxs.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable {
	
    /**
     * 主键订单ID
     */
    private Long id;

    /**
     * 交易状态：0-未支付 1-已支付 2-交易关闭
     */
    private Long status;

    /**
     * 交易金额
     */
    private BigDecimal money;
    
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * 订单编号
     */
    private Long orderNumber;

    /**
     * 订单创建时间
     */
    private Long createTime;
    //格式化时间
    private Date createDate;

    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
     * 商品id
     */
    private Long commodityId;

    /**
     * 交易数量
     */
    private Long orderCount;

    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 用户级别
     */
    private String userGrade;
    
    private String statusS;//状态显示
    private String formatTime;//时间格式化
    private String commS; //商品种类；
    private Long djs;//倒计时时间
    
	public Long getDjs() {
		return djs;
	}

	public void setDjs(Long djs) {
		this.djs = djs;
	}

	public String getCommS() {
		return commS;
	}

	public void setCommS(String commS) {
		this.commS = commS;
	}

	public String getFormatTime() {
		return formatTime;
	}

	public void setFormatTime(String formatTime) {
		this.formatTime = formatTime;
	}

	public String getStatusS() {
		return statusS;
	}

	public void setStatusS(String statusS) {
		this.statusS = statusS;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", money=").append(money);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", createTime=").append(createTime);
        sb.append(", commodityId=").append(commodityId);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", userId=").append(userId);
        sb.append(", userGrade=").append(userGrade);
        sb.append(", username=").append(username);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}