package com.jacobarchambault.bankapp;

public final class SavingsAccount implements InterestBearingAccount {
	private BasicAccount account;
	private double apr; // Interest rate
	private boolean status;

	public SavingsAccount(
			BasicAccount ba,
			double intRate) {
		account = ba;
		apr = intRate;
	}

	@Override
	public void calcInterest() {;
		// Add the interest to the balance.
		deposit(account.getBalance() * (apr / 12));
	}

	@Override
	public void deposit(double amount) {
		account.deposit(amount);
		if (!status) {
			if (account.getBalance() >= 300)
				status = true;
		}
	}

	@Override
	public void printBalance() {
		// TODO Auto-generated method stub
		account.printBalance();		
	}

	@Override
	public void withdraw(double amount) {
		if (status) {
			account.withdraw(amount);
			if (account.getBalance() < 300)
				status = false;
		}
	}

}
