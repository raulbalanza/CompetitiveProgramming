import java.util.Scanner;

public class NewYearsEve {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		final int yearsEve = 24*60;
		
		while (s.hasNextLine()) {
			
			String time = s.nextLine();
			
			if (time.equals("00:00")) { break; }
			else {
				
				int hours = Integer.parseInt(time.substring(0, 2));
				int minutes = Integer.parseInt(time.substring(3, 5));
				
				int acTime = hours*60 + minutes;
				
				System.out.println(yearsEve-acTime);
				
			}
			
		}	

	}

}
