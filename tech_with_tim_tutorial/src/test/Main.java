package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("\nt1 ------");
		t1();
		
		System.out.println("\nt2 ------");
		t2();
		
		System.out.println("\nt3 ------");
//		t3();
		
		System.out.println("\nt4 ------");
		t4();

		System.out.println("\nt5 ------");
//		t5();
		
		System.out.println("\nt6 ------");
//		t6();
		
		System.out.println("\nt7 ------");
		t7();
		
		System.out.println("\nt8 ------");
		t8();
		
		System.out.println("\nt9 ------");
//		t9();
		
		System.out.println("\nt10 ------");
//		t10();
		
		System.out.println("\nt11 ------");
//		t11();
		
		System.out.println("\nt12 ------");
		t12();
		
		System.out.println("\nt13 ------");
		t13();
		
		System.out.println("\nt14 ------");
		t14();
		
		System.out.println("\nt15 ------");
		t15();
		
		System.out.println("\nt16 ------");
		t16();
		
		System.out.println("\nt17 ------");
		t17();
		
		System.out.println("\nt17 task--");
		t17_task("hello it's me");
		
		System.out.println("\nt18 ------");
		t18();
		
		System.out.println("\nt19 ------");
		t19();
		
		System.out.println("\nt20 ------");
		t20();
		
		// introduction to classes
		
		System.out.println("\nt21 ------");
