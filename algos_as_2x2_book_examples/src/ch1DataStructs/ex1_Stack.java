package ch1DataStructs;

public class ex1_Stack<T> {
	private int top;
	private T[] s;
	
	public ex1_Stack(int N) {
		this.top = 0;
		this.s = (T[]) new Object[N];
	}
	
	public boolean empty() {
		return top == 0;
	}
	
	public void push(T t) {
		assert top < s.length : "Stack overflow";
		s[top++] = t;
	}
	
	public T pop() {
		assert !empty() : "Stack is already empty";
		return s[--top];
	}
}
