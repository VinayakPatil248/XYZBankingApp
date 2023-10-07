package com.application.bank;
import java.util.*;

class SavingsAccount implements Account {
    private double balance;
    private int accNumber;
    private String accHolderName;
    private boolean isFrozen;
    private List<Double> transactions;
    private AccountType type;
    private static final double MIN_BALANCE = 10000;

    public SavingsAccount(AccountType type, int accountNumber) {
        this.balance = type.getInitialBalance();
        this.isFrozen = false;
        this.accNumber = accountNumber;
        this.accHolderName = type.getName();
        this.transactions = new ArrayList<>();
        this.type = type;
    }

    @Override
    public void deposit(double amount) {
    	if (verifyAccountNumber(accNumber)) {
            balance += amount;
            transactions.add(amount);
            System.out.println("Deposit of Rs. " + amount + " successful.");
        } else {
            System.out.println("Invalid account number.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (verifyAccountNumber(accNumber)) {
        	if (balance - amount >= MIN_BALANCE) {
                balance -= amount;
                transactions.add(-amount);
                System.out.println("Withdrawal of Rs. " + amount + " successful.");
            } else {
                System.out.println("Minimum Balance Rs.10000/- Required OR Insufficient funds!");
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }

    @Override
    public void calculateInterest() {
    	double interestRate = 0.03; // 3% interest rate (adjust as needed)
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest calculated for SavingsAccount: Rs. " + interest);
    }

    @Override
    public void checkFreezeStatus() {
    	if (isFrozen) {
            System.out.println("Savings account is frozen.");
        } else {
            System.out.println("Savings account is active.");
        }
    }

    @Override
    public String getAccountType() {
        return type.getaccType();
    }

    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
	public String getName() {
		return accHolderName;
	}

	@Override
    public int getaccNumber() {
    	return accNumber;
    }
    
    @Override
    public boolean verifyAccountNumber(int inputAccountNumber) {
        return inputAccountNumber == accNumber;
    }
    
    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction history for SavingsAccount:");
        for (Double transaction : transactions) {
            if (transaction > 0) {
                System.out.println("Deposit: Rs. " + transaction);
            } else {
                System.out.println("Withdrawal: Rs. " + Math.abs(transaction));
            }
        }
    }
}