package ca.bcit.comp2613.coursematerial.day03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndGregorianCalendarExample {

	public static void main(String[] args) {
		Date curDate = new Date();		
		System.out.println(curDate);
		
		Calendar cal = Calendar.getInstance();
		Calendar yesterday = cal;
		yesterday.add(Calendar.DATE, -1);
		System.out.println(yesterday);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(dateFormat.format(yesterday.getTime()));
		
		// Question - what does the following line pring
		//System.out.println(dateFormat.format(cal.getTime()));
	}

}
