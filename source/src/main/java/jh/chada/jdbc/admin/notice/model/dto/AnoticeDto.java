package jh.chada.jdbc.admin.notice.model.dto;

public class AnoticeDto {

	private String memberNo;
	private String noticeContent;
	
	public AnoticeDto() {
		
	}

	public AnoticeDto(String memberNo, String noticeContent) {
		this.memberNo = memberNo;
		this.noticeContent = noticeContent;
	}

	@Override
	public String toString() {
		return "AnoticeDto [memberNo=" + memberNo + ", noticeContent=" + noticeContent + "]";
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

}
