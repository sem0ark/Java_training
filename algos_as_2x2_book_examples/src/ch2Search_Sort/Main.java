package ch2Search_Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch1DataStructs.ex6_MinHeap;
import ch1DataStructs.ex4_BinarySearchTree;

public class Main {
	public static void main(String[] args) {
		System.out.println("prog_1_1 -------------");
		n1_1();
		System.out.println("\n\n");
		System.out.println("prog_1_2 -------------");
		n1_2();
		System.out.println("\n\n");
		System.out.println("prog_2 -------------");
		n2();
		System.out.println("\n\n");
		System.out.println("prog_3 -------------");
		n3();
		System.out.println("\n\n");
		System.out.println("prog_4 -------------");
		n4();
		System.out.println("\n\n");
		System.out.println("prog_5 -------------");
		n5();
		System.out.println("\n\n");
		System.out.println("prog_6 -------------");
		n6();
		System.out.println("\n\n");
		System.out.println("prog_7_1 -------------");
		n7_1();
		System.out.println("\n\n");
		System.out.println("prog_8 -------------");
		n8();
		System.out.println("\n\n");
		System.out.println("prog_9_1 -------------");
		n9_1();
		System.out.println("\n\n");
		System.out.println("prog_9_2 -------------");
		n9_2();
		System.out.println("\n\n");
		System.out.println("prog_10_1 -------------");
		n10_1();
		System.out.println("\n\n");
		System.out.println("prog_10_2 -------------");
		n10_2();
		System.out.println("\n\n");
		System.out.println("prog_10_3 -------------");
		n10_3();
		System.out.println("\n\n");
		System.out.println("prog_1 search -------------");
		n11();
		System.out.println("\n\n");
		System.out.println("prog_2 search -------------");
		n12();
		System.out.println("\n\n");
		System.out.println("prog_3 search -------------");
		n13();
		System.out.println("\n\n");
		System.out.println("prog_4 search hash-table -------------");
		n14();
		System.out.println("\n\n");
		System.out.println("prog_5 search horspool's -------------");
		n15();
		System.out.println("\n\n");
	}
	
