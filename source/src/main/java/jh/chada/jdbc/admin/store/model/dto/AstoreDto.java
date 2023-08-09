package jh.chada.jdbc.admin.store.model.dto;

public class AstoreDto {

	private Integer sellNo;
	private String sellName;
	private Integer sellStock;
	private String priceCode;
	private String filePath;

	
	public AstoreDto() {

	}


	public AstoreDto(Integer sellNo, String sellName, Integer sellStock, String priceCode, String filePath) {
		this.sellNo = sellNo;
		this.sellName = sellName;
		this.sellStock = sellStock;
		this.priceCode = priceCode;
		this.filePath = filePath;
	}


	@Override
	public String toString() {
		return "AstoreDto [sellNo=" + sellNo + ", sellName=" + sellName + ", sellStock=" + sellStock + ", priceCode="
				+ priceCode + ", filePath=" + filePath + "]";
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


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
