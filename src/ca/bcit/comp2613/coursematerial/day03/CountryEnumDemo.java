package ca.bcit.comp2613.coursematerial.day03;

import java.util.Arrays;

// fyi ... note there is something called Locale in java.util

public class CountryEnumDemo {
	public static void main(String[] args) {
		System.out.println(Country.CAN);
		System.out.println(Country.CAN.name());
		System.out.println(Country.CAN.toString()); // hmmm, how do we check the source code for toString?
		System.out.println(Country.CAN.getDescription());
		System.out.println(Arrays.toString(Country.values()));
	}
}
