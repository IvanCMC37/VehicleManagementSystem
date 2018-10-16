//import java.io.File;
import java.util.*;
import java.io.*;

public class ManageHiring {
//	1. Add a new vehicle (Vehicle or PremiumVehicle)
//	- Input validation must ensure that ID is 6 characters and unique
//	2. Add a new customer (either of type ICustomer or CCustomer)
//	- Input validation must ensure ID is 6 characters, unique and starts with C
//	3. Display details of available vehicles in the specified range (daily-rate)
//	- Input validation must ensure lower limit of range is less than upper limit
//	4. Hire a vehicle
//	- must take into account constraints on individual customer
//	- Any exceptions must be caught and reported
//	5. Complete hire of vehicle
//	- discount must be computed based on customer hiring the vehicle
//	- Any exceptions must be caught and reported
//	6. Send a vehicle for service / Return a vehicle from Service
//	- Any exceptions must be caught and reported
//	7. Writing all objects to files and restoring them, when program is restarted.
	public static ArrayList<Vehicle> vehs = new ArrayList();
	public static ArrayList<Customer> cust = new ArrayList();
	public static ArrayList<locations> locas = new ArrayList();

	public static void main(String args[]){
		
		int input = 0;	//use for menu input
		String vehicleIDInput = "";	//use for menu input
		String DescriptionInput = "";	//use for menu input
		String hireIDInput = "";	//use for menu input
		double rateInput = 0;	//use for menu input
		int odoInput = 0;	//use for menu input
		int dailyMile = 0;	//use for menu input
		int serviceLength = 0;	//use for menu input
		int lastService = 0;	//use for menu input
		boolean error = false;	//to make sure the menu to run 
		int x = 0;
		int hireNumber =0;
		double totalChargeBefore = 0;
		double discountCharge = 0;
		double totalChargeAfter = 0;
		String customerID = "";
		String name = "";
		String phone = "";
		int yearEXP = 0;
		double discountRate =0.0;
		int locationA = 0;
		int locationB = 0;
		
		vehs.add(new Vehicle("QJT123","Starlet 99", 35.00, 190000));
		vehs.add( new PremiumVehicle("TUX132","BMW 05", 90.00, 12000,100, 10000,5000));
		vehs.add( new Vehicle("PTU121","Holden 03", 60.00, 165000));
		vehs.add(new Vehicle("OCD856","Camry 04", 65.00, 230000));
		vehs.add( new PremiumVehicle("TEY749","Jaguar 06", 125.00, 27000,120, 12000,20000));
		vehs.add(new Vehicle("TYR852","Subaru 02", 60.00, 270000));
		vehs.add( new PremiumVehicle("TEY749","Jaguar 06", 125.00, 27000,120, 12000,20000) );

		
		do{
			try{
				menu();
				Scanner console = new Scanner(System.in);
				input = console.nextInt();
				switch (input){
					case 1: 
						for (int i = 0; i < vehs.size(); i++ ){
							vehs.get(i).print();
						}
						if (vehs.size()==0){
							System.out.println("There is no car in the system yet.");
							break;
						}
						break;
					case 2:
						if (vehs.size()==0){
							System.out.println("There is no car in the system yet.");
							break;
						}
						int minMax[] = userInput1();	
						for (int i = 0; i < vehs.size(); i++ ){
							if(vehs.get(i).getDailyRate() >= minMax[0] &&vehs.get(i).getDailyRate()<= minMax[1]){
								vehs.get(i).print();
								x++;
							}			
						}
						if(x == 0){
							System.out.println("Nothing match your choice!");
						}
						break;
					case 3:
						vehsIDSelectmenu();
						if (vehs.size()==0){
							break;
						}
						vehicleIDInput = console.next();					
							if(vehs.get(Integer.parseInt(vehicleIDInput)-1).getStatus()=='A'){
								hireIDSelect();
								if (cust.size()==0){
									break;
								}
								hireIDInput = console.next();
						
								vehs.get(Integer.parseInt(vehicleIDInput)-1).hire(cust.get(Integer.parseInt(hireIDInput)-1).customerID);
								locas.add(new locations(Integer.parseInt(vehicleIDInput)-1,Integer.parseInt(hireIDInput)-1 ));
								locationA = locas.get(hireNumber).getLoctA();
								locationB = locas.get(hireNumber).getLoctB();
								System.out.println(locationA+ "   "+ locationB);
								System.out.println("hire Success");
								hireNumber++;
								break;
							}
							else{
								System.out.println("The vehicle is not available!");
							}

						break;
					case 4:
						vehsIDSelectmenu();
						vehicleIDInput = console.next();
//							if (vehicleIDInput.equals(vehs[i].getVehicleID())){
							if(vehs.get(Integer.parseInt(vehicleIDInput)-1).getStatus()=='H'){
								System.out.print("Enter odometer reading : ");
								odoInput = console.nextInt();
								DateTime.setAdvance(4,2,0);
								vehs.get(Integer.parseInt(vehicleIDInput)-1).hireComplete(odoInput);
								totalChargeBefore = vehs.get(Integer.parseInt(vehicleIDInput)-1).hireComplete(odoInput);
								outerloop:
								for (int i = 0; i< locas.size(); i++){
									if (locas.get(i).getLoctA()==Integer.parseInt(vehicleIDInput)-1){
										discountCharge =cust.get(locas.get(i).getLoctB()).getDiscount();
										totalChargeAfter = totalChargeBefore -discountCharge;
										locas.remove(i);
										break outerloop;
									}
								}
								System.out.println("CHARGED: "+totalChargeBefore+"  "+ totalChargeAfter+"  "+ discountCharge);
								System.out.println("Completed hire process finished!");
								hireNumber--;
//									error = true;
								break;
							}
							else{
								System.out.println("The vehicle is not on hire at the moment!");
							}
//							}
//							else if (i == vehs.length-1){
//								System.out.println("No such vehicle exist! \n");
//							}
						
						break;
					case 5:
						vehsIDSelectmenu();
						vehicleIDInput = console.next();
							if(vehs.get(Integer.parseInt(vehicleIDInput)-1).getStatus()=='A'){
								vehs.get(Integer.parseInt(vehicleIDInput)-1).service();
								System.out.println("Vehicle is set to service!");
								break;
							}
							else{
								System.out.println("The vehicle is not available at the moment!");
							}
						break;
					case 6:
						vehsIDSelectmenu();
						vehicleIDInput = console.next();
							if(vehs.get(Integer.parseInt(vehicleIDInput)-1).getStatus()=='S'){
								System.out.print("Enter odometer reading : ");
								odoInput = console.nextInt();
								vehs.get(Integer.parseInt(vehicleIDInput)-1).serviceComplete(odoInput);
								System.out.println("Completed service process finished!");
								break;
							}
							else{
								System.out.println("The vehicle is not on service at the moment!");
							}
						break;
					case 7:
						System.out.printf("%20s\n","What type of vehicle are you going to add?");
						System.out.printf("1. Normal Vehicle\n");
						System.out.printf("2. Premium Vehicle\n");
						System.out.printf("Your Choice : ");		
						input = console.nextInt();
						outerloop:
						if (input==1){
							System.out.println("Enter vechicleID : ");
							vehicleIDInput = console.next();
							if (vehicleIDInput.length() !=6){
								System.out.println("ID must be 6 digits");
								break;
							}
							for(int i =0;i<vehs.size();i++){
								if (vehs.get(i).getVehicleID().equals(vehicleIDInput)){
									System.out.println("ID not UNIQUE");
									break outerloop;
								}
							}
							System.out.println("Enter Description : ");
							DescriptionInput = console.next();
							System.out.println("Enter Daily rate : ");
							rateInput = console.nextDouble();
							System.out.println("Enter odometer : ");
							odoInput = console.nextInt();
							vehs.add(new Vehicle(vehicleIDInput,DescriptionInput,rateInput,odoInput));
							System.out.println("Vehicle added to system\n");
						}
						else if (input==2){
							System.out.println("Enter vechicleID : ");
							vehicleIDInput = console.next();
							if (vehicleIDInput.length() !=6){
								System.out.println("ID must be 6 digits");
								break;
							}
							for(int i =0;i<vehs.size();i++){
								if (vehs.get(i).getVehicleID().equals(vehicleIDInput)){
									System.out.println("ID not UNIQUE");
									break outerloop;
								}
							}
							System.out.println("Enter Description : ");
							DescriptionInput = console.next();
							System.out.println("Enter Daily rate : ");
							rateInput = console.nextDouble();
							System.out.println("Enter odometer : ");
							odoInput = console.nextInt();
							System.out.println("Enter daily mileage : ");
							dailyMile = console.nextInt();
							System.out.println("Enter service Length : ");
							serviceLength = console.nextInt();
							System.out.println("Enter lastService : ");
							lastService = console.nextInt();
							vehs.add(new PremiumVehicle(vehicleIDInput,DescriptionInput,rateInput,odoInput,dailyMile,serviceLength,lastService));
							System.out.println("Vehicle added to system\n");
						}
						else{
							System.out.println("wrong input, going back to menu!");
						}
						break;
					case 8:
						System.out.printf("%20s\n","What type of vehicle are you going to add?");
						System.out.printf("1. ICustomer\n");
						System.out.printf("2. CCustomer\n");
						System.out.printf("Your Choice : ");		
						input = console.nextInt();
						outerloop:
						if (input==1){
							System.out.println("Enter customerID : ");
							customerID = console.next();
							if (customerID.charAt(0)!='C'){
								System.out.println("ID must start with C");
								break;
							}
							if (customerID.length() !=6){
								System.out.println("ID must be 6 digits");
								break;
							}
							for(int i =0;i<cust.size();i++){
								if (cust.get(i).getCustomerID().equals(customerID)){
									System.out.println("ID not UNIQUE");
									break outerloop;
								}
							}
							System.out.println("Enter name : ");
							name = console.next();
							System.out.println("Enter phone : ");
							phone = console.next();
							System.out.println("Enter year of experience : ");
							yearEXP = console.nextInt();
							cust.add(new ICustomer(customerID, name, phone, yearEXP));
							System.out.println("Customer added to system\n");
						}
						else if (input==2){
							System.out.println("Enter customerID : ");
							customerID = console.next();
							if (customerID.charAt(0)!='C'){
								System.out.println("ID must start with C");
								break;
							}
							if (customerID.length() !=6){
								System.out.println("ID must be 6 digits");
								break;
							}
							for(int i =0;i<cust.size();i++){
								if (cust.get(i).getCustomerID().equals(customerID)){
									System.out.println("ID not UNIQUE");
									break outerloop;
								}
							}
							System.out.println("Enter name : ");
							name = console.next();
							System.out.println("Enter phone : ");
							phone = console.next();
							System.out.println("Enter discountRate : ");
							discountRate = console.nextDouble();
							cust.add(new CCustomer( customerID, name, phone,discountRate));
							System.out.println("Customer added to system\n");
						}
						else{
							System.out.println("wrong input, going back to menu!");
						}
						break;
					case 9:
						error = true;
//					      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//					      //read a line from the console
//					      String lineFromInput = in.readLine();
//
//					      //create an print writer for writing to a file
//					      PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
//
//					      //output to the file a line
//					      out.println(lineFromInput);
//
//					      //close the file (VERY IMPORTANT!)
//					      out.close();
//						for (int i = 0; i < vehs.size(); i++ ){
//							vehs.get(i).print();
//						}
						try(  PrintWriter out = new PrintWriter( "output.txt" )  ){
							for (int i = 0; i < vehs.size(); i++ ){
								out.println(vehs.get(i).toString());
							}
							for (int i = 0; i < cust.size(); i++ ){
								out.println(cust.get(i).toString());
							}
						}
						break;
				}
			}  catch (Exception e){
				System.out.println("invalid input try again!  "+e);
			}
		} while (!error);
//	
	}
	
