package com.jacobarchambault.bankapp;

/**
 * This program demonstrates a solution to the BankAccount and SavingsAccount
 * Classes programming challenge.
 */
public class SavingsDemo {

	public static void main(String[] args) {
		// Create a SavingsAccount object with a $100 balance,
		// 3% interest rate, and a monthly service charge
		// of $2.50.
		SavingsAccount savings = new SavingsAccount(new BasicAccount(
				100.0), 0.03);

		// Display what we've got.
		savings.printReceipt();

		// Make some deposits.
		savings.deposit(25.00);
		savings.deposit(10.00);
		savings.deposit(35.00);

		// Display what we've done so far.
		savings.printReceipt();

		// Make some withdrawals.
		savings.withdraw(100.00);
		savings.withdraw(50.00);
		savings.withdraw(10.00);
		savings.withdraw(1.00);
		savings.withdraw(1.00);

		// Display what we've done so far.
		savings.printReceipt();
	}
}
