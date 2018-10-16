public class CCustomer extends Customer{
	double discountRate = 0.08;
	double totalCharge = 0;
	double discountCharge = 0;
	
	//please refer to lect9 tochange
	public CCustomer(String customerID, String name,String phone, double discountRate) {
		super(customerID, name, phone);
		// TODO Auto-generated constructor stub
		this.discountRate=discountRate;
	}


	public double getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getTotalCharge() {
		return totalCharge;
	}


	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}


	public double getDiscountCharge() {
		return discountCharge;
	}


	public void setDiscountCharge(double discountCharge) {
		this.discountCharge = discountCharge;
	}

	@Override
	public double getDiscount() {
		super.setDiscount(this.getDiscountRate());
		discountCharge = this.getTotalCharge()*this.discountRate;
		return discountCharge;
	}


	@Override
	public String toString() {
		return "CCustomer [discountRate=" + discountRate + ", totalCharge=" + totalCharge + ", discountCharge="
				+ discountCharge + "]";
	}
	
	
}