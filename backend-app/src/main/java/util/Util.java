package util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Util {
	private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	
	public static Date parseDate(String date) throws ParseException {
		return Date.from(
			LocalDate.parse(date, dateFormat).atStartOfDay(ZoneOffset.UTC).toInstant()
		);
	}
	
	public static Date getNow() {
		return Date.from(
		    LocalDate.now().atStartOfDay(ZoneOffset.UTC).toInstant()
		);
	}
	
	public static Date getNowAfterDays(int days) {
		return Date.from(
		    LocalDate.now().plusDays(days).atStartOfDay(ZoneOffset.UTC).toInstant()
		);
	}
}
