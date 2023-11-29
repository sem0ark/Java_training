package zadatak3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Arkadii Semenov 5833
 * @summary CS202-DZ07 Task 3 done by Arkadii Semenov 5833 SI FIT
 *
 */
public class Main {
	public static void main(String[] args) {
		Stack<Integer> A = getValues();
		Stack<Integer> B = new Stack<>();
		Stack<Integer> C = new Stack<>();
		
		while(!A.isEmpty()) B.push(A.pop());
		while(!B.isEmpty()) {
			int v = B.pop();
			C.push(v);
			A.push(v);
		}
		
		showStack(A);
		showStack(C);
		System.out.println("As you can see, the values are identical.");
	}
	
	public static Stack<Integer> getValues() {
		Stack<Integer> A = new Stack<>();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter the numbers into the stack. Stop with -1");
		
		try {
			int i = 0; 
			while(true) {
				i = scan.nextInt();
				if(i == -1) break;
				A.push(i);
			}
		} catch (InputMismatchException e) {
			System.out.println("Please, provide correct input!");
		} finally {
			scan.close();
		}
		
		return A;
	}
	
	public static void showStack(Stack<Integer> s) {
		for(int i : s) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
