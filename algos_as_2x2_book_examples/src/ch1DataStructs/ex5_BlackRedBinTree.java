package ch1DataStructs;


public class ex5_BlackRedBinTree<T extends Comparable<T>> {
	private enum Color {
		RED, BLACK
	}
	
	private class Node {
		public T val;
		public Node left, right, parent;
		public Color color = Color.BLACK;
		
		public Node(T val) {
			this.val = val;
		}
	}
	
	final Node NIL = new Node(null);
	private Node root;
	
	
	public ex5_BlackRedBinTree() {
		this.root = NIL;
	}
	
	public void treeShow() {
		treeShowWalk(this.root);
	}
	
	public boolean treeContains(T v) {
		Node x = this.root;
		
		while (x != NIL && x.val != v)
			if (v.compareTo(x.val) < 0) x = x.left;
			else x = x.right;
		return (x != NIL) ? true : false; 
	}
	
	public T treeMin() {
		Node x = this.root;
		while (x != NIL) x = x.left;
		return x.val;
	}
	
	public T treeMax() {
		Node x = this.root;
		while (x != NIL) x = x.right;
		return x.val;
	}
	
	public Node treeSuccessor(Node x) {
		if (x.right != NIL) return treeMin(x.right);
		Node y = x.parent;
		while (y!=NIL && x==y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public Node treePredecessor(Node x) {
		if (x.left != NIL) return treeMax(x.left);
		Node y = x.parent;
		while (y!=NIL && x==y.left) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public void treeInsert(T v) {
		Node z = new Node(v);
		
		Node y = NIL, x = this.root;
		while (x != NIL) {
			y = x;
			if (z.val.compareTo(x.val) < 0) x = x.left;
			else x = x.right;
		}
		z.parent = y;
		if (y == NIL) this.root = z;
		else if (z.val.compareTo(y.val) < 0) y.left = z;
		else y.right = z;
		z.color = Color.RED;
		z.left = NIL;
		z.right = NIL;
		insertFixUp(z);
	}
	
	public void treeRemove(T v) {
		Node z = treeSearch(v);
		if (z == null) return;
		
		Node y = NIL, x = NIL;
		
		if (z.left == NIL || z.right == NIL) y = z;
		else y = treeSuccessor(z);
		
		if (y.left != NIL) x = y.left;
		else x = y.right;
		x.parent = y.parent;
		if (y.parent == NIL) this.root = x;
		else if (y == y.parent.left) y.parent.left = x;
		else y.parent.right = x;
		
		if (y != z) z.val = y.val;
		if (y.color == Color.BLACK) removeFixUp(x);
	}
	
	
	
	private Node treeMax(Node x) {
		while (x.right != NIL) x = x.right;
		return x;
	}
	
	private Node treeMin(Node x) {
		while (x.left != NIL) x = x.left;
		return x;
	}
	
	private void treeShowWalk(Node x) {
		if (x == NIL) return;
		
		treeShowWalk(x.left);
		
		System.out.print(x.val + " ");
		System.out.print(((x.left != NIL) ? x.left.val : '#') + " ");
		System.out.print(((x.right != NIL) ? x.right.val : '#') + " ");
		System.out.print(((x.parent != NIL) ? x.parent.val : '#') + " ");
		System.out.println(x.color.name());
		
		treeShowWalk(x.right);
	}
	
	public Node treeSearch(T v) {
		Node x = this.root;
		
		while (x != NIL && x.val.compareTo(v) != 0)
			if (v.compareTo(x.val) < 0) x = x.left;
			else x = x.right;
		return x;
	}
	
	private void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		
		y.left.parent = x;
		y.parent = x.parent;
		
		if (x.parent == NIL) this.root = y;
		else if (x == x.parent.left) x.parent.left = y;
		else x.parent.right = y;
		y.left = x;
		x.parent = y;
	}
	
	private void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		
		y.right.parent = x;
		y.parent = x.parent;
		
		if (x.parent == NIL) this.root = y;
		else if (x == x.parent.right) x.parent.right = y;
		else x.parent.left = y;
		y.right = x;
		x.parent = y;
	}
	
	private void insertFixUp(Node z) {
		while (z.parent!=NIL && z.parent.color==Color.RED) {
			if (z.parent == z.parent.parent.left) {
				Node y = z.parent.parent.right;
				if (y.color == Color.RED) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					rightRotate(z.parent.parent);
				}
			} else {
				Node y = z.parent.parent.left;
				if (y!=NIL && y.color == Color.RED) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		
		this.root.color = Color.BLACK;
	}
	
	private void removeFixUp(Node x) {
		if (x == x.parent.left) {
			Node w = x.parent.right;
			if (w.color == Color.RED) {
				w.color = Color.BLACK;
				x.parent.color = Color.RED;
				leftRotate(x.parent);
				w = x.parent.right;
			}
			if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
				w.color = Color.RED;
				x = x.parent;
			} else {
				if (w.right.color == Color.BLACK) {
					w.left.color = Color.BLACK;
					w.color = Color.RED;
					rightRotate(w);
					w = x.parent.right;
				}
				w.color = x.parent.color;
				x.parent.color = Color.BLACK;
				w.right.color = Color.BLACK;
				leftRotate(x.parent);
				x = this.root;
			}
		} else {
			Node w = x.parent.left;
			if (w.color == Color.RED) {
				w.color = Color.BLACK;
				x.parent.color = Color.RED;
				rightRotate(x.parent);
				w = x.parent.left;
			}
			if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
				w.color = Color.RED;
				x = x.parent;
			} else {
				if (w.left.color == Color.BLACK) {
					w.right.color = Color.BLACK;
					w.color = Color.RED;
					leftRotate(w);
					w = x.parent.left;
				}
				w.color = x.parent.color;
				x.parent.color = Color.BLACK;
				w.left.color = Color.BLACK;
				rightRotate(x.parent);
				x = this.root;
			}
		}
		x.color = Color.BLACK;
	}
}
