import java.util.Scanner;

public class P10035 { // This problem is equivalent to AER 124

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            // Process input
            String line = s.nextLine();
            int i = line.indexOf(" ");

            String n1 = line.substring(0, i);
            String n2 = line.substring(i+1);

            if (n1.equals("0") && n2.equals("0")) break;
            
            int carryOps = carry(n1, n2);

            if (carryOps == 0) System.out.println("No carry operation.");
            else if (carryOps == 1) System.out.println("1 carry operation."); 
            else System.out.println(carryOps + " carry operations.");

        }

    }

    public static int carry(String n1, String n2){

        int lengthDiff = n1.length()-n2.length();
        int absDiff = Math.abs(lengthDiff);

        if (lengthDiff<0){
            String a = n1;
            n1 = n2;
            n2 = a;
        }
        
        String zeroes = "";

        for (int j=0; j<absDiff; j++){
            zeroes += "0";
        }

        n2 = zeroes + n2;
        

        // Calculation
        int carryNo = 0;
        boolean didLast = false;

        for (int j=n1.length()-1; j>=0; j--){

            int num = Character.getNumericValue(n1.charAt(j));
            int den = Character.getNumericValue(n2.charAt(j));

            if (didLast && num+den+1>=10) { carryNo++; didLast = true; }
            else if (num+den>=10) { carryNo++; didLast = true; }
            else didLast = false;
            
        }

        return carryNo;

    }

}