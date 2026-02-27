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

        if (isEmpty()) {
            head = tail = newNode;
        } else {
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

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        numberOfElements++;
			
	}

	@Override
	public T get(int position) {
		// TODO 
		if (position < 0 || position >= numberOfElements) {
            return null;   // matches interface requirement
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
		Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
	}

	@Override
	public void printBackwards() {
		// TODO 
		Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.println();
	}

	@Override
	public boolean remove(T item) {
		// TODO 
	if (isEmpty()) {
            return false;
        }

        Node current = head;

        while (current != null) {

            if ((current.data == null && item == null) ||
                (current.data != null && current.data.equals(item))) {

                // Remove head
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    } else {
                        tail = null;
                    }
                }
                // Remove tail
                else if (current == tail) {
                    tail = tail.previous;
                    tail.next = null;
                }
                // Remove middle
                else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }

                numberOfElements--;
                return true;
            }

            current = current.next;
        }

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

