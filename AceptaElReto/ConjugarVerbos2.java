import java.util.Scanner;

public class ConjugarVerbos2{

    private static final int PRIMERA = 1;
    private static final int SEGUNDA = 2;
    private static final int TERCERA = 3;

    private static String [] pres = new String[6];
    private static String [] pret = new String[6];
    private static String [] futur = new String[6];

    private static final String [] presP = {"o", "as", "a", "amos", "ais", "an"};
    private static final String [] pretP = {"e", "aste", "o", "amos", "asteis", "aron"};
    private static final String [] futurP = {"are", "aras", "ara", "aremos", "areis", "aran"};

    private static final String [] presS = {"o", "es", "e", "emos", "eis", "en"};
    private static final String [] pretS = {"i", "iste", "io", "imos", "isteis", "ieron"};
    private static final String [] futurS = {"ere", "eras", "era", "eremos", "ereis", "eran"};

    private static final String [] presT = {"o", "es", "e", "imos", "is", "en"};
    private static final String [] pretT = {"i", "iste", "io", "imos", "isteis", "ieron"};
    private static final String [] futurT = {"ire", "iras", "ira", "iremos", "ireis", "iran"};

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        while (true){
            String [] inp = s.nextLine().split("\\s+");
            int c = 0;

            String lexema = inp[0].substring(0, inp[0].length()-2);
            String conj = inp[0].substring(inp[0].length()-2);
            if (conj.equals("ar")) {
                pres = presP;
                pret = pretP;
                futur = futurP;
            }
            else if (conj.equals("er")) {
                pres = presS;
                pret = pretS;
                futur = futurS;
            }
            else {
                pres = presT;
                pret = pretT;
                futur = futurT;
            }

            if (inp[1].equals("P")) print(pret, lexema);
            else if (inp[1].equals("A")) print(pres, lexema);
            else if (inp[1].equals("F")) print(futur, lexema);
            else break;
        }
        
    }

    public static void print(String[] t, String lexema){

        String [] pronomb = {"yo", "tu", "el", "nosotros", "vosotros", "ellos"};

        for (int i=0; i<6; i++){
            System.out.println(pronomb[i] + " " + lexema + t[i]);
        }

    }

}