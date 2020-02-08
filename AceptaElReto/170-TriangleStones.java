import java.util.Scanner;

public class TriangleStones {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			int stones = s.nextInt();
			if (stones==0) { run = false; }
			else {
				int size = (int) ((-1+Math.sqrt(1+8.0*stones))/2.0);
				int stUsed = (size*size + size)/2;
				
				System.out.println(size + " " + (stones-stUsed));
			}
			
		}
		
	}
	
}