	private static void n1_1() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex1_1_insertionSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n1_2() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex1_2_insertionSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n2() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex2_selectionSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n3() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex3_bubbleSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n4() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex4_shakerSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n5() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex5_quickSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n6() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex6_mergeSort(arr, 0, arr.length);
		showArr(arr);
	}
	
	private static void n7_1() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex7_1_heapSort(arr);
		showArr(arr);
	}
	
	private static void n8() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex8_binTreeSort(arr);
		showArr(arr);
	}
	
	private static void n9_1() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex9_1_countSort(arr, 0, arr.length, 10);
		showArr(arr);
	}
	
	private static void n9_2() {
		Random r = new Random();
		Integer[] arr = new Integer[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		ex9_2_countSort(arr, 0, arr.length, 10);
		showArr(arr);
	}
	
	private static void n10_1() {
		Random r = new Random();
		Integer[] arr = new Integer[20];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		showArr(arr);
		ex10_1_radixSort(arr, 0, arr.length, 100);
		showArr(arr);
	}
	
	private static void n10_2() {
		Random r = new Random();
		Integer[] arr = new Integer[20];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		showArr(arr);
		ex10_2_radixSort(arr, 0, arr.length, 100);
		showArr(arr);
	}
	
	private static void n10_3() {
		Random r = new Random();
		Integer[] arr = new Integer[20];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		showArr(arr);
		ex10_3_radixSort(arr, 0, arr.length, 100);
		showArr(arr);
	}
	
	private static void n11() {
		Random r = new Random();
		Integer[] arr = new Integer[20];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		showArr(arr);
		System.out.println(ex1_seqSearch(arr, 0, arr.length, 3));
	}
	
	private static void n12() {
		Random r = new Random();
		Integer[] arr = new Integer[20];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		ex6_mergeSort(arr, 0, arr.length);
		showArr(arr);
		System.out.println(ex2_binarySearch(arr, 0, arr.length, 3));
	}
	
	private static void n13() {
		Random r = new Random();
		Integer[] arr = new Integer[20];
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		ex6_mergeSort(arr, 0, arr.length);
		showArr(arr);
		System.out.println(ex3_interpolationSearch(arr, 0, arr.length, 3));
	}
	
	private static int h1(int K) {return (5*(K>>3)+1)%2048; }
	private static int h2(int K) {return K%98+1; }
	
	/**
	 * hash table example
	 * (2048 cells of positive numbers)
	 * 
	 * works using double hashing technique
	 * */
	private static void n14() {
		int[] H = new int[2048];
		final int count = 1024;
		
		Random r = new Random();
		
		// table initialization
		for (int i=0; i<2048; i++) H[i] = -1;
		for (int i=0; i<count; i++) {
			int value = Math.abs(r.nextInt());
			int j = h1(value);
			int step = h2(value);
			while (H[j]>=0) j = (j+step)%2048;
			H[j] = value;
		}
		
		// showing table to console
		for (int i=0; i<32; i++) {
			for (int j=0; j<64; j++) {
				if (H[j+i*32]>=0) System.out.print('#');
				else System.out.print('.');
			}
			System.out.print('\n');
		}
	}
	
	private static void n15() {
		String text = "tttrrrabacadagahaka,amnahaiaajalahklahgkahagjajakjakjhakjgakjhakjhgakjhgkhgkhggjgjgjgjgjgjgjgg";
		String pat  = "rrr";
		System.out.println(ex4_horspoolAlgorithm(pat, text));
	}
	
	
	
	private static <T extends Comparable<T>> void ex1_1_insertionSort(T[] A, int b, int e) {
		int i = b, j, k;
		for(++i; i!=e; i++) { 
			j=i; k=i;
			for(--j; (k!=b) && (A[j].compareTo(A[k])>0); --j, --k) {
				swap(A, k, j);
			}
		}
	}
	private static <T extends Comparable<T>> void ex1_2_insertionSort(T[] A, int b, int e) {
		int i = b, j, k;
		for(++i; i!=e; i++) {
			T x = A[i];
			j=i; k=i;
			for(--j; (k!=b) && (A[j].compareTo(x)>0); --j, --k) A[k] = A[j];
			A[k] = x;
		}
	}
	
	private static <T extends Comparable<T>> void ex2_selectionSort(T[] A, int b, int e) {
		int mini, i;
		for(; b!=e; ++b) {
			mini=b; i=b;
			for(++i; i!=e; ++i)
				if (A[mini].compareTo(A[i])>0)
					mini = i;
			if (b != mini) swap(A, b, mini);
		}
	}
	
	private static <T extends Comparable<T>> void ex3_bubbleSort(T[] A, int b, int e) {
		--e;
		int last, k, j;
		for(; b!=e; ++b) {
			last = e;
			for(k=e, j=k--; j!=b; j=k--) 
				if (A[j].compareTo(A[k])<0) {
					swap(A, j, k);
					last = k;
				}
			if (last == e) return;
			else b = last;
		}
	}
	
	private static <T extends Comparable<T>> void ex4_shakerSort(T[] A, int b, int e) {
		int last = --e;
		int j, k;
		
		for (;b!=e;) {
			for (k=e, j=k--; j!=b; j=k--) {
				if (A[j].compareTo(A[k])<0) {
					swap(A, j, k);
					last = k;
				}
			}
			if (last == e) return;
			else b = last;
			
			for (k=b, j=k++; j!=e; j=k++) {
				if (A[k].compareTo(A[j])<0) {
					swap(A, j, k);
					last = k;
				}
			}
			if (last == b) return;
			else e = last;
		}
		
	}
	
	private static <T extends Comparable<T>> void ex5_quickSort(T[] A, int b, int e) {
		int i = b; int j = e;
		--j; T x = A[i];
		do {
			while (A[i].compareTo(x)<0) ++i;
			while (x.compareTo(A[j])<0) --j;
			if (j>=i) {
				swap(A, i, j);
				++i; --j;
			}
		} while (j >= i);
		if (j>b) ex5_quickSort(A, b, j+1);
		if (e>i+1) ex5_quickSort(A, i, e);
	}
	
	private static <T extends Comparable<T>> void ex6_mergeSort(T[] A, int b, int e) {
		if (b >= e-1) return;
		int i = b + (e - b)/2;
		
		ex6_mergeSort(A, b, i);
		ex6_mergeSort(A, i, e);
		
		List<T> l = new ArrayList<>();
		List<T> r = new ArrayList<>();
		
		for (int j=b; j!=i; j++) l.add(A[j]);
		for (int j=i; j!=e; j++) r.add(A[j]);
		
		int li=0, ri=0;
		for (int j=b; j!=e; j++) {
			A[j]=(li == l.size()) ? r.get(ri++) :
				 (ri == r.size()) ? l.get(li++) :
				 (l.get(li).compareTo(r.get(ri))<0)
				 ? l.get(li++) : r.get(ri++);
		}
	}
	
	private static <T extends Comparable<T>> void ex7_1_heapSort(T[] A) {
		ex6_MinHeap<T> h = new ex6_MinHeap<>(A.clone(), A.length);
		for (int i=0; i<A.length; i++) {
			A[i] = h.heapPop();
		}
	}
	
	private static <T extends Comparable<T>> void ex8_binTreeSort(T[] A) {
		ex4_BinarySearchTree<T> tree = new ex4_BinarySearchTree<>();
		for (T x: A) {
			tree.treeInsert(x);
		}
		T[] t = tree.getArr();
		for (int i=0; i<A.length; i++) A[i] = t[i];
	}
	
	private static void ex9_1_countSort(Integer[] A, int b, int e, int maxValue) {
		int[] C = new int[maxValue+1];
		
		for (int j=b; j!=e; j++) ++C[A[j]];
		int i=0;
		for (int j=0; j<=maxValue; j++)
			for (int k=0; k<C[j]; k++)
				A[i++] = j;
	}
	
	private static void ex9_2_countSort(Integer[] A, int b, int e, int maxValue) {
		List<Integer>[] C = new ArrayList[maxValue+1];
		for (int j=0; j<=maxValue; j++) C[j] = new ArrayList<Integer>();
		
		for (int j=b; j!=e; j++) C[A[j]].add(A[j]);
		int i=0;
		for (int j=0; j<=maxValue; j++)
			for (int k=0; k<C[j].size(); k++)
				A[i++] = C[j].get(k);
	}
	
	private static void ex9_3_countSort(Integer[] A, int b, int e, int maxValue, AVF vF) {
		List<Integer>[] C = new ArrayList[maxValue+1];
		for (int j=0; j<=maxValue; j++) C[j] = new ArrayList<Integer>();
		
		for (int j=b; j!=e; j++) C[vF.VF(A[j])].add(A[j]);
		int i=0;
		for (int j=0; j<=maxValue; j++)
			for (int k=0; k<C[j].size(); k++)
				A[i++] = C[j].get(k);
	}
	
	/**
	 * value function abstract class
	 * */
	private static abstract class AVF {
		public int c;
		/**
		 * VF - value function
		 * gives discrete values from given input
		 * used for radix sort
		 * */
		public abstract int VF(int x);
		public AVF(int c) {
			this.c = c;
		}
	}
	private static class radix2Func extends AVF {
		public radix2Func(int c) {
			super(c);
		}
		@Override
		public int VF(int x) {
			x = x>>this.c;
			x -= (x>>1)<<1;
			return x;
		}
	}
	private static class radix4Func extends AVF {
		public radix4Func(int c) {
			super(c);
		}
		@Override
		public int VF(int x) {
			x = (x>>(2*this.c));
			x -= (x>>2)<<2;
			return x;
		}
	}
	private static class radix16Func extends AVF {
		public radix16Func(int c) {
			super(c);
		}
		@Override
		public int VF(int x) {
			x = (x>>(4*this.c));
			x -= (x>>4)<<4;
			return x;
		}
	}
	private static void ex10_1_radixSort(Integer[] A, int b, int e, int maxValue) {
		int maxD = 0;
		for(maxD=10; (new radix2Func(maxD)).VF(maxValue)==0; maxD--);
		for (int i=0; i<=maxD; i++) {
			ex9_3_countSort(A, b, e, 1, new radix2Func(i));
		}
	}
	private static void ex10_2_radixSort(Integer[] A, int b, int e, int maxValue) {
		int maxD = 0;
		for(maxD=10; (new radix4Func(maxD)).VF(maxValue)==0; maxD--);
		for (int i=0; i<=maxD; i++) {
			ex9_3_countSort(A, b, e, 3, new radix4Func(i));
		}
	}
	private static void ex10_3_radixSort(Integer[] A, int b, int e, int maxValue) {
		int maxD = 0;
		for(maxD=10; (new radix16Func(maxD)).VF(maxValue)==0; maxD--);
		for (int i=0; i<=maxD; i++) {
			ex9_3_countSort(A, b, e, 15, new radix16Func(i));
		}
	}
	
	private static <T extends Comparable<T>> int ex1_seqSearch(T[] A, int b, int e, T elem) {
		for (;b!=e;++b) if (A[b].compareTo(elem)==0) break;
		return b;
	}
	
	private static <T extends Comparable<T>> int ex2_binarySearch(T[] A, int b, int e, T elem) {
		int l=b, r=e, i;
		while(l<=r) {
			i = l + (r-l)/2;
			if (A[i].compareTo(elem)>0) r=--i;
			else if (A[i].compareTo(elem)<0) l = ++i;
			else return i;
		}
		return e;
	}
	
	private static int ex3_interpolationSearch(Integer[] A, int b, int e, Integer elem) {
		int l=b, r=e-1, i;
		while(l<=r) {
			if (A[l]==A[r] && A[l]!=elem) break;
			i = l + (elem-A[l])*(r-l)/(A[r]-A[l]);
			if (A[i]>elem) r=--i;
			else if (A[i]<elem) l = ++i;
			else return i;
		}
		return e;
	}

	
	private static int[] shiftTable(String p, int size) {
		int[] table = new int[size];
		for (int j=0; j<size; j++) table[j] = p.length();
		for (int j=0; j<p.length()-1; j++) table[p.charAt(j)] = p.length() - j - 1;
		return table;
	}
	private static int ex4_horspoolAlgorithm(String p, String text) {
		int[] table = shiftTable(p, 256);
		int m = p.length();
		for (int i=m-1; i<text.length(); i += table[text.charAt(i)]) {
			int k;
			for (k=0; k<m && p.charAt(m-k-1)==text.charAt(i-k); ++k);
			if (k==m) return i-m+1;
		}
		return -1;
	}
	
	
	
	
	private static <T> void showArr(T[] A) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	private static <E> void swap(E[] A, int i, int j) {E t = A[i]; A[i] = A[j]; A[j] = t; }
}
