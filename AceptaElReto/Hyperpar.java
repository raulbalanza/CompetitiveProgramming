import java.util.Scanner;

public class Hyperpar {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			int check = s.nextInt();
			
			if (check<0) { run = false; }
			else if (isHyperpar(check)) { System.out.println("SI"); }
			else { System.out.println("NO"); }
			
		}
		
	}
	
	public static boolean isHyperpar(int n) {
		
		while (n>0) {
			
			if ((n%10)%2!=0) return false;
			n/=10;
			
		}
		
		return true;
		
	}
	
}
