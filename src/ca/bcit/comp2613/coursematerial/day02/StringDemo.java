package ca.bcit.comp2613.coursematerial.day02;

public class StringDemo {
	public static void main(String[] args) {
		stringConcat();
		showIndexOfExample();
	}

	private static void showIndexOfExample() {
		String fox = "The quick brown fox jumps over the lazy dog";
		System.out.println(fox.indexOf("quick"));
		System.out.println(fox.startsWith("he"));
	}

	private static void stringConcat() {
		String str1 = "abc";
		String str2 = "def";
		// how do I append str1 to str2 ?!?!
		
		String str3 = str1 + str2;
		System.out.println(str3);
		
		// Another way to do it with StringBuilder
		StringBuilder sb= new StringBuilder() ;
		sb.append(str1).append(str2);
		System.out.println(sb.toString());
	}
}
