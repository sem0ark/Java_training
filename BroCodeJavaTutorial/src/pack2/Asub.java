package pack2;
import pack1.*;

public class Asub extends A{
	public static void main(String[] args) {
		Asub asub = new Asub();
		System.out.println(asub.protectedMessage);
	}
}
