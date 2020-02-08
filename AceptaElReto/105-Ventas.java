import java.util.Scanner;

public class Ventas {

    public static void main(String[] args) {
        boolean run = true;

        Scanner s = new Scanner(System.in);

        while (run){

            double [] ventas = new double [6];

            ventas[0] = s.nextDouble();
            if (ventas[0]!=-1){
                int min = 0;
                int max = 0;
                double media = ventas[0];

                for (int i=1; i<6; i++){
                    ventas[i]=s.nextDouble();
                    media += ventas[i];
                    if (ventas[i]>ventas[max]){ max = i; }
                    if (ventas[i]<ventas[min]){ min = i; }
                }

                media/=6;

                if (min==max){ System.out.println("EMPATE"); }
                else {

                    System.out.print(week(max) + " " + week(min) + " ");
                    if (media < ventas[5]){ System.out.println("SI"); }
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