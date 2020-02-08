import java.util.Scanner;

public class EncriptacionMensajes {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		boolean terminar = false;
		
		while (!terminar) {
			
			String inp = s.nextLine();
			String cod = "";
			int vocales = 0;
			int l = inp.length();
			int c = 'p'-inp.charAt(0);
			
			for (int i=1; i<l; i++) { 

				boolean lc = Character.isLowerCase(inp.charAt(i));
				boolean uc = Character.isUpperCase(inp.charAt(i));
				char a = inp.charAt(i);
				
				if (!lc && !uc) {
					cod += a;
				}
				else if ((a + c > 'z' && lc) || (a + c > 'Z' && uc)) {
					cod += (char) (a + c - 'z' + 'a' - 1);
				}
				
				else if ((a + c < 'a' && lc) || (a + c < 'A' && uc)) {
					cod += (char) (a + c + 'z' - 'a' + 1);
				}
				
				else {
					cod += (char) (a + c);
				}
				
			}
			
			// System.out.println(cod);
			
			if (cod.equals("FIN")){
				
				terminar=true;
				
			}
			else {
				
				int l2 = cod.length();
				
				for (int i=0; i<l2; i++) {
					
					char aux = cod.charAt(i);
					if ("AEIOUaeiou".indexOf(aux) != -1) { vocales++; }
								
				}
				
				System.out.println(vocales);
				
			}
			
		}
		
	}
	
}
