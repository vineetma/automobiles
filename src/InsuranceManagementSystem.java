
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.dkt.Automobile.Automobile;
import com.dkt.Automobile.Bike;
import com.dkt.Automobile.Bus;
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
		Scanner scan = new Scanner(System.in);

		/*
		 * Automobile auto1 = new Car(5, 200000, 1200); ins.addvehicle(auto1);
		 * auto1 = new Bike(2,80000,100); ins.addvehicle(auto1); auto1 =new
		 * Truck(3,900000,1600); ins.addvehicle(auto1);
		 * 
		 * auto1 = new Car(4,20000,1000); ins.addvehicle(auto1); auto1 = new
		 * Car(1,100000,1100); ins.addvehicle(auto1); auto1 = new
		 * Car(3,200000,1000); ins.addvehicle(auto1);
		 */
		while (true) {
			System.out.println("Select opion:");
			System.out.println("1 - Add Automobile");
			System.out.println("2 - Query");
			System.out.println("3 - List All");
			System.out.println("4 - Exit");
			int userSelection = scan.nextInt();

			switch (userSelection) {
			case 1: // add automobile
				while (true) {
					System.out.println("Add Automobile Menu");
					System.out.println("Select type from following:");
					String[] typeOfAutos = { "Car", "Bike", "Truck", "Bus" };
					int index = 1;
					for (String s : typeOfAutos) {
						System.out.println(index + " - " + s);
						index++;
					}
					int typeOfAuto = scan.nextInt();
					System.out.println("Give Engine: ");
					int engine = scan.nextInt();

					System.out.println("Give Age: ");
					int age = scan.nextInt();

					System.out.println("Give Price: ");
					int price = scan.nextInt();

					Automobile auto1;
					switch (typeOfAuto) {
					case 1:
						auto1 = new Car(age, price, engine);
						break;
					case 2:
						auto1 = new Bike(age, price, engine);
						break;
					case 3:
						auto1 = new Truck(age, price, engine);
						break;
					case 4:
						auto1 = new Bus(age, price, engine);
						break;
					default:
						auto1 = null;
						break;
					}
					ins.addvehicle(auto1);
					System.out.println("Automobile - "
							+ auto1.getClass().getName() + " added.");
					System.out.println("Cost of insurance is: "
							+ ins.getCostOfInsurance(auto1));
					File file = new File("c:/users/vineet/documents/test.txt");
					try {
						FileOutputStream fout = new FileOutputStream(file);
						fout.write(auto1.toString().getBytes());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out
							.println("Do you want to continue. Select one of the following: ");
					System.out.println("1 - Yes.. Continue Adding Automobiles");
					System.out.println("2 - Go to main menu");
					System.out.println("3 - Exit");
					int userChoice = scan.nextInt();
					if (userChoice == 1) {
						continue;
					}
					if (userChoice == 2) {
						break;
					}
					if (userChoice == 3) {
						System.out.println("Leaving for now..!! Bye");
						return;
					}
				}
				break;
			case 2: // query
				while (scan.hasNextLine()) {
					System.out.println("give enginee cc:");
					int cc = scan.nextInt();
					System.out.println("give age:");
					int age1 = scan.nextInt();

					List<Automobile> ls = ins.getAutoOfEngineAndAge(cc, age1);
					for (Automobile a : ls) {
						System.out.println("type:" + a.getClass().getName()
								+ ",engine:" + a.getEngineCc() + ", age:"
								+ a.getAge());
					}
					System.out
							.println("Do you want to continue. Select one of the following: ");
					System.out.println("1 - Yes.. Continue Adding Automobiles");
					System.out.println("2 - Go to main menu");
					System.out.println("3 - Exit");
					int userChoice = scan.nextInt();
					if (userChoice == 1) {
						continue;
					}
					if (userChoice == 2) {
						break;
					}
					if (userChoice == 3) {
						System.out.println("Leaving for now..!! Bye");
						return;
					}

				}
				break;
			case 3:
				ins.printAllAutomobile();
				break;
			case 4:
				System.out.println("Leaving for now..!! Bye");
				return;
			}

		}
		/*
		 * try { System.out.println("Insurance cost of auto1 -- " +
		 * ins.getCostOfInsurance(auto1)); } catch
		 * (InsuranceNotApplicableException e) { // TODO Auto-generated catch
		 * block System.out.println("Error: "+e.getReason());
		 * e.printStackTrace(); }
		 */

	}

}

