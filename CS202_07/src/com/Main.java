package com;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.stream().map(i -> {System.out.println(i); return i;}).toString();
	}
}
