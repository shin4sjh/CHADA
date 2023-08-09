package jh.chada.jdbc.article.keyword.model.dto;

public class KeywordDto {

	private String keywordCode;
	private String keywordName;
	
	public KeywordDto() {
		
	}

	public KeywordDto(String keywordCode, String keywordName) {
		this.keywordCode = keywordCode;
		this.keywordName = keywordName;
	}

	@Override
	public String toString() {
		return "KeywordDto [keywordCode=" + keywordCode + ", keywordName=" + keywordName + "]";
	}

	public String getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(String keywordCode) {
		this.keywordCode = keywordCode;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

}
