package com.dkt.Automobile;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class Insurance {
	protected int costOfInsurance;
	protected int age;
	protected float discount;
	

	protected ArrayList<Automobile> vehlist ;
	public  Insurance(){
		this.vehlist=new ArrayList<Automobile>();
		
	}

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


	public void addvehicle(Automobile a) {
		
		this.vehlist.add(a);

		
		
		

		
	}
public void printAllAutomobile(){
	

	ListIterator<Automobile> it1=vehlist.listIterator();
	while(it1.hasNext()){
		Automobile t=it1.next();
	System.out.println("type:"+t.getClass().getName()+",engine:"+t.getEngineCc()+", age:"+t.getAge());
	
			
				
}
	}
	public int getpremiumabove1000cc(AutomobileInterface auto)    
		{
			int prem;
			if(auto.getEngineCc()==1000)
			{
				//Premium formula
		//		(prem = dateofpurchase*claimifany/total timeperiodofcar);
		//		System.out.println("Premium is :" +prem);
			}
			else
			{
				System.out.println("Your Vehicle is not 1000 CC vehicle");
			}
			return getCostOfInsurance(auto);
		}
	public List<Automobile> getAutoOfEngineAndAge(int cc, int age){
		List<Automobile> selList=new ArrayList<Automobile>();
		
		for(Automobile a:vehlist){
			if(a.getEngineCc()==cc && a.getAge()>age){
				selList.add(a);
				
			}
			else {
				
			}
			
		}
		return selList;
		
		
		
	}

	public void writeObject(ObjectOutputStream out) {
		// TODO Auto-generated method stub
		for(Automobile a:vehlist) {
			try {
				out.writeObject(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
