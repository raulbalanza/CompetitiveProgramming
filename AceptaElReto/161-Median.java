import java.util.Scanner;

public class Median {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
			
		while (s.hasNextInt()) {
			
			int size = s.nextInt();
			if (size==0) { break; }
			int [] a = new int [size];
			int c=0;
			
			while (c<size) {
				
				int v = s.nextInt();
				a[c]=v;
				
				c++;
			}
			System.out.println((int) (2*median(a)));
			
		}
			
	}
	
	public static double median(int [] n) {
		
		for (int i=0; i<n.length-1; i++) {
			
			int aux = 0;
			
			for (int j=i+1; j<n.length; j++) {
				if (n[i]>n[j]) { 
					aux = n[i];
					n[i] = n[j];
					n[j] = aux;;
				}
			}
			
		}

		if (n.length%2==0) {
			
			int pos1 = (n.length/2)-1;
			int pos2 = (n.length/2);
			
			return (n[pos1]*1.0+n[pos2]*1.0)/2.0;

		}
		else {
			
			int pos = ((n.length+1)/2)-1;
			
			return n[pos]*1.0;
		}
		
	}

}