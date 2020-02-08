import java.util.Scanner;
import java.util.Locale;

public class SumaDeDigitos {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in).useLocale(Locale.US);
		
		while (s.hasNextLine()) {
		
		String n = s.nextLine();
		
		if (!n.contains("-")) {
		
		int totalSum = 0;
		
		for (int i=0; i<n.length(); i++) {
			char c = n.charAt(i);
			System.out.print(c);
			try { 
				char j = n.charAt(i+1);
				System.out.print(" + ");
			}
			catch (Exception ex) {}
			totalSum += Character.getNumericValue(c);
		}
		
		System.out.println(" = " + totalSum);
		}
	}
	}
}
