package jh.chada.jdbc.store.model.dto;

public class StoreOrderDto {

	private Integer orderNo;
	private String orderName;
	private String orderAddress;
	private String orderPhoneNumber;
	private String orderRequest;
	private Integer orderPrice;
	private String orderTime;
	private String memberNo;
	
	public StoreOrderDto() {
		}

	public StoreOrderDto(Integer orderNo, String orderName, String orderAddress, String orderPhoneNumber,
			String orderRequest, Integer orderPrice, String orderTime, String memberNo) {
		this.orderNo = orderNo;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderPhoneNumber = orderPhoneNumber;
		this.orderRequest = orderRequest;
		this.orderPrice = orderPrice;
		this.orderTime = orderTime;
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "StoreOrderDto [orderNo=" + orderNo + ", orderName=" + orderName + ", orderAddress=" + orderAddress
				+ ", orderPhoneNumber=" + orderPhoneNumber + ", orderRequest=" + orderRequest + ", orderPrice="
				+ orderPrice + ", orderTime=" + orderTime + ", memberNo=" + memberNo + "]";
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderPhoneNumber() {
		return orderPhoneNumber;
	}

	public void setOrderPhoneNumber(String orderPhoneNumber) {
		this.orderPhoneNumber = orderPhoneNumber;
	}

	public String getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

}
