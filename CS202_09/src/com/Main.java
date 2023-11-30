
package com;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		
	}
	
	private static void t1(LinkedList<Integer> nums) {
		System.out.println(nums.stream().reduce((a, b) -> Math.min(a, b)));
	}
	
	private static int t2(int num) {
		if(num == 0) return 0;
		return (num & 1) + t2(num / 10);
	}
}
