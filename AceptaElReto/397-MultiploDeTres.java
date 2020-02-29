import java.util.*;

public class MultiploDeTres {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        long casos = s.nextLong();

        while (casos > 0){

            long num = s.nextLong();
            
            if (num % 3 == 0 || num % 3 == 2){
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            casos--;

        }

    }

}