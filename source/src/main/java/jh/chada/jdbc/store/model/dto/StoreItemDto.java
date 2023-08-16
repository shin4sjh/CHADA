package jh.chada.jdbc.store.model.dto;

import java.util.List;

import jh.chada.jdbc.store.file.model.dto.SattachFileDto;

public class StoreItemDto {

	private Integer sellNo;
	private String sellName;
	private Integer sellStock;
	private String priceCode;
	private List<SattachFileDto> sattachFileList;
	
	private Integer priceUnit;
	private Integer priceCup;
	private Integer pricePot;
	
	public StoreItemDto() {
	}
	
//	public StoreItemDto(Integer sellNo, String sellName, Integer sellStock, String priceCode) {
//		this.sellNo = sellNo;
//		this.sellName = sellName;
//		this.sellStock = sellStock;
//		this.priceCode = priceCode;
//	}
	
	public StoreItemDto(Integer sellNo, String sellName, Integer sellStock, String priceCode,
			 Integer priceUnit, Integer priceCup, Integer pricePot) {
		this.sellNo = sellNo;
		this.sellName = sellName;
		this.sellStock = sellStock;
		this.priceCode = priceCode;
		this.priceUnit = priceUnit;
		this.priceCup = priceCup;
		this.pricePot = pricePot;
	}



	@Override
	public String toString() {
		return "StoreItemDto [sellNo=" + sellNo + ", sellName=" + sellName + ", sellStock=" + sellStock + ", priceCode="
				+ priceCode + ", sattachFileList=" + sattachFileList + ", priceUnit=" + priceUnit + ", priceCup="
				+ priceCup + ", pricePot=" + pricePot + "]";
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

	public Integer getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(Integer priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Integer getPriceCup() {
		return priceCup;
	}

	public void setPriceCup(Integer priceCup) {
		this.priceCup = priceCup;
	}

	public Integer getPricePot() {
		return pricePot;
	}

	public void setPricePot(Integer pricePot) {
		this.pricePot = pricePot;
	}

	
	
}
