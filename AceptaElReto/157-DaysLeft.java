import java.util.Scanner;

public class DaysLeft {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		final int endDay = 365;
		
		int n = s.nextInt();
		int c = 0;
		
		while (c<n) {
			
			int day = s.nextInt();
			int month = s.nextInt()-1;
			
			switch (month) {
				case 12: day+=31;
				case 11: day+=30;
				case 10: day+=31;
				case 9: day+=30;
				case 8: day+=31;
				case 7: day+=31;
				case 6: day+=30;
				case 5: day+=31;
				case 4: day+=30;
				case 3: day+=31;
				case 2: day+=28;
				case 1: day+=31;
			}
			
			System.out.println(endDay-day);
			
			c++;
		}

	}

}
