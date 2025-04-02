package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Time24 extends Time implements ClockFunctions{
	private static int hour24;
	private ArrayList<ArrayList<String>> alarms24 = new ArrayList<>();
	
//	GregorianCalendar calendar = new GregorianCalendar();
	
	public Time24(){
		super();
	}
	
	@Override
	public void updateCurrentTime(){
		getHour24();
		getMinute();
		getSecond();
	}
	
/*	|GregorianCalendar.HOUR_OF_DAY|
Field number for get and set indicating the hour of the day. HOUR_OF_DAY is used for the 24-hour clock. 
E.g., at 10:04:15.250 PM the HOUR_OF_DAY is 22.
*/
	public int getHour24() {
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			hour24 = calendar.get(GregorianCalendar.HOUR_OF_DAY);
		}
		return hour24;
	}
	
	public void setHour24(int hour24) {
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			hour24 = calendar.get(GregorianCalendar.HOUR_OF_DAY);
			Time24.hour24 = hour24;
		}
	}
	
	public ArrayList<ArrayList<String>> getAlarms24() {
		return alarms24;
	}
	
	public void addAlarm24(String hour, String minute, String days, String status){
		ArrayList<String> alarm24 = new ArrayList<>(Arrays.asList(hour, minute, days, status));
		alarms24.add(alarm24);
	}
	
//	public String toString24(int hour, int minute, int second){
//		return String.format("%02d:%02d:%02d", hour, minute, second);
//	}	
	public String toString24(){
		return String.format("%02d:%02d:%02d", hour24, minute, second);
	}
	
	public ArrayList convert24To12(String hour){ // Return Hour and AM_PM in 12-Hour Format
		int converted_hour = Integer.parseInt(hour);
		ArrayList<String> str_time12 = new ArrayList<>();
		if(converted_hour <= 12){
			if("00".equals(hour)){
				str_time12.add("12");
				str_time12.add("AM");
			}
			else if("12".equals(hour)){
				str_time12.add("12");
				str_time12.add("PM");
			}
			else{
				str_time12.add(hour);
				str_time12.add("AM");
			}
		}
		else{
			str_time12.add(String.format("%02d", converted_hour - 12));
			str_time12.add("PM");
		}
		return str_time12;
	}
	
	@Override
	public void readAlarms(){
		System.out.println("Alarm Read & Loaded!");
	}
	
	@Override
	public void saveAlarmsToFile(){
		System.out.println("Alarm Successfully Saved to File!");
	}
}
