package jh.chada.jdbc.mypage.model.dto;

public class MypageOrderDto {

	private Integer orderNo;
	private String orderName;
	private String orderAddress;
	private String orderPhoneNumber;
	private String orderRequest;
	private Integer orderPrice;
	private String orderTime;
	private String memberMo;
	
	private Integer sellNo;
	private String ocartAmount; 
	
	public MypageOrderDto() {
		//insert delete one list
	}

	public MypageOrderDto(Integer orderNo, String orderName, String orderAddress, String orderPhoneNumber,
			String orderRequest, Integer orderPrice, String orderTime, String memberMo) {
		this.orderNo = orderNo;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderPhoneNumber = orderPhoneNumber;
		this.orderRequest = orderRequest;
		this.orderPrice = orderPrice;
		this.orderTime = orderTime;
		this.memberMo = memberMo;
	}

	public MypageOrderDto(Integer orderNo, Integer sellNo, String ocartAmount) {
		this.orderNo = orderNo;
		this.sellNo = sellNo;
		this.ocartAmount = ocartAmount;
	}

	@Override
	public String toString() {
		return "MypageOrderDto [orderNo=" + orderNo + ", orderName=" + orderName + ", orderAddress=" + orderAddress
				+ ", orderPhoneNumber=" + orderPhoneNumber + ", orderRequest=" + orderRequest + ", orderPrice="
				+ orderPrice + ", orderTime=" + orderTime + ", memberMo=" + memberMo + ", sellNo=" + sellNo
				+ ", ocartAmount=" + ocartAmount + "]";
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

	public String getMemberMo() {
		return memberMo;
	}

	public void setMemberMo(String memberMo) {
		this.memberMo = memberMo;
	}

	public Integer getSellNo() {
		return sellNo;
	}

	public void setSellNo(Integer sellNo) {
		this.sellNo = sellNo;
	}

	public String getOcartAmount() {
		return ocartAmount;
	}

	public void setOcartAmount(String ocartAmount) {
		this.ocartAmount = ocartAmount;
	}

	
	
}
