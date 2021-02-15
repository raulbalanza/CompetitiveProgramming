import java.util.*;

public class Bombillas {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();

        while ((cases--) > 0){

            int horasMaximas = s.nextInt();
            int encendidosMaximos = s.nextInt();
            int horasPorEncendido = s.nextInt();

            int horasEstimadas = horasPorEncendido * encendidosMaximos;

            if (horasEstimadas > horasMaximas){
                System.out.println("HORAS");
            } else if (horasEstimadas == horasMaximas){
                System.out.println("AMBAS");
            } else {
                System.out.println("ENCENDIDOS");
            }

        }

    }

}