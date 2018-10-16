
public class Vehicle {
	
	private String vehicleID;
	private String hirerID;
	private String description;
	private char status;
	private double dailyRate;
	private int odometer;
	private DateTime dateHire;
	private double totalCharge;
	
	public Vehicle(String vehicleID, String description, double dailyRate, int odometer){
		this.setVehicleID(vehicleID);
		this.setDescription(description);
		this.setDailyRate(dailyRate);
		this.setOdometer(odometer);
		this.setStatus('A');
	}
	
	public boolean hire(String hirerID){
		if(getStatus() == 'A'){
			this.setHirerID(hirerID);
			setDateHire(new DateTime());
			getDateHire().getTime();
			this.setStatus('H');
			return true;
		}
		else 
			return false;
	}
	
	public boolean service(){
		if(this.getStatus() == 'A'){
			this.setStatus('S');
			return true;
		}
		else
			return false;		
	}
	
	public boolean serviceComplete(int odo){
		//return odo reading, how?
		//date diff maybe
		if (this.getStatus() == 'S'){
			this.setOdometer(odo);
			this.setStatus('A');
			return true;
		}
		else 
			return false;
	}
	
	public double hireComplete(int odo){
		DateTime dateComplete = new DateTime();
		dateComplete.getTime();
		//need a if for like diffdays>=0 to do this
		if (this.getStatus() == 'H' && this.getOdometer() < odo){
			this.setStatus('A');
			this.setOdometer(odo);
			this.setTotalCharge(DateTime.diffDays(dateComplete, this.getDateHire()) *this.getDailyRate());
			return this.getTotalCharge();
		}
		else
			return -1.0;
		//else diffdays <= then -1.0
	}
	
	public void print(){
		System.out.println("\n*************** Vehicle Details ***************");
		System.out.println(DateTime.getCurrentTime());
		System.out.println(this);
		
		if (this.getStatus() =='H'){
			System.out.print("Hirer="+this.getHirerID());
			System.out.println("  Date/Time of the hire="+this.getDateHire());
		}
	}
	

@Override
	public String toString(){
		return "vehicleID=" + getVehicleID() + ", description=" + getDescription() + ", status=" + status
				+ ", dailyRate=" + dailyRate + ", odometer=" + odometer;
	}
	
	public String getID(){
		return this.getVehicleID();
	}
	
	public String getHirer(){
		return this.getHirerID();
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public DateTime getDateHire() {
		return dateHire;
	}

	public void setDateHire(DateTime dateHire) {
		this.dateHire = dateHire;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public String getHirerID() {
		return hirerID;
	}

	public void setHirerID(String hirerID) {
		this.hirerID = hirerID;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
	
	

}




