package pl.bookmaker.externalservice.demo.converters;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateParser {

	public static String getDateFromJson(String date){
		return date.substring(0, 10);
	}
	
	public static String getTimeFromJson(String date) {
	return date.substring(11, 19);
	}

	public static String getToday() {
		Date currentDate = new Date();
		return new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
	}

	public static String getTodayWithTime() {
		Date currentDate = new Date();
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
	}

	public static String getCurrentTime() {
		Date currentDate = new Date();
		return new SimpleDateFormat("HH:mm:ss").format(currentDate);
	}

	public static String getTodayWithAddOrSubstraction(int addOrSubstractNumerOfDay) {
		Date currentDate = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE,addOrSubstractNumerOfDay);
		Date dateOfGregorianCalendar = calendar.getTime();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(dateOfGregorianCalendar);
		return modifiedDate;
	}





}