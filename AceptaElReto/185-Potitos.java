import java.util.Arrays;
import java.util.Scanner;

public class Potitos {

	public static int [] nIng = new int [2];	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int a = Integer.parseInt(s.nextLine());
		
		while (a>0) {
			
			int c = 0;
			
			nIng[0]=0;
			nIng[1]=0;
			
			String [] yes = new String [250];
			String [] no = new String [250];
			
			while (c<a) {
				
				String p = s.nextLine();
				
				String eat = p.substring(0, p.indexOf(':'));
				String ing = p.substring(p.indexOf(':')+1, p.indexOf("FIN")).trim();
				
				String [] ingP = ing.split("\\s+");
				
				int eatD;
				String [] aux;
				
				if (eat.equals("SI")) { eatD = 1; aux = yes; }
				else { eatD = 0; aux = no; }
				
				for (int i=0; i<ingP.length; i++) {
					add(aux, ingP[i], eatD);
				}
				
				c++;
			}
			
			for (int i=0; i<nIng[1]; i++) {
				
				boolean isYes = false;
				for (int j=0; j<nIng[0] && !isYes; j++) {
					if (yes[i].equals(no[j])) { isYes = true; remove(no, j); }
				}
				
			}
			
			Arrays.sort(no, 0, nIng[0]);
			
			for (int j=0; j<nIng[0]; j++) {
				System.out.print(no[j] + " ");
				try { if (no[j+1]!=null) { System.out.print(" "); } }
				catch (Exception ex) {}
			}
			System.out.println();
			
			a = Integer.parseInt(s.nextLine());
			
		}
		
	}
	
	public static void add(String [] a, String e, int c) {	
		
		boolean exists = false;
		for (int i=0; i<nIng[c] && !exists; i++) {
			
			if (a[i].equals(e)) { exists=true; }
			
		}
		
		if (!exists) { a[nIng[c]++]=e; }
		
	}
	
	public static void remove(String [] a, int pos) {
		
		a[pos] = null;
		nIng[0]--;
		
		for (int i=pos; i<=nIng[0]; i++) { a[i]=a[i+1]; }
		
	}

}
