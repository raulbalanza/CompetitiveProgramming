import java.util.*;

public class P494 {

    public static void main(String[] args) {
    
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()){

            String [] c = s.nextLine().trim().split("\\P{Alpha}+");
            int words = c.length;

            for (int i=0; i<c.length; i++){
                if (c[i].isEmpty()) words--;
            }

            System.out.println(words);

        }

    }

}