package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: 
		// For construct a new link list
		// 1. Create sentinel nodes for head and tail
		LLNode<E> n1 = new LLNode<E>(null);
		LLNode<E> n2 = new LLNode<E>(null);
		// 2. Assign reference of sentinel nodes to head and tail
		head = n1;
		tail = n2;
		// 3. Set next and prev for head and tail
		head.next = tail;
		tail.prev = head;
		// 4. Set size = 0
		size = 0;
	}
	

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		// 1. Create new node
		LLNode<E> n = new LLNode<E>(element);
		// 2. Change reference 
		n.prev = tail.prev;
		tail.prev = n;
		n.prev.next = n;
		// 3. Add 1 to size
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		//Check for invalid case
		if (size == 0 || index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		// Create count variable 
		int count = 0;
		LLNode<E> start = head.next;
		while (true) {
			if (count == index) {
				return start.data;
			}
			
			start = start.next;
			count++;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		// Check for element
		if (element == null) {
			throw new NullPointerException();
		}
		
		// Check for index
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		// Create count variable 
		int count = 0;
		LLNode<E> curNode = head.next;
		// Create new node with added element
		LLNode<E> n = new LLNode<E>(element);
		while (true) {
			if (count == index) {
				// Set next of prev node of current added index to new node
				curNode.prev.next = n;
				n.prev = curNode.prev;
				// Set prev node of current index to new node
				curNode.prev = n;
				// Set next of n = currIndex
				n.next = curNode;
				size++;
				return;
			}
			
			curNode = curNode.next;
			count++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		// Check for index 
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Create count variable 
		int count = 0;
		LLNode<E> curNode = head.next;
		while (true) {
			if (count == index) {
				// Update prev node's next to currNode's next
				curNode.prev.next = curNode.next;
				// Update next node's prev to currNode's prev
				curNode.next.prev = curNode.prev;
				// Subtract one from size
				size--;
				// Return value of curNode
				return curNode.data;
			}
			curNode = curNode.next;
			count++;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		// Check for element
		if (element == null) {
			throw new NullPointerException();
		}
				
		// Check for index
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		// Create count variable 
		int count = 0;
		LLNode<E> curNode = head.next;
		while (true) {
			if (count == index) {
				E value = curNode.data;
				curNode.data = element;
				return value;
			}
			curNode = curNode.next;
			count++;
		}
	}   
	
	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}
	
	public String toString() {
		return "Value : " + this.data;
	}

}
