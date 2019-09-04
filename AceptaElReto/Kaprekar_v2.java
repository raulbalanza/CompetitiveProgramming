import java.util.Scanner;
import java.util.Locale;

public class Kaprekar_v2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in).useLocale(Locale.US);
		
		int repeat = s.nextInt();
		int exec = 0;
		
		while (exec<repeat) {
			
			int n = s.nextInt();
			int cycles = 0;
			
			if (n<0) { }
			else if (!twoDiffDigits(n)) { System.out.println(8); }
			else if (n==6174) { System.out.println(0); }
			else {
				
				while (n!=6174) {
					
					n = Math.abs(orderMinToMax(numToArray(n))-orderMaxToMin(numToArray(n)));
					cycles++;
					
				}
				
				System.out.println(cycles);
				
			}
			
			exec++;
			
		}
		
	}
	
	public static boolean twoDiffDigits(int n) {
		
		for (int i = 0; i<=9; i++) {
			
			if (n==1111*i) { return false; }
			
		}
		
		return true;
		
	}
	
	public static int [] numToArray(int n) {
		
		int [] num = new int [4];
		
		for (int i = 0; i<4; i++) {
			num[i] = n%10;
			n = n/10;
			// System.out.println(num[i]);	
		}
		
		return num;
		
	}
	
	public static int orderMaxToMin(int [] n) {
		
		for (int i=0; i<n.length-1; i++) {
			
			int aux = 0;
			
			for (int j=i+1; j<n.length; j++) {
				if (n[i]<n[j]) { 
					aux = n[i];
					n[i] = n[j];
					n[j] = aux;;
				}
			}
			
		}
		
		int num = 0;
		int aux = 1;
		
		for (int i=(n.length-1); i>=0; i--) {
			
			num += n[i]*aux;
			aux *= 10;
			
		}

		return num;
	}
	
	public static int orderMinToMax(int [] n) {
		
		for (int i=0; i<n.length-1; i++) {
			
			int aux = 0;
			
			for (int j=i+1; j<n.length; j++) {
				if (n[i]>n[j]) { 
					aux = n[i];
					n[i] = n[j];
					n[j] = aux;;
				}
			}
			
		}
		
		int num = 0;
		int aux = 1;
		
		for (int i=(n.length-1); i>=0; i--) {
			
			num += n[i]*aux;
			aux *= 10;
			
		}

		return num;
		
	}
}
