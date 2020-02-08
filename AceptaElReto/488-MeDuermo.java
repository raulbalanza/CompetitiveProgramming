import java.util.Scanner;

public class MeDuermo {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		int count = 0;
		
		while (count<cases) {
			
			String [] data = s.nextLine().split("\\s+");
			int [] parseData = new int [data.length];
			
			String [] save = s.nextLine().split("\\s+");
			int [] parseSave = new int [save.length];
			
			for (int i=0; i<data.length; i++) { parseData[i]=Integer.parseInt(data[i]); }
			for (int i=0; i<save.length; i++) { parseSave[i]=Integer.parseInt(save[i]); }
			
			int sessions = 1;
			int timeUntilSleeping = parseData[1];
			for (int i=1; i<save.length; i++) {
				int currSave = parseSave[i-1];
				if (timeUntilSleeping<parseSave[i]) { 
					sessions++; timeUntilSleeping=currSave+parseData[1]; 
				}
			}
			
			System.out.println(sessions);
			
			count++;
		}
		
	}
	
}
