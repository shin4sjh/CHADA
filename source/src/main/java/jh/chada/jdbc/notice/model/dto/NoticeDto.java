package jh.chada.jdbc.notice.model.dto;

public class NoticeDto {

	private String memberNo;
	private String noticeContent;
	
	public NoticeDto() {

	}

	public NoticeDto(String memberNo, String noticeContent) {
		this.memberNo = memberNo;
		this.noticeContent = noticeContent;
	}

	@Override
	public String toString() {
		return "NoticeDto [memberNo=" + memberNo + ", noticeContent=" + noticeContent + "]";
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
