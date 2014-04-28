package ca.bcit.comp2613.coursematerial.day03;

import java.util.ArrayList;

public class ErrorDemo {

	public static void main(String[] args) {
		doOutOfMemoryError();		
	
			
		//doMyError();
			
		
		
		// question ... can you catch an Error with try/catch (Exception)
		// question ... can you catch an Error with try/catch (Error)
		// question ... can you catch an Error with try/catch (Throwable)
		// hint - Eclipse shortcut ALT-SHIFT-Z
	}

	private static void doMyError() {
		throw new MyError();
	}

	private static void doOutOfMemoryError() {
		ArrayList<Long[]> list = new ArrayList<>();
		while (true) {
		  list.add(new Long[Integer.MAX_VALUE]);
		  
		}
	}
	
	
}
