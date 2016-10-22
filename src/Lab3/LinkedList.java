package Lab3;

import java.util.Stack;

public class LinkedList 
{
	private ListElement head = new ListElement(); // the head of the linked list
	private ListElement currentNode = new ListElement(); // the current node in the linked list in addElement function
	private ListElement nodeIterator; // a new node in the linked list
	private ListElement tempSearch = new ListElement(); // deletes a node in the linked list
	private ListElement previousNode = new ListElement(); // tails current node
	//private ListElement temp1 = new ListElement();
	private ListElement endNode = new ListElement();
	private int addIterator;
	private boolean indexPositionFound = true;
	
	public LinkedList()
	{
		head = null;
		currentNode = null;
		nodeIterator = null;
		previousNode = null;
		endNode = null;
		addIterator = 0;
	}
	
	public void addElement(ListElement le)
	{
		// first iteration
		if (addIterator == 0)
		{
			
			//head = new ListElement(); // creates a new head object
			//currentNode = new ListElement(); // creates a new current object
			head = le; // sets the head equal to first node
			currentNode = head; // sets the current node equal to head node
			
			addIterator++;
			currentNode.setIterator(addIterator);
		}
		
		// second iteration
		else if (head.getNext() == null)
		{	
			nodeIterator = new ListElement(); // new node object to store the new node
			head.setNext(le); // sets head next component to the new node
			nodeIterator = head.getNext(); // sets the new node object equal to new node
			currentNode = nodeIterator; // sets the current object equal to the next node in the list
			
			addIterator++;
			currentNode.setIterator(addIterator);
		}
		
		// after second iteration
		else
		{
			currentNode.setNext(le);
			nodeIterator = currentNode.getNext();
			currentNode = nodeIterator;
			
			addIterator++;
			currentNode.setIterator(addIterator);
		}
		
		endNode = currentNode;
	}
	
	public void retrieveElement(int indexPosition)
	{
		tempSearch = head; // sets currentNode back to head
		indexPositionFound = true; // resets index position
		
		while(indexPositionFound)
		{
			// error checks of there are any nodes in the list
			if (tempSearch == null)
			{
				System.out.println("there are currently no nodes in the list, please add a node first");
				indexPositionFound = false;
			}
			
			// checks the current node for correct index
			else if (tempSearch.getIterator() == indexPosition)
			{
				//prints the retrieved value
				System.out.println("the retrieved value in the linked list is: " + tempSearch.getData());
				indexPositionFound = false;
			}
				
			// checks following nodes in the list
			else
			{
				if (tempSearch.getNext() != null) 
					tempSearch = tempSearch.getNext(); // iterates currentNode
				
				// error checks the index bound
				else 
				{
					System.out.println("incorrect index please try again"); // prints out the error statement
					indexPositionFound = false;
				}	
			}
		}
	}
	
	public boolean deleteElement(int indexPosition)
	{
		tempSearch = head;
		boolean deletedANode = false;
		
	
		while(tempSearch != null)
		{
				
			if (tempSearch.getIterator() == indexPosition)
			{
				// changes the endNode to new end node if the last node is deleted
				if (tempSearch.getIterator() == endNode.getIterator() && tempSearch.getNext() == null)
				{
					// if there is only one node in the list change previousNode to head instead of null
					if(tempSearch == head)
						previousNode = head;
					
					//set the endNode equal to previousNode 
					endNode = previousNode;
				}
				
				// condition for the first node to be deleted
				if (tempSearch == head)
				{
					// sets the new head index to 1, only if there are two node in the list
					if (head.getNext() != null)
					{
						head.getNext().setIterator(head.getIterator());
						head = head.getNext();
						deletedANode = true;
						break;
					}
					
					head = head.getNext();
				}
				
				else
					previousNode.setNext(tempSearch.getNext());
					
				deletedANode = true;
				
				
			}
			else
				previousNode = tempSearch;
				
			tempSearch = tempSearch.getNext();
		}
		
		if (deletedANode)
			addIterator--; //decreases addIterator
		
		return deletedANode;	
	}
	
	public void printLinkedListTail()
	{
		Stack<Integer> reverseListValues = new Stack<Integer>();
		tempSearch = head;
		
		// error checks of there are any nodes in the list
		if (tempSearch == null)
			System.out.println("there are currently no nodes in the list, please add a node first");
	
		else
		{
			System.out.println("the linked list from tail to head is:");
			
			// fills the stack with the list values in reverse order
			for (int i = 0; i < endNode.getIterator(); i++)
			{
				reverseListValues.push(tempSearch.getData());
				tempSearch = tempSearch.getNext();
			}
			
			// prints the list from tail to head
			for (int i = 0; i < endNode.getIterator(); i++)
			{
				System.out.println(reverseListValues.peek());
				reverseListValues.pop();
			}
		}
	}
	
	public void printLinkedListHead()
	{
		tempSearch = head;
		
		// error checks of there are any nodes in the list
		if (tempSearch == null)
			System.out.println("there are currently no nodes in the list, please add a node first");
		
		else
		{
			System.out.println("the linked list from head to tail is:");
			
			// prints the list from head to tail
			for (int i = 0; i < endNode.getIterator(); i++)
			{
				System.out.println(tempSearch.getData());
				tempSearch = tempSearch.getNext();
			}
		}
	}	
}






