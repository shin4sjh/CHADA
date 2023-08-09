package jh.chada.jdbc.article.file.model.dto;

public class AattachFileDto {

	private String afilePath;
	private Integer articleCode;
	
	public AattachFileDto() {
	
	}

	public AattachFileDto(String afilePath, Integer articleCode) {
		this.afilePath = afilePath;
		this.articleCode = articleCode;
	}

	@Override
	public String toString() {
		return "AattachFileDto [afilePath=" + afilePath + ", articleCode=" + articleCode + "]";
	}

	public String getAfilePath() {
		return afilePath;
	}

	public void setAfilePath(String afilePath) {
		this.afilePath = afilePath;
	}

	public Integer getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(Integer articleCode) {
		this.articleCode = articleCode;
	}

}
