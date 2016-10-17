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
			System.out.println("d) to print the list");
			System.out.println("e) to exit the program");
			
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
				
			}
			
			else if (choice.equals("d"))
			{
				
			}
			
			// error checks the users input
			else if (!(choice.equals("a")|| choice.equals("b") || choice.equals("c") || choice.equals("d") || choice.equals("e")))      
				System.out.println("Incorrect option please try again");

		}while(!choice.equals("e"));
		
		System.out.println("good bye!");
		
		in.close(); // closes scanner
	}
}
