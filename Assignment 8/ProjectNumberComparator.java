import java.util.*;
// Assignment #:8
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35-9:25
//  Description: The ProjectNumberComparator class defines the compare method
//               so it compares the project number of two projects

public class ProjectNumberComparator implements Comparator<Project>
{
	private int numDifference=0;//intialize variable to hold the difference between the numbers
	public int compare( Project first, Project second)//returns the difference between the numbers
	{
		numDifference=first.getProjNumber()-second.getProjNumber();//subtract the project numbers
		return numDifference;
	}
}