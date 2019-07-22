// Assignment #: 5
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35
//  Description: The Assignment 5 class displa ys a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5
 {
  public static void main (String[] args)
     {
     // ArrayList object is used to store account objects
     ArrayList accountList = new ArrayList();

     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

          String line, inputInfo;
       boolean operation = false;
       char input1;
       do
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add BankAccount
                    System.out.print("Please enter some account information to add:\n");
                    inputInfo = stdin.readLine().trim();
                    accountList.add(BankAccountParser.parseStringToBankAccount(inputInfo));
                    break;
             case 'C':   //Make Credit
                    System.out.print("Account number to make credit:\n");
                    String accountNumber = stdin.readLine().trim();
                    System.out.print("Amount (in pennies) to make credit:\n");
                    int amount = Integer.parseInt(stdin.readLine().trim());
					for(int i=0;i<accountList.size();i++)
					{
						if(((BankAccount)accountList.get(i)).getAccountNumber().equals(accountNumber))
						{
							operation=((BankAccount)accountList.get(i)).credit(amount);
							break;
						}
						else
						{
							operation=false;
						}
					}
                    /***********************************************************************************
                     ***  ADD your code here to credit the specified account with the amount
                     ***********************************************************************************/

                if (operation)
                    System.out.print("credit performed\n");
                else
                    System.out.print("credit not performed\n");
               break;
              case 'D':   //Make Debit
                    System.out.print("Account number to make debit:\n");
                    String accountNumber2 = stdin.readLine().trim();
                    System.out.print("Amount (in pennies) to make debit:\n");
                    int amount2 = Integer.parseInt(stdin.readLine().trim());
					for(int i=0;i<accountList.size();i++)
					{
						if(((BankAccount)accountList.get(i)).getAccountNumber().equals(accountNumber2))
						{
							operation=((BankAccount)accountList.get(i)).debit(amount2);
							break;
						}
						else
						{
							operation=false;
						}
					}
                    /***********************************************************************************
                     ***  ADD your code here to debit the specified account with the amount
                     ***********************************************************************************/

                    if (operation)
                        System.out.print("debit performed\n");
                    else
                        System.out.print("debit not performed\n");
                    break;
             case 'I':    //Apply Monthly Interest
					for(int i=0;i<accountList.size();i++)
					{
						((BankAccount)accountList.get(i)).applyInterest();
					}
                    /***********************************************************************************
                     ***  ADD your code here to apply monthly interest to each account in the acountList.
                     ***********************************************************************************/

                    System.out.print("monthly interest applied\n");
                    break;
             case 'L':   //List BankAccounts
                   	for(int i=0;i<accountList.size();i++)
					{
						System.out.println(accountList.get(i).toString());
					}
					if(accountList.isEmpty())
					{
						System.out.println("no account\n");
					}
                    /***********************************************************************************
                     ***  ADD your code here to print out all objects in the bank account list.
                     ***  If there is no account, print "no account\n"
                     ***********************************************************************************/

                    break;
             case 'Q':   //Quit
                    break;
             case 'T':   //Transfer Fund
                    System.out.print("Account number to transfer funds FROM - \n");
                    String fromAccountNumber = stdin.readLine().trim();
                    System.out.print("Account number to transfer funds TO - \n");
                    String toAccountNumber = stdin.readLine().trim();
                    System.out.print("Amount (in pennies) to transfer:\n");
                    int amount3 = Integer.parseInt(stdin.readLine().trim());

                    BankAccount fromAccount = null, toAccount = null;
					for(int i=0;i<accountList.size();i++)
					{
						if(((BankAccount)accountList.get(i)).getAccountNumber().equals(toAccountNumber))
						{
							toAccount=((BankAccount)accountList.get(i));
						}
						if(((BankAccount)accountList.get(i)).getAccountNumber().equals(fromAccountNumber))
						{
							fromAccount=((BankAccount)accountList.get(i));
						}
					}
                    /***********************************************************************************
                     ***  ADD your code here to debit the specified account with the amount
                     ***********************************************************************************/

                    if (toAccount != null && fromAccount != null && fromAccount.getBalanceInPennies() >= amount3) {
                        fromAccount.debit(amount3);
                        toAccount.credit(amount3);
                        System.out.print("transfer performed\n");
                        }
                    else
                        System.out.println("*** transfer failed - Invalid account number or insufficient funds!");
                    break;
             case '?':   //Display Menu
                    printMenu();
                    break;
             default:
                    System.out.print("Unknown action\n");
                    break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }

  /** The method printMenu displays the menu to a use **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd BankAccount\n" +
                      "C\t\tMake Credit\n" +
                      "D\t\tMake Debit\n" +
                      "I\t\tApply Monthly Interest\n" +
                      "L\t\tList BankAccounts\n" +
                      "Q\t\tQuit\n" +
                      "T\t\tTransfer Fund\n" +
                      "?\t\tDisplay Help\n\n");
  }
}
