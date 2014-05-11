package ca.bcit.comp2613.coursematerial.day05;

import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesDemo {

	public static void main(String[] args) {
		PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		try {
			// create a hello.properties file
			propertiesConfiguration.load(PropertiesDemo.class.getResourceAsStream("hello.properties"));
			System.out.println(propertiesConfiguration.getString("whoami"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
