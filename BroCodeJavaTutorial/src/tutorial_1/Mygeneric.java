package tutorial_1;
//						. can be multiple Ex: <T, V, Thing1>
public class Mygeneric <T> {
	T x;
	Mygeneric(T x) {
		this.x = x;
	}
	
	public T getVal() {
		return x;
	}
}
