package ca.bcit.comp2613.coursematerial.day03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndGregorianCalendarExample {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		// question, what's that weird yyyy/MM/dd HH:mm:ss and how do I find more information on that?
		// hint SHIFT-F2 or F3
		
		Date curDate = new Date();		
		System.out.println(dateFormat.format(curDate));
		
		Calendar cal = Calendar.getInstance();
		Calendar yesterday = cal;
		yesterday.add(Calendar.YEAR, -1);
		yesterday.add(Calendar.DATE, -1);
		
		System.out.println(dateFormat.format(yesterday.getTime()));
		
		// question - what does the following line print
		// question - how many methods in Date are deprecated
		//System.out.println(dateFormat.format(cal.getTime()));
	}

}
