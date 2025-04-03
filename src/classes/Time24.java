package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Time24 extends Time implements ClockFunctions{
	private static int hour24;
	private static ArrayList<ArrayList<String>> alarms24 = new ArrayList<>();
	
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
	
	public ArrayList<String> convert24To12(String hour){ // Return Hour and AM_PM in 12-Hour Format
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
	
	public void createAlarms24File(){
		File file = new File("src/classes/Alarm24HourFormat.txt");
		if(file.exists()){
			System.out.println("Alarm24HourFormat.txt already exists");
			return;
		}
		
		try{
			file.createNewFile();
			System.out.println("Alarm24HourFormat.txt has been created successfully");
			FileWriter fw = new FileWriter(file);
			fw.write("Hour24/Minute/Days/Status\n");
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
			return;
		}
	}
	
	@Override
	public void readAlarms(){
		createAlarms24File(); // If Alarm24HourFormat.txt exists in the folder then nothing will be done
		alarms24.forEach(ArrayList::clear); // Clear inner lists first
		alarms24.clear(); // Then, clear outer list
		try{
			File file = new File("src/classes/Alarm24HourFormat.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String alarm24;
			br.readLine(); // Read and ignore the first line (column names)
			while((alarm24 = br.readLine()) != null){
				String[] alarmData = alarm24.split("/");
				if(alarmData.length == 4){
					String alarmHour = alarmData[0];
					String alarmMinute = alarmData[1];
					String alarmDays = alarmData[2];
					String alarmStatus = alarmData[3];
					addAlarm24(alarmHour, alarmMinute, alarmDays, alarmStatus);
				}
				else{
					System.out.println("Error: Invalid alarm format in Alarm24HourFormat.txt");
					System.exit(0); // Possible Enhancement: Can automatically delete the alarm
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Alarm Read & Loaded!");
	}
	
	@Override
	public void saveAlarmsToFile(){
		createAlarms24File(); // If Alarm24HourFormat.txt exists in the folder then nothing will be done
		try{
			File file = new File("src/classes/Alarm24HourFormat.txt");
			FileWriter fw = new FileWriter(file, false); // Default mode: Overwrite the whole file
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// Write the header first
			pw.println("Hour24/Minute/Days/Status");
			
			for(ArrayList<String> alarm24 : alarms24){
				pw.println(String.join("/", alarm24));
			}
			pw.close();
			bw.close();
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Alarm Successfully Saved to File!");
	}
	
	public ArrayList<String> findExistingAlarm24(String hour, String minute, String days) {
		for (ArrayList<String> alarm24 : alarms24) {
			if (hour.equals(alarm24.get(0)) && minute.equals(alarm24.get(1)) && days.equals(alarm24.get(2))) {
				return alarm24;
			}
		}
		return null;
	}
	
	public void updateAlarm24Status(String hour24, String minute, String days){
		for(ArrayList<String> alarm24 : alarms24){
			if(hour24.equals(alarm24.get(0)) && minute.equals(alarm24.get(1))
			&& days.equals(alarm24.get(2))){
				alarm24.set(3, "Active");
				return;
			}
		}
	}
}
