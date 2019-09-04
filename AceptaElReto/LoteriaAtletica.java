import java.util.Scanner;

public class LoteriaAtletica {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());
        int proc = 0;

        while (proc < count){

            int decimos = Integer.parseInt(s.nextLine());
            int total = 0;

            for (int i=0; i<decimos; i++){
                if (s.nextInt()%2==0) total++;
            }
            s.nextLine();

            System.out.println(total);

            proc++;

        }
        
    }



    
}