package com.techelevator.exceptions;

// By extending the Exception class, we make a checked exception
// By extending the RuntimeException we make an UNCHECKED exception
public class OverdraftException extends Exception {

	private double overdraftAmount = 0;
	
	public OverdraftException(String message, double overdraftAmount) {
		super(message);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
