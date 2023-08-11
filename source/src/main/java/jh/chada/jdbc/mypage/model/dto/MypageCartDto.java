package jh.chada.jdbc.mypage.model.dto;

public class MypageCartDto {

	private Integer sellNo;
	private String memberNo;
	private Integer cartAmount;
	private String cartTime;
	private String wish;
	
	public MypageCartDto() {
//	one	insert delete
	}

	
	
	
	
	
	public MypageCartDto(Integer sellNo, String memberNo, Integer cartAmount, String cartTime) {
		this.sellNo = sellNo;
		this.memberNo = memberNo;
		this.cartAmount = cartAmount;
		this.cartTime = cartTime;
	}






	public MypageCartDto(Integer sellNo, String memberNo, String wish) {
		this.sellNo = sellNo;
		this.memberNo = memberNo;
		this.wish = wish;
	}






	@Override
	public String toString() {
		return "MypageCartDto [sellNo=" + sellNo + ", memberNo=" + memberNo + ", cartAmount=" + cartAmount
				+ ", cartTime=" + cartTime + ", wish=" + wish + "]";
	}

	public Integer getSellNo() {
		return sellNo;
	}

	public void setSellNo(Integer sellNo) {
		this.sellNo = sellNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Integer cartAmount) {
		this.cartAmount = cartAmount;
	}

	public String getCartTime() {
		return cartTime;
	}

	public void setCartTime(String cartTime) {
		this.cartTime = cartTime;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
	}

	
	
}
