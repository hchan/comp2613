package ca.bcit.comp2613.coursematerial.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class ComparatorAndComparableDemo {

	public static void main(String[] args) {
		showComparatorExample();
		//showComparableExample();
	}

	private static void showComparableExample() {
		ArrayList<PersonWithComparable> myList = new ArrayList<>();
		PersonWithComparable person1 = new PersonWithComparable("Henry", "Chan");
		PersonWithComparable person2 = new PersonWithComparable("Jerry", "Mouse");
		PersonWithComparable person3 = new PersonWithComparable("Tom", "Cat");
		PersonWithComparable person4 = new PersonWithComparable("Felix", "Cat");
		
		myList.add(person1);
		myList.add(person2);
		myList.add(person3);
		myList.add(person4);
		Collections.sort(myList);
		for (PersonWithComparable person : myList) {
			System.out.println(person);
		}
	}

	private static void showComparatorExample() {
		ArrayList<Person> myList = new ArrayList<>();
		Person person1 = new Person("Henry", "Chan");
		Person person2 = new Person("Jerry", "Mouse");
		Person person3 = new Person("Tom", "Cat");
		Person person4 = new Person("Felix", "Cat");
		
		myList.add(person1);
		myList.add(person2);
		myList.add(person3);
		myList.add(person4);
		
		Comparator<Person> myComparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int retval = o1.getLastName().compareTo(o2.getLastName());
				if (retval == 0) {
					retval = o1.getFirstName().compareTo(o2.getFirstName());
				}
				return retval;
			}
		};
		Collections.sort(myList, myComparator);
		for (Person person : myList) {
			System.out.println(person);
		}
	}

}
