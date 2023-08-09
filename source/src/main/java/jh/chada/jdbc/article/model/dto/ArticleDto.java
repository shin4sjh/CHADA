package jh.chada.jdbc.article.model.dto;

import java.util.List;

import jh.chada.jdbc.article.file.model.dto.AattachFileDto;


public class ArticleDto {


		private Integer articleCode;
		private String memberNo;
		private String articleTitle;
		private String keywordCode;
		private String articleTime;
		private String aritcleContent;
		private String readDate;
		private String alikeDate; 

		private List<AattachFileDto> aattachFileList;
		
	
	public ArticleDto() {

	}


	public ArticleDto(Integer articleCode, String memberNo, String articleTitle, String keywordCode, String articleTime,
			String aritcleContent, String readDate, String alikeDate) {
		this.articleCode = articleCode;
		this.memberNo = memberNo;
		this.articleTitle = articleTitle;
		this.keywordCode = keywordCode;
		this.articleTime = articleTime;
		this.aritcleContent = aritcleContent;
		this.readDate = readDate;
		this.alikeDate = alikeDate;
	}


	@Override
	public String toString() {
		return "ArticleDto [articleCode=" + articleCode + ", memberNo=" + memberNo + ", articleTitle=" + articleTitle
				+ ", keywordCode=" + keywordCode + ", articleTime=" + articleTime + ", aritcleContent=" + aritcleContent
				+ ", readDate=" + readDate + ", alikeDate=" + alikeDate + "]";
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


	public String getAritcleContent() {
		return aritcleContent;
	}


	public void setAritcleContent(String aritcleContent) {
		this.aritcleContent = aritcleContent;
	}


	public String getReadDate() {
		return readDate;
	}


	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}


	public String getAlikeDate() {
		return alikeDate;
	}


	public void setAlikeDate(String alikeDate) {
		this.alikeDate = alikeDate;
	}

}
