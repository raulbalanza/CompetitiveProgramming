import java.util.Scanner;

public class Dhahran_v2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		while (s.hasNext()) {
			
			boolean stop = false;
			
			String n = s.nextLine();
			int l = n.length();
			int dot = n.indexOf(".");
			
			int intDot = -1;
			int decDot = -1;
			
			if (dot!=-1) {
				stop = false;
				for (int i=0; i<dot && !stop; i++) {
					if (n.charAt(i)!='0') { intDot = i; stop = true; }
				}
				
				stop = false;
				for (int i=l-1; i>dot && !stop; i--) {
					if (n.charAt(i)!='0') { decDot = i; stop = true; }
				}
				
				if (intDot==decDot) { System.out.println(0); }
				else if (intDot==-1) { System.out.println(n.substring(dot-1, decDot+1)); }
				else if (decDot==-1) { System.out.println(n.substring(intDot, dot)); }
				else { System.out.println(n.substring(intDot, decDot+1)); }
			}
			else {
				
				stop = false;
				for (int i=0; i<l && !stop; i++) {
					if (n.charAt(i)!='0') { intDot = i; stop = true; }
				}
				
				if (intDot==-1) { System.out.println(0); }
				else { System.out.println(n.substring(intDot)); }
				
			}
			
		}
		
	}
	
}
