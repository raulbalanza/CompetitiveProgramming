import java.util.Scanner;

public class TriangularMatrix {

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
				
				boolean zeros1 = true;
				boolean zeros2 = true;
				
				for (int i=0; i<dim; i++) {
					for (int j=0; j<dim; j++) {
						if ( i!=j && m[i][j]!=0 && j>i ) { zeros1 = false; }
						if ( i!=j && m[i][j]!=0 && j<i ) { zeros2 = false; }
					}
				}
				
				if (zeros1 || zeros2) { System.out.println("SI"); }
				else { System.out.println("NO"); }
				
			}
			
		}

	}

}