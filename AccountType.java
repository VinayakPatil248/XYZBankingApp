package com.application.bank;

class AccountType {
    private String accType;
    private String name;
    private int accNumber;
    private double initialBalance;
    private double overdraftLimit;
    private int freezeDurationMinutes;

    public AccountType(String accType, String name, int accNumber, double initialBalance, double overdraftLimit, int freezeDurationMinutes) {
        this.accType = accType;
        this.name=name;
        this.accNumber=accNumber;
        this.initialBalance = initialBalance;
        this.overdraftLimit = overdraftLimit;
        this.freezeDurationMinutes = freezeDurationMinutes;
    }

    public String getaccType() {
        return accType;
    }
    
    public String getName() {
		return name;
	}

	public int getaccNumber()
    {
    	return accNumber;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public int getFreezeDurationMinutes() {
        return freezeDurationMinutes;
    }
}
