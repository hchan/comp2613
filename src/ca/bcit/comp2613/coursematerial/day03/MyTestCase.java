package ca.bcit.comp2613.coursematerial.day03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTestCase {

	@Before
	public void setUp() throws Exception {
		System.out.println("Hello");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Bye");
	}

	@Test
	public void test() {
		System.out.println("In Test");
		fail("Not yet implemented");
	}

}
