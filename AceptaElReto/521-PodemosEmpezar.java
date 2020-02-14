import java.util.*;

public class PodemosEmpezar {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            int pisos = s.nextInt();
            int letras = s.nextInt();
            int asistentes = s.nextInt();

            Set<String> set = new HashSet<String>();

            if (pisos == 0 && letras == 0 && asistentes == 0) break;

            for (int i=0; i<asistentes; i++){

                String as = s.nextInt() + s.next();
                set.add(as);

            }

            if (set.size()*2 >= pisos*letras){
                System.out.println("EMPEZAMOS");
            } else {
                System.out.println("ESPERAMOS");
            }

        }

    }

}