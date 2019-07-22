// Assignment #: 11
// Name: Taylor Collins
// StudentID: 1213902038
// Lecture: MWF 8:35-9:25
// Description: PrimeComputing.java contains a constructor to instantiate
//              various queues and a method to compute the prime numbers from the
//              original queue.


//We will be using LinkedList as a Queue
import java.util.LinkedList;
import java.util.*;

public class PrimeComputing
 {
  private int n, lastPrime, primeCount;
  private LinkedList<Integer> originalQueue;
  private LinkedList<Integer> primeQueue;
  private LinkedList<Integer> backupQueue;

  //Constructor to initialize all queues
  public PrimeComputing(int enteredNum)
   {
	   n=enteredNum;
	   originalQueue=new LinkedList<Integer>();
	   primeQueue=new LinkedList<Integer>();
	   backupQueue=new LinkedList<Integer>();

	   for(int i=2;i<=n;i++)//adds values to the queue
	   {
		   originalQueue.offer(i);
	   }
      //TO BE COMPLETED
   }

  // computes all prime numbers up to some n
  public void computePrimesUpToN()
   {
       int nextPrime = 2;
       lastPrime = 2;

       System.out.println("\nProcessing......");

       do {
		   if(originalQueue.peek()!=null)//checks to see if element is null
		   {
		   		nextPrime=originalQueue.remove();
		   		lastPrime=nextPrime;//set the last prime to current
		   	}
           //1. Remove the first element in the original queue of integers
           //and set the next prime "nextPrime" to be the number


           //TO BE COMPLETED

           System.out.println("The next prime to divide: " + nextPrime);

			 primeQueue.add(nextPrime);
           //2. Enqueue the next Prime into the primeQueue.
           //TO BE COMPLETED

			for(Integer prime:originalQueue)//goes through the original queues
			{
				if(prime%nextPrime!=0)//if the remainder is not zero add it to backup
				{
					backupQueue.add(prime);
				}
			}
			originalQueue.clear();//clear queue

			while(backupQueue.size()>0)//add values back to queue
			{
				originalQueue.add(backupQueue.remove());
			}




           //3. Go through the integers in the original queue,
           //and elimienate any number that is divisible by the next prime
           //HINT: you will need to remove each integer from the original queue
           //to examine them, and put back the integers that are NOT
           //divisible by the next prime.
           //This is where you will need a back up queue.
           //Also, you will need to keep track of the last such prime
           //that is used to divide other integers in the original queue.

           //TO BE COMPLETED

       } while (nextPrime <= Math.sqrt(n));

       //4. Transfer all remaining integers in the original queue
       //to the prime queue.
       while(originalQueue.size()>0)
       {
		   primeQueue.add(originalQueue.remove());
	   }

   }

  //It prints out all primes up to N, by displaying 10 prime numbers
  //in each line.
  public void printResults()
     {
         System.out.println("\n-----------------------");
         System.out.println("The prime(s) up to " + n);
         System.out.println("-----------------------");

         int count = 0;
         primeCount = 0;

         while (primeQueue.isEmpty() == false)
         {
             int primeNum = primeQueue.remove();
             System.out.print(primeNum + "\t");

             count++;
             //displaying 10 primes in each line
             if (count%10 == 0)
                 System.out.print("\n");
         }
         System.out.println("\n-----------------------");
         primeCount = count;
     }

  // It returns the laegest prime that was used to divide other integers
  // in the original queue. Note that this is not the largest prime found.
  public int getMaxPrime()
     {
         return lastPrime;
     }

  // It return the count of prime numbers up to n
  public int getCount()
     {
         return primeCount;
     }
}
