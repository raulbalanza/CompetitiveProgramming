import java.util.Scanner;

public class KaprekarNumber {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			int n = s.nextInt();
			
			if (n==0) { run = false; }
			else if (Kaprekar(n)) { System.out.println("SI"); }
			else { System.out.println("NO"); }
			
		}
		
	}
	
	public static boolean Kaprekar(int n) {
		
		long a = n*n, b = 0;
		int d = 1;
		
		while (a>0) {
			
			b += a % 10 * d;
			a/=10; d*=10;
			if (b>0 && a+b==n) { return true; }
			
		}
		
		return false;
		
	}
	
}
