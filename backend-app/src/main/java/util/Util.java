package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	
	
	public static Date parseDate(String date) throws ParseException {
		return dateFormat.parse(date);
	}
}
