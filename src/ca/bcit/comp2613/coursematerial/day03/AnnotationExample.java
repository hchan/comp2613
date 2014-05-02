package ca.bcit.comp2613.coursematerial.day03;

import java.util.ArrayList;
import java.util.Date;

public class AnnotationExample {
	@SuppressWarnings("rawtypes")
	
	private ArrayList arrayList;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		AnnotationExample annotationExample = new AnnotationExample();
		annotationExample.arrayList = new ArrayList();
		annotationExample.arrayList.add("A String");
		annotationExample.arrayList.add(1);
		System.out.println(annotationExample.toString());
		System.out.println(annotationExample.getBrokenToString());
	}
	
	
	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	// question: what happens if I mistype toString ... such as toStrin
	public String toString() {
		String retval = "";
		
		Date unusedDate;
		for (Object obj: arrayList) {
			Date date = new Date();
			int secs = date.getSeconds();
			retval += secs + obj.getClass().getName() + "\n";
		}
		return retval;
	}
	
	@Deprecated
	public String getBrokenToString() {
		return "JUNK";
	}
}
