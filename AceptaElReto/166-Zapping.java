import java.util.Scanner;

public class Zapping {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			int n1 = s.nextInt();
			int n2 = s.nextInt();
			
			if (n1==0 && n2==0) { run = false; }
			else {
				
				int nMa = n1>n2 ? n1 : n2;
				int nMi = n1>n2 ? n2 : n1;
				
				int w1 = nMa-nMi;				
				int w2 = (nMi) + (99-nMa);
				
				System.out.println(Math.min(w1, w2));
				
			}
			
		}

	}

}
