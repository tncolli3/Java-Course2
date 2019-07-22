import java.util.*;
// Assignment #:8
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35-9:25
//  Description: The Sorts class uses insertion sort and a comparator object
//               to sort the project list
public class Sorts
{
	public static void sort(Project[]projectList,int size,Comparator<Project> other)//sorts the projects based on what comparator is used
	{//uses insertion sort
		for (int index = 1; index < size; index++)
		{
			Project key = projectList[index];
			int position = index;

		         // shift larger values to the right
			while (position > 0 && other.compare(projectList[position],projectList[position-1])<0 && projectList[position]!=null)
			{
				projectList[position] = projectList[position-1];
				position--;
			}

			projectList[position] = key;
		}
	}
}
