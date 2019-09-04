import java.util.Scanner;

public class Ascensor_v4 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (s.hasNext() && run) {
			
			String [] a = s.nextLine().split("\\s");
			
			if (Integer.parseInt(a[0])<0) { 
				run = false;
			}
			else {
				
				int [] b = new int [a.length];
				int total = 0;
				boolean go = true;
				
				for (int i=0; i<a.length; i++) { b[i]=Integer.parseInt(a[i]); }
				for (int j=1; j<a.length-1 && go; j++) { 
					if (b[j]==-1) { go = false; }
					else { total += Math.abs(b[j]-b[j-1]); }
				}
				
				System.out.println(total);
				
			}
			
		}
		
	}

}
