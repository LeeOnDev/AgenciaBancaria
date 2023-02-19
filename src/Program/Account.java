package Program;

import Model.Utils;

public class Account {
	
	private static int accountCounter = 1;
	
	private int accountNumber;
	private User user;
	private Double balance = 0.0;
	
	
	public Account( User user) {
	
		this.accountNumber = accountCounter;
		this.user = user;
		accountCounter +=1;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "\nAccountNumber: " + this.getAccountNumber() +
				"\nName: " + this.user.getName() +
				"\nNif: " + this.user.getNif() +
				"\nEmail: " + this.user.getEmail() +
				"\nBalance: " + Utils.doubleToString(this.getBalance()) +
				"\n";
	}
	
	public void deposit (Double value) {
		if(value > 0) {
			setBalance(getBalance() + value);
			System.out.println("Your deposit has been made successfully!!");
		}else {
			System.out.println("Unable to perform deposit operation!!");
		}
	}
	
	public void withdrawal (Double value) {
		if(value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			System.out.println("Sucessful bank withdrawal!!");
		}else {
			System.out.println("Failed to withdraw");
		}
	}
	
	public void bankTransfer(Account accountToDeposit, Double value) {
		if(value > 0 && this.getBalance()>= value) {
		setBalance(getBalance() - value);
		
		accountToDeposit.balance = accountToDeposit.getBalance() + value;
		System.out.println("Sucessful bank transfer!!");
	}else {
		System.out.println("Failed to transfer!!");
	}

	}
	}
