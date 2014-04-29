package ca.bcit.comp2613.coursematerial.day03;

import java.math.BigDecimal;

public class BigDecimalExample {

	public static void main(String[] args) {
		double coffee = 4.99;
		double taxRate = 0.05;
		double result = (coffee * taxRate);
		System.out.println(result);
		// question (Eclipse) how do we extract the above to a method?  Hint refactor
		// question - is this a bug in Java or a bug in with your computer ... try calc???
		// hint: Google: floating point arithmetic http://en.wikipedia.org/wiki/Floating_point
		//showBigDecimalCalc();
	}
	
	// now let's show the BigDecimalCalc
	public static void showBigDecimalCalc() {
		
		BigDecimal coffee = new BigDecimal("4.99");
		BigDecimal taxRate = new BigDecimal("0.05");
		BigDecimal result =  coffee.multiply(taxRate);
	
		System.out.println(result);
	}

}
