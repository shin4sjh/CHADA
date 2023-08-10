package jh.chada.jdbc.article.model.dto;

public class ArticleListDto {

	public ArticleListDto() {
	
	}

	private Integer articleCode;
	private String memberNo;
	private String articleTitle;
	private String keywordCode;
	private String articleTime;
	
	
	
	public ArticleListDto(Integer articleCode, String memberNo, String articleTitle, String keywordCode,
			String articleTime) {
		this.articleCode = articleCode;
		this.memberNo = memberNo;
		this.articleTitle = articleTitle;
		this.keywordCode = keywordCode;
		this.articleTime = articleTime;
	}
	@Override
	public String toString() {
		return "ArticleListDto [articleCode=" + articleCode + ", memberNo=" + memberNo + ", articleTitle="
				+ articleTitle + ", keywordCode=" + keywordCode + ", articleTime=" + articleTime + "]";
	}
	public Integer getArticleCode() {
		return articleCode;
	}
	public void setArticleCode(Integer articleCode) {
		this.articleCode = articleCode;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getKeywordCode() {
		return keywordCode;
	}
	public void setKeywordCode(String keywordCode) {
		this.keywordCode = keywordCode;
	}
	public String getArticleTime() {
		return articleTime;
	}
	public void setArticleTime(String articleTime) {
		this.articleTime = articleTime;
	}
	
}
