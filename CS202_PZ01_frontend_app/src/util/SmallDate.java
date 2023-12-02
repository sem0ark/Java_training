package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallDate extends Date {
	private static final long serialVersionUID = 8491158565529631701L;

	
	
	public SmallDate() {
		super();
	}

	public SmallDate(long date) {
		super(date);
	}


	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this);
	}
}
