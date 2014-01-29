package com.dkt.Automobile;

public class Insurance {
	protected int costOfInsurance;
	protected int age;
	protected float discount;

	protected int getDiscountedCostOfInsurance(AutomobileInterface auto, int pcInsurance) {
		costOfInsurance = auto.getPrice() * pcInsurance / 100;
		System.out.println("Insurance %age: "+pcInsurance + ", Price: " + auto.getPrice());
		System.out.println("INitial cost of insurance: "+costOfInsurance);
		System.out.println("Price of Auto: " + auto.getPrice());
		discount = 0;
		System.out.println("Age: " + age);
		for (int i = 0; i < age - 1; i++) {
			discount = (float)10 / 100;
			System.out.println("Value of I: " + i);
			System.out.println("Discount calc.now: "+discount);
			costOfInsurance = costOfInsurance - (int)(costOfInsurance * discount);
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
			} else {
				System.out.println("Only supports 1000 and 1600cc automobiles");
			}

			} else {
				System.out.println("Insurnace cost can not be calculated");
			}
		return costOfInsurance;
	}
}
