import java.util.Scanner;

public class Giratiempo_v3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int casos = s.nextInt();
		int count = 0;
		
		while (count<casos) {
			
			long n = s.nextLong();
			long c = 0;

			long tot = n;
			
			while (tot>=3600){

				long num = tot/3600;
				long res = tot%3600;

				c+= num;
				tot = num+res;

			}
			
			System.out.println(n + c);
		
			count++;
		}
		
	}
	
}
