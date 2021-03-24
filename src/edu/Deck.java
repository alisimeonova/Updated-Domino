package edu;

public class Deck<T>
{
	private Node<T> left;
	private Node<T> right;
	
	public Deck()
	{
		left = right = null;
	}
	
	public boolean isEmpty()
	{
		return left == null;
	}
	
	public T getLeft()
	{
		if(left == null)
			return null;
		return left.data;
	}
	
	public T getRight()
	{
		if(right == null)
			return null;
		return right.data;
	}
	
	public void addLeft(T item)
	{
		if(isEmpty())
		{
			left = right = new Node<>(item);
		}
		else
		{
			left = new Node<>(item, left);
		}
	}
	
	public void addRight(T item)
	{
		if(isEmpty())
		{
			addLeft(item);
		}
		else
		{
			right.next = new Node<>(item);
			right = right.next;
		}
	}
	
	public Iterator<T> getIterator()
	{
		return new DeckIterator();
	}
	
	private class DeckIterator implements Iterator<T>
	{
		Node<T> current;
		DeckIterator()
		{
			current = left;
		}
		
		@Override
		public T next() {
			T toReturn = current.data;
			current = current.next;
			return toReturn;
		}

		@Override
		public boolean hasNext() {
			if(current == null)
				return false;
			return current.next != null;
		}
		
	}
}
