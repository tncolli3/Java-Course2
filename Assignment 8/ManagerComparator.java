import java.util.*;
// Assignment #:8
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35-9:25
//  Description: The ManagerComparator class defines the compare method
//               so it compares the manager of two projects based on dept number,and full name

public class ManagerComparator implements Comparator<Project>
{
	private int deptComparison=0,fNameComp=0,lNameComp=0;//initializes variables that keep track of the different comparions

	public int compare(Project first,Project second)//compares the different parts of a manager starting with numbers then first and last names if necessary
	{
		Manager firstMan=first.getProjManager(),secondMan=second.getProjManager();//creates two managers from the projects
		deptComparison=firstMan.getDeptNum()-secondMan.getDeptNum();//compares the numbers
		if(deptComparison>0 || deptComparison<0)
		{
			return deptComparison;
		}
		else
		{
			fNameComp=firstMan.getFirstName().compareTo(secondMan.getFirstName());
			if(fNameComp>0||fNameComp<0)
			{
				return fNameComp;
			}
			else
			{
				lNameComp=firstMan.getLastName().compareTo(secondMan.getLastName());
				if(lNameComp>0||lNameComp<0)
					return lNameComp;
				else
				{
					return 0;
				}
			}
		}
	}
}