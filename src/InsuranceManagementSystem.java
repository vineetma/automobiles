import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		boolean fileOutOpen = true;

		FileOutputStream fileOut = null;
		ObjectOutputStream out1 = null;

		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		boolean fileInOpen = true;
		try {
			fileIn = new FileInputStream("f1.ser");
			in = new ObjectInputStream(fileIn);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			fileInOpen = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fileInOpen = false;
		}
		if (fileInOpen) {
			Automobile auto2 = null;
			boolean doneWithReading = false;
			while (!doneWithReading) {
				try {
					auto2 = (Automobile) in.readObject();
					ins.addvehicle(auto2);
					System.out.println("Added a veihcle: "+auto2.getClass().toString()+","+auto2.getEngineCc());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Done with reading");
					doneWithReading = true;
				}
			}
		}

		if (fileInOpen) {
			ins.printAllAutomobile();
			try {
				in.close();
				fileIn.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

		try {
			fileOut = new FileOutputStream("f1.ser");
			out1 = new ObjectOutputStream(fileOut);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fileOutOpen = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fileOutOpen = false;
		}
		if (!fileOutOpen)
			System.out.println("Unable to write..");
		do {
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
						if (fileOutOpen) 
							ins.writeObject(out1);
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
				if (fileOutOpen) 
						ins.writeObject(out1);

				System.out.println("Leaving for now..!! Bye");
				return;
			}

		} while (scan.hasNext());

		if (fileOutOpen) {
			try {
				out1.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
