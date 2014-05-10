package ca.bcit.comp2613.coursematerial.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionsDemo {

	public static void main(String[] args) {
		System.out.println("List Example --------");
		showListExample();
		System.out.println("Set Example --------");
		showSetExample();
		System.out.println("Map Example --------");
		showMapExample();

	}

	private static void showMapExample() {
		HashMap<String, Integer> aHashMap = new HashMap<String, Integer>();
		//HashMap<String, Integer> aHashMap = new LinkedHashMap<String, Integer>();
		aHashMap.put("Henry", 99);
		aHashMap.put("Tom", 98);
		aHashMap.put("Jerry", 97);
		aHashMap.put("Henry", 100); // Let's give Henry a score of 100 instead of 99
		for (String key: aHashMap.keySet()) {
		    System.out.println(key + ": " + aHashMap.get(key));
		}
		// question what order does the above print it out in ?
		// what happens when we used the LinkedHashMap ?
		// take 10 min or so to play with it
	}

	private static void showSetExample() {
		Set<String> aSet = new HashSet<String>();
		//Set<String> aSet = new TreeSet<>();
		aSet.add("Henry"); 
		aSet.add("Tom");
		aSet.add("Jerry");
		aSet.add("Jerry");
		aSet.add("Jerry");
		aSet.add("Jerry");
		for (String str : aSet) {
			System.out.println(str);
		}
		// question, how many Jerry's are in the HashSet
		// question, how do we change the order?
		// student todo, see the implemenation of "add" in Set
	}

	private static void showListExample() {
		ArrayList<String> anArrayList = new ArrayList<>();
		anArrayList.add("Henry");
		anArrayList.add("Tom");
		anArrayList.add("Jerry");
		anArrayList.add("Jerry");
		anArrayList.add("Jerry");
		anArrayList.add("Jerry");
		for (String str : anArrayList) {
			System.out.println(str);
		}
		
	}

}
