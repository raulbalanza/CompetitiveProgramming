import java.util.*;

public class P455 {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();

        for (int i=0; i<n; i++){

            s.nextLine();
            String ese = s.nextLine().trim();
            int length = ese.length();

            for (int j=1; j<=length; j++){
                String [] combs = (ese.split("(?<=\\G.{" + j + "})"));

                //System.out.println(Arrays.toString(combs));

                boolean found = false;
                int k = 1;
                for (; k<combs.length && !found; k++){
                    if (!combs[k].equals(combs[0])){
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println(j);
                    if (i != n-1) System.out.println();
                    break;
                }
            }

        }

    }
    
}
