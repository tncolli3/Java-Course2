// Assignment #: 5
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35
//  Description: This creates a credit card account and defines the abstract methods of BankAccount.java

public class CreditcardAccount extends BankAccount
{
	private int creditLimitPennies;
	public CreditcardAccount(int balance,double interestRate,String accountNum,int creditcardLimit)//constructor
	{
		super(balance,interestRate,accountNum);//use parent class
		creditLimitPennies=creditcardLimit;//set credit limit
	}

	public boolean debit(int amountInPennies)//subtract the amount from the credit account as long as it is not greater than the credit limit
	{
		boolean operation=true;
		if((amountInPennies>creditLimitPennies)||((balanceInPennies-amountInPennies)<(creditLimitPennies*(-1))))//or if the balance will be greater than the negative credit limit
		{
			operation=false;
		}
		else
		{
			balanceInPennies-=amountInPennies;
		}
		return operation;
	}

	public void applyInterest()//applies interest only if the balance is negative
	{
		if(balanceInPennies<0)
		{
			balanceInPennies+=(balanceInPennies*interestRate);
		}
	}

	public String toString()//returns a string of information about the creditcard account
	{
		String credit="\nAccount type\t:\tCreditcard"+super.toString()+"Credit limit\t:\t"+fmt.format((creditLimitPennies*.01))+"\n";
		return credit;
	}
}
