package jh.chada.jdbc.store.model.dto;

public class StoreItemDto {

	private Integer sellNo;
	private String sellName;
	private Integer sellStock;
	private String priceCode;
	public StoreItemDto() {
	}
	public StoreItemDto(Integer sellNo, String sellName, Integer sellStock, String priceCode) {
		this.sellNo = sellNo;
		this.sellName = sellName;
		this.sellStock = sellStock;
		this.priceCode = priceCode;
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

	
	
}
