package com.developersdelicias.codesmells.primitive_obsession;

public class Payment {
	private final double amount;
	private final String description;

	private Payment(double amount, String description) {
		this.amount = amount;
		this.description = description;
	}

	public static Payment of(double amount, String description) {
		return new Payment(amount, description);
	}

	public Double amount() {
		return amount;
	}
}
