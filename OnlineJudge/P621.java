import java.util.*;

public class P621 {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();

        for (int i=0; i<n; i++){

            String exp = s.nextLine().trim();

            if (exp.equals("1") || exp.equals("4") || exp.equals("78")){
                System.out.println("+");
            } else if (exp.endsWith("35")){
                System.out.println("-");
            } else if (exp.startsWith("9") && exp.endsWith("4")){
                System.out.println("*");
            } else {
                System.out.println("?");
            }

        }

    }

}
