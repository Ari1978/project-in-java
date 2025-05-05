package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO que contiene información de fecha y hora.")
public class TimeResponseDTO {
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int seconds;
	private int milliSeconds;
	private String dateTime;
	private String date;
	private String time;
	private String timeZone;
	private String dayOfWeek;
	private boolean dstActive;

}
