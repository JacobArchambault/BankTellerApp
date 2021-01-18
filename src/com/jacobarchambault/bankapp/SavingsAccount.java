package com.jacobarchambault.bankapp;

import java.text.NumberFormat;

public class SavingsAccount extends BankAccount {
	private boolean status;

	public SavingsAccount(
			double bal,
			double intRate,
			double mon) {
		super(
				bal,
				intRate,
				mon);
	}

	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		if (!status) {
			if (getBalance() >= 25)
				status = true;
		}
	}

	/**
	 * The monthlyProcess method calls the super class's monthlyProcess method. If
	 * the number of withdrawals is greater than 4, the monthly service charges are
	 * increased.
	 */

	@Override
	public void monthlyProcess() {
		double msc; // Monthly service charge
		if (getNumWithdrawals() > 4) {
			// Get the monthly service charges.
			msc = getMonthlyServiceCharges();
			// Increase the monthly service charges.
			setMonthlyServiceCharges(msc + (getNumWithdrawals() - 4));
			// Do the monthly processing.
			super.monthlyProcess();
			// Set the monthly charges back.
			setMonthlyServiceCharges(msc);
		} else
			super.monthlyProcess();
	}

	@Override
	public void withdraw(double amount) {
		if (status) {
			super.withdraw(amount);
			if (getBalance() < 25)
				status = false;
		}
	}

	void printReceipt() {
		System.out.println("Balance: " + NumberFormat.getCurrencyInstance()
				.format(getBalance()));
		System.out.println("Number of deposits: " + getNumDeposits());
		System.out.println("Number of withdrawals: " + getNumWithdrawals());
		System.out.println();

	}
}
