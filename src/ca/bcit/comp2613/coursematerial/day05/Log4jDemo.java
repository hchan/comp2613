package ca.bcit.comp2613.coursematerial.day05;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemo {

	public static void main(String[] args) {
		PropertyConfigurator.configure(
				Log4jDemo.class.getResourceAsStream("log4j.properties")
				);
		Logger log = Logger.getLogger(Log4jDemo.class);
		
		
		
		
		
		log.debug("This is a debug message");
		
		log.info("This is an info message");
		
		log.error("ERROR", new Exception("Doh"));
	}
}
