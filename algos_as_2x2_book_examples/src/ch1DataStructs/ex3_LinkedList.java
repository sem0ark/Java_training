package ch1DataStructs;



public class ex3_LinkedList<T extends Comparable<T>> {
	private class Node {
		private T value;
		public Node next, prev;
		public Node(T val) {
			this.value = val;
		}
		
		public T get() {
			return this.value;
		}
	}
	
	
	private Node head;
	public ex3_LinkedList() {
		
	}

	public void remove(T x) {
		Node n;

		for (n = head; n != null; n = n.next)
			if (n.get().compareTo(x) == 0)
				break;
		
		if (n == null) return;
		if (n.prev != null) n.prev.next = n.next;
		else head = n.next;
		if (n.next != null) n.next.prev = n.prev;
		n = null;
	}
	
	public void append(T x) {
		Node n = new Node(x);
		n.next = head;
		if (head != null) head.prev = n;
		head = n;
	}
	
	public void showAll() {
		System.out.print("List: ");
		for (Node n = head; n != null; n = n.next)
			System.out.print(n.get() + " ");
		System.out.println();
	}
}
