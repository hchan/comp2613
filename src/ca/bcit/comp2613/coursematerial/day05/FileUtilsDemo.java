package ca.bcit.comp2613.coursematerial.day05;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtilsDemo {

	public FileUtilsDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			FileUtils.writeStringToFile(new File("test.txt"), "Hello World");
			System.out.println(FileUtils.readFileToString(new File("test.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
