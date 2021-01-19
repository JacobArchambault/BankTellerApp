package com.jacobarchambault.bankapp;

import java.text.NumberFormat;

public final class BasicAccount implements Account {
	private double balance; // Account balance

	public BasicAccount(
			double bal) {
		balance = bal;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * The getBalance method returns the account balance.
	 * 
	 * @return The account balance.
	 */
	public double getBalance() {
		return balance;
	}

	@Override
	public void printBalance() {
		System.out.println("Balance: " + NumberFormat.getCurrencyInstance()
				.format(balance));
		System.out.println();

	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

}
