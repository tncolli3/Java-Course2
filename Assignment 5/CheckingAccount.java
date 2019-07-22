// Assignment #: 5
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35
//  Description: This class creates a checking account and defines the abstract methods of BankAccount.java

public class CheckingAccount extends BankAccount
{
	private int overdraftFeePennies;

	public CheckingAccount(int balance,double interestRate,String accountNum,int overdraftFeeInPennies)//constructor
	{
		super(balance,interestRate,accountNum);//uses parent class to create object
		overdraftFeePennies=overdraftFeeInPennies;
	}

	public boolean debit(int amountInPennies)//if the amount in pennies is greater than the balance, an overdraft fee will be subtracted along with the amount
	{
		boolean operation=false;
		if(amountInPennies<balanceInPennies)
		{
			balanceInPennies-=amountInPennies;
			operation=true;
		}
		else
		{
			balanceInPennies-=(overdraftFeePennies+amountInPennies);
		}
		return operation;//returns boolean value
	}

	public void applyInterest()//applies interes only if the balance is positive
	{
		if(balanceInPennies>0)
		{
			balanceInPennies+=(balanceInPennies*interestRate);
		}
	}

	public String toString()//returns a string of information about checking account
	{
		String checking="\nAccount type\t:\tChecking"+super.toString()+"Overdraft fee\t:\t"+fmt.format((overdraftFeePennies*.01))+"\n";
		return checking;
	}
}