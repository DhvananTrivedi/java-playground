package model;

public class Address {
	
	private String pincode;
	
	public Address(String pincode) {
		super();
		this.pincode = pincode;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [pincode=" + pincode + "]";
	}
	
}
