package com.application.bank;
import java.util.*;

class SalaryAccount implements Account {
    private double balance;
    private int accNumber;
    private String accHolderName;
    private boolean isFrozen;
    private List<Double> transactions;
    private Date lastTransactionDate;
    private AccountType type;
    private static final double MIN_BALANCE = 0;
    
    private Timer freezeTimer;

    public SalaryAccount(AccountType type, int accountNumber) {
        this.balance = type.getInitialBalance();
        this.isFrozen = false;
        this.accNumber = accountNumber;
        this.accHolderName = type.getName();
        this.transactions = new ArrayList<>();
        this.lastTransactionDate = new Date();
        this.type = type;
        
     // Schedule a timer task to check for inactivity
        scheduleInactivityCheck();
    }
    
    private void scheduleInactivityCheck() {
        freezeTimer = new Timer();
        long delay = 2 * 60 * 1000; // 2 minutes (for simulation)
        freezeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkInactivity();
            }
        }, delay);
    }
    
    private void checkInactivity() {
        long currentTime = new Date().getTime();
        long lastTransactionTime = lastTransactionDate.getTime();

        if (currentTime - lastTransactionTime >= 2 * 60 * 1000) { // 2 minutes (for simulation)
            isFrozen = true;
            System.out.println("Salary account is frozen due to inactivity for 2 minutes.");
        }
    }

    @Override
    public void deposit(double amount) {
    	if (verifyAccountNumber(accNumber)) {
            balance += amount;
            transactions.add(amount);
            lastTransactionDate = new Date();
            resetFreezeTimer();
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
                lastTransactionDate = new Date();
                resetFreezeTimer();
                System.out.println("Withdrawal of Rs. " + amount + " successful.");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }

    @Override
    public void calculateInterest() {
    	System.out.println("Salary accounts do not earn interest.");
    }

    @Override
    public void checkFreezeStatus() {
    	if (isFrozen) {
            System.out.println("Salary account is frozen.");
        } else {
            System.out.println("Salary account is active.");
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
        System.out.println("Transaction history for SalaryAccount:");
        for (Double transaction : transactions) {
            if (transaction > 0) {
                System.out.println("Deposit: Rs. " + transaction);
            } else {
                System.out.println("Withdrawal: Rs. " + Math.abs(transaction));
            }
        }
    }
    
    private void resetFreezeTimer() {
        freezeTimer.cancel();
        scheduleInactivityCheck();
    }
}