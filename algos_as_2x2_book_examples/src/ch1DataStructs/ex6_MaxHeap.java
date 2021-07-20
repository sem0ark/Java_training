package ch1DataStructs;

public class ex6_MaxHeap<T extends Comparable<T>> {
	private int heapSize;
	private T[] A;
	
	public ex6_MaxHeap(T[] A, int size) {
		this.heapSize = size;
		this.A = A;
		makeHeap();
	}
	
	public void makeHeap() {
		for (int i=heapSize/2; i>=1; i--) {
			heapify(i-1);
		}
	}
	
	public T heapPop() {
		if (heapSize > 0) {
			T max = A[0];
			A[0] = A[--heapSize];
			heapify(0);
			return max;
		} else {
			throw new IndexOutOfBoundsException("Heap is already empty");
		}
	}
	
	public void heapPush(T v) {
		if (heapSize < this.A.length) {
			A[heapSize++] = v;
			int i = heapSize-1;
			while (i>0 && A[pf(i)].compareTo(A[i])<0) {
				swap(i, pf(i));
				i = pf(i);
			}
		} else {
			throw new IndexOutOfBoundsException("Heap overflow");
		}
	}
	
	public boolean empty() {
		return heapSize == 0;
	}
	
	private void heapify(int i) {
		int l=lf(i), r=rf(i);
		int max;
		max = (l<heapSize && A[l].compareTo(A[i])>0)? l : i; 
		max = (r<heapSize && A[r].compareTo(A[max])>0)? r : max;
		if (max != i) {
			swap(i, max);
			heapify(max);
		}
	}
	
	
	private void swap(int i, int j) {
		T t = this.A[i];
		this.A[i] = this.A[j];
		this.A[j] = t;
	}
	private int pf(int i) {return (i-1)/2;}
	private int lf(int i) {return 2*i+1;  }
	private int rf(int i) {return 2*i+2;  }
}