//		t21();
		
		System.out.println("\nt22 ------");
		t22();
		
		System.out.println("\nt23 ------");
		t23();
		
		System.out.println("\nt24 ------");
		t24();
		
		System.out.println("\nt25 ------");
		t25();
		
		System.out.println("\nt26 ------");
		t26();
		
		System.out.println("\nt27 ------");
		t27();
		
		System.out.println("\nt28 ------");
		t28();
		
		System.out.println("\nt29 ------");
		t29();
		
		System.out.println("\nt30 ------");
		t30();
	}
	
	private static void print(String s) { System.out.print(s); }
	private static void print(int s) { System.out.print(s); }
	private static void print(double s) { System.out.print(s); }
	private static void print(boolean s) { System.out.print(s); }
	private static void print(int[] s) {
		for (int i=0; i<s.length; i++) {
			print(s[i]);
			print(" ");
		}
		print("\n");
	}
	private static void print(double[] s) {
		for (int i=0; i<s.length; i++) {
			print(s[i]);
			print(" ");
		}
		print("\n");
	}
	private static void print(boolean[] s) {
		for (int i=0; i<s.length; i++) {
			print(s[i]);
			print(" ");
		}
		print("\n");
	}
	
	public static void t1() {
		int t = 10;
		System.out.println(t);
		System.out.println("testestetsetest");
		System.out.println("testestetsetest * * * 2");
	}

	public static void t2() {
		int hello_world = 5;
		System.out.println(hello_world);
		
	}
	
	public static void t3() {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		int s2 = sc.nextInt();
		boolean s3 = sc.nextBoolean();
		double s4 = sc.nextDouble();
		
		System.out.println("Printed " + s1);
		System.out.println("Printed " + s2);
		System.out.println("Printed " + s3);
		System.out.println("Printed " + s4);
		
		int x1 = Integer.parseInt(sc.next());
		double x2 = Double.parseDouble(sc.next());
		boolean x3 = Boolean.parseBoolean(sc.next());
		System.out.println(x1 + " " + x2 + " " + x3);
	}
	
	public static void t4() {
		int a, b, c;
		String s;
		boolean fg;
		
		s = "helohelo";
		a = b = 23;
		c = 20;
		
		fg = !(a==b) || (s.contains("lo") && a <= b && s.equals(s));
		
		System.out.println(fg);
	}
	
	public static void t5() {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		String s = "";
		for (int i=0; i<x; i++) {
			s += sc.next();
		}
	}
	
	public static void t6() {
		Scanner sc = new Scanner(System.in);
		print("Enter your age: ");
		int age = sc.nextInt();
		if (age >= 20) {
			print(age + "? --> You are old ...\n");
			if (age == 999) {
				print("Smth went wrong with you.'.'.'.\n");
			}
		} else if (age == 18) {
			print("testestestestest\n");
		} else {
			print(age + "? --> You are young ...\n");
		}
	}
	
	public static void t7() {
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2};
		x[9] = 10;
		
		for (int i=0; i<x.length; i++) {
			print(x[i]);
		}
		print("\n");
		print(x);
		print("\n");
	}
	
	public static void t8() {
		int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == 5) {
				print("Found a 5 at " + i + "\n");
			} else {
				print(arr[i] + "...\n");
			}
		}
	}
	
	public static void t9() {
		int[] arr = {1, 7, 8, 4, 5};
		String[] names = new String[5];
		
		int c=0;
		for (int i: arr) {
			print(i + " " + c + "\n");
			c++;
		}
		
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<names.length; i++) {
			print("input: ");
			names[i] = sc.nextLine();
		}
		
		for (String i: names) {
			print(i + " ");
			if (i.equals("stop")) {break;}
		}
		print("\n");
	}
	
	public static void t10() {
		Scanner sc = new Scanner(System.in);
		int x=-1;
		while (x!=0) {
			x = sc.nextInt();
		}
	}
	
	public static void t11() {
		Scanner sc = new Scanner(System.in);
		int x;
		do {
			x = sc.nextInt();
		} while (x != 10);
	}
	
	public static void t12() {
		Set<Integer> t = new HashSet<Integer>();
		t.add(5);
		t.add(7);
		t.add(5);
		t.add(5);
		t.add(9);
		t.add(-8);
		t.remove(9);
		
		boolean  x = t.contains(0);
		
		System.out.println(x);
		System.out.println(t + " " + t.size() + " " + t.isEmpty());
	}

	public static void t13() {
		Set<Integer> t = new TreeSet<Integer>(); // sorted order
		t.add(5);
		t.add(7);
		t.add(5);
		t.add(5);
		t.add(9);
		t.add(-8);
		t.remove(9);
		
		boolean  x = t.contains(0);
		
		System.out.println(x);
		System.out.println(t + " " + t.size() + " " + t.isEmpty());
	}
	
	public static void t14() {
		Set<Integer> t = new LinkedHashSet<Integer>();
		t.add(5);
		t.add(7);
		t.add(5);
		t.add(5);
		t.add(9);
		t.add(-8);
		t.remove(9);
		
		boolean  x = t.contains(0);
		
		System.out.println(x);
		System.out.println(t + " " + t.size() + " " + t.isEmpty());
	}
	
	public static void t15() {
		ArrayList<Integer> t = new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			t.add(i);
		}
		t.get(0);
		t.set(1, 5);
		System.out.println(t);
		System.out.println(t.subList(1, 3));
	}
	
	public static void t16() {
		LinkedList<Integer> t = new LinkedList<Integer>();
		for (int i=0; i<10; i++) {
			t.add(i);
		}
		t.get(0);
		t.set(1, 5);
		System.out.println(t);
		System.out.println(t.subList(1, 3));
	}
	
	public static void t17() {
		Map m = new HashMap();
		
		m.put("tim", 5);
		m.put("joe", "x");
		m.put(11, 999);
		m.put("12", 5);
		m.put("a","b");
		
		m.containsValue("b");
		m.containsKey("a");
		
		System.out.println(m);
		System.out.println(m.get("tim"));
		System.out.println(m.get(239128));
		System.out.println(m.values());
		m.clear();
		System.out.println(m.values() + " " + m.isEmpty());
	}
	
	public static void t17_task(String s) {
		Map m = new HashMap<Character, Integer>();
		int x;
		for (char c: s.toCharArray()) {
			if (m.containsKey(c)) {
				x = (int) m.get(c);
				m.put(c, x+1);
			} else {
				m.put(c, 1);
			}
		}
		
		System.out.println(m);
	}	
	public static void t18() {
		Map m = new TreeMap(); // sorted order
		
		m.put("tim", 5); //keys have to be the same
		m.put("joe", "x");
		m.put("12", 5);
		
		System.out.println(m);
		System.out.println(m.get("tim"));
	}
	
	public static void t19() {
		Map m = new LinkedHashMap();
		
		m.put("tim", 5);
		m.put("joe", "x");
		m.put("12", 5);
		
		System.out.println(m);
		System.out.println(m.get("tim"));
	}
	
	public static void t20() {
		int[] x = {-99,5,3,1,2,4,1,2,4,7,4,8,9,6,0};
		Arrays.sort(x, 1, 7);
		print(x);
		
		Arrays.sort(x);
		print(x);
	}
	
	
	// introduction to classes
	public static void t21() {
		Scanner sc =  new Scanner(System.in);
		tim(sc.nextLine(), 5);
		print(add2(6) + "\n");
		print(louder("hello") + "\n");
	}
	
	public static void tim(String s, int x) {
		for (int i=0; i<x; i++) {
			System.out.println(s);
		}
	}
	
	public static int add2(int x) {
		return x+2;
	}
	
	public static String louder(String x) {
		return x + "!";
	}
	// -----
	
	public static void t22() {
		Dog tim =  new Dog("tim",  4);
		Dog bill = new Dog("bill", 7);
		Dog bob =  new Dog("bob",  11);
		
		tim.speak();
		bill.speak();
		bob.speak();
		
		print(tim.getAge() + "\n");
	}
	
	public static void t23() {
		Cat tim =  new Cat("tim", 4, 16);
		Cat bob =  new Cat("bob", 4);
		Cat bib =  new Cat("bib");
		
		tim.speak();
		bob.speak();
		bib.speak();
	}
	
	public static void t24() {
		Dog tim =  new Dog("tim",  4);
		Dog bill = new Dog("bill", 7);
		Dog bob =  new Dog("bob",  11);
		
		print(tim.getCount() + " " + bill.getCount() + " " + bob.getCount() + "\n");
	}
	
	public static void t25() {
		Student tim =  new Student("tim");
		Student tim2 =  new Student("tim");
		Student bob =  new Student("bob");
		
		System.out.println(tim == tim2);
		System.out.println(tim == bob);
		System.out.println(tim.equals(tim2));
		System.out.println(tim.compareTo(bob));
		System.out.println(tim.toString());
	}
	
	public static void t26() {
		OuterClass outer = new OuterClass();
		outer.inner();
		
		OuterClass.PInnerClass inner = outer.new PInnerClass();
		inner.display();
	}
	
	public static void t27() {
		OuterClass outer = new OuterClass();
		outer.inner2();
	}
	
	public static void t28() {
		Car ford = new Car();
		ford.speedUp(10);
		ford.changeGear(2);
		ford.display();
	}

	public static void t29() {
		System.out.println(Vehicle.math(5));
	}
	
	public static void t30() {
		Level lvl = Level.LOW;
		String en = lvl.toString();
		Level[] arr = Level.values();
		
		for (Level l : arr) {
			System.out.println(l);
		}
		
		if (lvl == Level.LOW) {
			print(lvl+"\n");
		} else if (lvl == Level.MEDIUM) {
			print(lvl+"\n");
		} else {
			print(lvl+"\n");
		}
		
		System.out.println(lvl.getLvl());
		System.out.println(Level.valueOf("LOW"));
		
		lvl.setLvl(5);
		
		System.out.println(lvl.getLvl());
	}
}
