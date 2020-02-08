import java.util.*;

public class Cubifinitos_v5 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        while (true){
            
            int n = in.nextInt();
            if (n==0) break;

            if (n==1){
                System.out.println("1 -> cubifinito.");
                continue; // Jump to next iteration
            }

            ArrayList<Integer> s = new ArrayList<Integer>();
            s.add(n);

            System.out.print(n + " ");
            while (true){
                int sum = sumOfDigits(n);
                if (sum==1){
                    System.out.println("- 1 -> cubifinito.");
                    break;
                }
                else if (s.indexOf(sum)!=-1){
                    System.out.println("- " + sum + " -> no cubifinito.");
                    break;
                }
                else {
                    s.add(sum);
                    System.out.print("- " + sum + " ");
                    n = sum;
                }

            }

        }

    }

    public static int sumOfDigits(int n){

        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum += d*d*d;
            n /= 10;
        }

        return sum;

    }

}