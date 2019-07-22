// Assignment #: 4
// Name: Taylor Collins
// StudentID: 1213902038
// Lecture: 8:35
// Description:Contains the methods used to set up and create information about the project


public class  Project
{
	private String projTitle; //declare variables
	private int projNumber;
	private String projLocation;
	private Manager projManager;

	public Project() //constructor. Initializes variables to default values
	{
		projTitle="?";
		projNumber=0;
		projLocation="?";
		projManager=new Manager();
	}

	public String getProjTitle() //returns the name of the project
	{
		return projTitle;
	}

	public int getProjNumber() //returns the project number
	{
		return projNumber;
	}

	public Manager getProjManager() //returns the manager
	{
		return projManager;
	}

	public void setProjTitle(String aTitle) //sets the name of the project
	{
		projTitle=aTitle;
	}

	public void setProjNumber(int number) //sets the project number
	{
		projNumber=number;
	}

	public void setProjLocation(String aLocation) //sets the location of the project
	{
		projLocation=aLocation;
	}
	public void setProjManager(String someFirstName,String someLastName,int someDeptNum) //sets the project manager
	{
		projManager.setFirstName(someFirstName); //uses methods from the Manager class
		projManager.setLastName(someLastName);
		projManager.setDeptNum(someDeptNum);
	}

	public String toString() //stores the info of the project in a string and returns it when called
	{
		String project= "\nProject Title:\t\t"+projTitle+"\nProject Number:\t\t"+projNumber+"\nProject Location:\t"+projLocation+"\nProject Manager:\t"+projManager.toString()+"\n\n";
		return project;
	}
}


