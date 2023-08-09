package jh.chada.jdbc.store.model.dto;

public class StoreDto {

	private Integer sellNo;
	private String sellName;
	private Integer sellStock;
	private String priceCode;
	
	private Integer orderNo;
	private String orderName;
	private String orderAddress;
	private String orderPhoneNumber;
	private String orderRequest;
	private Integer orderPrice;
	private String orderTime;
	private String memberNo;
	

	private String ocartAmount;
	
	private Integer couponCode;
	private String couponName;
	private Integer couponDr;
	private Integer couponDa;
	private Integer couponCon;
	private String couponLimit;
	
	private String memberPoint;
	
	public StoreDto() {
		
	}

	@Override
	public String toString() {
		return "StoreDto [sellNo=" + sellNo + ", sellName=" + sellName + ", sellStock=" + sellStock + ", priceCode="
				+ priceCode + ", orderNo=" + orderNo + ", orderName=" + orderName + ", orderAddress=" + orderAddress
				+ ", orderPhoneNumber=" + orderPhoneNumber + ", orderRequest=" + orderRequest + ", orderPrice="
				+ orderPrice + ", orderTime=" + orderTime + ", memberNo=" + memberNo + ", ocartAmount=" + ocartAmount
				+ ", couponCode=" + couponCode + ", couponName=" + couponName + ", couponDr=" + couponDr + ", couponDa="
				+ couponDa + ", couponCon=" + couponCon + ", couponLimit=" + couponLimit + ", memberPoint="
				+ memberPoint + "]";
	}

	public Integer getSellNo() {
		return sellNo;
	}

	public void setSellNo(Integer sellNo) {
		this.sellNo = sellNo;
	}

	public String getSellName() {
		return sellName;
	}

	public void setSellName(String sellName) {
		this.sellName = sellName;
	}

	public Integer getSellStock() {
		return sellStock;
	}

	public void setSellStock(Integer sellStock) {
		this.sellStock = sellStock;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
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

	public String getOcartAmount() {
		return ocartAmount;
	}

	public void setOcartAmount(String ocartAmount) {
		this.ocartAmount = ocartAmount;
	}

	public Integer getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(Integer couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Integer getCouponDr() {
		return couponDr;
	}

	public void setCouponDr(Integer couponDr) {
		this.couponDr = couponDr;
	}

	public Integer getCouponDa() {
		return couponDa;
	}

	public void setCouponDa(Integer couponDa) {
		this.couponDa = couponDa;
	}

	public Integer getCouponCon() {
		return couponCon;
	}

	public void setCouponCon(Integer couponCon) {
		this.couponCon = couponCon;
	}

	public String getCouponLimit() {
		return couponLimit;
	}

	public void setCouponLimit(String couponLimit) {
		this.couponLimit = couponLimit;
	}

	public String getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(String memberPoint) {
		this.memberPoint = memberPoint;
	}
	
	
}
