package ca.bcit.comp2613.coursematerial.day04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class DeleteFromCollection {

	public static void main(String[] args) {
		ArrayList<Integer> randomInts = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int randInt = rand.nextInt(100);
			randomInts.add(randInt);
		}
		printInts(randomInts);
		attemptToRemoveEvenInts(randomInts);
		//aBetterAttemptToRemoveEvenInts(randomInts);
		printInts(randomInts);
	}

	private static void aBetterAttemptToRemoveEvenInts(
			ArrayList<Integer> randomInts) {
		Iterator<Integer> iter = randomInts.iterator();
		while (iter.hasNext()) {
			int intLoop = iter.next();
			if (intLoop % 2 == 0) {
				iter.remove();
			}
		}
	}

	private static void printInts(ArrayList<Integer> randomInts) {
		for (Integer intLoop : randomInts) {
			System.out.println(intLoop);
		}
		System.out.println("-----------------");
	}

	private static void attemptToRemoveEvenInts(ArrayList<Integer> randomInts) {
		for (Integer intLoop : randomInts) {
			if (intLoop % 2 == 0) {
				randomInts.remove(intLoop);
			}
		}
	}

}
