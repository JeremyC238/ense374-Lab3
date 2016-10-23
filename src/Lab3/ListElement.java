package Lab3;

public class ListElement 
{
	private int data;
	private ListElement next;
	
	public ListElement()
	{
		this.data = 0;
		this.next = null;
	}
	
	public ListElement(int dataItem) // only occurs after first iteration
	{
		this.data = dataItem;
		this.next = null;
	}
	
	public int getData()
	{
		return this.data;
	}
	
	public void setNext(ListElement le) // sets next to the next node in the list
	{
		this.next = le;
	}
	
	public ListElement getNext()
	{
		return this.next;
	}
}
