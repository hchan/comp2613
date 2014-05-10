package ca.bcit.comp2613.coursematerial.day04;

import java.util.ArrayList;

public class GenericDemo {

	public static void main(String[] args) {
		ArrayList<String> anArrayList = new ArrayList<String>();
		// question, why does the following line give compile warning:
		// anArrayList.add(5);
		anArrayList.add("Hello");
		System.out.println(anArrayList);
		System.out.println(anArrayList.get(0)); // notice how I don't need to cast the .get(0) to a String
		// anotherArrayListExample
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	// notice the suppress annotation to skip the warning
	public static void anotherArrayListExample() {
		ArrayList anArrayList = new ArrayList<>();
		anArrayList.add(new Integer(1));
		anArrayList.add("hello");
		// notice how the for loop recurses through Object
		for (Object obj : anArrayList) {
			System.out.println(obj);
		}
	}

}
