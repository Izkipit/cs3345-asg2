public class DoublyLinkedList<T> implements List<T> {
	private Node head, tail;
	private int numberOfElements;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}
	
	@Override
	public void addLast(T item) {
		// TODO 
		Node newNode = new Node(item);

        if (isEmpty()) //Checks if the list is empty before adding the first node
		{
            head = tail = newNode; // Adds the first node, must set head and tail equal since the first node is both the head and tail of the list
        } 
		else 
		{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        numberOfElements++;
	}

	@Override
	public void addFirst(T item) {
		// TODO 
		Node newNode = new Node(item);
		if(isEmpty()) {
			head = tail = newNode;
		} 
		else 
		{
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}

	@Override
	public T get(int position) {
		// TODO 
		if (position < 0 || position >= numberOfElements) {
			return null; // Position is out of bounds
		}

        Node current = head;

        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.data;
	}

	@Override
	public void print() {
		// TODO
		if(numberOfElements == 0) {
			System.out.println("The list is empty");
			return;
		}

		Node current = head;
        for(int i = 0; i < numberOfElements; i++) {
			System.out.print(current.data + " ");
			current = current.next;
			System.out.println("Position: " + i);
		}
	}

	@Override
	public void printBackwards() {
		// TODO 
		if(numberOfElements == 0) {
			System.out.println("The list is empty");
			return;
		}

		Node current = tail;
		for(int i = numberOfElements - 1; i >= 0; i--) {
			System.out.print(current.data + " ");
			current = current.previous;
			System.out.println("Position: " + i);
		}
	}

	@Override
	public boolean remove(T item) {
		// TODO 

        return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return numberOfElements == 0;
	}

	@Override
	public int getLength() {
		// TODO 
		return numberOfElements;
	}
	
	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next, previous;

		private Node(T data) {
			this(data,null,null);
		}

		private Node (T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
	}


}

