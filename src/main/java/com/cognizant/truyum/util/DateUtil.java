package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author 877962
 *
 */
public class DateUtil {

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDate(String date) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block

		}
		return null;
	}

}