import java.util.Scanner;

public class Pentavocalicas {

    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        int tot = Integer.parseInt(s.nextLine());

        for (int cases=0; cases<tot; cases++){

            boolean cA = false, cE = false, cI = false, cO = false, cU = false;

            String word = s.nextLine();
            int l = word.length();

            int remaining = 5;

            for (int i=0; i<l && remaining>0; i++){
                char c = Character.toLowerCase(word.charAt(i));
                
                if (c=='a' && !cA){ cA = true; remaining--; }
                if (c=='e' && !cE){ cE = true; remaining--; }
                if (c=='i' && !cI){ cI = true; remaining--; }
                if (c=='o' && !cO){ cO = true; remaining--; }
                if (c=='u' && !cU){ cU = true; remaining--; }

            }

            if (remaining>0) System.out.println("NO");
            else System.out.println("SI");

        }

    }

}