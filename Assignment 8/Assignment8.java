// Assignment #: 8
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35-9:25
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;
import java.util.*;

public class Assignment8
 {
  public static void main (String[] args)
   {
       char input1;
       String projTitle, projNumStr, projLocation, firstName, lastName, deptNumStr;
       int projNumber, deptNumber;

       boolean operation = false;
       int operation2 = 0;
       String line;
       String filename;

       // create a ProjectManagement object. This is used throughout this class.
       ProjectManagement manage1 = null;

       try
       {
           // print out the menu
           printMenu();

           // create a BufferedReader object to read input from a keyboard
           InputStreamReader isr = new InputStreamReader (System.in);
           BufferedReader stdin = new BufferedReader (isr);

           System.out.print("Please enter a maximum number of projects\n");
           String maxStr = stdin.readLine().trim(); //read in the max number as a string
           int max = Integer.parseInt(maxStr);
           manage1 = new ProjectManagement(max);

           do
           {
               System.out.print("What action would you like to perform?\n");
               line = stdin.readLine().trim();  //read a line
               input1 = line.charAt(0);
               input1 = Character.toUpperCase(input1);

               if (line.length() == 1)          //check if a user entered only one character
               {
                   switch (input1)
                   {
                       case 'A':   //Add Project
                           System.out.print("Please enter a project to add:\n");
                           System.out.print("Please enter its title to add:\n");
                           projTitle = stdin.readLine().trim();
                           System.out.print("Please enter its project number to add:\n");
                           projNumStr = stdin.readLine().trim();
                           projNumber = Integer.parseInt(projNumStr);
                           System.out.print("Please enter its project location to add:\n");
                           projLocation = stdin.readLine().trim();

                           System.out.print("Please enter its manager's first name to add:\n");
                           firstName = stdin.readLine().trim();
                           System.out.print("Please enter its manager's last name to add:\n");
                           lastName = stdin.readLine().trim();
                           System.out.print("Please enter its manager's department number to add:\n");
                           deptNumStr = stdin.readLine().trim();
                           deptNumber = Integer.parseInt(deptNumStr);

                           operation = manage1.addProject(projTitle, projNumber, projLocation,
                                                          firstName, lastName, deptNumber);
                           if (operation == true)
                               System.out.print("project added\n");
                           else
                               System.out.print("project not added\n");
                           break;
                       case 'C':  //Create a new project management
                           System.out.print("Please enter a new maximum number of projects:\n");
                           maxStr = stdin.readLine().trim(); //read in the max number as a string
                           max = Integer.parseInt(maxStr);
                           manage1 = new ProjectManagement(max);
                           break;
                       case 'D':  //Search by project number
                           System.out.print("Please enter project number to search:\n");
                           projNumStr = stdin.readLine().trim();
                           projNumber = Integer.parseInt(projNumStr);
                           operation2=manage1.projectNumberExists(projNumber);

                           if (operation2 > -1)
                               System.out.print("project number " + projNumber + " found\n");
                           else
                               System.out.print("project number " + projNumber + " not found\n");
                           break;
                       case 'E':  //Search by manager
                           System.out.print("Please enter the first name of a manager to search:\n");
                           firstName = stdin.readLine().trim();
                           System.out.print("Please enter the last name of a manager to search:\n");
                           lastName = stdin.readLine().trim();
                           System.out.print("Please enter the department number of a manager to search:\n");
                           deptNumStr = stdin.readLine().trim();
                           deptNumber = Integer.parseInt(deptNumStr);

                           operation2=manage1.managerExists(firstName, lastName, deptNumber);

                           if (operation2 > -1)
                           {
                               System.out.print("project manager "  + lastName + "," + firstName
                                            + " of the department " + deptNumber + " found\n");
                           }
                           else
                           {
                               System.out.print("project manager "  + lastName + "," + firstName
                                                + " of the department " + deptNumber + " not found\n");
                           }
                           break;
                       case 'L':   //List projects
                           System.out.print(manage1.listProjects());
                           break;
                       case 'O':  // Sort by project numbers
                           manage1.sortByProjectNumber();
                           System.out.print("sorted by project numbers\n");
                           break;
                       case 'P':  // Sort by manager information
                           manage1.sortByManager();
                           System.out.print("sorted by managers\n");
                           break;
                       case 'Q':   //Quit
                           break;
                       case 'R':  //Remove by project number
                           System.out.print("Please enter project number to remove:\n");
                           projNumStr = stdin.readLine().trim();
                           projNumber = Integer.parseInt(projNumStr);
                           operation=manage1.removeProjectNumber(projNumber);
                           if (operation == true)
                               System.out.print("project number " + projNumber + " removed\n");
                           else
                               System.out.print("project number " + projNumber + " not found\n");

                           break;
                       case 'T':  //Close ProjectManagement
                           manage1.closeProjectManagement();
                           System.out.print("project management system closed\n");
                           break;
                       case 'U':  //Write Text to a File
                           System.out.print("Please enter a file name to write:\n");
                           filename = stdin.readLine().trim();
                           System.out.print("Please enter a string to write in the file:\n");
                           line = stdin.readLine().trim();
                           try
                           {
							   File output=new File(filename);
							   PrintWriter pr=new PrintWriter(output);
							   pr.print(line+"\n");
							   pr.println();
							   System.out.print(filename+" was written\n");
							   pr.close();
						   }
						   catch(IOException exception)
						   {
							   System.out.print(filename+" was not found\n");
						   }



                           /************************************************************************************
                           ***  ADD your code to write a text (string) to the specified file. Catch exceptions.
                           ************************************************************************************/
                           break;
                       case 'V':  //Read Text from a File
                           System.out.print("Please enter a file name to read:\n");
                           filename = stdin.readLine().trim();
                           File input=null;
                           try
                           {
							   input=new File(filename);
							   Scanner read=new Scanner(input);
							   String contents=read.nextLine();
							   System.out.print(filename+" was read\n");
							   System.out.print("The first line of the file is:\n"+contents+"\n");
							   read.close();
						   }
						   catch(FileNotFoundException exception)
						   {
							   System.out.print(input+" was not found\n");
						   }

                           /************************************************************************************
                            ***  ADD your code to read a text (string) from the specified file. Catch exceptions.
                            ************************************************************************************/
                           break;
                   case 'W':  //Serialize ProjectManagement to a File
                           System.out.print("Please enter a file name to write:\n");
                           filename = stdin.readLine().trim();
                           File output=null;
                           try
                           {
							   output=new File(filename);
							   FileOutputStream file=new FileOutputStream(output);
							   ObjectOutputStream out=new ObjectOutputStream(file);
							   out.writeObject(manage1);
							   System.out.print(filename+" was written\n");
							   out.close();
						   }
						   catch(NotSerializableException exception)
						   {
							   System.out.print(filename+" was not found\n");
						   }

                           /************************************************************************************
                            ***  ADD your code to write the project management oject to the specified file. Catch exceptions.
                            ************************************************************************************/
                           break;
                       case 'X':  //Deserialize ProjectManagement from a File
                           System.out.print("Please enter a file name to read:\n");
                           filename = stdin.readLine().trim();
                           File read=null;
                           try
                           {
							   read=new File(filename);
							   FileInputStream file=new FileInputStream(read);
							   ObjectInputStream in=new ObjectInputStream(file);
							   manage1=(ProjectManagement)in.readObject();
							   System.out.print(filename+" was read\n");
							   in.close();
						   }
						   catch(ClassNotFoundException exception)
						   {
							   System.out.print(filename+" was not found\n");
						   }
						   catch(FileNotFoundException exception)
						   {
							   System.out.print(filename+" was not found\n");
						   }

                           /************************************************************************************
                            ***  ADD your code to read a project management object from the specified file. Catch exception.
                            ***********************************************************************************/
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
           } while (input1 != 'Q' || line.length() != 1);
       }
    catch (IOException exception)
       {
           System.out.print("IO Exception\n");
       }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Project\n" +
                      "C\t\tCreate ProjectManagement\n" +
                      "D\t\tSearch by Project Number\n" +
                      "E\t\tSearch by Manager\n" +
                      "L\t\tList Projects\n" +
                      "O\t\tSort by Project Number\n" +
                      "P\t\tSort by Manager\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove by Project Number\n" +
                      "T\t\tClose ProjectManagement\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize ProjectManagement to File\n" +
                      "X\t\tDeserialize ProjectManagement from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
}