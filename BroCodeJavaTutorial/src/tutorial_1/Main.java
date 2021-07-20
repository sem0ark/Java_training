package tutorial_1;

import Tools.ToolBox; // another package

import javax.sound.sampled.*;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {
	/*
	 * EVERYTHING FROM TUTORIAL: 
	 * 		https://youtu.be/xk4_1vDrzzo
	 * */
	
	// some topics were skipped!
	public static void main(String[] args) {
		System.out.println("\nt1   ------------");
		t1();
		
		System.out.println("\nt2   ------------");
		t2();
		
		System.out.println("\nt3   ------------");
//		t3();
		
		System.out.println("\nt4   ------------");
		t4();
		
		System.out.println("\nt5   ------------");
//		t5();
		
		System.out.println("\nt6   ------------");
		t6();
		
		System.out.println("\nt7   ------------");
		t7();
		
		System.out.println("\nt8   ------------");
		t8();
		
		System.out.println("\nt9   ------------");
		t9();
		
		System.out.println("\nt10   ------------");
//		t10();
		
		System.out.println("\nt11   ------------");
		t11();
		
		System.out.println("\nt12   ------------");
//		t12();
		
		System.out.println("\nt13   ------------");
		t13();
		
		System.out.println("\nt14   ------------");
		t14();
		
		System.out.println("\nt15   ------------");
		t15();
		
		System.out.println("\nt16   ------------");
		t16();
		
		System.out.println("\nt17   ------------");
		t17();
		
		System.out.println("\nt18   ------------");
		t18();
		
		System.out.println("\nt19   ------------");
		t19();
		
		System.out.println("\nt20   ------------");
		t20();
		
		System.out.println("\nt21   ------------");
		t21();
		
		System.out.println("\nt22   ------------");
		t22();
		
		System.out.println("\nt23   ------------");
		t23();
		
		System.out.println("\nt24   ------------");
		t24();
		
		System.out.println("\nt25   ------------");
		t25();
		
		System.out.println("\nt26   ------------");
		t26();
		
		System.out.println("\nt27   ------------");
		t27();
		
		System.out.println("\nt28   ------------");
		t28();
		
		System.out.println("\nt29   ------------");
		t29();
		
		System.out.println("\nt30   ------------");
		t30();
		
		System.out.println("\nt31   ------------");
		t31();
		
		System.out.println("\nt32   ------------");
		t32();
		
		System.out.println("\nt33   ------------");
		t33();
		
		System.out.println("\nt34   ------------");
		t34();
		
		System.out.println("\nt35   ------------");
		t35();
		
		System.out.println("\nt36   ------------");
		t36();
		
		System.out.println("\nt37   ------------");
//		t37();
		
		System.out.println("\nt38   ------------");
//		t38();
		
		System.out.println("\nt39   ------------");
		t39();
		
		System.out.println("\nt40   ------------");
		t40();
		
		System.out.println("\nt41   ------------");
		t41();
		
		System.out.println("\nt42   ------------");
//		t42();
		
		System.out.println("\nt43   ------------");
		t43();
		
		System.out.println("\nt44   ------------");
		t44();
		
		System.out.println("\nt45   ------------");
		t45();
		
		System.out.println("\nt46   ------------");
		t46();
		
		System.out.println("\nt47   ------------");
		t47();
		
		System.out.println("\nt48   ------------");
//		t48();
		
		System.out.println("\nt49   ------------");
//		t49();
		
		System.out.println("\nt50   ------------");
//		t50();
		
		System.out.println("\nt51   ------------");
		t51();
		
	}
	
	public static void t1() {
		System.out.println("I love pizza!");
		System.out.println("It's very good!");
		System.out.println();
		System.out.print("I love pizza!");
		System.out.println("It's very good!");
		System.out.println();
		System.out.println("\tI \"love\" pizza!");
		System.out.println("It's \\very good!"); // this is a comment
		
		/*
		 * this
		 * is
		 * a
		 * comment
		 * */
	}
	
	public static void t2() {
		String x = "water";
		String y = "kool-aid";
		String t;
		
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		t=x; x=y; y=t;
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
	}
	
	public static void t3() {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		System.out.println(t);
		sc.close();
	}
	
	public static void t4() {
		int x = 10;
		x = x/2;
		x = x*2;
		x = x%3;
		x++;
		x--;
		x = x+12;
		x = x-5;
	}
	
	public static void t5() {
		double x=3.14, y=-10;
		System.out.println(Math.max(x, y));
		System.out.println(Math.min(x, y));
		System.out.println(Math.abs(y));
		System.out.println(Math.sqrt(x));
		System.out.println(Math.round(x));
		System.out.println(Math.ceil(x));
		System.out.println(Math.floor(x));
		
		double a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter side a: ");
		a = sc.nextDouble();
		System.out.print("Enter side b: ");
		b = sc.nextDouble();
		c = Math.sqrt(a*a+b*b);
		System.out.println("hypotenuse: "+c);
		sc.close();
	}
	
	public static void t6() {
		Random rand = new Random();
		
		int x1 = rand.nextInt(6);
		System.out.println(x1);
		
		double x2 = rand.nextDouble();
		System.out.println(x2);
		
		boolean x3 = rand.nextBoolean();
		System.out.println(x3);
	}
	
	public static void t7() {
		int age = 18;
		if (age<18) {
			System.out.println("You are not an adult!");
		} else if (age>=75) {
			System.out.println("Ok Boomer!");
		} else {
			System.out.println("You are an adult!");
		} 
	}
	
	public static void t8() {
		String day = "Friday";
		switch(day) {
		case "Sunday": System.out.println("It's Sunday");
		break;
		case "Monday": System.out.println("It's Monday");
		break;
		case "Tuesday": System.out.println("It's Tuesday");
		break;
		case "Wednesday": System.out.println("It's Wednesday");
		break;
		case "Thursday": System.out.println("It's Thursday");
		break;
		case "Friday": System.out.println("It's Friday");
		break;
		case "Saturday": System.out.println("It's Saturday");
		break;
		default: System.out.println("This is not a day");
		}
	}
	
	public static void t9() {
		if (9==9 && 2-1<0 || !(1==0)) {
			System.out.println("This is math.1.1.1.");
		}
	}
	
	public static void t10() {
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		while(name.isBlank()) {
			System.out.print("Enter your name: ");
			name = sc.nextLine();
		}
		System.out.println("Hello "+name);
		
		name = "";
		do {
			System.out.print("Enter your name: ");
			name = sc.nextLine();
		} while(name.isBlank());
		System.out.println("Hello "+name);
		
		sc.close();
	}
	
	public static void t11() {
		for (int i=0; i<10; i++) {
			System.out.print(i);
		}
		System.out.println();
		for (int i=9; i>=0; i--) {
			System.out.print(i);
		}
		System.out.println("Happy new year!");
		for (int i=9; i>=0; i-=2) {
			System.out.print(i);
		}
	}
	
	public static void t12() {
		Scanner sc  = new Scanner(System.in);
		int rows, cols;
		String symbol = "";
		System.out.print("Enter # of rows: ");
		rows = sc.nextInt();
		System.out.print("Enter # of cols: ");
		cols = sc.nextInt();
		
		System.out.print("Enter symbol to use: ");
		symbol = sc.next();
		
		for (int i=0; i<rows; i++) {
			System.out.println();
			for (int j=0; j<cols; j++) {
				System.out.print(symbol);
			}
		}
		sc.close();
	}
	
	public static void t13() {
		String name = "  Dro  ";
		System.out.println(name.charAt(3));
		System.out.println(name.indexOf("o"));
		System.out.println(name.isBlank());
		System.out.println(name.isEmpty());
		System.out.println(name.length());
		
		System.out.println(name.toUpperCase());
		System.out.println(name.toLowerCase());
		
		System.out.println(name.trim());
		System.out.println(name.replace(' ', '='));
	}
	
	public static void t14() {
		Integer i = 12010;
		Boolean b = true;
		Character c  = ' ';
		Double d = 129.231;
		
		System.out.println(Integer.toBinaryString(i));
	}
	
	public static void t15() {
		ArrayList<String> food = new ArrayList<String>();
		food.add("pizza");
		food.add("hotdog");
		food.add("hamburger");
		
		food.set(1, "sushi");
		food.remove(2);
		
		for (int i=0; i<food.size(); i++) {
			System.out.println(food.get(i));
		}

		food.clear();
	}
	
	public static void t16() {
		ArrayList<ArrayList<String>> groceryList = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> bakeryList = new ArrayList<String>();
		bakeryList.add("Pasta");
		bakeryList.add("Garlic bread");
		bakeryList.add("Donuts");
		
		ArrayList<String> produceList = new ArrayList<String>();
		produceList.add("tomatoes");
		produceList.add("zucchini");
		produceList.add("peppers");
		
		ArrayList<String> drinksList = new ArrayList<String>();
		drinksList.add("soda");
		drinksList.add("coffe");
		
		groceryList.add(bakeryList);
		groceryList.add(produceList);
		groceryList.add(drinksList);
		
		System.out.println(groceryList);
		System.out.println(groceryList.get(2));
		System.out.println(groceryList.get(2).get(0));
	}
	
	public static void t17() {
		String[] animals = {"cat", "dog(colly)", "rat", "bird(parrot)"};
		ArrayList<String> animals2 = new ArrayList<String>();
		
		animals2.add("cat");
		animals2.add("doggy");
		animals2.add("raven");
		animals2.add("bird");
		
		for(String i : animals) {
			System.out.println(i);
		}
		
		for(String i : animals2) {
			System.out.println(i);
		}
	}
	
	static void hello(String name, int age) {
		System.out.println("Hello, "+name);
		System.out.println("You are "+age);
	}
	static int add_(int x, int y) {
		return x+y;
	}
	public static void t18() {
		hello("Bro", 13);
		hello("Bra", 15);
		hello("Bri", 20);
		
		System.out.println(add_(11, 239));
	}
	
	static int add2(int x) {
		System.out.println("this is overloaded method #1");
		return x;
	}
	static int add2(int x, int y) {
		System.out.println("this is overloaded method #2");
		return x+y;
	}
	static int add2(int x, int y, int z) {
		System.out.println("this is overloaded method #3");
		return x+y+z;
	}
	static int add2(int x, int y, int z, int w) {
		System.out.println("this is overloaded method #4");
		return x+y+z+w;
	}
	static double add2(double x, double y) {
		System.out.println("this is overloaded method #5");
		return x+y;
	}
	static double add2(double x, double y, double z) {
		System.out.println("this is overloaded method #6");
		return x+y+z;
	}
	public static void t19() {
		System.out.println(add2(1));
		System.out.println(add2(1, 2));
		System.out.println(add2(1, 2, 3));
		System.out.println(add2(1, 2, 3, 4));
		System.out.println(add2(1.0, 2.0));
		System.out.println(add2(1.0, 2.0, 3.0));
	}
	
	public static void t20() {
		int i = 12010;
		boolean b = true;
		char c  = '@';
		double d = 12009.261;
		String s = "tetetetetest";
		
		System.out.printf("format string %d\n", i);
		System.out.printf("format string %b\n", b);
		System.out.printf("format string %c\n", c);
		System.out.printf("format string %s\n", s);
		System.out.printf("format string %f\n", d);
		
		System.out.printf("format string %10f\n", d);
		System.out.printf("format string %10d\n", i);
		
		System.out.printf("format string %-10f_\n", d);
		System.out.printf("format string %-10d_\n", i);
		
		System.out.printf("format string %.2f\n", d);
		
		System.out.printf("format string %020f\n", d);
		
		System.out.printf("format string %,f\n", d);
	}
	
	public static void t21() {
		final double PI = 3.14159;
		
		System.out.println(PI);
	}
	
	public static void t22() {
		Car myCar1 = new Car();
		Car myCar2 = new Car();
		
		System.out.println(myCar1.make);
		System.out.println(myCar1.model);
		myCar1.drive();
		myCar1.brake();

		System.out.println(myCar2.make);
		System.out.println(myCar2.model);
		myCar2.drive();
		myCar2.brake();
	}
	
	public static void t23() {
		Human h1 = new Human("Rick", 65, 70);
		Human h2 = new Human("Morty", 16, 50);
		
		System.out.println(h1.name);
		System.out.println(h2.name);
		h2.eat();
		h1.drink();
	}
	
	public static void t24() {
		DiceRoller dice = new DiceRoller();
		dice.roll();
	}
	
	public static void t25() {
		Pizza pizza = new Pizza("thicc crust", "tomato", "mozzarella", "peperoni");
		System.out.println("Here are your ingredients of your pizza: ");
		System.out.println(pizza.bread);
		System.out.println(pizza.sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.topping);
		
		pizza = new Pizza("thicc crust", "tomato", "mozzarella");
		System.out.println("\nHere are your ingredients of your pizza: ");
		System.out.println(pizza.bread);
		System.out.println(pizza.sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.topping);
		
		pizza = new Pizza("thicc crust", "tomato");
		System.out.println("\nHere are your ingredients of your pizza: ");
		System.out.println(pizza.bread);
		System.out.println(pizza.sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.topping);
		
		pizza = new Pizza("thicc crust");
		System.out.println("\nHere are your ingredients of your pizza: ");
		System.out.println(pizza.bread);
		System.out.println(pizza.sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.topping);
		
		pizza = new Pizza();
		System.out.println("\nHere are your ingredients of your pizza: ");
		System.out.println(pizza.bread);
		System.out.println(pizza.sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.topping);
	}
	
	public static void t26() {
		Car myCar1 = new Car();
		System.out.println(myCar1);
	}
	
	public static void t27() {
		Random r = new Random();
		Food[] refrigerator = new Food[3];
		String[] names = {"pizza", "pasta", "hotdog"};
		for (int i=0; i<refrigerator.length; i++) {
			refrigerator[i] = new Food(names[i], r.nextInt(7)+1);
		}
		
		for (int i=0; i<refrigerator.length; i++) {
			System.out.println(refrigerator[i]);
		}
	}
	
	public static void t28() {
		Garage garage = new Garage();
		garage.park(new Car2("BMW"));
		garage.park(new Car2("Tesla"));
		garage.park(new Car2("Chevrole"));
		System.out.println(garage);
		garage.showCars();
	}
	
	public static void t29() {
		Friend friend1 = new Friend("Spongebob");
		Friend friend2 = new Friend("Patrick");
		Friend friend3 = new Friend("Squidward");
		System.out.println(friend1 + " " + friend2 + " " + friend3);
		Friend.displayNumberOfFriends();
	}
	
	public static void t30() {
		Car3 car = new Car3();
		car.go();
		
		Bicycle bike = new Bicycle();
		bike.go();
		
		System.out.println(car.speed +" "+ bike.speed);
		System.out.println(car.wheels +" "+ car.doors);
		System.out.println(bike.wheels +" "+ bike.pedals);
	}
	
	public static void t31() {
		Animal animal = new Animal();
		Dog dog = new Dog();
		
		animal.speak();
		dog.speak();
	}

	public static void t32() {
		Hero hero1 = new Hero("Batman", 42, "$$$");
		Hero hero2 = new Hero("SuperHero", 42, "everything");
		
		System.out.println(hero1);
		System.out.println(hero2);
	}
	
	
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
	
	
	public static void t33() {
		Car5 car = new Car5("Chevrolet", "Camaro", 2021);
		System.out.println(car.getMake() + " " + car.getModel() + " " + car.getYear());
		
		car.setYear(2022);
		System.out.println(car.getMake() + " " + car.getModel() + " " + car.getYear());
	}
	
	public static void t34() {
		Car5 car1 = new Car5("Chevrolet", "Camaro", 2021);
		Car5 car2 = new Car5("Ford", "Mustang", 2022);
		Car5 car3 = new Car5(car2);
		
		car2.copy(car1);
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
	}
	
	public static void t35() {
		/* Interface -> A template that can be applied to a class.
		 * 				Similar to inheritance, but specifies what a class has/must do.
		 * 				Classes can apply more than one interface, inheritance is
		 * 					limited to 1 direct super.
		 * */
		
		Rabbit rabbit = new Rabbit();
		rabbit.flee();
		
		Hawk hawk = new Hawk();
		hawk.hunt();
		
		Fish fish = new Fish();
		fish.flee();
		fish.hunt();
	}
	
	public static void t36() {
		Car6 car = new Car6();
		Bicycle2 bicycle = new Bicycle2();
		Boat boat = new Boat();
		
		Vehicle2[] racers = {car, boat, bicycle};
		
		for (Vehicle2 i: racers) {
			System.out.print(i + "  ");
			i.go();
		}
	}

	public static void t37() {
		Animal2 animal;
		Scanner sc = new Scanner(System.in);
		System.out.println("What animal do you want?");
		System.out.print("(1=Dog) or (2=Cat): ");
		int choice = sc.nextInt();
		if (choice == 1) {
			animal = new Dog2();
			animal.speak();
		} else if (choice == 2) {
			animal = new Cat();
			animal.speak();
		} else {
			animal = new Animal2();
			animal.speak();
			System.out.println("This choice was invalid.");
		}
		sc.close();
	}
	
	public static void t38() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter a whole number to divide: ");
			int x1 = sc.nextInt();
			System.out.println("Enter a whole number to divide by: ");
			int x2 = sc.nextInt();
			
			int z = x1/x2;
			
			System.out.println("result: "+z);
		}
		catch(ArithmeticException e) {
			System.out.println("You can't divide by zero.");
		}
		catch(InputMismatchException e) {
			System.out.println("Please, enter a WHOLE NUMBER.");
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
		finally {
			System.out.println("This will always print");
			sc.close();
		}
	}
	
	public static void t39() {
		File file = new File("test.txt");
		
		if (file.exists()) {
			System.out.println("That file exists!");
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			
			System.out.println(file.isFile());
			System.out.println(file.isDirectory());
		} else {
			System.out.println("That file doesn't exists!");
		}
	}
	
	public static void t40() {
		try {
			FileWriter writer = new FileWriter("poem.txt");
			writer.write("Roses are red \nViolets are blue \nRockin' everywhere!");
			writer.append("\n(A poem by Bri)");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void t41() {
		try {
			FileReader reader = new FileReader("test2.txt");
			int data = reader.read();
			while (data != -1) {
				System.out.print((char) data);
				data = reader.read();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void t42() {
		Scanner sc = new Scanner(System.in);
		try {
			File file = new File("Three_A2EG3.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			
			String response = "";
			while(!response.equals("Q")) {
				System.out.println("P=play, S=stop, R=reset, Q=quit");
				System.out.print("Ente your choice: ");
				
				response = sc.nextLine();
				response = response.toUpperCase();
				
				switch(response) {
					case("P"): clip.start(); break;
					case("S"): clip.stop(); break;
					case("R"): clip.setMicrosecondPosition(0); break;
					case("Q"): clip.close(); break;
					default: System.out.println("Not a valid response.");
					
				}
			}
			System.out.println("Bye.");
		}
		catch(Exception e) {
			System.out.println("smth went wrong");
		}
		finally {
			sc.close();
		}
	}
	
	public static void t43() {
		// creating anonymous inner class for only one instance
		Greeting greet = new Greeting() {
			@Override
			public void welcome() {
				System.out.println("welcome it is overriden");
			}
		};
		
		greet.welcome();
	}
	
	
//	inconvenient
//	private static void displayArr(Integer[] arr) {
//		for (Integer x:  arr) {System.out.print(x+" ");}
//		System.out.println();
//	}
//	private static void displayArr(Double[] arr) {
//		for (Double x:  arr) {System.out.print(x+" ");}
//		System.out.println();
//	}
//	private static void displayArr(Character[] arr) {
//		for (Character x:  arr) {System.out.print(x+" ");}
//		System.out.println();
//	}
//	private static void displayArr(String[] arr) {
//		for (String x:  arr) {System.out.print(x+" ");}
//		System.out.println();
//	}
	
	public static <T> void displayArr(T[] arr) { // T -> Thing <- generic
		for (T x:  arr) {System.out.print(x+" ");}
		System.out.println(arr.length); // can use method of generics
	}
	
	public static <T> T getFirst(T[] arr) {return arr[0];}
	
	/* generics =>	enable types (classes and interfaces) to be parameters when
	 * 				defining:
	 * 					classes, interfaces and methods
	 * 					a benefit is to eliminate the need to create
	 * 					multiple versions of methods
	 * 					or classes for various data types.
	 *				Use 1 version for all reference data types
	 * */
	
	/* bounded types => create generic objects of a generic class
	 * 					to have data of specific
	 * 					derived types ex.Numbers
	 * */
	
	public static void t44() {
		
		Integer[] intArr = {1, 2, 3, 4, 5};
		Double[] doubleArr = {5.5, 4.4, 3.3, 2.2, 1.1};
		Character[] charArr = {'h', 'e', 'l', 'l', 'o'};
		String[] strArr = {"B","Y","E"};
		
		displayArr(intArr);
		displayArr(doubleArr);
		displayArr(charArr);
		displayArr(strArr);
		System.out.println();
		System.out.println(getFirst(intArr));
		System.out.println(getFirst(doubleArr));
		System.out.println(getFirst(charArr));
		System.out.println(getFirst(strArr));
	}
	public static void t45() {
//		Myint i = new Myint(4);
//		Mychar c = new Mychar('@');
//		Mydouble d = new Mydouble(3.14);
//		Mystr s = new Mystr("tetete");
		
		Mygeneric<Integer> i = new Mygeneric<Integer>(4);
		Mygeneric<Character> c = new Mygeneric<Character>('@');
		Mygeneric<Double> d = new Mygeneric<Double>(3.14);
		Mygeneric<String> s = new Mygeneric<String>("tetete");
		
//		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<Integer, String> table = new HashMap<>();
		
		System.out.println(i.getVal());
		System.out.println(c.getVal());
		System.out.println(d.getVal());
		System.out.println(s.getVal());
		
		Pair<Integer, Character> p1 = new Pair<>(10, '@');
		System.out.println(p1.first + " " + p1.second);
		
//		NPair<Integer, Character> p2 = new Pair<>(10, '@'); // wouldn't work
//		System.out.println(p1.first + " " + p1.second);
	}
	
	/* serialization => 	translating object to byte code
	 * 						and saving in its current state
	 * */
	
	/* deserialization => 	translating object from byte code
	 * 						and creating in its saved state
	 * */
	
	/* Note: 	1. children classes of a parent that implements Serializable will do so as well
	 * 			2. static fields are not serialized (they belong to a class, not object)
	 * 			3. class's definition is not recorded, cast it as the object type
	 * 			4. fields declared as transient aren't serialized, they are ignored
	 * 			5. sreialVersionID is a unique version ID, insures that objects compatible, else throws exception
	 * */
	
	public static void t46() {
		User user = new User();
		
		user.name = "Bro";
		user.password = "Pizza";
		
		try {
			FileOutputStream fileOut = new FileOutputStream("Userinfo.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			
			long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
			System.out.println(serialVersionUID);
			
			out.close();
			fileOut.close();
			
			System.out.println("Object saved! :)");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void t47() {
		User user;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream("Userinfo.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			user = (User) in.readObject();
			
			long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
			System.out.println(serialVersionUID);
			
			in.close();
			fileIn.close();
			
			
			
			System.out.println("name: " + user.name + " ;passoword: " + user.password);
			user.sayhello();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void t48() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int counter = 10;
			@Override
			public void run() {
				if (counter>0) {
					System.out.println(counter + " seconds");
					counter--;
				} else {
					System.out.println("Happy New Year");
					timer.cancel();
				}
			}
		};
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2020);
		date.set(Calendar.MONTH, Calendar.DECEMBER);
		date.set(Calendar.DAY_OF_MONTH, 31);
		date.set(Calendar.HOUR_OF_DAY, 23);
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 50);
		date.set(Calendar.MILLISECOND, 0);
//		timer.schedule(task, date.getTime());

//		timer.schedule(task, 1000);
		
//		timer.scheduleAtFixedRate(task, 0, 1000);
		
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);
	}
	
	/*
	thread =	A thread of execution in a program (kind of like a virtual CPU)
				The JVM allows an application to have multiple threads running concurrently
				Each thread can execute parts of you code in parallel with the main thread
				Each thread has a priority.
				Threads with higher priority are executed in preference compared to threads with a lower priority
			
			    The Java Virtual Machine continues to execute threads until either of the following occurs
					1. The exit method of class Runtime has been called
					2. All user threads have died
					
				When a JVM starts up, there is a thread which calls the main method
				This thread is called “main”
						
				Daemon thread is a low priority thread that runs in background to perform tasks such as garbage collection 
				JVM terminates itself when all user threads (non-daemon threads) finish their execution
	 */ 
	public static void t49() {
//		System.out.println(Thread.activeCount());
//		
//		Thread.currentThread().setName("MainTread");
//		System.out.println(Thread.currentThread().getName());
//		
//		Thread.currentThread().setPriority(10);
//		System.out.println(Thread.currentThread().getPriority());
//		
//		System.out.println(Thread.currentThread().isAlive());
		
//		for (int i=3;i>0; i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Done!");
	
		MyThread thread2 = new MyThread();
		thread2.setDaemon(true);
		System.out.println(thread2.isDaemon());
		thread2.start();
//		System.out.println(thread2.isAlive());
		thread2.setName("Tread2");
//		System.out.println(thread2.getName());
//		System.out.println(thread2.getPriority());
		System.out.println(Thread.activeCount());
	}
	
	/* multythreading =>	process of executing threads simultaneously
	 * */
	
	public static void t50() {
		Thread.currentThread().setPriority(5);
		
		// Create a subclass of Thread
		MyThread2 thread1 = new MyThread2();
		
		// or
		
		// implement Runnable interface and pass instance as an argument to Thread()
		MyRunnable runnable1 = new MyRunnable();
		Thread thread2 = new Thread(runnable1);
		
		thread1.setPriority(6);
		thread2.setPriority(6);
		
		thread1.setDaemon(true);
		thread2.setDaemon(true);
		
		thread1.start();
		try {
			thread1.join(3000); // calling thread (ex.main) waits until the specified thread dies or for x milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		
	}
	
	public static void t51() {
		Tools.ToolBox.hello();
	}
}
















