package ca.bcit.comp2613.coursematerial.day03;

//http://countrycode.org/
public enum Country {
	CAN("Canada", 1), HK("Hong Kong", 52), BM("Bermuda", 141);

	private String description;
	private int isoCode;
	Country(String description, int isoCode) {
		this.description = description;
		this.isoCode = isoCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(int isoCode) {
		this.isoCode = isoCode;
	}
	
	
}
