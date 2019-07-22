// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

// Assignment #: 10
//         Name: Taylor Collins
//    StudentID: 1213902038
//    Lecture: MWF 8:35-9:25
//  Description: LinkedList contains methods to organize and change a linked list


import java.util.NoSuchElementException;
import java.lang.*;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;
   private Node current=first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   public String toString()//returns all of the elements
   {
	   LinkedListIterator iterate=new LinkedListIterator();
	   String str="{ ";
	   while(iterate.hasNext())
	   {
	   		str+=iterate.next()+ " ";
		}
		str+= "}\n";
	   return str;
   }

   public int size()//finds the size of the LinkedList
   {
	   LinkedListIterator iterate=new LinkedListIterator();
	   int count=0;
	   while(iterate.hasNext())
	   {
		   count++;
		   iterate.next();
	   }
	   return count;
   }

   public void addElement(Object element)
   {
	   LinkedListIterator iterate=new LinkedListIterator();//create iterator
	  if(first==null||((String)first.data).compareTo((String)element)>=0)//checks to see if the first node is empty
	   {
		   addFirst(element);//adds the element to the first node
	   		current=first;
	   }
	   else
	   {
		   if(((String)iterate.next()).compareTo((String)element)>0)//adds the node before the previous
		   {
			   Node newNode=new Node();
			   newNode.data=element;
			   newNode.next=current.next;
				current=newNode;

			}
			if(((String)iterate.next()).compareTo((String)element)<0)//adds the node after
			{
				iterate.add(element);
			}
	   }



   }

   public void removeElementsAtOddIndices()//removes the elements at odd locations
   {
	   int i=0;
	   LinkedListIterator iterate=new LinkedListIterator();
	   while(iterate.hasNext())
	   {
			iterate.next();
			if((i%2!=0 &&i!=0)|| i==1)
			{
				 iterate.remove();
			}
			i++;
		}
   }

   public Object searchByIndex(int index)//finds the object in the list and returns it
   {
	   Object obj=null;
	   LinkedListIterator iterate=new LinkedListIterator();
	   if(index>=size()||index<0)
	   {
		   IndexOutOfBoundsException ex=new IndexOutOfBoundsException();
		   throw ex;
	   }
	   for(int i=0;i<=index;i++)
	   {
		   obj=iterate.next();
	   }
	   return obj;
   }

   public void removeAdditionalOccurrences(Object element)//removes the extra elements
   {
		LinkedListIterator iterate=new LinkedListIterator();
		while(iterate.hasNext())
		{
			Object obj=iterate.next();
	  	 	if(obj.equals(element))
	   		{
				obj=iterate.next();
		 		  if(obj.equals(element))//calls remove method if the next one is the same as previous
		 		  {
					   iterate.remove();
		 		  }
	  	 	}
  		 }
   }

   public void searchAndIncrease(Object element, int howMany)//adds in object
   {

	   while(howMany>0)
	   {
		   addElement(element);//use addElement method to add in the object
		   howMany--;
	   }
   }








   /*********************************************************
   Add your methods here
   *********************************************************/


   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
     {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class