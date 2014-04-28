package ca.bcit.comp2613.coursematerial.day02;

public class DebuggingExample {
	public static void main(String[] args) {
		String str1 = "Hello";
		str1 += "ccc";
		int a = 5;
		str1 += String.valueOf(a);
		letsSeeIfWeChangeTheStringToUpperCase(str1);
		System.out.println(str1);
	}

	private static void letsSeeIfWeChangeTheStringToUpperCase(String str1) {
		str1.toUpperCase();
	}
}
