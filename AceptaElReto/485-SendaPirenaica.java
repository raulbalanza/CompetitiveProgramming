import java.util.Scanner;

public class SendaPirenaica {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		while (true) {
			
			int etapas = Integer.parseInt(s.nextLine());
			if (etapas==0) { break; }
			String [] dista = s.nextLine().split("\\s+");
			int [] dist = new int [dista.length+1];
			
			for (int i=0; i<dista.length; i++) { dist[i]=Integer.parseInt(dista[i]); }
			dist[etapas]=0;			
			
			boolean firstTime = true;
			
			for (int j=0; j<etapas; j++) {
				
				if (!firstTime) {
					System.out.print(" ");
				}

				firstTime = false;
				
				int temp = 0;
				for (int i=j; i<etapas; i+=2) {
					
					temp+= dist[i]+dist[i+1];
					
				}
				System.out.print(temp);
				
				
			}
			System.out.println();
			
		}
		
	}
	
}
