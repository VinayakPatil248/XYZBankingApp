package com.application.bank;
import java.util.*;

class CurrentAccount implements Account {
    private double balance;
    private int accNumber;
    private String accHolderName;
    private double overdraftLimit;
    private List<Double> transactions;
    private AccountType type;

    public CurrentAccount(AccountType type, int accountNumber) {
        this.balance = type.getInitialBalance();
        this.overdraftLimit = type.getOverdraftLimit();
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
        	if (balance + overdraftLimit >= amount) {
                balance -= amount;
                transactions.add(-amount);
                System.out.println("Withdrawal of Rs. " + amount + " successful.");
            } else {
                System.out.println("Withdrawal amount exceeds the overdraft limit of Rs.5000/-");
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }

    @Override
    public void calculateInterest() {
    	System.out.println("Current accounts do not earn interest.");
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