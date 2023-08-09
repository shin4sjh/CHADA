package jh.chada.jdbc.board.file.model.dto;

public class BattachFileDto {
	
	private String bfilePath;
	private Integer boardCode;
	
	public BattachFileDto() {
	
	}

	public BattachFileDto(String bfilePath) {
		this.bfilePath = bfilePath;
	}

	public BattachFileDto(String bfilePath, Integer boardCode) {
		this.bfilePath = bfilePath;
		this.boardCode = boardCode;
	}

	@Override
	public String toString() {
		return "BattachFileDto [bfilePath=" + bfilePath + ", boardCode=" + boardCode + "]";
	}

	public String getBfilePath() {
		return bfilePath;
	}

	public void setBfilePath(String bfilePath) {
		this.bfilePath = bfilePath;
	}

	public Integer getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(Integer boardCode) {
		this.boardCode = boardCode;
	}

}
