
public class PremiumVehicle extends Vehicle{

	private int freeMileage;
	private int serviceLength;
	private int odoReading;
	

	public PremiumVehicle(String vehicleID, String description, double dailyRate, int odometer, int freeMileage,
			int serviceLength, int odoReading) {
		super(vehicleID, description, dailyRate, odometer);
		this.freeMileage = freeMileage;
		this.serviceLength = serviceLength;
		this.odoReading = odoReading;
	}

//overriding methods from superclass
@Override
	public boolean serviceComplete(int odo){
		//return odo reading, how?
		//date diff maybe
		if (super.getStatus() == 'S'){
			super.setOdometer(odo);
			super.setStatus('A');
			this.odoReading =odo;
			return true;
		}
		else 
			return false;
	}

@Override
	public double hireComplete(int odo){
		DateTime dateComplete = new DateTime();
		dateComplete.getTime();
		int freeCharge;
		if (super.getStatus() == 'H' && super.getOdometer() < odo){
			if (DateTime.diffDays(dateComplete, super.getDateHire())>0){
				freeCharge = this.freeMileage*DateTime.diffDays(dateComplete, super.getDateHire());
			}
			else{
				freeCharge = 0;
			}
			double totalCharge = DateTime.diffDays(dateComplete, super.getDateHire()) *super.getDailyRate() + (odo-super.getOdometer()-freeCharge)*.1;
			super.setStatus('A');
			super.setOdometer(odo);
			return totalCharge;
		}
		else
			return -1.0;
		//else diffdays <= then -1.0
	}
	
@Override
	public boolean hire(String hirerID){
		if(super.getStatus() == 'A' && ((this.odoReading+ this.serviceLength) >= super.getOdometer())){
			super.setHirerID(hirerID);
			super.setDateHire(new DateTime());
			super.getDateHire().getTime();
			super.setStatus('H');
			return true;
		}
		else 
			return false;
	}

	public void print(){
		System.out.println("\n*************** Vehicle Details ***************");
		System.out.println(DateTime.getCurrentTime());
		System.out.println(this);
	
		if (this.getStatus() =='H'){
			System.out.print("Hirer="+this.getHirerID());
			System.out.println("  Date/Time of the hire="+this.getDateHire());
		}
		System.out.print("Mileage Allowance = "+freeMileage);
		System.out.print(" Service Length = "+serviceLength);
		System.out.println(" Last Service = "+odoReading);
	}



@Override
	public String toString(){
		return "vehicleID=" + super.getVehicleID() + ", description=" + super.getDescription() + ", status=" + super.getStatus()
				+ ", dailyRate=" + super.getDailyRate() + ", odometer=" + super.getOdometer();
	}

}
