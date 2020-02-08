import java.util.Scanner;
import java.util.Locale;

public class NumerosReversibles {
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in).useLocale(Locale.US);
		
		int number = s.nextInt();
		
		while (number!=0) {

			int prime = number + reverse(number);
			
			if (reversible(prime) && sameDigits(number)) {
				System.out.println("SI");
			}
			else {
				System.out.println("NO");
			}
			
			number = s.nextInt();
			
		} 

	}
	
	public static int reverse(int num) {
		
		int revNum = 0, aux = 0;
		
		do {
		
			aux = num % 10;
			revNum = aux + revNum * 10;
			num = num / 10;
		
		} while (num > 0);
		
		return revNum;
		
	}
	
	public static boolean reversible(int n) {
		
		while (n > 0) {
			
			if ((n%10)%2==0) { return false; }
			n /= 10;
			
		}
		
		return true;
		
	}
	
	// Simplify method
	/*public static boolean sameDigits(int n) {
		
		int r = reverse(n);
		
		if ((n>99999999 && n<=999999999) && (r>99999999 && r<=999999999)) { return true; }
		else if ((n>9999999 && n<=99999999) && (r>9999999 && r<=99999999)) { return true; }
		else if ((n>999999 && n<=9999999) && (r>999999 && r<=9999999)) { return true; }
		else if ((n>99999 && n<=999999) && (r>99999 && r<=999999)) { return true; }
		else if ((n>9999 && n<=99999) && (r>9999 && r<=99999)) { return true; }
		else if ((n>999 && n<=9999) && (r>999 && r<=9999)) { return true; }
		else if ((n>99 && n<=999) && (r>99 && r<=999)) { return true; }
		else if ((n>9 && n<=99) && (r>9 && r<=99)) { return true; }
		else if ((n>0 && n<=9) && (r>0 && r<=9)) { return true; }
		else { return false; }
		
	}*/
	
	public static boolean sameDigits(int n) {
		
		int r = reverse(n);
		int digitsN = 0;
		int digitsR = 0;
		
		while (n!=0) {
			
				n/=10;
				digitsN++;
			
			}
		
		while (r!=0) {
			
				r/=10;
				digitsR++;
			
			}
		
		return digitsN == digitsR;	
		
	}

}