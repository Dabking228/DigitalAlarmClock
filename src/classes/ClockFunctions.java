package classes;

public interface ClockFunctions {
	public abstract void updateCurrentTime();
	public abstract void readAlarms();
	public abstract void saveAlarmsToFile();
	
	/* For better clarity
	public abstract void toString(); toString12() and toString24() are used
	public abstract void addAlarm(); addAlarm12() and addAlarm24() are used
	public abstract boolean createAlarmsFile(); createAlarms12File() and createAlarms24File() are used
	*/
}
