import java.util.Scanner;

public class RadaresTramo {

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        
        while (true){

            double dist = s.nextInt();
            double velMax = s.nextInt();
            double tiempo = s.nextInt();

            if (dist==0 && velMax==0 && tiempo==0) break;

            boolean c1 = dist<=0 || velMax<=0 || tiempo<=0;

            if (c1) System.out.println("ERROR");
            else {

                double velMaxPermitida = (dist/tiempo*1.0)*3.6;

                double velDiff = velMaxPermitida - velMax;
                
                if (velDiff > 0){
    
                    double percentage = velMax*0.2;
    
                    if (velDiff >= percentage){
                        System.out.println("PUNTOS");
                    } else {
                        System.out.println("MULTA");
                    }
    
                } else {
                    System.out.println("OK");
                }

            }

        }

    }

}