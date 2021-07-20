package ch1DataStructs;


public class Main {

	public static void main(String[] args) {
		System.out.println("prog_1 -------------");
		n1();
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
		System.out.println("prog_6_1 -------------");
		n6_1();
		System.out.println("\n\n");
		System.out.println("prog_6_2 -------------");
		n6_2();
		System.out.println("\n\n");
	}
	
	private static void n1() {
		ex1_Stack<Integer> s = new ex1_Stack<>(4);
		for(int i=0; i<3; i++) s.push(i);
		for(int i=0; i<3; i++) System.out.println(s.pop());
	}
	
	private static void n2() {
		ex2_Queue<Integer> q = new ex2_Queue<>(4);
		for(int i=0; i<3; i++) q.enqueue(i);
		for(int i=0; i<3; i++) System.out.println(q.dequeue());
	}

	private static void n3() {
		ex3_LinkedList<String> s = new ex3_LinkedList<>();
		
		s.showAll();
		
		s.append("0");
		s.append("1");
		s.append("5");
		s.append("2");
		
		s.remove("1");
		
		s.showAll();
	}
	
	private static void n4() {
		ex4_BinarySearchTree<Integer> tree = new ex4_BinarySearchTree<>();
		
		tree.treeInsert(7);
		tree.treeInsert(17);
		tree.treeInsert(8);
		tree.treeInsert(5);
		tree.treeInsert(22);
		tree.treeInsert(23);
		tree.treeInsert(1);
		tree.treeInsert(3);
		tree.treeInsert(2);
		tree.treeInsert(5);
		tree.treeInsert(4);
		tree.treeInsert(6);
		
		tree.treeRemove(3);
		
		tree.treeShow();
	}
	
	private static void n5() {
		ex5_BlackRedBinTree<Integer> tree = new ex5_BlackRedBinTree<>();
		
		tree.treeInsert(7);
		tree.treeInsert(17);
		tree.treeInsert(8);
		tree.treeInsert(5);
		tree.treeInsert(22);
		tree.treeInsert(23);
		tree.treeInsert(1);
		tree.treeInsert(3);
		tree.treeInsert(2);
		tree.treeInsert(5);
		tree.treeInsert(4);
		tree.treeInsert(6);
		
		tree.treeShow();
		System.out.println();
		
		tree.treeRemove(3);
		
		tree.treeShow();
	}
	
	private static void n6_1() {
		ex6_MaxHeap<Integer> h = new ex6_MaxHeap<>(new Integer[100], 0);
		
		h.heapPush(4);
		h.heapPush(5);
		h.heapPush(6);
		h.heapPush(1);
		h.heapPush(2);
		h.heapPush(3);
		h.heapPush(4);
		h.heapPush(5);
		h.heapPush(6);
		h.heapPush(1);
		h.heapPush(2);
		h.heapPush(3);
		
		while (!h.empty()) {
			System.out.println(h.heapPop());
		}
	}
	
	private static void n6_2() {
		ex6_MinHeap<Integer> h = new ex6_MinHeap<>(new Integer[100], 0);
		h.heapPush(4);
		h.heapPush(5);
		h.heapPush(6);
		h.heapPush(1);
		h.heapPush(2);
		h.heapPush(3);
		h.heapPush(4);
		h.heapPush(5);
		h.heapPush(6);
		h.heapPush(1);
		h.heapPush(2);
		h.heapPush(3);
		
		while (!h.empty()) {
			System.out.println(h.heapPop());
		}
	}
}
