package tutorial_1;

public class NPair <T extends Number, V extends Number> {
	
	public final T first;
	public final V second;
	
	NPair(T first, V second) {
		this.first = first;
		this.second = second;
	}
}

