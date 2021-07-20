package tutorial_1;

import java.util.Random;

public class DiceRoller {
	int number;
	Random random;
	
	DiceRoller() {
		random = new Random();
		number = 0;
	}
	
	void roll() {
		number = random.nextInt(6)+1;
		System.out.println(number);
	}
}
