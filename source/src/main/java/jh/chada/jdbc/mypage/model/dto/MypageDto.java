package jh.chada.jdbc.mypage.model.dto;

public class MypageDto {

	private String memberNo;
	private String memberId;
	private String memberPassword;
	private String memberRank;
	private String memberPhoneNumber;
	private String memberPhoneNumber2;
	private String memberEmail;
	private String memberEmail2;
	private String memberSignDate;
	private String memeberName;
	private Integer memberGender;
	private String memberBirth;
	private String address;
	private String address2;
	
	private Integer orderNo;
	private String orderName;
	private String orderAddress;
	private String orderPhoneNumber;
	private String orderRequest;
	private Integer orderPrice;
	private String orderTime;
	
	private String noticeContent;
	
	private Integer couponCode;
	private String couponName;
	private Integer couponDr;
	private Integer couponDa;
	private Integer couponCon;
	private String couponLimit;
	
	private String memberPoint;
	
	private Integer sellNo;
	private String wish;
	
	private Integer cartAmount;
	private String cartTime;
	
	private Integer boardCode; 
	private String boardTitle; 
	private String boardContent; 
	private String boardDate; 
	private String boardRef; 
	private String boardLevel; 
	private String boardStep; 
	private String boardCategory;
	private String keywordCode;
	private Integer tagNo;
	
	private Integer replyNo;
	private String replyDate;
	private Integer replyLevel;
	private Integer replyStep;
	
	private String blikeDate;
	
	public MypageDto() {
		
	}

	public MypageDto(String memberNo, String memberId, String memberPassword, String memberRank,
			String memberPhoneNumber, String memberPhoneNumber2, String memberEmail, String memberEmail2,
			String memberSignDate, String memeberName, Integer memberGender, String memberBirth, String address,
			String address2, Integer orderNo, String orderName, String orderAddress, String orderPhoneNumber,
			String orderRequest, Integer orderPrice, String orderTime, String noticeContent, Integer couponCode,
			String couponName, Integer couponDr, Integer couponDa, Integer couponCon, String couponLimit,
			String memberPoint, Integer sellNo, String wish, Integer cartAmount, String cartTime, Integer boardCode,
			String boardTitle, String boardContent, String boardDate, String boardRef, String boardLevel,
			String boardStep, String boardCategory, String keywordCode, Integer tagNo, Integer replyNo,
			String replyDate, Integer replyLevel, Integer replyStep, String blikeDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberRank = memberRank;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberPhoneNumber2 = memberPhoneNumber2;
		this.memberEmail = memberEmail;
		this.memberEmail2 = memberEmail2;
		this.memberSignDate = memberSignDate;
		this.memeberName = memeberName;
		this.memberGender = memberGender;
		this.memberBirth = memberBirth;
		this.address = address;
		this.address2 = address2;
		this.orderNo = orderNo;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderPhoneNumber = orderPhoneNumber;
		this.orderRequest = orderRequest;
		this.orderPrice = orderPrice;
		this.orderTime = orderTime;
		this.noticeContent = noticeContent;
		this.couponCode = couponCode;
		this.couponName = couponName;
		this.couponDr = couponDr;
		this.couponDa = couponDa;
		this.couponCon = couponCon;
		this.couponLimit = couponLimit;
		this.memberPoint = memberPoint;
		this.sellNo = sellNo;
		this.wish = wish;
		this.cartAmount = cartAmount;
		this.cartTime = cartTime;
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardRef = boardRef;
		this.boardLevel = boardLevel;
		this.boardStep = boardStep;
		this.boardCategory = boardCategory;
		this.keywordCode = keywordCode;
		this.tagNo = tagNo;
		this.replyNo = replyNo;
		this.replyDate = replyDate;
		this.replyLevel = replyLevel;
		this.replyStep = replyStep;
		this.blikeDate = blikeDate;
	}

	@Override
	public String toString() {
		return "MypageDto [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPassword=" + memberPassword
				+ ", memberRank=" + memberRank + ", memberPhoneNumber=" + memberPhoneNumber + ", memberPhoneNumber2="
				+ memberPhoneNumber2 + ", memberEmail=" + memberEmail + ", memberEmail2=" + memberEmail2
				+ ", memberSignDate=" + memberSignDate + ", memeberName=" + memeberName + ", memberGender="
				+ memberGender + ", memberBirth=" + memberBirth + ", address=" + address + ", address2=" + address2
				+ ", orderNo=" + orderNo + ", orderName=" + orderName + ", orderAddress=" + orderAddress
				+ ", orderPhoneNumber=" + orderPhoneNumber + ", orderRequest=" + orderRequest + ", orderPrice="
				+ orderPrice + ", orderTime=" + orderTime + ", noticeContent=" + noticeContent + ", couponCode="
				+ couponCode + ", couponName=" + couponName + ", couponDr=" + couponDr + ", couponDa=" + couponDa
				+ ", couponCon=" + couponCon + ", couponLimit=" + couponLimit + ", memberPoint=" + memberPoint
				+ ", sellNo=" + sellNo + ", wish=" + wish + ", cartAmount=" + cartAmount + ", cartTime=" + cartTime
				+ ", boardCode=" + boardCode + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardRef=" + boardRef + ", boardLevel=" + boardLevel + ", boardStep="
				+ boardStep + ", boardCategory=" + boardCategory + ", keywordCode=" + keywordCode + ", tagNo=" + tagNo
				+ ", replyNo=" + replyNo + ", replyDate=" + replyDate + ", replyLevel=" + replyLevel + ", replyStep="
				+ replyStep + ", blikeDate=" + blikeDate + "]";
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberPhoneNumber2() {
		return memberPhoneNumber2;
	}

	public void setMemberPhoneNumber2(String memberPhoneNumber2) {
		this.memberPhoneNumber2 = memberPhoneNumber2;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberEmail2() {
		return memberEmail2;
	}

	public void setMemberEmail2(String memberEmail2) {
		this.memberEmail2 = memberEmail2;
	}

	public String getMemberSignDate() {
		return memberSignDate;
	}

	public void setMemberSignDate(String memberSignDate) {
		this.memberSignDate = memberSignDate;
	}

	public String getMemeberName() {
		return memeberName;
	}

	public void setMemeberName(String memeberName) {
		this.memeberName = memeberName;
	}

	public Integer getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(Integer memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
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

	public Integer getSellNo() {
		return sellNo;
	}

	public void setSellNo(Integer sellNo) {
		this.sellNo = sellNo;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
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

	public Integer getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(Integer boardCode) {
		this.boardCode = boardCode;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardRef() {
		return boardRef;
	}

	public void setBoardRef(String boardRef) {
		this.boardRef = boardRef;
	}

	public String getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(String boardLevel) {
		this.boardLevel = boardLevel;
	}

	public String getBoardStep() {
		return boardStep;
	}

	public void setBoardStep(String boardStep) {
		this.boardStep = boardStep;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(String keywordCode) {
		this.keywordCode = keywordCode;
	}

	public Integer getTagNo() {
		return tagNo;
	}

	public void setTagNo(Integer tagNo) {
		this.tagNo = tagNo;
	}

	public Integer getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public Integer getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(Integer replyLevel) {
		this.replyLevel = replyLevel;
	}

	public Integer getReplyStep() {
		return replyStep;
	}

	public void setReplyStep(Integer replyStep) {
		this.replyStep = replyStep;
	}

	public String getBlikeDate() {
		return blikeDate;
	}

	public void setBlikeDate(String blikeDate) {
		this.blikeDate = blikeDate;
	}

	
	
}
