package jh.chada.jdbc.admin.member.model.dto;

public class AmemberDto {
	
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

	public AmemberDto() {
		}

	public AmemberDto(String memberNo, String memberId, String memberPassword, String memberRank,
			String memberPhoneNumber, String memberPhoneNumber2, String memberEmail, String memberEmail2,
			String memberSignDate, String memeberName, Integer memberGender, String memberBirth, String address,
			String address2) {
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
	}

	@Override
	public String toString() {
		return "AmemberDto [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPassword=" + memberPassword
				+ ", memberRank=" + memberRank + ", memberPhoneNumber=" + memberPhoneNumber + ", memberPhoneNumber2="
				+ memberPhoneNumber2 + ", memberEmail=" + memberEmail + ", memberEmail2=" + memberEmail2
				+ ", memberSignDate=" + memberSignDate + ", memeberName=" + memeberName + ", memberGender="
				+ memberGender + ", memberBirth=" + memberBirth + ", address=" + address + ", address2=" + address2
				+ "]";
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
	
	
}
