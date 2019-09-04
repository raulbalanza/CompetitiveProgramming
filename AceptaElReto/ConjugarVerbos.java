import java.util.Scanner;

public class ConjugarVerbos{

    private static final int PRIMERA = 1;
    private static final int SEGUNDA = 2;
    private static final int TERCERA = 3;

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        while (true){
            String [] inp = s.nextLine().split("\\s+");
            int c = 0;

            String lexema = inp[0].substring(0, inp[0].length()-2);
            String conj = inp[0].substring(inp[0].length()-2);
            if (conj.equals("ar")) c = PRIMERA;
            else if (conj.equals("er")) c = SEGUNDA;
            else c = TERCERA;

            if (inp[1].equals("P")) pretPerfSimple(c, lexema);
            else if (inp[1].equals("A")) presente(c, lexema);
            else if (inp[1].equals("F")) futuro(c, lexema);
            else break;
        }
        
    }

    public static void presente(int c, String lexema){

        switch (c){

            case PRIMERA:
                System.out.println("yo " + lexema + "o");
                System.out.println("tu " + lexema + "as");
                System.out.println("el " + lexema + "a");
                System.out.println("nosotros " + lexema + "amos");
                System.out.println("vosotros " + lexema + "ais");
                System.out.println("ellos " + lexema + "an");
                break;
            
            case SEGUNDA:
                System.out.println("yo " + lexema + "o");
                System.out.println("tu " + lexema + "es");
                System.out.println("el " + lexema + "e");
                System.out.println("nosotros " + lexema + "emos");
                System.out.println("vosotros " + lexema + "eis");
                System.out.println("ellos " + lexema + "en");
                break;

            case TERCERA:
                System.out.println("yo " + lexema + "o");
                System.out.println("tu " + lexema + "es");
                System.out.println("el " + lexema + "e");
                System.out.println("nosotros " + lexema + "imos");
                System.out.println("vosotros " + lexema + "is");
                System.out.println("ellos " + lexema + "en");
                break;

        }
        
    }

    public static void pretPerfSimple(int c, String lexema){

        switch (c){

            case PRIMERA:
                System.out.println("yo " + lexema + "e");
                System.out.println("tu " + lexema + "aste");
                System.out.println("el " + lexema + "o");
                System.out.println("nosotros " + lexema + "amos");
                System.out.println("vosotros " + lexema + "asteis");
                System.out.println("ellos " + lexema + "aron");
                break;
            
            case SEGUNDA:
                System.out.println("yo " + lexema + "i");
                System.out.println("tu " + lexema + "iste");
                System.out.println("el " + lexema + "io");
                System.out.println("nosotros " + lexema + "imos");
                System.out.println("vosotros " + lexema + "isteis");
                System.out.println("ellos " + lexema + "ieron");
                break;

            case TERCERA:
                System.out.println("yo " + lexema + "i");
                System.out.println("tu " + lexema + "iste");
                System.out.println("el " + lexema + "io");
                System.out.println("nosotros " + lexema + "imos");
                System.out.println("vosotros " + lexema + "isteis");
                System.out.println("ellos " + lexema + "ieron");
                break;

        }
        
    }

    public static void futuro(int c, String lexema){

        switch (c){

            case PRIMERA:
                System.out.println("yo " + lexema + "are");
                System.out.println("tu " + lexema + "aras");
                System.out.println("el " + lexema + "ara");
                System.out.println("nosotros " + lexema + "aremos");
                System.out.println("vosotros " + lexema + "areis");
                System.out.println("ellos " + lexema + "aran");
                break;
            
            case SEGUNDA:
                System.out.println("yo " + lexema + "ere");
                System.out.println("tu " + lexema + "eras");
                System.out.println("el " + lexema + "era");
                System.out.println("nosotros " + lexema + "eremos");
                System.out.println("vosotros " + lexema + "ereis");
                System.out.println("ellos " + lexema + "eran");
                break;

            case TERCERA:
                System.out.println("yo " + lexema + "ire");
                System.out.println("tu " + lexema + "iras");
                System.out.println("el " + lexema + "ira");
                System.out.println("nosotros " + lexema + "iremos");
                System.out.println("vosotros " + lexema + "ireis");
                System.out.println("ellos " + lexema + "iran");
                break;

        }
        
    }

}