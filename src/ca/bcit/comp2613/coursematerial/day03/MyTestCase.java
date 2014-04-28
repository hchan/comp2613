package ca.bcit.comp2613.coursematerial.day03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTestCase {

	
	// question - what happens when I comment out the Annotation above?
	@Before
	public void setUp() throws Exception {
		System.out.println("Hello");
	}

	@After
	// question - what happens when I comment out the Annotation above?
	public void tearDown() throws Exception {
		System.out.println("Bye");
	}

	@Test
	// question - what happens when I comment out the Annotation above?
	public void test() {
		System.out.println("In Test");
		String powerful = "Annotations";
		assertTrue("Annotations".equals(powerful));
	}

	// fyi ... true story - most new grads start their career as QA developers ...
	// at least that was what I was told by my first manager
	// jUnit *could* be your #1 friend
}
