import java.util.Scanner;

public class RealVehicle2 {
	public static void main(String args[]){
		Vehicle vehs[] = new Vehicle[6];
		int input = 0;
		String vehicleIDInput = "";
		String hireIDInput = "";
		int odoInput = 0;
		boolean error = false;
		
		vehs[0] = new Vehicle("QJT123","Starlet 99", 35.00, 190000);
		vehs[1] = new PremiumVehicle("TUX132","BMW 05", 90.00, 12000,100, 10000,5000);
		vehs[2] = new Vehicle("PTU121","Holden 03", 60.00, 165000);
		vehs[3] = new Vehicle("OCD856","Camry 04", 65.00, 230000);
		vehs[4] = new PremiumVehicle("TEY749","Jaguar 06", 125.00, 27000,120, 12000,20000);
		vehs[5] = new Vehicle("TYR852","Subaru 02", 60.00, 270000);
		
		for (int i = 0; i < vehs.length; i++ ){
			vehs[i].print();
		}
		
		do{
			try{
				menu();
				Scanner console = new Scanner(System.in);
				input = console.nextInt();
				switch (input){
					case 1: 
						for (int i = 0; i < vehs.length; i++ ){
							vehs[i].print();
						}
//						error = true;
						break;
					case 2:
						System.out.print("Enter vehicle ID : ");
						vehicleIDInput = console.next();
						for (int i = 0; i < vehs.length; i++ ){
							if (vehicleIDInput.equals(vehs[i].getVehicleID())){
								if(vehs[i].getStatus()=='A'){
									System.out.print("Enter hirer ID : ");
									hireIDInput = console.next();
									vehs[i].hire(hireIDInput);
//									error = true;
									System.out.println("hire SUccess");
									break;
								}
								else{
									System.out.println("The vehicle is not available!");
								}
							}
							else if (i == vehs.length-1){
								System.out.println("No such vehicle exist! \n");
							}
						}
						break;
					case 3:
						System.out.print("Enter vehicle ID : ");
						vehicleIDInput = console.next();
						for (int i = 0; i < vehs.length; i++ ){
							if (vehicleIDInput.equals(vehs[i].getVehicleID())){
								if(vehs[i].getStatus()=='H'){
									System.out.print("Enter odometer reading : ");
									odoInput = console.nextInt();
									vehs[i].hireComplete(odoInput);
//									error = true;
									System.out.println("Completed hire process finished!");
									break;
								}
								else{
									System.out.println("The vehicle is not on hire at the moment!");
								}
							}
							else if (i == vehs.length-1){
								System.out.println("No such vehicle exist! \n");
							}
						}
						break;
					case 4:
						System.out.print("Enter vehicle ID : ");
						vehicleIDInput = console.next();
						for (int i = 0; i < vehs.length; i++ ){
							if (vehicleIDInput.equals(vehs[i].getVehicleID())){
								if(vehs[i].getStatus()=='A'){
									vehs[i].service();
//									error = true;
									System.out.println("Vehicle is set to service!");
									break;
								}
								else{
									System.out.println("The vehicle is not available at the moment!");
								}
							}
							else if (i == vehs.length-1){
								System.out.println("No such vehicle exist! \n");
							}
						}
						break;
					case 5:
						System.out.print("Enter vehicle ID : ");
						vehicleIDInput = console.next();
						for (int i = 0; i < vehs.length; i++ ){
							if (vehicleIDInput.equals(vehs[i].getVehicleID())){
								if(vehs[i].getStatus()=='S'){
									System.out.print("Enter odometer reading : ");
									odoInput = console.nextInt();
									vehs[i].serviceComplete(odoInput);
//									error = true;
									System.out.println("Completed service process finished!");
									break;
								}
								else{
									System.out.println("The vehicle is not on service at the moment!");
								}
							}
							else if (i == vehs.length-1){
								System.out.println("No such vehicle exist! \n");
							}
						}
						break;
					case 6:
						error = true;
						break;
				}
			}  catch (Exception e){
				System.out.println("invalid input try again!  "+e);
			}
		} while (!error);
	
	}
	
	public static void menu(){
		System.out.printf("%20s\n","Vehicle Menu");
		System.out.printf("Display Available Cars%8s\n", "1");
		System.out.printf("Hire Vehicle%18s\n", "2");
		System.out.printf("Complete Hire%17s\n", "3");
		System.out.printf("Service Vehicle%15s\n", "4");
		System.out.printf("Complete Service%14s\n", "5");
		System.out.printf("Exit%26s\n", "6");
		System.out.printf("%20s", "Your Choice : ");		
	}
}

