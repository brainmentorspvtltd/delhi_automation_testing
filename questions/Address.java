package questions;

public class Address {
	private String city;
	private String country;
	private String pinCode;
	
	public Address(String city, String country, String pinCode) {
		super();
		this.city = city;
		this.country = country;
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public int hashCode() {
		return this.city.length()+ this.country.length();
	}
	
	public boolean equals(Object object) {
		if(object instanceof Address) {
			Address address = (Address) object;
			if(this.city.equals(address.city) && 
					this.country.equals(address.country) && 
					this.pinCode.equals(address.pinCode)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
	

}
