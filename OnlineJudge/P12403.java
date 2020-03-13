import java.util.*;

public class SaveSetu {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int operations = s.nextInt();
        long sum = 0;

        for (int i=0; i<operations; i++){
            
            String op = s.next().trim();
            
            if (op.charAt(0) == 'd'){
                sum += s.nextLong();
            } else {
                System.out.println(sum);
            }
        
        }

    }

}