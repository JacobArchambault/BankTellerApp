package com.jacobarchambault.bankapp;

public final class SavingsAccount implements InterestBearingAccount {
	private BasicAccount account;
	private double apr; // Interest rate
	private boolean monthlyFeeAccrued;

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
	}

	@Override
	public void printBalance() {
		account.printBalance();		
	}

	@Override
	public void withdraw(double amount) {
			account.withdraw(amount);
			if (!monthlyFeeAccrued) {
				if (account.getBalance() < 300)
					monthlyFeeAccrued = true;				
			}
	}

}
