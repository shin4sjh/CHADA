package jh.chada.jdbc.board.model.dto;

import java.util.List;

import jh.chada.jdbc.board.file.model.dto.BattachFileDto;


public class BoardDto {

	private Integer boardCode; 
	private String boardTitle; 
	private String boardContent; 
	private String boardDate; 
	private Integer boardRef; 
	private Integer boardLevel; 
	private Integer boardStep; 
	private String memberNo; 
	private String boardCategory;
	private String keywordCode;
	private Integer tagNo;
	private Integer replyNo;
	private String replyDate;
	private Integer replyLevel;
	private Integer replyStep;
	private String readDate;
	private String blikeDate;
	private String tagName;
	private String tagName2;
	private String tagName3;
	
	private List<BattachFileDto> battachFileList;
	
	public BoardDto() {
	}

//	selectOne
	
	public BoardDto(Integer boardCode, String boardTitle, String boardContent, String boardDate, Integer boardRef,
			Integer boardLevel, Integer boardStep, String memberNo, String boardCategory, String keywordCode,
			Integer tagNo) {
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardRef = boardRef;
		this.boardLevel = boardLevel;
		this.boardStep = boardStep;
		this.memberNo = memberNo;
		this.boardCategory = boardCategory;
		this.keywordCode = keywordCode;
		this.tagNo = tagNo;
	}

	
//	selectList
	
	
	public BoardDto(Integer boardCode, String boardTitle, String boardDate, Integer boardRef, Integer boardLevel,
			Integer boardStep, String memberNo, String boardCategory, String keywordCode, Integer tagNo) {
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardRef = boardRef;
		this.boardLevel = boardLevel;
		this.boardStep = boardStep;
		this.memberNo = memberNo;
		this.boardCategory = boardCategory;
		this.keywordCode = keywordCode;
		this.tagNo = tagNo;
	}

//	원본글 등록 view

	
//	답글 등록 view
	
	public BoardDto(Integer boardCode, String boardTitle, String boardContent, String boardDate, Integer boardRef,
			Integer boardLevel, Integer boardStep, String memberNo, String boardCategory, String keywordCode,
			Integer tagNo, Integer replyNo, String replyDate, Integer replyLevel, Integer replyStep, String readDate,
			String blikeDate, String tagName, String tagName2, String tagName3, List<BattachFileDto> battachFileList) {
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardRef = boardRef;
		this.boardLevel = boardLevel;
		this.boardStep = boardStep;
		this.memberNo = memberNo;
		this.boardCategory = boardCategory;
		this.keywordCode = keywordCode;
		this.tagNo = tagNo;
		this.replyNo = replyNo;
		this.replyDate = replyDate;
		this.replyLevel = replyLevel;
		this.replyStep = replyStep;
		this.readDate = readDate;
		this.blikeDate = blikeDate;
		this.tagName = tagName;
		this.tagName2 = tagName2;
		this.tagName3 = tagName3;
		this.battachFileList = battachFileList;
	}

	

	public BoardDto(Integer boardCode, String boardTitle, String boardContent, String memberNo
			) {
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberNo = memberNo;

	}

	@Override
	public String toString() {
		return "BoardDto [boardCode=" + boardCode + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardRef=" + boardRef + ", boardLevel=" + boardLevel + ", boardStep="
				+ boardStep + ", memberNo=" + memberNo + ", boardCategory=" + boardCategory + ", keywordCode="
				+ keywordCode + ", tagNo=" + tagNo + ", replyNo=" + replyNo + ", replyDate=" + replyDate
				+ ", replyLevel=" + replyLevel + ", replyStep=" + replyStep + ", readDate=" + readDate + ", blikeDate="
				+ blikeDate + ", tagName=" + tagName + ", tagName2=" + tagName2 + ", tagName3=" + tagName3
				+ ", battachFileList=" + battachFileList + "]";
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

	public Integer getBoardRef() {
		return boardRef;
	}

	public void setBoardRef(Integer boardRef) {
		this.boardRef = boardRef;
	}

	public Integer getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(Integer boardLevel) {
		this.boardLevel = boardLevel;
	}

	public Integer getBoardStep() {
		return boardStep;
	}

	public void setBoardStep(Integer boardStep) {
		this.boardStep = boardStep;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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

	public String getReadDate() {
		return readDate;
	}

	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}

	public String getBlikeDate() {
		return blikeDate;
	}

	public void setBlikeDate(String blikeDate) {
		this.blikeDate = blikeDate;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName2() {
		return tagName2;
	}

	public void setTagName2(String tagName2) {
		this.tagName2 = tagName2;
	}

	public String getTagName3() {
		return tagName3;
	}

	public void setTagName3(String tagName3) {
		this.tagName3 = tagName3;
	}

	public List<BattachFileDto> getBattachFileList() {
		return battachFileList;
	}

	public void setBattachFileList(List<BattachFileDto> battachFileList) {
		this.battachFileList = battachFileList;
	}

	
	


	}
