// Assignment #:2
// Name: Taylor Collins
// StudentID: 1213902038
// Lecture: MWF 8:35
// Description: Takes in numbers and finds certain characteristics of the set


import java.util.*;
public class Assignment2
{
	public static void main(String[]args)
	{
		int entValue,largest,numEven=0; //declares variables
		int sum=0;
		int smallest;
		int index=0;
		int size=100;
		int numentered=0;
		int[] numbers=new int[size];
		Scanner scan=new Scanner(System.in); //declare scanner
		entValue=scan.nextInt();



		while(entValue!=0) //asks for new values as long ass zero is not entered
		{
			numentered++; //keeps track of the amount of numbers entered
			numbers[index]=entValue;
			index++; //tracks the index of the number in the array
			entValue=scan.nextInt();
		}
		if(entValue==0) //includes zero in the array
		{
			numbers[index+1]=entValue;
			numentered++;
		}

		smallest=numbers[0];
		for(int i=1;i<numentered;i++) //finds the smallest number
		{
			if(numbers[i]<smallest)
			{
				smallest=numbers[i];
			}
		}

		int [] evens=new int[numentered]; //array for only the even numbers
		index=0;
		for(int i=0;i<numentered;i++)//finds the evens and stores them in the array
		{
			if((numbers[i] %2)==0)
			{
				numEven++;
				evens[index]=numbers[i];
				index++;
			}
		}

		largest=evens[0];
		for(int j=1;j<numEven;j++)//finds the largest even number
		{
			if(evens[j]>largest)
			{
				largest=evens[j];
			}
		}




		for(int i=0;i<size;i++)
		{
			if(numbers[i]>0) //adds the numbers together as long as they are positive
			{
				sum+=numbers[i];
			}
		}

		System.out.println("The minimum integer is "+ smallest);
		System.out.println("The largest integer that is divisible by 2 is "+largest);
		System.out.println("The count of even integers in the sequence is "+numEven);
		System.out.println("The sum of positive integers is "+sum);
	}
}


