
/**
 * Defines a doubly-linked list class
 * @author
 * @author
 */

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.List;

public class LinkedList<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTORS ****/

	/**
	 * Instantiates a new LinkedList with default values
	 * 
	 * @postcondition to initialize the fields inside the List class with a starting
	 *                value
	 */

	public LinkedList() {
		this.first = null;
		this.last = null;
		this.iterator = null;
		this.length = 0;

	}

	/**
	 * Converts the given array into a LinkedList
	 * 
	 * @param array the array of values to insert into this LinkedList
	 * @return 
	 * @postcondition <fill in here>
	 */
	public LinkedList<T> LinkedList(T[] array) {
		LinkedList<T> L = new LinkedList<>();
		L = (LinkedList<T>) Arrays.asList(array);
		return L;
	}

    /**
     * Instantiates a new LinkedList by copying another List
     * @param original the LinkedList to copy
     * @postcondition a new List object, which is an identical,
     * but separate, copy of the LinkedList original
     */
	public LinkedList(LinkedList<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		} else {
			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;
		}
	}

	/**** ACCESSORS ****/

	//#5///////////////////////////// getFirst()///////////////////////////////

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition list is empty
	 * @return the value stored at node first
	 * @throws NoSuchElementException when list is empty
	 */

	public T getFirst() throws NoSuchElementException {
		if(length == 0) {
			throw new NoSuchElementException("getFirst:"  + " the list is empty \n");
		}else {
			return first.data; 
		}
	}

	/////////////////////////////// getLast()///////////////////////////////
	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition the list is not empty
	 * @return the value stored in the node last
	 * @throws NoSuchElementException indicates that list is empty
	 */

	public T getLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getLast: LinkedList is empty");
		}
		return last.data;
	}

	
	// #4///////////////////////////////////////////getIterator()///////////////////////////////////

	/**
	 * Returns the data stored in the iterator node
	 * 
	 * @precondition iterator cannot be null
	 * @throw NullPointerException when iterator is null
	 */
	public T getIterator() throws NullPointerException {
		if(iterator == null) {
			throw new NullPointerException("getIterator" + "Iterator is null");
		}else {
			return iterator.data;
		}
	}

	/**
	 * Returns the current length of the LinkedList
	 * 
	 * @return the length of the LinkedList from 0 to n
	 */

	public int getLength() {
		return length;
	}

	
	/**
	 * Returns whether the LinkedList is currently empty
	 * 
	 * @return whether the LinkedList is empty
	 */

	public boolean isEmpty() {
		return length == 0;
	}

	
	// #3///////////////////////////////////////////offEnd()///////////////////////////////////

	/**
	 * Returns whether the iterator is offEnd, i.e. null
	 * 
	 * @return whether the iterator is null
	 */

	public boolean offEnd() {
		return iterator == null;
	}

	/**** MUTATORS ****/
	
	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the LinkedList
	 * @postcondition new element was added at the front of the LinkedList
	 */

	public void addFirst(T data) {

		if (length == 0) {
			first = last = new Node(data);
		} else {
			Node n = new Node(data);
			n.next = first;
			first.prev = n;
			first = n;
		}

		length++;

	}


	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the LinkedList
	 * @postcondition adds new node at the end of the Linked list
	 */

	public void addLast(T data) {
		if (length == 0) {
			last = first = new Node(data);
		} else {
			Node n = new Node(data);
			n.prev = last;
			last.next = n;
			last = n;
		}
		length++;

	}

	// #12///////////////////////////////////////////addIteratorFirst()//////////////////////////////////

	/**
	 * Inserts a new element after the iterator
	 * 
	 * @param data the data to insert
	 * @precondition iterator cannot be null
	 * @throws NullPointerException when iterator is null
	 */
	public void addIterator(T data) throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("addIterator(): " + "iterator is offend. cannot add");
		}
		else if (iterator == last) {
			addLast(data);
		}
		else {
			Node n = new Node(data);
			n.next = iterator.next;
			n.prev = iterator;
			iterator.next.prev = n;
			iterator.next = n;
		}
		length++;
	}

	/**
	 * removes the element at the front of the LinkedList
	 * 
	 * @precondition the list is empty
	 * @postcondition the first element has been removed
	 * @throws NoSuchElementException if the list is empty
	 */

	public void removeFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeFirst(): " + "The list is empty. No first Element\n");
		}
		
		else if(length == 1){
			iterator = first = last = null;
		}
		else {
			if(iterator == first) {
				iterator = null;
			}
			first = first.next;
			first.prev = null;
		}
		length--;
	}
	

	/**
	 * removes the element at the end of the LinkedList
	 * 
	 * @precondition the list is empty
	 * @postcondition the last element has been removed
	 * @throws NoSuchElementException if the list is empty
	 * 
	 */


	public void removeLast() throws NoSuchElementException {
		
		if (length == 0) {
			throw new NoSuchElementException("removeLast(): " + "The list is empty. No last Element\n");
		}
		
		else if(length == 1){
			iterator = first = last = null;
		}
		else {
			if(iterator == last) {
				iterator = null;
			}
			last = last.prev;
			last.next = null;
		}
		length--;
	}
	// #6///////////////////////////////////////////removeIterator()///////////////////////////////////

	/**
	 * removes the element referenced by the iterator
	 * 
	 * @precondition iterator cannot be null
	 * @postcondition it will remove the node where the iterator is
	 * @throws NullPointerException when iterator is null
	 */
	public void removeIterator() throws NullPointerException {
		if(iterator == null) {
			throw new NullPointerException("removeIterator(): " + "iterator is null");
		}else if(iterator == first) {
			removeFirst();
		}else if(iterator == last) {
			removeLast();
		}else {
			iterator.next.prev = iterator.prev;
			iterator.prev.next = iterator.next;
			iterator = null;
			length--;
		}

	}
	// #8///////////////////////////////////////////positionIterator()///////////////////////////////////

	/**
	 * places the iterator at the first node
	 * 
	 * @postcondition moves iterator to the beginning of the list
	 * 
	 */
	public void positionIterator() {
		iterator = first; 
	}

	// #9///////////////////////////////////////////advanceIterator()///////////////////////////////////

	/**
	 * Moves the iterator one node towards the last
	 * 
	 * @precondition Iterator can not be null
	 * @postcondition iterator moves to the next node
	 * @throws NullPointerException when iterator is null
	 */
	public void advanceIterator() throws NullPointerException {
		if(iterator == null) {
			throw new NullPointerException("advanceIterator(): " + "iterator is null, it cannot move to next node");
		}else {
			iterator = iterator.next;
		}

	}

	/**
	 * Moves the iterator one node towards the first
	 * 
 * @precondition Iterator can not be null
	 * @postcondition iterator moves to the previous node
	 * @throws NullPointerException when iterator is null
	 */
	// #10///////////////////////////////////////////revereseIterator()///////////////////////////////////

	public void reverseIterator() throws NullPointerException {
		if(iterator == null) {
			throw new NullPointerException("advanceIterator(): " + "iterator is null, it cannot move to next node");
		}else {
			iterator = iterator.prev;
		}
	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * Converts the LinkedList to a String, with each value separated by a blank
	 * line At the end of the String, place a new line character
	 * 
	 * @return the LinkedList as a String
	 */
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node temp = first;
		while (temp != null) {
			result.append(temp.data + " ");
			temp = temp.next;
		}

		return result.toString() + "\n";
	}

    /**
     * Determines whether the given Object is
     * another LinkedList, containing
     * the same data in the same order
     * @param o another Object
     * @return whether there is equality
     */
    @SuppressWarnings("unchecked") //good practice to remove warning here
    @Override public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if (!(o instanceof LinkedList)) {
            return false;
        } else {
            LinkedList<T> L = (LinkedList<T>) o; 
            if (this.length != L.length) {
                return false;
            } else {
                Node temp1 = this.first;
                Node temp2 = L.first;
                while (temp1 != null) {
                	if(!temp1.data.equals(temp2.data)) {
                		return false; 
                	}
                	temp1 = temp1.next;
                	temp2 = temp2.next; 
                }
                return true;
            }
        }
    }

	/** CHALLENGE METHODS */

	/**
	 * Zippers two LinkedLists to create a third List which contains alternating
	 * values from this list and the given parameter For example: [1,2,3] and
	 * [4,5,6] -> [1,4,2,5,3,6] For example: [1, 2, 3, 4] and [5, 6] -> [1, 5, 2, 6,
	 * 3, 4] For example: [1, 2] and [3, 4, 5, 6] -> [1, 3, 2, 4, 5, 6]
	 * 
	 * @param list the second LinkedList in the zipper
	 * @return a new LinkedList, which is the result of zippering this and list
	 * @postcondition this and list are unchanged
	 */
	public LinkedList<T> zipperLists(LinkedList<T> list) {
	LinkedList<T> third = new LinkedList<>();
	{
		Node temp1 = this.first;
		Node temp2= list.first;
		Node temp3 = third.first;
		
		int counter = 0;
		
		while (temp1!=null&&temp2!=null)
		{
			if (counter % 2 == 0)
			{
				temp3 = temp1;
				temp1= temp1.next;
				temp3 = temp3.next; 
			}
			else {
				temp3 = temp2;
				temp2= temp2.next;
				temp3 = temp3.next; 
			}
			counter++;
		}
		if (temp1==null) {
			while (temp2 != null) {
				temp3 = temp2;
				temp2= temp2.next;
				temp3 = temp3.next;
			}
		}
		else {
			while (temp1 != null) {
				temp3 = temp1;
				temp1= temp1.next;
				temp3 = temp3.next; 
			}
		}
		
	}
		
		return third;
	}

	/**
	 * Determines whether any of the next or prev links in the List are broken, i.e.
	 * referencing the wrong Node or null Used by the programmer for error checking
	 * 
	 * @return whether a broken links exist
	 */
	public boolean containsBrokenLinks() {
		return false;
	}
}