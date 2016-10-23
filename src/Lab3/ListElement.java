package Lab3;

public class ListElement 
{
	private int data;
	private ListElement next;
	private ListElement previous;
	
	public ListElement()
	{
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	public ListElement(int dataItem) // only occurs after first iteration
	{
		this.data = dataItem;
		this.next = null;
		this.previous = null;
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
	
	public void setPrevious(ListElement le)
	{
		this.previous = le;
	}
	
	public ListElement getPrevious()
	{
		return this.previous;
	}
}
