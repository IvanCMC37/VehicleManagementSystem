import java.util.*;

public class RealVehicle {


	
	public static void main(String args[]){
		int x =0;
		String vehicleIDInput = "";
		String hireIDInput = "";
		int odoReadingInput = 0;
		boolean moreTransCheck = false;
		String userYNInput = "";
		
		//SectionII -i
		Vehicle vehs[] = new Vehicle[5];
		vehs[0] = new Vehicle("SAM134","Toyota Camry 02", 45.00, 140000);
		vehs[1] = new Vehicle("QKO156","Honda Accord 04", 65.00, 125000);
		vehs[2] = new Vehicle("TUV178","Toyota Starlet 02", 35.00, 180000);
		vehs[3] = new Vehicle("SAG132","Toyota Avalon 05", 52.00, 190000);
		vehs[4] = new Vehicle("PRE342","Honda Civic 97", 35.00, 145000);
		
		//SectionII -ii
		for (int i = 0; i < vehs.length; i++ ){
			System.out.print("ID = "+vehs[i].getVehicleID());
			System.out.println("  Description = "+vehs[i].getDescription());
		}		
		
		//SectionII - iii
		int minMax[] = userInput1();	
		for (int i = 0; i < vehs.length; i++ ){
			if(vehs[i].getDailyRate() >= minMax[0] &&vehs[i].getDailyRate()<= minMax[1]){
				System.out.print("ID = "+vehs[i].getVehicleID());
				System.out.println("  Description = "+vehs[i].getDescription());
				x++;
			}			
		}
		if(x==0){
			System.out.println("Nothing match your choice!");
		}
		
		//SecrionII - iv + v

		Scanner console = new Scanner(System.in);
		do{
			try{
				System.out.print("Enter the vehicleID that you want to do operation on:");
				vehicleIDInput = console.next();
				for (int i = 0; i < vehs.length; i++ ){
					if(vehicleIDInput.equals(vehs[i].getVehicleID())){
						if(vehs[i].getStatus() == 'A'){
							System.out.print("Enter hireID to hire the vehicle : ");					
							hireIDInput = console.next();
							vehs[i].hire(hireIDInput);
							moreTransCheck =true;
							System.out.println(hireIDInput+" hired "+vehs[i].getVehicleID());
						}
						else if(vehs[i].getStatus()=='S'){
							System.out.print("Enter new odometer reading : ");
							odoReadingInput = console.nextInt();
							moreTransCheck =true;
							vehs[i].serviceComplete(odoReadingInput);
							System.out.println("service completed : "+vehs[i].getVehicleID());
						}
						else if (vehs[i].getStatus()=='H'){
							System.out.print("Enter new odometer reading : ");
							odoReadingInput = console.nextInt();
							moreTransCheck =true;
							vehs[i].hireComplete(odoReadingInput);
							System.out.println("completed hire : "+vehs[i].getVehicleID());
						}
					}
					else if (i == vehs.length-1 &&moreTransCheck ==false){
						System.out.println("No such vehicle exist! \n");
					}
				}
				System.out.print("Any more transactions?Y/N :");
				userYNInput = console.next();
				if (userYNInput.equals("N")){
					moreTransCheck =true;
				}
				else if (userYNInput.equals("Y")){
					moreTransCheck =false;
				}
				else{
					System.out.println("Wrong Input");
				}
			}catch(Exception e){
				System.out.println("invalid input try again!  "+e);
			}
		}while(!moreTransCheck);
		
		//sectionII vi
		for (int i = 0; i < vehs.length; i++ ){
			vehs[i].print();
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
					error = true;
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
