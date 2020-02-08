import java.util.Scanner;

public class UltimoDigitoFactorial {

	public static void main(String[] args) {
		
		 Scanner s = new Scanner(System.in);
		 
		 int rep = s.nextInt();
		 int nums = 0;

		 while (rep>nums) {
			 
			int num = s.nextInt();
			System.out.println(lastDigitFactorial(num));
				 
			 nums++; 
		 }
	}
	 
	 public static int lastDigitFactorial(int n) {
		 
		 	switch (n) {
         		case 0:
         		case 1:	return 1;
         		case 2:	return 2;
         		case 3:	return 6;
         		case 4:	return 4;
         		default: return 0;
		 }
			
	 }
	
}
