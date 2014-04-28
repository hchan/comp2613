package ca.bcit.comp2613.coursematerial.day03;

import java.util.Random;
import java.util.UUID;

public class RandomExample {
	public static void main(String[] args) {
		int countGreaterThanHalf = 0;
		for (int i = 0; i < 100; i++) {
			Random rand = new Random();
			float randUUID = rand.nextFloat();
			String randomString = UUID.randomUUID().toString();
			if (randUUID > 0.5) {
				countGreaterThanHalf++;
			}
			System.out.println(randUUID + ":" + randomString);
		}
		System.out.println("Generated count of numbers > 0.5: " + countGreaterThanHalf);
		
		// question, how do you generate 100 Random Objects ... say Item or Student ?
	}
}
