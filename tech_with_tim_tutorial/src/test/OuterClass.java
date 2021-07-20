package test;

public class OuterClass {
	private class InnerClass {
		public void display() {
			System.out.println("This is inner class");
		}
	}
	
	public class PInnerClass {
		public void display() {
			System.out.println("This is public inner class");
		}
	}
	
	public void inner() {
		InnerClass inner = new InnerClass();
		inner.display();
	}
	
	public void inner2() {
		class MInnerClass{
			public void display() {
				System.out.println("Inner method class");
			}
		}
		
		MInnerClass inn  = new MInnerClass();
		inn.display();
	}
}
