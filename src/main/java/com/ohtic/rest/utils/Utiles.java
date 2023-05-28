package com.ohtic.rest.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utiles {

	public static Date localDateTimeToDate(LocalDateTime localDateTime) {
		ZoneId defaultZone = ZoneId.systemDefault();
		return Date.from(localDateTime.atZone(defaultZone).toInstant());
	}
}
