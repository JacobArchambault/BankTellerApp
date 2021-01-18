package com.jacobarchambault.bankapp;

public final class BasicAccount implements Account {
	private double apr; // Interest rate
	private double balance; // Account balance
	private double monthlyServiceCharges; // Service charges
	private int numDeposits = 0; // Number of deposits
	private int numWithdrawals = 0; // Number of withdrawals

	public BasicAccount(
			double bal,
			double intRate,
			double mon) {
		balance = bal;
		apr = intRate;
		monthlyServiceCharges = mon;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		numDeposits++;
	}

	/**
	 * The getBalance method returns the account balance.
	 * 
	 * @return The account balance.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * The getInterestRate method returns the interest rate.
	 * 
	 * @return The interest rate.
	 */

	public double getInterestRate() {
		return apr;
	}

	/**
	 * The getMonthlyServiceCharges method returns the monthly service charges
	 * 
	 * @return The monthly service charges.
	 */
	public double getMonthlyServiceCharges() {
		return monthlyServiceCharges;
	}

	/**
	 * The getNumDeposits method returns the number of deposits.
	 * 
	 * @return The number of deposits.
	 */
	public int getNumDeposits() {
		return numDeposits;
	}

	/**
	 * The getNumWithdrawals method returns the number of withdrawals.
	 * 
	 * @return The number of withdrawals.
	 */

	public int getNumWithdrawals() {
		return numWithdrawals;
	}

	/**
	 * The monthlyProcess method subtracts the monthly service charge from the
	 * account balance and adds the monthly interest. The number of deposits and
	 * number of withdrawals are set to 0.
	 */

	public void monthlyProcess() {
		// Subtract the monthly service charges
		// from the balance.
		balance -= monthlyServiceCharges;

		// Calculate and add the interest for
		// the month.
		calcInterest();

		// Reset the number of deposits and
		// withdrawals to zero.
		numDeposits = 0;
		numWithdrawals = 0;
	}

	/**
	 * The setMonthlyServiceCharges method sets the monthly service charge to a
	 * specified amount.
	 * 
	 * @param m The amount of monthly service charge.
	 */
	public void setMonthlyServiceCharges(double m) {
		monthlyServiceCharges = m;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
		numWithdrawals++;
	}

	private void calcInterest() {
		// Get the monthly interest rate.
		double monIntRate = apr / 12;
		// Get the amount of interest for the month.
		double monInterest = balance * monIntRate;
		// Add the interest to the balance.
		balance += monInterest;
	}

}
