import java.util.Arrays;
import java.util.Scanner;

public class EsquiandoAlaska {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        
        while (true){

            int n = s.nextInt();

            if (n==0) break;

            int [] esquiadores = new int [n];
            int [] esquis = new int [n];

            for (int i=0; i<n; i++){
                esquiadores[i] = (s.nextInt());
            }

            Arrays.sort(esquiadores);

            for (int i=0; i<n; i++){
                esquis[i] = (s.nextInt());
            }

            Arrays.sort(esquis);

            int minDiff = 0;

            for (int i=0; i<n; i++){

                minDiff += Math.abs(esquiadores[i] - esquis[i]);

            }

            System.out.println(minDiff);

        }

    }

}