
public abstract class Customer {
	String customerID,name,phone;
	double discount = 0;
	
	public Customer(String customerID, String name, String phone){
		this.setCustomerID(customerID);
		this.setName(name);
		this.setPhone(phone);
	}
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public abstract double getDiscount();

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", phone=" + phone + ", discount=" + discount
				+ "]";
	}
	

}

