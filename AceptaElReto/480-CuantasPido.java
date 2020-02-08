import java.util.Scanner;

public class CuantasPido {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		int count = 0;
		
		while (count<cases) {
			
			int grapes = s.nextInt();
			int badGrapes = s.nextInt();
			int everyGrapes = s.nextInt();

			int bring = (grapes / everyGrapes)*badGrapes;
			int resto = ((grapes) % everyGrapes);
			
			int out = 0;
			
			if (badGrapes>resto) { out = resto; }
			else { out = badGrapes; }
			
			System.out.println(bring+out);
			
			count++;
			
		}
		
	}
	
}
