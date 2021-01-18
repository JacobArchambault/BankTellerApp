package com.jacobarchambault.bankapp;

import java.text.NumberFormat;

public final class SavingsAccount implements Account {
	private double apr; // Interest rate
	private BasicAccount account;
	private boolean status;

	public SavingsAccount(
			BasicAccount ba,
			double intRate) {
		account = ba;
		apr = intRate;
	}

	private void calcInterest() {
		// Get the monthly interest rate.
		double monIntRate = apr / 12;
		// Get the amount of interest for the month.
		double monInterest = account.getBalance() * monIntRate;
		// Add the interest to the balance.
		deposit(monInterest);
	}

	@Override
	public void deposit(double amount) {
		account.deposit(amount);
		if (!status) {
			if (account.getBalance() >= 25)
				status = true;
		}
	}

	@Override
	public void withdraw(double amount) {
		if (status) {
			account.withdraw(amount);
			if (account.getBalance() < 25)
				status = false;
		}
	}

	void printBalance() {
		System.out.println("Balance: " + NumberFormat.getCurrencyInstance()
				.format(account.getBalance()));
		System.out.println();

	}
}
