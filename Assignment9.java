import java.io.*;
// Assignment #:9
// Name:Taylor Collins
// StudentID:1213902038
// Lecture:MWF 8:35-9:25
// Description: Using recursive methods, Assignment9.java prints information about
//              an array of integers
public class Assignment9
{
	public static void main(String[] args)
	{
		int[] numArray=new int[100];//instantiate array to hold at most 100 elements
		int i=0,elementCount=0;
		try//try to fill the array
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int input=Integer.parseInt(reader.readLine());
			while(input!=0)//take input while until zero is entered
			{
				numArray[i]=input;
				i++;
				input=Integer.parseInt(reader.readLine());
			}
			reader.close();
			int min=findMin(numArray,0,i);//find the smallest value
			int even=computeMaxDivisibleBy2(numArray,0,i);//find the largest even number
			elementCount=countEvenNumbers(numArray,0,i);//find the number of evens
			int sum=computeSumOfNumbersAtIndexDivisibleBy3(numArray,0,i);//add together all of the numbers at multiple of 3 index

			//print out calculations
			System.out.println("The minimum number is "+min);
			System.out.println("The largest integer that is divisible by 2 is "+even);
			System.out.println("The count of even numbers in the sequence is "+elementCount);
			System.out.println("The sum of numbers at indexes divisible by 3 is "+sum);
		}
		catch(IOException exception)
		{
			System.out.println(exception);
		}

	}
	public static int findMin(int[] numbers,int startIndex,int endIndex)//finds the smallest number in the array
	{
		int midIndex=(startIndex+endIndex)/2;//find middle index of the array
		int leftMin=0,rightMin=0;
		if(startIndex==endIndex)
		{
			return numbers[startIndex];
		}
		else
		{//recursive part
			leftMin=findMin(numbers,startIndex,midIndex);
			rightMin=findMin(numbers,midIndex+1,endIndex);

			if(leftMin<rightMin)//determine which is smallest
			{
				return leftMin;
			}
			else
			{
				return rightMin;
			}
		}
	}


	public static int computeMaxDivisibleBy2(int[] elements, int startIndex, int endIndex)//returns largest even integer
	{
		int midIndex=(startIndex+endIndex)/2;//the middle indec
		if(startIndex==endIndex)
		{
			if(elements[startIndex]%2==0)//checks to see if it's even
			{
				return elements[startIndex];
			}
			else
			{
				return 0;
			}
		}
		else
		{//recursion. finds largest even on each side of the array
			int leftMax=computeMaxDivisibleBy2(elements,startIndex,midIndex);
			int rightMax=computeMaxDivisibleBy2(elements,midIndex+1,endIndex);

			if(leftMax>rightMax)//returns largest number
			{
				return leftMax;
			}
			else{
				return rightMax;
			}
		}
	}


	public static int countEvenNumbers(int[] elements, int startIndex, int endIndex)//counts even numbers
	{
		int midIndex=(startIndex+endIndex)/2;
		if(startIndex==endIndex)
		{
			if(elements[startIndex]%2==0)//if the number is even,add 1 to the total
			{
				return 1;
			}
			else{
				return 0;
			}
		}
		else
		{//recursion. counts the number of even elements on each side of the array
			int leftEvens=countEvenNumbers(elements,startIndex,midIndex);
			int rightEvens=countEvenNumbers(elements,midIndex+1, endIndex);

			return leftEvens+rightEvens;//returns total number
		}
	}

	public static int computeSumOfNumbersAtIndexDivisibleBy3(int[] elements, int startIndex, int endIndex)//adds numbers at indexes divisible by three
	{
		int midIndex=(startIndex+endIndex)/2;
		if(startIndex==endIndex)
		{
			if(startIndex%3==0)//if divisible by three add it to the total
			{
				return elements[startIndex];
			}
			else{
				return 0;
			}
		}
		else
		{//recursion. adds up the elements from both sides of the array
			int leftby3=computeSumOfNumbersAtIndexDivisibleBy3(elements,startIndex,midIndex);
			int rightby3=computeSumOfNumbersAtIndexDivisibleBy3(elements,midIndex+1,endIndex);

			return leftby3+rightby3;//returns the total sum
		}
	}
}