	public static void menu(){
		System.out.printf("%22s\n","Management Menu");
		System.out.printf("Display All Cars%14s\n", "1");
		System.out.printf("Select Available Cars%9s\n", "2");
		System.out.printf("Hire Vehicle%18s\n", "3");
		System.out.printf("Complete Hire%17s\n", "4");
		System.out.printf("Service Vehicle%15s\n", "5");
		System.out.printf("Complete Service%14s\n", "6");
		System.out.printf("Add a vehicle%17s\n", "7");
		System.out.printf("Add a customere%15s\n", "8");
		System.out.printf("Exit%26s\n", "9");
		System.out.printf("%20s", "Your Choice : ");		
	}
	
	public static void vehsIDSelectmenu(){
		if (vehs.size()>0){
			System.out.println("select vehicle to continute");
			for (int i = 0; i < vehs.size(); i++ ){				
				System.out.print((i+1)+": " );
				System.out.println(vehs.get(i).getVehicleID());			
			}
			System.out.printf("your choice :");
		}
		else{
			System.out.println("there is no record for any vehicle in the system!");
		}
	}
	
	public static void hireIDSelect(){
		if (cust.size()>0){
			for (int i = 0; i < cust.size(); i++ ){
				System.out.println("select customer to continute");
				System.out.print((1+i)+": " );
				System.out.println(cust.get(i).getCustomerID());
				System.out.printf("your choice :");
			}
		}
		else{
			System.out.println("there is no record for any customer in the system!");
			
		}
	}
	
	public static int[] userInput1(){
		int lowerLimit = 0;
		int higherLimit = 0;
		boolean error = false;
		do{
			try{
				Scanner console = new Scanner(System.in);
				System.out.println("Enter lower : ");
				lowerLimit = console.nextInt();
				System.out.println("Enter higher : ");
				higherLimit = console.nextInt();
				if (higherLimit >= lowerLimit){
//					error = true;
					System.out.println("you entered lower as :" + lowerLimit);
					System.out.println("you entered higher as :" + higherLimit);
				}
				else{
					System.out.println("2nd number must be greater than 1st num!");
				}

			} catch (Exception e){
				System.out.println("invalid input try again!  "+e);
			}	
		}while (!error);
		return new int[]{lowerLimit, higherLimit};		
	}
	


	

}
