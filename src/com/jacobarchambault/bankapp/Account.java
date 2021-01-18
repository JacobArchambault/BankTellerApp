package com.jacobarchambault.bankapp;

public interface Account {
	public void deposit(double amount);

	public void printBalance();
	public void withdraw(double amount);
}
