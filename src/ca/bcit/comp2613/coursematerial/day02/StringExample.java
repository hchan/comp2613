package ca.bcit.comp2613.coursematerial.day02;

public class StringExample {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "def";
		String str3 = str1 + str2;
		System.out.println(str3);
		String fox = "The quick brown fox jumps over the lazy dog";
		System.out.println(fox.indexOf("quick"));
		System.out.println(fox.startsWith("he"));
	}
}
