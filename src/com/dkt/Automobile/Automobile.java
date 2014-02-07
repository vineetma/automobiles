package com.dkt.Automobile;

import java.io.Serializable;

public abstract class Automobile implements AutomobileInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8609739931372457928L;
	protected int price;
	protected int engineCC;
	protected int age;
	public Automobile() {
		
	}
	public Automobile(int a, int p,int e){
		this.age=a;
		this.price=p;
		this.engineCC=e;
		
	}
	
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	
	public int getEngineCc() {
		// TODO Auto-generated method stub
		return engineCC;
	}

	
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}


}
