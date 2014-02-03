import java.util.List;
import java.util.Scanner;

import com.dkt.Automobile.Automobile;
import com.dkt.Automobile.Bike;
import com.dkt.Automobile.Car;
import com.dkt.Automobile.Insurance;
import com.dkt.Automobile.InsuranceNotApplicableException;
import com.dkt.Automobile.Scooter;
import com.dkt.Automobile.Truck;

public class InsuranceManagementSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Insurance ins = new Insurance();
		Automobile auto1 = new Car(5, 200000, 1200);
		ins.addvehicle(auto1);
		 auto1 = new Bike(2,80000,100);
		 ins.addvehicle(auto1);
		 auto1 =new Truck(3,900000,1600);
		 ins.addvehicle(auto1);
		
		 auto1 = new Car(4,20000,1000);
		 ins.addvehicle(auto1);
		 auto1 = new Car(1,100000,1100);
		 ins.addvehicle(auto1);
		 auto1 = new Car(3,200000,1000);
		 ins.addvehicle(auto1);
		 Scanner scan=new Scanner(System.in);
		while(true){
		 System.out.println("give enginee cc:");
		 int cc =scan.nextInt();
		 System.out.println("give age:");
		 int age =scan.nextInt();
		 
		 
		List<Automobile> ls= ins.getAutoOfEngineAndAge(cc,age);
		for(Automobile a :ls){
			System.out.println("type:"+a.getClass().getName()+",engine:"+a.getEngineCc()+", age:"+a.getAge());
		}
		
		} 
		 
	/*	try {
			System.out.println("Insurance cost of auto1 -- "
					+ ins.getCostOfInsurance(auto1));
		} catch (InsuranceNotApplicableException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getReason());
			e.printStackTrace();
		}*/

	}

}
