package com.dkt.Automobile;

public class InsuranceNotApplicableException extends Exception {

	/**
	 * 
	 */
	String reason;
	public InsuranceNotApplicableException(String reason) {
		this.reason = reason;
	}
	public String getReason() {
		return this.reason;
	}
	private static final long serialVersionUID = 3330832260637323521L;
	
}
