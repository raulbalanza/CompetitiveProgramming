import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;

public class PreparingClock {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		int count = 0;
		
		while (count<cases) {
			
			String times = s.nextLine();
			
			String [] first = times.substring(0, times.indexOf(" ")).split(":");
			String [] last = times.substring(times.indexOf(" ")+1).split(":");
			
			GregorianCalendar start = new GregorianCalendar(2000, 01, 01, Integer.parseInt(first[0]), Integer.parseInt(first[1]), Integer.parseInt(first[2]));
			GregorianCalendar end = new GregorianCalendar(2000, 01, 01, Integer.parseInt(last[0]), Integer.parseInt(last[1]), Integer.parseInt(last[2]));
			
			String numbers = s.nextLine();
			
			int campanadas = Integer.parseInt(numbers.substring(0, numbers.indexOf(" ")));
			int conocer = Integer.parseInt(numbers.substring(numbers.indexOf(" ")+1));
			
			int startToSeconds = start.get(Calendar.DAY_OF_MONTH)*24*60*60 + start.get(Calendar.HOUR_OF_DAY)*60*60 + start.get(Calendar.MINUTE) * 60 + start.get(Calendar.SECOND);
			int endToSeconds = end.get(Calendar.DAY_OF_MONTH)*24*60*60 + end.get(Calendar.HOUR_OF_DAY)*60*60 + end.get(Calendar.MINUTE) * 60 + end.get(Calendar.SECOND);
			
			int difference = endToSeconds-startToSeconds;
			
			if (difference<0) {
				end.add(Calendar.DAY_OF_MONTH, 1);
				startToSeconds = start.get(Calendar.DAY_OF_MONTH)*24*60*60 + start.get(Calendar.HOUR_OF_DAY)*60*60 + start.get(Calendar.MINUTE) * 60 + start.get(Calendar.SECOND);
				endToSeconds = end.get(Calendar.DAY_OF_MONTH)*24*60*60 + end.get(Calendar.HOUR_OF_DAY)*60*60 + end.get(Calendar.MINUTE) * 60 + end.get(Calendar.SECOND);
				
				difference = endToSeconds-startToSeconds;
			}
			
			int timeCamp = (difference/(campanadas-1))*(conocer-1);
			
			int dT = start.get(Calendar.HOUR_OF_DAY)*60*60 + start.get(Calendar.MINUTE) * 60 + start.get(Calendar.SECOND) + timeCamp;
			
			int fH = ((dT/3600)%24); int fM = (dT%3600)/60; int fS = ((dT%3600)%60);
			
			String finalTime = String.format("%02d:%02d:%02d", fH, fM, fS);
			
			System.out.println(finalTime);
			
			count++;
		}
		
	}
	
	
}