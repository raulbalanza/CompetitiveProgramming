import java.util.Scanner;

public class FreeGums_v3 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (true){

            int chicCanj = s.nextInt();
            int chicReg = s.nextInt();
            int chicCom = s.nextInt();

            if (chicCanj == 0 && chicReg == 0 && chicCom == 0) break;

            if (chicReg>=chicCanj && chicCom>=chicCanj) System.out.println("RUINA");
            else if (chicReg == 0) System.out.println(chicCom + " " + chicCom);
            else {

                int chicTot = chicCom;

                while (chicCom>=chicCanj){

                    int calc = (chicCom*chicReg)/chicCanj;

                    chicTot += calc;
                    chicCom = calc + (chicCom*chicReg)%chicCanj;

                }

                System.out.println(chicTot + " " + chicCom);

            }

        }


    }

}