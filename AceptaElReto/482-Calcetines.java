import java.util.Scanner;

public class Calcetines {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			String a = s.nextLine();
			String [] b = a.split("\\s+");
			
			if (b[0].equals(".")) { run = false; }
			else { System.out.println(analyze(b)); }
			
		}
		
	}
	
	public static String analyze(String [] b) {
		
		int countN = 0;
		int countG = 0;
		
		for (int i=0; i<b.length-1; i++) {
			if (b[i].equals("N")) { countN++; }
			if (b[i].equals("G")) { countG++; }
		}
		
		if (countN%2==0 && countG%2==0) { return "EMPAREJADOS"; }
		if (countN%2!=0 && countG%2==0) { return "NEGRO SOLITARIO"; }
		if (countG%2!=0 && countN%2==0) { return "GRIS SOLITARIO"; }
		else { return "PAREJA MIXTA"; }
		
	}
	
}
