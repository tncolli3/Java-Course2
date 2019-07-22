import java.io.*;
import java.util.*;
// Assignment #:8
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35-9:25
//  Description: The ProjectManagement class contains methods to sort, search and edit
//               the project list

public class ProjectManagement implements Serializable
{
	private Project[] projectList;
	private int currentProjectsCount;
	private int maxSize;

	public ProjectManagement(int maximumsize)//constructor. Used to create ProjectManagement object and itialize variables
	{
		maxSize=maximumsize;
		projectList=new Project[maxSize];
		currentProjectsCount=0;
	}

	public int projectNumberExists(int projectNumber)//searches for the project number and returns the index
	{
		for(int i=0;i<currentProjectsCount;i++)
		{
			if(projectList[i].getProjNumber()==projectNumber)
			{
				return i;
			}
		}
		return -1;
	}

	public int managerExists(String firstName,String lastName,int deptNum)//uses linear search to find the manager
	{
		int pos=0;
		boolean found=false;
		while(pos<currentProjectsCount && !found)
		{
			String fName=projectList[pos].getProjManager().getFirstName();//gets managers first name
			String lName=projectList[pos].getProjManager().getLastName();//gets managers last name
			int dNum=projectList[pos].getProjManager().getDeptNum();//gets department number
			if(fName.equals(firstName) && lName.equals(lastName) &&dNum==deptNum)//searches for it in the array
			{
				found=true;
			}
			else
			{
				pos++;
			}
		}
		if(found)//returns position if found
		{
			return pos;
		}
		else//returns -1 if not found
			return -1;
	}

	public boolean addProject(String projTitle, int projNumber,String projLocation,String firstName,String lastName,int deptNum)
	//adds project if the project number does not already exist and if the array is not full
	{
		for(int i=0;i<currentProjectsCount;i++)
		{
			if((currentProjectsCount==maxSize)||(projectList[i].getProjNumber()==projNumber))
			{
				return false;
			}
		}

		Project proj=new Project();
		proj.setProjTitle(projTitle);
		proj.setProjNumber(projNumber);
		proj.setProjLocation(projLocation);
		proj.setProjManager(firstName,lastName,deptNum);

		currentProjectsCount++;//increments the project count
		projectList[currentProjectsCount-1]=proj;//adds the new project
		return true;
	}

	public boolean removeProjectNumber(int projectNumber)//removes a project by number if it is in the array
	{
		for(int i=0; i<currentProjectsCount;i++)
		{
			if(projectNumber==projectList[i].getProjNumber())
			{
				for(int j=i+1;j<currentProjectsCount;j++)
				{
					projectList[j-1]=projectList[j];
				}
				currentProjectsCount--;
				return true;
			}
		}
		return false;
	}

	public void sortByProjectNumber()//uses the project number comparator to sort the array using the sort method
	{
		ProjectNumberComparator num=new ProjectNumberComparator();
		Arrays.sort(projectList,0,currentProjectsCount,num);
	}

	public void sortByManager()//sorts by manager using the manager comparator
	{
		ManagerComparator man=new ManagerComparator();
		Arrays.sort(projectList,0,currentProjectsCount,man);
	}

	public String listProjects()//lists the objects on the screen
	{
		String str="\n";
		if(currentProjectsCount==0)
		{
			str="\nno project\n";
		}
		else
		{
			for(int i=0;i<currentProjectsCount;i++)
			{
				str+=projectList[i].toString();
			}
		}
		return str+"\n";
	}

	public void closeProjectManagement()//clears the project list
	{
		for(int i=0;i<currentProjectsCount;i++)
		{
			projectList[i]=null;
		}
		currentProjectsCount=0;
	}



}


