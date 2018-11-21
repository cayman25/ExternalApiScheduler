package pl.bookmaker.externalservice.demo.converters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateParser {

	public static String getDateFromJson(String date){
		return date.substring(0, 10);
	}
	
	public static String getTimeFromJson(String date) {
	return date.substring(11, 19);
	}

	public static String getTodayWithAddOrSubstractDay(int numberOfDay) {
		LocalDate currentDate = LocalDate.now();
		return currentDate.plusDays(numberOfDay).toString();
	}

}