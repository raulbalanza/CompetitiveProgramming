import java.util.Scanner;

public class P10055 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            long n1 = s.nextLong();
            long n2 = s.nextLong();

            if (n2>n1){

                long a = n1;
                n1 = n2;
                n2 = a;

            }
            
            System.out.println(n1-n2);

        }

    }

}