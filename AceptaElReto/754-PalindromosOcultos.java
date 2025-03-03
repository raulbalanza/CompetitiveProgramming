import java.util.*;

public class PalindromosOcultos {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {

            String palabra = s.nextLine().trim();
            char[] letras = palabra.toCharArray();
            Arrays.sort(letras);

            char[] parejas = new char[letras.length];
            int p = 0;
            char sola = 0;

            boolean noHay = false;

            for (int i = 0; i < letras.length && !noHay; i++) {

                if ((i + 1) < letras.length && letras[i+1] == letras[i]) {
                    parejas[p++] = letras[i];
                    i++;
                } else if (sola != 0) {
                    noHay = true;
                } else {
                    sola = letras[i];
                }

            }

            if (noHay) {
                System.out.println("NO HAY");
                continue;
            }

            int i;
            for (i = 0; i < p; i++) {
                System.out.print(parejas[i]);
            }

            if (sola != 0) System.out.print(sola);

            for (i--; i >= 0; i--) {
                System.out.print(parejas[i]);
            }

            System.out.println();

        }

    }


}
