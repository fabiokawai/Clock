import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock extends Thread{
	
	private DateTimeFormatter dateFormatH = DateTimeFormatter.ofPattern("HH");
	private DateTimeFormatter dateFormatM = DateTimeFormatter.ofPattern("mm");
	private DateTimeFormatter dateFormatS = DateTimeFormatter.ofPattern("ss");
	LocalDateTime now;
	private int hour;
	private int minute;
	private int seconds;
	
	public void run(){
		while (true){
			now = LocalDateTime.now();
			hour = Integer.parseInt(dateFormatH.format(now));
			minute = Integer.parseInt(dateFormatM.format(now));
			seconds = Integer.parseInt(dateFormatS.format(now));
			System.out.println(dateFormatH.format(now) + ":" + dateFormatM.format(now) + ":" + dateFormatS.format(now));
			try {
				Clock.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSeconds() {
		return seconds;
	}

}
