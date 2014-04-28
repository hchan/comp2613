package ca.bcit.comp2613.coursematerial.day03;

import java.math.BigDecimal;

public class BigDecimalExample {

	public static void main(String[] args) {
		double coffee = 4.99;
		double taxRate = 0.05;
		double result = (coffee * taxRate);
		System.out.println(result);
		//showBigDecimalCalc();
	}
	
	public static void showBigDecimalCalc() {
		
		BigDecimal coffee = new BigDecimal("4.99");
		BigDecimal taxRate = new BigDecimal("0.05");
		BigDecimal result =  coffee.multiply(taxRate);
	
		System.out.println(result);
	}

}
