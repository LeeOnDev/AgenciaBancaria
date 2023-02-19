package Program;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBAncaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Account> bankAccounts;
	
	public static void main(String[] args) {
		bankAccounts = new ArrayList<Account>();
		operations();
	}
	
	public static void operations() {
		System.out.println("_________________________________________________________________");
		System.out.println("__________________Welcome to our Agency__________________________");
		System.out.println("_________________________________________________________________");
		System.out.println("************* Select one operation please  **********************");
		System.out.println("_________________________________________________________________");
		System.out.println("|  Option 1 - Creat an account  |");
		System.out.println("|  Option 2 -     Deposit       |");
		System.out.println("|  Option 3 -   Withdrawal      |");
		System.out.println("|  Option 4 -     Transfer      |");
		System.out.println("|  Option 5 -     All List      |");
		System.out.println("|  Option 6 -      Exit         |");
		
		
		int operation = input.nextInt();
		
		switch(operation) {
		case 1:
			creatAccount();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdrawal();
			break;
		case 4:
			transfer();
			break;
		case 5:
			allList();
			break;
		case 6:
			System.out.println("Thank you, see you soon!!");
			System.exit(0);
			
			default:
				System.out.println("Invalid option!!");
				operations();
				break;
		}
		
	}
	
	public static void creatAccount() {
		System.out.println("\nName: ");
		String name = input.next();
		
		System.out.println("\nNif: ");
		String nif = input.next();
		
		System.out.println("\nEmail: ");
		String email = input.next();
		
		User user = new User(name, nif,email );
		
		Account account = new Account(user);
		
		bankAccounts.add(account);
		System.out.println("Your account was sucessful created!");
		operations();
		
		}
	public static Account findAccount(int accountNumber) {
		Account account = null;
		if (bankAccounts.size()> 0) {
			for(Account c: bankAccounts) {
				if(c.getAccountNumber() == accountNumber);
				account = c;
			}
		}
		return account;
	}
	
	public static void deposit() {
		System.out.println("Account number: ");
		int accountNumber = input.nextInt();
		
		Account account = findAccount(accountNumber);
		
		if(account != null) {
			System.out.println("How much do you want to deposit? ");
			Double depositValue = input.nextDouble();
			account.deposit(depositValue);
			System.out.println("Sucessful deposit!");
		}else {
			System.out.println(" Account not found!");
		}
		operations();
	}
	
	public static void withdrawal() {
		 System.out.println("Account number: ");
		 int accountNumber = input.nextInt();
		 
		 Account account = findAccount(accountNumber);
		 
		 if(account != null) {
			 System.out.println("How much do you want to withdrawal? ");
			 Double withdrawValue = input.nextDouble();
			 account.withdrawal(withdrawValue);
			 System.out.println("Sucessful withdrawal!");
		 }else {
			 System.out.println("Account not found!");
		 }
		 operations();
	}
	public static void transfer() {
		System.out.println("sender account number: ");
		int accountNumberSender = input.nextInt();
		
		Account accountSender = findAccount(accountNumberSender);
		
		if(accountSender != null) {
			System.out.println("Receiver Account Number: ");
			int recipientAccountNumber = input.nextInt();
			
			Account recipientAccount = findAccount(recipientAccountNumber);
			
			if(recipientAccount != null) {
				System.out.println("Tranfer value is: ");
				Double value = input.nextDouble();
				
				accountSender.bankTransfer(recipientAccount, value);
			}
		}
		operations();
	}
	
	public static void allList() {
		if(bankAccounts.size() > 0) {
			for(Account account: bankAccounts) {
				System.out.println(account);
			}
		}else {
			System.out.println("No accounts finded!");
		}
		operations();
	}
	
}
