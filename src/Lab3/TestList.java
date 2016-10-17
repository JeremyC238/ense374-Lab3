package Lab3;

import java.util.Scanner;

public class TestList 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String choice = "";
		int data;
		ListElement addElement;
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
			
			//assume user adds an item the first time
			if (choice.equals("a"))
			{
				System.out.println("please enter a data element to add to the list");
				data = in.nextInt(); // takes the user input
				
				addElement = new ListElement(data); // creates a new node in the form of a class
												
				list.addElement(addElement); // adds the new node to the list
			}
			
			else if (choice.equals("b"))
			{
				
			}
			
			else if (choice.equals("c"))
			{
				
			}
			
			else if (choice.equals("d"))
			{
				
			}
			
			//else
				//System.out.println("Incorrect option please try again");

		}while(!choice.equals("e"));
	
	in.close();
	}
}
