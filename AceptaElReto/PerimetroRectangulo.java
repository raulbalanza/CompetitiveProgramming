import java.util.Scanner;

public class PerimetroRectangulo {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		boolean last = false;
		
		while (!last) {

			int x = s.nextInt();
			int y = s.nextInt();
			
			long perimetro = 2*y + 2*x;
				
			if (x<0 || y<0) {
				last = true;
			}
			else {
				System.out.println(perimetro);
			}
			
		}
			
	}
	
}
