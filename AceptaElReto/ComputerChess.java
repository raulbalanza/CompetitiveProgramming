import java.util.Scanner;

public class ComputerChess {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
			int fila = s.nextInt();
			int columna = s.nextInt();
			
			if (fila==0 && columna==0) { run = false; }
			else {
				
				char filaC = (char) (105 - fila);
				
				System.out.println(filaC + "" + columna);
				
			}
			

		}
		
	}
	
}
