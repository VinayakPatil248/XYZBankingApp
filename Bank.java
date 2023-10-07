package com.application.bank;
import java.util.*;

class Bank {
    private List<Account> accounts;
    private int maxAccounts = 10;
    
    public Bank() {
        this.accounts = new ArrayList<>();
    }
    
    public boolean hasReachedMaxAccounts() {
        return accounts.size() >= maxAccounts;
    }

    public void openAccount(AccountType type, int accountNumber) throws Exception {
            Account account;
            if (hasReachedMaxAccounts()) {
                throw new Exception("The bank has reached the maximum number of accounts (10).");
            }
            else
            {
            switch (type.getaccType()) {
                case "Savings":
                    account = new SavingsAccount(type, accountNumber);
                    break;
                case "Salary":
                    account = new SalaryAccount(type, accountNumber);
                    break;
                case "Current":
                    account = new CurrentAccount(type, accountNumber);
                    break;
                case "Loan":
                    account = new LoanAccount(type, accountNumber);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid account type.");
            }
            accounts.add(account);
           }
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
}