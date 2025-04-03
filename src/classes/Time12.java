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

public class Time12 extends Time implements ClockFunctions{
	private static int hour12;
	private static int am_pm;
	private static ArrayList<ArrayList<String>> alarms12 = new ArrayList<>();
	
//	GregorianCalendar calendar = new GregorianCalendar();
	
	public Time12() {
		super();
	}
	
	@Override
	public void updateCurrentTime(){
		getHour12();
		getMinute();
		getSecond();
		getAm_pm();
	}
	
/*	|GregorianCalendar.HOUR|
Field number for get and set indicating the hour of the morning or afternoon. 
HOUR is used for the 12-hour clock (0 - 11). Noon and midnight are represented by 0, not by 12.
E.g., at 10:04:15.250 PM the HOUR is 10.
*/
	public int getHour12() {
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			hour12 = calendar.get(GregorianCalendar.HOUR);
		}
		return (hour12 == 0) ? hour12 = 12 : hour12;
	}
	
	public void setHour12(int hour12) {
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			hour12 = calendar.get(GregorianCalendar.HOUR);
			Time12.hour12 = hour12;
		}
		
	}
	
	public String getAm_pm() {
		if(getIsTimeDefault() == true){
			GregorianCalendar calendar = new GregorianCalendar();
			am_pm = calendar.get(GregorianCalendar.AM_PM);
		}
		return (am_pm == GregorianCalendar.AM) ? "AM" : "PM";
	}
	
	public void setAm_pm(int am_pm) {
		if(getIsTimeDefault() == true){
			GregorianCalendar calendar = new GregorianCalendar();
			am_pm = calendar.get(GregorianCalendar.AM_PM);
			Time12.am_pm = am_pm;
		}
	}
	
	public ArrayList<ArrayList<String>> getAlarms12() {
		return alarms12;
	}
	
	public void addAlarm12(String hour, String minute, String am_pm, String days, String status){
		ArrayList<String> alarm12 = new ArrayList<>(Arrays.asList(hour, minute, am_pm, days, status));
		alarms12.add(alarm12);
	}
	
//	public String toString12(int hour, int minute, int second, String am_pm){
//		String time12 = String.format("%02d:%02d:%02d", hour, minute, second);
//		return time12 + " " + am_pm;
//	}
	public String toString12(){
		String time12 = String.format("%02d:%02d:%02d", hour12, minute, second);
		return time12 + " " + getAm_pm(); // Can also straightaway put am_pm instead of getAm_pm()
	}
	
	public String convert12To24(String hour, String am_pm){ // Only return hour for 24-Hour Format
		int converted_hour = Integer.parseInt(hour);
		String str_hour;
		if("AM".equals(am_pm)){ // AM
			if("12".equals(hour)){
				str_hour = "00";
			}
			else{
				return hour;
			}
		}
		else{ // PM
			if("12".equals(hour)){
				return hour;
			}
			else{
				str_hour = String.format("%02d", converted_hour + 12);
			}
		}
		return str_hour;
	}
	
	public void createAlarms12File(){
		File file = new File("src/classes/Alarm12HourFormat.txt");
		if(file.exists()){
			System.out.println("Alarm12HourFormat.txt already exists");
			return;
		}
		
		try{
			file.createNewFile();
			System.out.println("Alarm12HourFormat.txt has been created successfully");
			FileWriter fw = new FileWriter(file);
			fw.write("Hour12/Minute/Am_pm/Days/Status\n");
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
			return;
		}
	}
	
	@Override
	public void readAlarms(){
		createAlarms12File(); // If Alarm12HourFormat.txt exists in the folder then nothing will be done
		
		// Clear each inner list first before removing their references
		alarms12.forEach(ArrayList::clear); // Using method reference "::" 
		// alarms12.forEach(innerList -> innerList.clear()); // Using lambda expression
		
		// Then, clear outer list.
		alarms12.clear();
		/* If only clearing outer list, the inner lists still exist in memory if something else is referencing them
		This could cause memory leaks and unwanted behaviour */
		/* If there are no other references to the inner lists elsewhere in the program, Java's garbage 
		collector (GC) will automatically remove them.
		However, if another part of the program still holds references to any of the inner lists, they will 
		persist in memory.
		*/
		
		try{
			File file = new File("src/classes/Alarm12HourFormat.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String alarm12;
			br.readLine(); // Read and ignore the first line (column names)
			while((alarm12 = br.readLine()) != null){
				String[] alarmData = alarm12.split("/");
				if(alarmData.length == 5){
					String alarmHour = alarmData[0];
					String alarmMinute = alarmData[1];
					String alarmAm_pm = alarmData[2];
					String alarmDays = alarmData[3];
					String alarmStatus = alarmData[4];
					addAlarm12(alarmHour, alarmMinute, alarmAm_pm, alarmDays, alarmStatus);
				}
				else{
					System.out.println("Error: Invalid alarm format in Alarm12HourFormat.txt");
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
	public void saveAlarmsToFile() {
		createAlarms12File(); // If Alarm12HourFormat.txt exists in the folder then nothing will be done
		try{
			File file = new File("src/classes/Alarm12HourFormat.txt");
			FileWriter fw = new FileWriter(file, false); // Default mode: Overwrite the whole file
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// Write the header first
			pw.println("Hour12/Minute/Am_pm/Days/Status");
			
			for(ArrayList<String> alarm12 : alarms12){
				pw.println(String.join("/", alarm12));
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
	
	public ArrayList<String> findExistingAlarm12(String hour, String minute, String am_pm, String days) {
		for (ArrayList<String> alarm12 : alarms12) {
			/* Check AM_PM first to reduce unnecessary checking if the hour, minute, selected days and status
			are the same but different in AM and PM */
			if (am_pm.equals(alarm12.get(2)) && hour.equals(alarm12.get(0)) && minute.equals(alarm12.get(1)) && days.equals(alarm12.get(3))) {
				return alarm12;
			}
		}
		return null;
	}
	
	public void updateAlarm12Status(String hour12, String minute, String am_pm, String days){
		for(ArrayList<String> alarm12 : alarms12){
			if(am_pm.equals(alarm12.get(2)) && hour12.equals(alarm12.get(0)) && minute.equals(alarm12.get(1)) 
			&& days.equals(alarm12.get(3))){
				alarm12.set(4, "Active");
				return;
			}
		}
	}
}
