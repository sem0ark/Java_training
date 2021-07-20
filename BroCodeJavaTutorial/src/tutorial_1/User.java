package tutorial_1;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 4401294585104968665L;
	String name;
	transient String password;
	
	public void sayhello() {
		System.out.println("Hello " + name);
	}
}
