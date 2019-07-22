// Assignment #: 4
// Name: Taylor Collins
// StudentID: 1213902038
// Lecture: 8:35
// Description: Manager class contains methods that will be used to create information about the project manager


public class Manager
{
	private String firstName; //declare instance variables
	private String lastName;
	private int deptNum;

	public Manager() //constructor. initizializes the instance variables to default values
	{
		firstName="?";
		lastName="?";
		deptNum=0;
	}

	public String getFirstName() //returns the first name of the manager
	{
		return firstName;
	}

	public String getLastName() //returns the last name of the manager
	{
		return lastName;
	}

	public int getDeptNum() //returns the department number
	{
		return deptNum;
	}

	public void setFirstName(String someFirstName) //sets the last name of the manager
	{
		firstName=someFirstName;
	}

	public void setLastName(String someLastName) //sets the managers last name
	{
		lastName=someLastName;
	}

	public void setDeptNum(int someDeptNum) //sets the department number of the manager
	{
		deptNum=someDeptNum;
	}


	public String toString() //stores the manager information in a stings and returns it
	{
		String str=firstName+" "+lastName+", Dept Num:"+deptNum;

		return str;
	}
}