import java.util.Scanner;

public class DivideFactorial {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			long num = s.nextLong();
			long den = s.nextLong();

			if (num>=den) System.out.println(divFacto(num, den));
			else run = false; 
						
		}
		
    }
	
	public static long divFacto(long num, long den) {

        long tot = 1;

        for (long i=den+1; i<=num; i++){

            tot *= i;

        }
        
		return tot;
		
	}
	
}
