import java.util.Scanner;

public class FinDeMes {

    public static void main(String [] args){

        Scanner s = new Scanner(System.in);

        int count = Integer.parseInt(s.nextLine());
        int c = 0;

        while (c<count){

            int val1 = s.nextInt();
            int val2 = s.nextInt();
            s.nextLine();

            if (val1+val2>=0) {
                System.out.println("SI");
            }
            else {
                System.out.println("NO");
            }

            c++;
        }

    }

}