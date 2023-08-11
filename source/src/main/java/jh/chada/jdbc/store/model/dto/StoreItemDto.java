package jh.chada.jdbc.store.model.dto;

import java.util.List;

import jh.chada.jdbc.store.file.model.dto.SattachFileDto;

public class StoreItemDto {

	private Integer sellNo;
	private String sellName;
	private Integer sellStock;
	private String priceCode;
	private List<SattachFileDto> sattachFileList;
	
	public StoreItemDto() {
	}
	
	public StoreItemDto(Integer sellNo, String sellName, Integer sellStock, String priceCode) {
		this.sellNo = sellNo;
		this.sellName = sellName;
		this.sellStock = sellStock;
		this.priceCode = priceCode;
	}
	
	
	@Override
	public String toString() {
		return "StoreItemDto [sellNo=" + sellNo + ", sellName=" + sellName + ", sellStock=" + sellStock + ", priceCode="
				+ priceCode + ", sattachFileList=" + sattachFileList + "]";
	}

	public Integer getSellNo() {
		return sellNo;
	}
	public void setSellNo(Integer sellNo) {
		this.sellNo = sellNo;
	}
	public String getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	public Integer getSellStock() {
		return sellStock;
	}
	public void setSellStock(Integer sellStock) {
		this.sellStock = sellStock;
	}
	public String getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public List<SattachFileDto> getSattachFileList() {
		return sattachFileList;
	}

	public void setSattachFileList(List<SattachFileDto> sattachFileList) {
		this.sattachFileList = sattachFileList;
	}

	
	
}
