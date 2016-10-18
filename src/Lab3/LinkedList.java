package Lab3;

import java.util.Stack;

public class LinkedList 
{
	private ListElement head = new ListElement(); // the head of the linked list
	private ListElement currentNode = new ListElement(); // the current node in the linked list
	private ListElement nodeIterator; // a new node in the linked list
	private ListElement deleteNode = new ListElement(); // deletes a node in the linked list
	private ListElement previousNode = new ListElement(); // tails current node
	private ListElement temp1 = new ListElement();
	private ListElement endNode = new ListElement();
	private int addIterator;
	private boolean indexPositionFound = true;
	
	public LinkedList()
	{
		head = null;
		currentNode = null;
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
		currentNode = head; // sets currentNode back to head
		indexPositionFound = true; // resets index position
		
		while(indexPositionFound)
		{
			// error checks of there are any nodes in the list
			if (currentNode == null)
			{
				System.out.println("there are currently no nodes in the list, please add a node first");
				indexPositionFound = false;
			}
			
			// checks the current node for correct index
			else if (currentNode.getIterator() == indexPosition)
			{
				//prints the retrieved value
				System.out.println("the retrieved value in the linked list is: " + currentNode.getData());
				indexPositionFound = false;
			}
				
			// checks following nodes in the list
			else
			{
				if (currentNode.getNext() != null) 
					currentNode = currentNode.getNext(); // iterates currentNode
				
				// error checks the index bound
				else 
				{
					System.out.println("incorrect index please try again"); // prints out the error statement
					indexPositionFound = false;
				}	
			}
		}
	}
	
	public void deleteElement(int indexPosition)
	{
		currentNode = head; // sets currentNode back to head
		indexPositionFound = true; // resets index position
		
		while (indexPositionFound)
		{
			// error checks of there are any nodes in the list
			if (currentNode == null)
			{
				System.out.println("there are currently no nodes in the list, please add a node first");
				indexPositionFound = false;
			}
			
			// checks the current node for correct index
			else if (currentNode.getIterator() == indexPosition)
			{
				deleteNode = currentNode; // sets delete node equal to node to be deleted
				temp1 = previousNode.getNext(); // hold the previous node
				temp1 = currentNode.getNext(); // sets previous node equal to node after current node
				
				// delete node
				//deleteNode.remove()
				
				indexPositionFound = false;
			}
							
			// checks following nodes in the list
			else
			{
				if (currentNode.getNext() != null) 
					currentNode = currentNode.getNext(); // iterates currentNode
							
				// error checks the index bound
				else 
				{
					System.out.println("incorrect index please try again"); // prints out the error statement
					indexPositionFound = false;
				}	
			}
		}
	}
	
	public void printLinkedListTail()
	{
		Stack<Integer> reverseListValues = new Stack<Integer>();
		currentNode = head;
		
		// error checks of there are any nodes in the list
		if (currentNode == null)
			System.out.println("there are currently no nodes in the list, please add a node first");
	
		else
		{
			System.out.println("the linked list from tail to head is:");
			
			// fills the stack with the list values in reverse order
			for (int i = 0; i < endNode.getIterator(); i++)
			{
				reverseListValues.push(currentNode.getData());
				currentNode = currentNode.getNext();
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
		currentNode = head;
		
		// error checks of there are any nodes in the list
		if (currentNode == null)
			System.out.println("there are currently no nodes in the list, please add a node first");
		
		else
		{
			System.out.println("the linked list from head to tail is:");
			
			// prints the list from head to tail
			for (int i = 0; i < endNode.getIterator(); i++)
			{
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNext();
			}
		}
	}	
}






