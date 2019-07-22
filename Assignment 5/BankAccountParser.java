// Assignment #: 5
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35
//  Description: This account reads in information from a string and creates a bank account based on the information given

public class BankAccountParser
{
	public static BankAccount parseStringToBankAccount(String lineToParse)//constructor
	{
		BankAccount accountType=null;//bank account object
		String[] account=new String[5];//create an array to store the information from the string
		account=lineToParse.split("/");

		if(account[0].equals("SA")||account[0].equals("sa"))//creates an object depending on what is located at account[0]
		{
			accountType=new SavingsAccount(Integer.parseInt(account[3]),Double.parseDouble(account[2]),account[1]);//creates savings account
		}
		else if(account[0].equals("CH")||account[0].equals("ch"))//creates checking account
		{
			accountType= new CheckingAccount(Integer.parseInt(account[3]),Double.parseDouble(account[2]),account[1],Integer.parseInt(account[4]));
		}
		else if(account[0].equals("CR")||account[0].equals("cr"))//creates credit account
		{
			accountType=new CreditcardAccount(Integer.parseInt(account[3]),Double.parseDouble(account[2]),account[1],Integer.parseInt(account[4]));
		}
		return accountType;//returns account
	}
}
