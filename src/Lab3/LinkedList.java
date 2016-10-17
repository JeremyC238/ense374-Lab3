package Lab3;

public class LinkedList 
{
	private ListElement head;
	private ListElement currentNode;
	private ListElement newNode;
	private int iterator;
	
	public LinkedList()
	{
		head = null;
		currentNode = null;
		iterator = 0;
	}
	
	public void addElement(ListElement le)
	{
		// first iteration
		if (iterator == 0)
		{
			
			head = new ListElement(); // creates a new head object
			currentNode = new ListElement(); // creates a new current object
			head = le; // sets the head equal to first node
			currentNode = head; // sets the current node equal to head node
			iterator++;
		}
		
		// second iteration
		else if (head.getNext() == null)
		{	
			newNode = new ListElement(); // new node object to store the new node
			head.setNext(le); // sets head next component to the new node
			newNode = head.getNext(); // sets the new node object equal to new node
			currentNode = newNode; // sets the current object equal to the next node in the list
		}
		
		// after second iteration
		else
		{
			currentNode.setNext(le);
			newNode = currentNode.getNext();
			currentNode = newNode;
		}
	}
}
