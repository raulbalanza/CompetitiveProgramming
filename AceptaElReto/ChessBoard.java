import java.util.Scanner;

public class ChessBoard{

    public static void main(String [] args){

        Scanner s = new Scanner(System.in);
        boolean run = true;

        while (run){

            int size = s.nextInt();
            if (size==0){ break; }
            char ch = s.nextLine().charAt(1);
            
            // System.out.println("size is " + size + "\nch is " + ch);

            int dash = 8 * size;

            line(dash);
            
            for (int j=0; j<8; j++){
                for (int l=0; l<size; l++){
                    System.out.print("|");
                    if (j%2==0){
                        for (int k=0; k<4; k++){
                            for (int i=0; i<size; i++) System.out.print(" ");
                            for (int i=0; i<size; i++) System.out.print(ch);
                        }
                    }
                    else{
                        for (int k=0; k<4; k++){
                            for (int i=0; i<size; i++) System.out.print(ch);
                            for (int i=0; i<size; i++) System.out.print(" ");
                        }
                    }
                    System.out.println("|");
                }
            }

            line(dash);

        }

    }

    public static void line(int dash){
        System.out.print("|");
        for (int i=0; i<dash; i++)  System.out.print('-');
        System.out.println("|");
    }

}