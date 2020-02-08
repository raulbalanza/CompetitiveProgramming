import java.util.Scanner;

public class Ventas_noArray {

    public static void main(String[] args) {
        boolean run = true;

        Scanner s = new Scanner(System.in);

        while (run){

            double val = s.nextDouble();
            if (val!=-1){
                int min = 0;
                double minV = val;
                int max = 0;
                double maxV = val;
                double media = val;

                for (int i=1; i<6; i++){
                    val=s.nextDouble();
                    media += val;
                    if (val>maxV){ max = i; maxV = val; }
                    if (val<minV){ min = i; minV = val; }
                }

                media/=6;

                if (min==max){ System.out.println("EMPATE"); }
                else {

                    System.out.print(week(max) + " " + week(min) + " ");
                    if (media < val){ System.out.println("SI"); }
                    else { System.out.println("NO"); }

                }
            }
            else { run = false; }
            
        }

    }

    public static String week(int i){
        switch (i){
            case 0:
                return "MARTES";
            case 1:
                return "MIERCOLES";
            case 2:
                return "JUEVES";
            case 3:
                return "VIERNES";
            case 4:
                return "SABADO";
            default:
                return "DOMINGO";
        }


    }

}