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
			System.out
					.println(FileUtils.readFileToString(new File("test.txt")));
			findTempFileDirectory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void findTempFileDirectory() throws IOException {
		// create a temp file
		File temp = File.createTempFile("hello", ".tmp");

		System.out.println("Temp file : " + temp.getAbsolutePath());

		// Get tempropary file path
		String absolutePath = temp.getAbsolutePath();
		String tempFilePath = absolutePath.substring(0,
				absolutePath.lastIndexOf(File.separator));

		System.out.println("Temp file path : " + tempFilePath);
	}

}
