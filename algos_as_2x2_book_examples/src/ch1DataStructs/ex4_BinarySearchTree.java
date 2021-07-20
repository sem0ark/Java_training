package ch1DataStructs;

public class ex4_BinarySearchTree<T extends Comparable<T>> {
	
	private Node root;
	private int len;
	
	private class Node {
		public T val;
		public Node left, right, parent;
		
		public Node(T val) {
			this.val = val;
		}
	}
	
	
	public ex4_BinarySearchTree() {
		this.len = 0;
	}
	
	public void treeShow() {
		treeShowWalk(this.root);
	}
	
	public boolean treeContains(T v) {
		Node x = this.root;
		
		while (x != null && x.val != v)
			if (v.compareTo(x.val) < 0) x = x.left;
			else x = x.right;
		return (x != null) ? true : false; 
	}
	
	public T treeMin() {
		Node x = this.root;
		while (x.left != null) x = x.left;
		return x.val;
	}
	
	public T treeMax() {
		Node x = this.root;
		while (x.right != null) x = x.right;
		return x.val;
	}
	
	public Node treeSuccessor(Node x) {
		if (x.right != null) return treeMin(x.right);
		Node y = x.parent;
		while (y!=null && x==y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public Node treePredecessor(Node x) {
		if (x.left != null) return treeMax(x.left);
		Node y = x.parent;
		while (y!=null && x==y.left) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public void treeInsert(T v) {
		this.len++;
		
		Node z = new Node(v);
		Node y = null, x = this.root;
		while (x != null) {
			y = x;
			if (z.val.compareTo(x.val) < 0) x = x.left;
			else x = x.right;
		}
		z.parent = y;
		if (y == null) this.root = z;
		else if (z.val.compareTo(y.val) < 0) y.left = z;
		else y.right = z;
	}
	
	public T treeRemove(T v) {
		this.len--;
		
		Node z = treeSearch(v);
		if (z == null) return null;
		
		Node y, x;
		if (z.left == null || z.right == null) y = z;
		else y = treeSuccessor(z);
		
		if (y.left != null) x = y.left;
		else x = y.right;
		
		if (x != null) x.parent = y.parent;
		if (y.parent == null) this.root = x;
		else if (y == y.parent.left) y.parent.left = x;
		else y.parent.right = x;
		
		if (y != z) z.val = y.val;
		return y.val;
	}
	
	public T[] getArr() {
		Node x = treeMin(this.root);
		T[] t = (T[]) new Comparable[this.len];
		for (int i=0; i<this.len; i++) {
			t[i] = x.val;
			x = treeSuccessor(x);
		}
		
		return t;
	}
	
	private Node treeMax(Node x) {
		while (x.right != null) x = x.right;
		return x;
	}
	
	private Node treeMin(Node x) {
		while (x.left != null) x = x.left;
		return x;
	}
	
	private void treeShowWalk(Node x) {
		if (x == null) return;
		
		treeShowWalk(x.left);
		
		System.out.print(x.val + " ");
		System.out.print(((x.left != null) ? x.left.val : '#') + " ");
		System.out.print(((x.right != null) ? x.right.val : '#') + " ");
		System.out.println((x.parent != null) ? x.parent.val : '#');
		
		treeShowWalk(x.right);
	}
	
	public Node treeSearch(T v) {
		Node x = this.root;
		
		while (x != null && x.val.compareTo(v) != 0)
			if (v.compareTo(x.val) < 0) x = x.left;
			else x = x.right;
		return x;
	}
}
