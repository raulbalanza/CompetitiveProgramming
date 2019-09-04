import java.util.Scanner;

public class MissingPiece{

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        
        while (true){
            int c = Integer.parseInt(s.nextLine());
            if (c==0) break;
            int [] values = new int [c+1];
            for (int i=1; i<c; i++){
		    int v = s.nextInt();
                values[v]=v;
            }
            s.nextLine();
            boolean found = false;
            for (int i=1; i<=c && !found; i++){
                if (values[i]==0){
            found = true;
            System.out.println(i);
		}    
            }

        }

    }

}
