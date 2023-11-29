
package Zadatak13;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Arkadii Semenov 5833 SI FIT
 * @summary DZ06 Task 13: <br>
 * compute the greatest digit in the given number with recursion.
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		
		try {
			int i = scan.nextInt();
			int res = compute(i);
			System.out.printf("The greatest digit of number %d is %d\n", i, res);
		} catch(InputMismatchException e) {
			main(args);
		}
		scan.close();
	}
	
	private static int compute(int x) {
		return compute_tail(x, 0);
	}
	
	private static int compute_tail(int x, int t) {
		if(x == 0) return t;
		return compute_tail(x/10, Math.max(x % 10, t));
	}
}
