package com.dkt.Automobile;

import java.util.ArrayList;

public class Insurance {
	protected int costOfInsurance;
	protected int age;
	protected float discount;
	protected int lv;

	protected int getDiscountedCostOfInsurance(AutomobileInterface auto,
			int pcInsurance) {
		costOfInsurance = auto.getPrice() * pcInsurance / 100;
		System.out.println("Insurance %age: " + pcInsurance + ", Price: "
				+ auto.getPrice());
		System.out.println("INitial cost of insurance: " + costOfInsurance);
		System.out.println("Price of Auto: " + auto.getPrice());
		discount = 0;
		System.out.println("Age: " + age);
		for (int i = 0; i < age - 1; i++) {
			discount = (float) 10 / 100;
			System.out.println("Value of I: " + i);
			System.out.println("Discount calc.now: " + discount);
			costOfInsurance = costOfInsurance
					- (int) (costOfInsurance * discount);
			System.out.println("Cost Of Insurance: " + costOfInsurance);
		}
		System.out.println("Insurance effective price: " + costOfInsurance);
		return costOfInsurance;
	}

	public int getCostOfInsurance(AutomobileInterface auto) {
		age = auto.getAge();
		costOfInsurance = 0;
		if (auto.getNumOfWheels() == 2) {
			if (auto.getEngineCc() < 100) {
				this.getDiscountedCostOfInsurance(auto, 2);
			} else {
				System.out
						.println("Greater than 100cc twoWheelercannot be insured");
			}

		} else if (auto.getNumOfWheels() == 4) {
			if (auto.getEngineCc() == 1000) {

				if (age < 2) {
					this.getDiscountedCostOfInsurance(auto, 4);
				}
				if (age > 2) {
					this.getDiscountedCostOfInsurance(auto, 5);
				}
			} else if (auto.getEngineCc() == 1600) {

				if (age < 2) {
					this.getDiscountedCostOfInsurance(auto, 2);
				}
			
				if (age > 2) {
					this.getDiscountedCostOfInsurance(auto, 3);
				} 
			}else if (auto.getEngineCc() == 1400) {

				if (age < 2) {
					this.getDiscountedCostOfInsurance(auto, 6);
				}
				if (age > 2) {
					this.getDiscountedCostOfInsurance(auto, 5);
				}
			}
			else {
				System.out.println("Only supports 1000,1400 and 1600cc,  automobiles");
			}

		} else {
			System.out.println("Insurnace cost can not be calculated");
		}
		return costOfInsurance;
	}

	public int addvehicles() {
		// created empty arraylist with an initial capacity
		ArrayList<Integer> vehlist = new ArrayList<Integer>(5);

		// add method to add vehicle numbers
		vehlist.add(1);
		vehlist.add(2);
		vehlist.add(3);
		vehlist.add(4);

		// printing all elements in the list
		for (Integer veh : vehlist) {
			System.out.println("Vehicle registration :" + veh);
		}
		return addvehicles();
	}

	public int getpremiumabove1000cc(AutomobileInterface auto)    
		{
			int prem;
			if(auto.getEngineCc()==1000)
			{
				//Premium formula
				(prem = dateofpurchase*claimifany/total timeperiod of car);
				System.out.println("Premium is :" +prem);
			}
			else
			{
				System.out.println("Your Vehicle is not 1000 CC vehicle");
			}
			return getCostOfInsurance(auto);
		}
}
