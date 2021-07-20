package pack1;
import pack2.*;

public class A {
	protected String protectedMessage = "This is protected";
	
	/* Access levels
	 * ___________________________________________________
	 * |Modifier    | Class | Package | Subclass | World |
	 * |____________|_______|_________|__________|_______|
	 * |public      |   Y   |    Y    |     Y    |   Y   |
	 * |protected   |   Y   |    Y    |     Y    |   N   |
	 * |no modifier |   Y   |    Y    |     N    |   N   |
	 * |private     |   Y   |    N    |     N    |   N   |
	 * |____________|_______|_________|__________|_______|
	 * 
	 * */
	
	public static void main(String[] args) {
		C c = new C();
//		System.out.println(c.defaultMessage);
		System.out.println(c.publicMessage);
		
		B b = new B();
//		System.out.println(b.privateMessage);
	}
}
