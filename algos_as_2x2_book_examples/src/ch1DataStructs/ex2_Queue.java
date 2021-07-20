package ch1DataStructs;

public class ex2_Queue<T> {
	private int tail, head;
	private T[] q;
	
	public ex2_Queue(int N) {
		this.tail = 0;
		this.head = 0;
		this.q = (T[]) new Object[N];
	}
	
	public boolean empty() {
		return tail == head;
	}
	
	public T dequeue() {
		assert !empty() : "Queue is already empty";
		int oldHead = head;
		head = (head+1)%q.length;
		return q[oldHead];
	}
	
	public void enqueue(T t) {
		assert (head%q.length != (tail+1)%q.length) : "Queue overflow";
		q[tail] = t;
		tail = (tail+1)%q.length;
	}
}
