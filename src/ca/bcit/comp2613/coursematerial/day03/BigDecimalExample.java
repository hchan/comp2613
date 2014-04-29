package ca.bcit.comp2613.coursematerial.day03;

import java.math.BigDecimal;

public class BigDecimalExample {

	public static void main(String[] args) {
		double coffee = 4.99;
		double taxRate = 0.05;
		double result = (coffee * taxRate);
		System.out.println(result);
		// question (Eclipse) how do we refactor the above to a method?
		// question - is this a bug in Java or a bug in ... ???
		// hint: google floating point arithmetic 
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
