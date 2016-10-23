package Lab3;

import java.util.Stack;

public class LinkedList 
{
	private ListElement head = new ListElement(); // the head of the linked list
	private ListElement currentNode; // the current node in the linked list in addElement function
	//private ListElement nodeIterator; // a new node in the linked list
	//private ListElement tempSearch = new ListElement(); // deletes a node in the linked list
	//private ListElement previousNode; // tails current node
	private ListElement endNode = new ListElement();
	private int listLength;
	//private boolean indexPositionFound = true;
	
	public LinkedList()
	{
		head = null;
		currentNode = null;
		
		//nodeIterator = null;
		//previousNode = null;
		endNode = null;
		listLength = 0;
	}
	
	public void addElement(ListElement le)
	{
		// first iteration
		if (listLength == 0)
		{
			head = le; // sets the head equal to first node
			endNode = head; // sets the current node equal to head node
		}
		
		//after first iteration
		else
		{
			endNode.setNext(le); // sets endNode next equal to the new node
			endNode = endNode.getNext(); // updates endNode to the last node in list
		}
		
		listLength++; // increments the number of nodes in the list
	}
	
	public ListElement retrieveElement(int indexPosition)
	{
		// checks if the list is empty or
		// indexPosition is not greater than the number of nodes in the list
		if (indexPosition < 0 || indexPosition > listLength)
			return null;
		
		else
		{
			currentNode = head; // sets currentNode equal to the start of the list
			
			// iterates currentNode until correct node is found
			for (int i = 0; i < indexPosition - 1; i++)
				currentNode = currentNode.getNext();
			
			return currentNode; // returns the correct node back to main
		}
	}
	
	public boolean deleteElement(int indexPosition)
	{
		// checks if the list is empty or
		// indexPosition is not greater than the number of nodes in the list
		if (indexPosition < 0 || indexPosition > listLength)
			return false;
				
		// condition to delete the head node
		else if(indexPosition == 1)
		{
			head = head.getNext(); // increments head to the next node in the list
			
			listLength--; // decrements listLength
		}
				
		// condition for any node after the head
		else
		{
			currentNode = head; //reset current node equal to the head
			//indexPosition = indexPosition - 1;
					
			// iterates current node until it finds the node before the one to delete
			for (int i = 0; i < indexPosition - 2; i++)
				currentNode = currentNode.getNext();
			
			//once currentNode stops, set currentNode equal to the node after the deleted node
			currentNode.setNext(currentNode.getNext().getNext());
			
			if (currentNode.getNext() == null)
				endNode = currentNode;
				
			
			listLength--; // decrements listLength
		}
		
		return true;
	}
	
	public void printLinkedListTail()
	{
		Stack<Integer> reverseListValues = new Stack<Integer>();
		currentNode = head;
		
		// checks if the list is empty
		if (listLength == 0)
			System.out.println("there are currently no nodes in the list, please add a node first");
		
		else
		{	
			// fills the stack with the list values in reverse order
			for (int i = 0; i < listLength; i++)
			{
				reverseListValues.push(currentNode.getData()); // pushes the current node on to the stack
				currentNode = currentNode.getNext(); // iterates through the list
			}
			
			System.out.println("the linked list from tail to head is:");
			
			// prints the list from tail to head
			for (int i = 0; i < listLength; i++)
			{
				System.out.println(reverseListValues.peek()); // prints the top value from the stack
				reverseListValues.pop(); // iterates through the stack
			}
		}
	}
	
	public void printLinkedListHead()
	{
		currentNode = head;
		
		// checks if the list is empty
		if (listLength == 0)
			System.out.println("there are currently no nodes in the list, please add a node first");
		
		else
		{
			System.out.println("the linked list from head to tail is:");
			
			// prints the list from head to tail
			for (int i = 0; i < listLength; i++)
			{
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNext();
			}
		}
	}	
}






