public class ICustomer extends Customer{
	int yearEXP = 0;
	int pastMile = 0;
	double discountCharge = 0;
	double totalCharge = 0;
	
	public ICustomer(String customerID, String name, String phone, int yearEXP) {
		super(customerID, name, phone);
		// TODO Auto-generated constructor stub
		this.yearEXP=yearEXP;
		
	}
	@Override
	public double getDiscount() {
		if (pastMile >=200000){
			super.setDiscount(0.2);
			discountCharge = this.getTotalCharge()*0.2;
			
		}
		else if(pastMile>=100000){
			super.setDiscount(0.1);
			discountCharge = this.getTotalCharge()*0.1;
		}
		else{
			super.setDiscount(0);
			discountCharge = 0;
		}
		return discountCharge;
	}
	public int getYearEXP() {
		return yearEXP;
	}
	public void setYearEXP(int yearEXP) {
		this.yearEXP = yearEXP;
	}
	public int getPastMile() {
		return pastMile;
	}
	public void setPastMile(int pastMile) {
		this.pastMile = pastMile;
	}
	public double getDiscountCharge() {
		return discountCharge;
	}
	public void setDiscountCharge(double discountCharge) {
		this.discountCharge = discountCharge;
	}
	public double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
	@Override
	public String toString() {
		return "ICustomer [yearEXP=" + yearEXP + ", pastMile=" + pastMile + ", discountCharge=" + discountCharge
				+ ", totalCharge=" + totalCharge + "]";
	}
	
	
}