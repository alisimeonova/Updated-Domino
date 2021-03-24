package edu;

import edu.Node;

public class LinkedList<T> implements List<T> 
{
	private Node<T> linkedList;
	private int index;
	
	public LinkedList(Node<T> linkedList, int index)
	{
		this.linkedList = linkedList;
		this.index = index;
	}
	
	public LinkedList()
	{
		this.index = 0;
	}
	
	public int getIndex()
	{
		return this.index;
	}

	@Override
	public boolean isEmpty()
	{
		if(index <= 0)
			return true;
		return false;
	}

	@Override
	public boolean contains(T item)
	{
		Node<T> current = linkedList;
		
		if(current != null) 
		{
			if(current.data.equals(item))
			{
				return true;
			}
			current =current.next;
		}
		return false;
	}

	@Override
	public void add(T item) 
	{
		Node<T> newItem = new Node<>(item);
		if(isEmpty())
		{
			this.linkedList = newItem;
		}
		else
		{
			Node<T> temp = linkedList;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newItem;
		}
		index++;
	}

	@Override
	public void insertAt(T item, int index) 
	{
		Node<T> newNode = new Node<>(item);
		 
	    if(index == 0) 
	    {
	        newNode.next = linkedList;
	        linkedList = newNode;
	    }
	    else 
	    {
	        Node<T> node = linkedList;
	        while(--index > 0) 
	        {
	            node = node.next;
	        }
	        newNode.next = node.next;
	        node.next = newNode;
	    }
		
	}

	@Override
	public void removeFrom(int index) 
	{
		if(index == 0)
		{
			this.linkedList = linkedList.next;
		}
		else
		{
			Node<T> temp = linkedList;
			int count = 0;
			while(count < index - 1)
			{
				temp = temp.next;
				count++;
			}
			Node<T> removedItem = temp.next;
			temp = removedItem.next;
		}
		this.index--;
		
	}

	@Override
	public void remove(T item)
	{
		if(getIndex(item) != -1)
			removeFrom(getIndex(item));
		return;
	}

	@Override
	public T get(int index) 
	{
		Node<T> a = linkedList;
		for(int i=0; i < index; i++)
		{
			a = a.next;
		}
		return a.data;
	}

	@Override
	public void clear() 
	{
		this.index = 0;
	}
	
	public int getIndex(T item)
	{
		int br = 0;
		Node<T> temp = linkedList;
		while(temp.data != null)
		{
			if(temp.data.equals(item))
			{
				return br;
			}
			br++;
			temp = temp.next;
		}
		return -1;
		
	}

}
