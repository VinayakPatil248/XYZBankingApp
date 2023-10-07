package com.application.bank;
import java.util.*;

public class XYZBankingApplication {
	
    public static void main(String[] args) {
        System.out.println("Welcome to the XYZ Bank");
        Bank xyzBank = new Bank();
        Scanner scanner = new Scanner(System.in);
			while(true) {
			System.out.println("1. Create a New Account");
			System.out.println("2. Existing Customer Banking");
			System.out.println("3. End of Day Report");
			System.out.println("0. Exit From Application");
			System.out.println("Select your Choice:");
			int num = scanner.nextInt();
				switch(num)
				{
					case 1:
						createAccount(xyzBank);
						break;
					case 2:
						performAccountActions(xyzBank);
			            break;
					case 3:
						// Generate end-of-day report
						generateEndOfDayReport(xyzBank);
						break;
					case 0:
						System.out.println("Exiting from Bank Application!!....Visit Again");
						return;
					default:
			            System.out.println("Invalid choice. Please select a valid option.");
				}
			}
		}
    
     public static void createAccount(Bank bank)
     {	
    	 Scanner scanner = new Scanner(System.in);
			try {
			     System.out.println("Enter Your Name:");
				 String name = scanner.next();
				 System.out.println("Enter Your AccountNumber:");
				 int accNumber = scanner.nextInt();
			         System.out.println("1. Savings");
			         System.out.println("2. Salary");
			         System.out.println("3. Current");
			         System.out.println("4. Loan");
			         System.out.println("5. Exit");
			         System.out.println("Choose an account type to open:");

			         int accountChoice = scanner.nextInt();
			         AccountType selectedAccountType = null;

			         switch (accountChoice) {
			             case 1:
			            	 System.out.println("Enter Amount want to Deposite initially:");
			            	 double intBalance = scanner.nextInt();
			            	 if(intBalance >= 10000)
			            	 {
			            	 selectedAccountType = new AccountType("Savings",name,accNumber, intBalance, 0, 0);
			            	 }else
			            	 {
			            		 System.out.println("Minimum Balance Rs.10000/- is required to Open the Savings Account ");
			            	 }
			                 break;
			             case 2:
			            	 selectedAccountType = new AccountType("Salary",name,accNumber, 0, 0, 2); // Simulate 2 minutes
			                 break;
			             case 3:
			            	 selectedAccountType = new AccountType("Current",name,accNumber, 0, 5000.0, 0);
			                 break;
			             case 4:
			            	 System.out.println("Enter The Loan Amount:");
			            	 double loan = scanner.nextInt();
			            	 selectedAccountType = new AccountType("Loan",name,accNumber, -loan, 0, 0);
			                 break;
			             default:
			                 System.out.println("Invalid choice. Please select a valid option.");
			                 return;
			         }
			         bank.openAccount(selectedAccountType, accNumber);
			         System.out.println("Account created successfully!"); 
			 } catch (Exception e) {
			     System.out.println("Error: " + e.getMessage());
			 }
		}

    // Method to perform actions on a specific account
    public static void performAccountActions(Bank bank) {
        Scanner scanner = new Scanner(System.in);
			System.out.print("Enter your account number: ");
			int accountNumber = scanner.nextInt();

			Account selectedAccount = null;
			for (Account account : bank.getAccounts()) {
			    if (account.getaccNumber() == accountNumber) {
			        selectedAccount = account;
			        break;
			    }
			}

			if (selectedAccount == null) {
			    System.out.println("Account not found. Please enter a valid account number.");
			    return;
			}

			while (true) {
				System.out.println("Account Holder Name: " + selectedAccount.getName());
			    System.out.println("Account Number: " + selectedAccount.getaccNumber());
			    System.out.println("Account Type: " + selectedAccount.getAccountType());
			    System.out.println("Balance: " + selectedAccount.getBalance());
			    System.out.println("*****************************************************");
			    System.out.println("1. Deposit");
			    System.out.println("2. Withdraw");
			    System.out.println("3. Calculate Interest");
			    System.out.println("4. Check Freeze Status");
			    System.out.println("5. Print Transaction History");
			    System.out.println("6. Exit");
			    System.out.println("Enter What operation want to perform:");

			    int choice = scanner.nextInt();

			    switch (choice) {
			        case 1:
			            System.out.print("Enter deposit amount: ");
			            double depositAmount = scanner.nextDouble();
			            selectedAccount.deposit(depositAmount);
			            break;
			        case 2:
			            System.out.print("Enter withdrawal amount: ");
			            double withdrawAmount = scanner.nextDouble();
			            selectedAccount.withdraw(withdrawAmount);
			            break;
			        case 3:
			        	selectedAccount.calculateInterest();
			            break;
			        case 4:
			        	selectedAccount.checkFreezeStatus();
			            break;
			        case 5:
			        	selectedAccount.printTransactionHistory();
			            break;
			        case 6:
			            return;
			        default:
			            System.out.println("Invalid choice. Please select a valid option.");
			    }
			}
		}
    
    public static void generateEndOfDayReport(Bank bank) {
        System.out.println("End-of-Day Report:");
        for (Account account : bank.getAccounts()) {
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Account Number: " + account.getaccNumber());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("---------------------------------");
        }
    }
}