import java.util.Scanner;

public class P10071 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNextInt()){

            int v = s.nextInt();
            int t = s.nextInt();

            if (t==0){

                System.out.println(0);

            } else {

                double accel = v/(t*1.0);

                double pos = (accel*(t*2)*(t*2))/2.0;

                System.out.println(Math.round(pos));

            }

        }

    }

}