package ca.bcit.comp2613.coursematerial.day02;

public class DebuggingDemo {
	public static String apple = "apple";
	public static void main(String[] args) {
		passByValue();
		simpleStringWithPlusSigns();
		strRefvsEquals();
	}

	private static void strRefvsEquals() {
		String str1 = "a";
		String str2 = "a";
		System.out.println(str1 == str2); // aka String interns: http://en.wikipedia.org/wiki/String_interning
		System.out.println(apple.substring(0, 1) == str1);
		System.out.println(apple.substring(0, 1).equals("a"));
	}

	private static void simpleStringWithPlusSigns() {
		// TODO place breakpoint at next line
		String str1 = "a";
		String str2 = "b";
		str1 = str2 + str1;
		str2 = str1 + str2;
		str1 = str2 + str1;
		str2 = str1 + str2;
		System.out.println(str2);
	}

	private static void passByValue() {
		String str1 = "Hello";
		
		letsSeeIfWeChangeTheStringToUpperCase(str1);
		System.out.println(str1);
	}

	private static void letsSeeIfWeChangeTheStringToUpperCase(String str1) {
		str1 = str1.toUpperCase();
	}
}
