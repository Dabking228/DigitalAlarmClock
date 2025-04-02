package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

public class Time {
	protected static int second;
	protected static int minute;
	protected static String date;
	protected static boolean isTimeDefault;
	protected static boolean is12HourFormat;
	protected static int snoozingTime;
	protected static boolean isDefaultSnoozingTime;

/* Mistake: As this only creates one calendar instance, which will not be able to be updated and only serve a fixed value
	protected GregorianCalendar calendar = new GregorianCalendar();
*/	
	
	public Time() {
		
	}
	
	public int getMinute() {
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			minute = calendar.get(GregorianCalendar.MINUTE);
		}
		return minute;
	}
	
	public void setMinute(int minute) {
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			minute = calendar.get(GregorianCalendar.MINUTE);
			Time.minute = minute;	
		}
	}

	public int getSecond() {
		GregorianCalendar calendar = new GregorianCalendar();
		Time.second = calendar.get(GregorianCalendar.SECOND);
		return second;
	}
	
	public void setSecond(int second){
		if(isTimeDefault == true){
			GregorianCalendar calendar = new GregorianCalendar();
			second = calendar.get(GregorianCalendar.SECOND);
			Time.second = second;	
		}
	}
	
	public String getMonth(){
		GregorianCalendar calendar = new GregorianCalendar();
		int month_input = calendar.get(GregorianCalendar.MONTH);
		String month_output = null;
		switch(month_input){
			case 0 -> month_output = "January";
			case 1 -> month_output = "February";
			case 2 -> month_output = "March";
			case 3 -> month_output = "April";
			case 4 -> month_output = "May";
			case 5 -> month_output = "June";
			case 6 -> month_output = "July";
			case 7 -> month_output = "August";
			case 8 -> month_output = "September";
			case 9 -> month_output = "October";
			case 10 -> month_output = "November";
			case 11 -> month_output = "December";
		}
		return month_output;
	}
	
	public String getDate(){
		GregorianCalendar calendar = new GregorianCalendar();
		return "Date: " + calendar.get(GregorianCalendar.DATE) + " " + getMonth() + " " + calendar.get(GregorianCalendar.YEAR);
	}
	
	public void setDate(String date){
		Time.date = date;
	}
	
	public boolean getIsTimeDefault() {
		return isTimeDefault;
	}

	public void setIsTimeDefault(boolean isTimeDefault) {
		Time.isTimeDefault = isTimeDefault;
	}

	public boolean getIs12HourFormat() {
		return is12HourFormat;
	}

	public void setIs12HourFormat(boolean is12HourFormat) {
		Time.is12HourFormat = is12HourFormat;
	}
	
	public int getSnoozingTime() {
		if(isDefaultSnoozingTime == true){
			snoozingTime = 120000;
		}
		return snoozingTime;
	}

	public void setSnoozingTime(int snoozingTime) {
		Time.snoozingTime = snoozingTime;
	}

	public boolean getIsDefaultSnoozingTime() {
		return isDefaultSnoozingTime;
	}

	public void setIsDefaultSnoozingTime(boolean isDefaultSnoozingTime) {
		Time.isDefaultSnoozingTime = isDefaultSnoozingTime;
	}
	
	public void checkClockSettings() {
		try{
			File file = new File("src/classes/ClockSettings.txt");
			if(!file.exists()){
				file.createNewFile();
				System.out.println("ClockSettings.txt has been created successfully");
				FileWriter fw = new FileWriter(file);
				fw.write("isTimeDefault/is12HourFormat/isDefaultSnoozingTime/snoozingTime\n");
				fw.write("true/true/true/120000");
				fw.close();
				
				setIsTimeDefault(true);
				setIs12HourFormat(true);
				setIsDefaultSnoozingTime(true);
				setSnoozingTime(120000);
			}
			else{
				System.out.println("ClockSettings.txt already exists");
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				br.readLine(); // Read and ignore the first line (column names)
				String secondLine = br.readLine(); // Read the settings in the second line
				
				if(secondLine != null && !secondLine.trim().isEmpty()){ // Check if second line is not null or empty
					String[] settings = secondLine.split("/"); // Store the settings in the second line into this array
					if(settings.length == 4){
						setIsTimeDefault(Boolean.parseBoolean(settings[0]));
						setIs12HourFormat(Boolean.parseBoolean(settings[1]));
						setIsDefaultSnoozingTime(Boolean.parseBoolean(settings[2]));
						setSnoozingTime(Integer.parseInt(settings[3]));
					}
					else{
						System.out.println("Error: Invalid settings format in ClockSettings.txt");
						System.exit(0);
					}	
				}
				else{
					System.out.println("Error: No settings found in ClockSettings.txt");
					System.exit(0);
				}
				br.close();
				fr.close();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
