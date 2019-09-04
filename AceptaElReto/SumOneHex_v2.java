import java.util.Scanner;

public class SumOneHex_v2 {

	public static final char [] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			String b = s.nextLine().toUpperCase();
			char [] c = b.toCharArray();
			char [] a = new char [c.length+1];
			a[0] = '0';
			
			for (int k=1; k<=c.length; k++) {
				a[k]=c[k-1];
			}
			
			if (b.equals("FIN")) { run = false; }
			else {
				
				boolean cont = true;
				
				for (int j=1; j<=a.length && cont; j++) {
					int pos = -1;
					
					for (int i=0; pos==-1; i++) {
						if (a[a.length-j]==hex[i]) { pos = i; a[a.length-j]=hex[pos+1]; cont = false; }
						else if (a[a.length-j]=='F') { pos = 15; a[a.length-j]='0'; }
					}
					
				}
				
				display(a);
				
			}
		}
		
	}
	
	public static void display(char [] a) {
		
		int i = 0;
		if (a[0]=='0') { i = 1; }
		
		while (i<a.length) {
			System.out.print(a[i]);
			i++;
		}
		
		System.out.print("\n");
		
	}
	
}
