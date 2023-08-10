package jh.chada.jdbc.store.file.model.dto;

public class SattachFileDto {

	private String filePath;
	private Integer sellNo;
	
	public SattachFileDto() {
	}

	public SattachFileDto(String filePath, Integer sellNo) {
		this.filePath = filePath;
		this.sellNo = sellNo;
	}

	
	
	public SattachFileDto(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "SattachFileDto [filePath=" + filePath + ", sellNo=" + sellNo + "]";
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getSellNo() {
		return sellNo;
	}

	public void setSellNo(Integer sellNo) {
		this.sellNo = sellNo;
	}

}
