package Lab3;

import java.util.Scanner;

public class TestList 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String choice = "";
		int data;
		ListElement add;
		LinkedList list = new LinkedList();
		
		do
		{
			// menu that prompt the user to enter an option
			System.out.println("please enter an option for the linked list");
			System.out.println("a) to add a node to the list");
			System.out.println("b) to retrieve a node from the list");
			System.out.println("c) to delete a node from the list");
			System.out.println("d) to print the list from tail to head");
			System.out.println("e) to print the list from head to tail");
			System.out.println("f) to exit the program");
			
			choice = in.next(); // user enters input
			
			// adds a node to the linked list
			if (choice.equals("a"))
			{
				System.out.println("please enter a data element to add to the list");
				data = in.nextInt(); // takes the user input
				
				add = new ListElement(data); // creates a new node in the form of a class
												
				list.addElement(add); // adds the new node to the list
			}
			
			// retrieves a node from the linked list
			else if (choice.equals("b"))
			{
				System.out.println("please enter an index position to traverse to in the list");
				data = in.nextInt(); // takes the users input
				
				list.retrieveElement(data); //retrieves the node requested	
			}
			
			// deletes a node from the linked list
			else if (choice.equals("c"))
			{
				System.out.println("please enter the index position of the node you wish to delete");
				data = in.nextInt(); // takes the users input
				
				// if returns true, prints message that the node was deleted
				if (list.deleteElement(data))
					System.out.println("node successfully deleted");
				
				// if returns false, prints message saying there are no nodes in the list
				else
					System.out.println("there are currently no nodes in the list, please add a node first");
			}
			
			// prints the linked list from tail to head
			else if (choice.equals("d"))
			{
				list.printLinkedListTail();
			}
			
			// prints the linked list from head to tail
			else if (choice.equals("e"))
			{
				list.printLinkedListHead();
			}
			
			// error checks the users input
			else if (!(choice.equals("a")|| choice.equals("b") || choice.equals("c") || choice.equals("d") || choice.equals("e") || choice.equals("f")))      
				System.out.println("Incorrect option please try again");
			
			System.out.println(); // adds new line

		}while(!choice.equals("f"));
		
		System.out.println("good bye!");
		
		in.close(); // closes scanner
	}
}
