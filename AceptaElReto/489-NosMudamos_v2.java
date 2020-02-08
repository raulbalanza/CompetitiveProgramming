import java.util.*;

public class NosMudamos_v2 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            int actual = s.nextInt();
            int nuevos = s.nextInt();

            if (nuevos<actual) {
                s.nextLine();
                s.nextLine();
                s.nextLine();
                System.out.println("NO");
            }
            else {

                int [][] schools = new int[2][nuevos];

                for (int i=0; i<actual; i++){ schools[0][i]=s.nextInt(); }                
                for (int i=0; i<nuevos; i++){ schools[1][i]=s.nextInt(); }
                
                Arrays.sort(schools[0]);
                Arrays.sort(schools[1]);
            
                invert(schools[0]);
                invert(schools[1]);

                boolean fail = false;
                for(int i=0; i<actual && !fail; i++){

                   if (schools[0][i]>schools[1][i]){
                       fail = true;
                   }

                }

                if (!fail) System.out.println("SI");
                else { System.out.println("NO"); }

            }

        }

    }

    public static void invert(int [] x){

        for (int i=0; i<x.length/2; i++){
            int aux = x[i];
            x[i]=x[x.length-1-i];
            x[x.length-1-i]=aux;
        }

    } 

}