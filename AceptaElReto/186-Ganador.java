import java.util.*;

public class Ganador {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){

            int equipos = s.nextInt();
            int globos = s.nextInt();

            if (equipos == 0 && globos == 0) break;

            int [] res = new int [equipos];

            for(int i=0; i<globos; i++){

                res[s.nextInt()-1]++;
                s.nextLine();

            }

            int pos = 0;
            int max = res[0];

            for(int i=1; i<res.length; i++){

                if (res[i] > max) {
                    max = res[i];
                    pos = i;
                }

            }

            boolean found = false;

            for(int i=pos+1; i<res.length && !found; i++){

                if (res[i] == max) {
                    found = true;
                }

            }

            if (!found) System.out.println(pos+1);
            else System.out.println("EMPATE");

        }
        
    }

}
