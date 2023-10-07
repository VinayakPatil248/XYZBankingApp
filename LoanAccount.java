package com.application.bank;
import java.util.*;

class LoanAccount implements Account {
	private double balance;
	private int accNumber;
	private String accHolderName;
    private List<Double> transactions;
    private AccountType type;

    public LoanAccount(AccountType type, int accountNumber) {
    	this.balance = type.getInitialBalance();
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
            System.out.println("Loan repayment of Rs. " + amount + " is successful.");
        } else {
            System.out.println("Invalid account number.");
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("You cannot Withdraw from the Loan Account");
    }

    @Override
    public void calculateInterest() {
    	double interestRate = 9.5; // 9.5% interest rate (adjust as needed)
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest calculated for LoanAccount: Rs. " + interest);
    }

    @Override
    public void checkFreezeStatus() {
    	System.out.println("Current account does not have freeze status.");
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
    public int getaccNumber() {
    	return accNumber;
    }
    
    @Override
	public String getName() {
		return accHolderName;
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