import java.util.Scanner;

public class IdentityMatrix {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (s.hasNextInt() && run) {
			
			int dim = s.nextInt();
			
			if (dim==0) { break; }
			else {  
				
				int [][] m = new int [dim][dim];
				
				for (int i=0; i<dim; i++) {
					for (int j=0; j<dim; j++) {
						m[i][j]=s.nextInt();
					}
				}
				
				boolean fullOfOnes = true;
				boolean zeros = true;
				
				for (int i=0; i<dim; i++) {
					for (int j=0; j<dim; j++) {
						if ( i!=j && m[i][j]!=0 ) { zeros = false; }
						else if (i==j && m[i][j]!=1) { fullOfOnes = false; }
					}
				}
				
				if (zeros && fullOfOnes) { System.out.println("SI"); }
				else { System.out.println("NO"); }
				
			}
			
		}

	}

}
