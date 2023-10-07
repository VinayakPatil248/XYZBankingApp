package com.application.bank;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void calculateInterest();
    void checkFreezeStatus();
    String getAccountType();
    double getBalance();
    int getaccNumber();
    String getName();
    boolean verifyAccountNumber(int inputAccountNumber);
	void printTransactionHistory();
}
