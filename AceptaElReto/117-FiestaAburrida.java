import java.util.Scanner;
import java.util.Locale;

public class FiestaAburrida {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in).useLocale(Locale.US);
		
		int unknown = s.nextInt();
		int hello = 0;
		
		String hi = s.nextLine();
		
		while (unknown>hello) {
			
			hi = s.nextLine();
			
			hi = hi.replace("Soy ", "");

			System.out.println("Hola, " + hi + ".");
			
			hello++;
			
		}
		
		
		
	}
	
}
