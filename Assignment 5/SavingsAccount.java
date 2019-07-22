// Assignment #: 5
//         Name:Taylor Collins
//    StudentID:121302038
//      Lecture:MWF 8:35
//  Description: this creates a savings account and defines the abstract methods of BankAccount.java

public class SavingsAccount extends BankAccount
{
	private int overdraftFeePennies;
	public SavingsAccount(int balance, double interestrate,String accountNum)//constructor creates a savings account
	{
		super(balance,interestrate,accountNum);//calls the parent class to create the object

	}

	public boolean debit(int amountInPennies)//subtracts the amount entered as long as it is not greater than the balance
	{
		boolean operation=false;

		if(amountInPennies<=balanceInPennies)
		{
			operation=true;
			balanceInPennies-=amountInPennies;
		}

		return operation;
	}

	public void applyInterest()//applies interest to the account if the balance is positive
	{
		if(balanceInPennies>0)
		{
			balanceInPennies+=(balanceInPennies*interestRate);
		}
	}

	public String toString()//returns a string of information
	{
		String accountInfo="\nAccount type\t:\tSavings"+super.toString();//uses the super class to return information
		return accountInfo;
	}
}
