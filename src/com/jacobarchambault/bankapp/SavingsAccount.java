package com.jacobarchambault.bankapp;

import java.text.NumberFormat;

public final class SavingsAccount {
	private boolean status;
	private BankAccount account;

	public SavingsAccount(
			BankAccount ba) {
		account = ba;
	}

	public void deposit(double amount) {
		account.deposit(amount);
		if (!status) {
			if (account.getBalance() >= 25)
				status = true;
		}
	}

	/**
	 * The monthlyProcess method calls the super class's monthlyProcess method. If
	 * the number of withdrawals is greater than 4, the monthly service charges are
	 * increased.
	 */

	public void monthlyProcess() {
		double msc; // Monthly service charge
		if (account.getNumWithdrawals() > 4) {
			// Get the monthly service charges.
			msc = account.getMonthlyServiceCharges();
			// Increase the monthly service charges.
			account.setMonthlyServiceCharges(msc + (account.getNumWithdrawals() - 4));
			// Do the monthly processing.
			account.monthlyProcess();
			// Set the monthly charges back.
			account.setMonthlyServiceCharges(msc);
		} else
			account.monthlyProcess();
	}

	public void withdraw(double amount) {
		if (status) {
			account.withdraw(amount);
			if (account.getBalance() < 25)
				status = false;
		}
	}

	void printReceipt() {
		System.out.println("Balance: " + NumberFormat.getCurrencyInstance()
				.format(account.getBalance()));
		System.out.println("Number of deposits: " + account.getNumDeposits());
		System.out.println("Number of withdrawals: " + account.getNumWithdrawals());
		System.out.println();

	}
}
