import java.text.*;
// Assignment #: 5
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35
//  Description: this abstract method contains several methods that will be used to manipulate the different accounts

public abstract class BankAccount
{ //declare variables and decimal format
	protected int balanceInPennies;
	protected double interestRate;
	protected String accountNumber;
	DecimalFormat fmt=new DecimalFormat("0.00");

	public BankAccount(int balance,double interestRate, String accountNum)//constructor instantiates the variables
	{
		balanceInPennies=balance;
		this.interestRate=interestRate;
		accountNumber=accountNum;
	}

	public String getAccountNumber()//returns the account number
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNo)//sets the account number
	{
		accountNumber=accountNo;
	}

	public int getBalanceInPennies()//returns the balance in pennies
	{
		return balanceInPennies;
	}

	public boolean credit(int amountPennies)//adds the amount desired to the total balance and returns true if successful
	{
		boolean operation;
		if(amountPennies>0)//the amount must be positive
		{
			balanceInPennies+=amountPennies;
			operation=true;
		}
		else
		{
			operation=false;
		}
		return operation;
	}

	public abstract boolean debit(int amountPennies);//abstract method that will be defined in each child class

	public double getInterestRate()//returns the interest rate
	{
		return interestRate;
	}
	public void setInterestRate(double rate)//sets the interest rate to a value entered by the user
	{
		interestRate=rate;
	}

	public abstract void applyInterest();

	public String toString()//stores all of the information in a string
	{
		String str="\nAccount ID\t:\t"+accountNumber+"\nBalance\t\t:\t"+fmt.format(balanceInPennies*.01)+"\nInterest rate\t:\t"+fmt.format(interestRate)+"\n";
		return str;
	}
}
