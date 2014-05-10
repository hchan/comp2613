package ca.bcit.comp2613.coursematerial.day04;

public class PersonWithComparable implements Comparable<PersonWithComparable> {
	private String firstName;
	private String lastName;
	public PersonWithComparable(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		
		return lastName + ", " + firstName;
	}
	@Override
	public int compareTo(PersonWithComparable o) {
		int retval = this.getLastName().compareTo(o.getLastName());
		if (retval == 0) {
			retval = this.getFirstName().compareTo(o.getFirstName());
		}
		return retval;
	}

	
}
