import java.util.Scanner;

public class SumCarry_v3 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            // PROCESS INPUT
            String line = s.nextLine();
            int i = line.indexOf(" ");

            String n1 = line.substring(0, i);
            String n2 = line.substring(i+1);

            if (n1.equals("0") && n2.equals("0")) break;
            
            System.out.println(carry(n1, n2));

        }

    }

    public static int carry(String n1, String n2){

        int lengthDiff = n1.length()-n2.length();
        int absDiff = Math.abs(lengthDiff);

        if (lengthDiff<0){
            String a = n1;
            n1 = n2;
            n2 = a;
        }
        
        String zeroes = "";

        for (int j=0; j<absDiff; j++){
            zeroes += "0";
        }

        n2 = zeroes + n2;
        

        // BEGIN OPERATIONS
        int carryNo = 0;
        boolean didLast = false;

        for (int j=n1.length()-1; j>=0; j--){

            int num = Character.getNumericValue(n1.charAt(j));
            int den = Character.getNumericValue(n2.charAt(j));

            // System.out.println("Sum " + num + " + " + den);

            if (didLast && num+den+1>=10) { carryNo++; didLast = true; }
            else if (num+den>=10) { carryNo++; didLast = true; }
            else didLast = false;
            
        }

        return carryNo;

    }

    // ALT FASTER METHOD
    public static int carryDos(String s2, String s1)
    {
        int cuenta=0; //cuenta de acarreos
        int acarreo=0; //acarreo actual
        int i=0; //posición por la izquierda
        boolean terminado=false; //bandera para controlar el bucle
        while (!terminado)
        {
            //Coger el siguiente dígito de cada número por la izquierda. 
            //Si he superado la longitud, el dígito en el que estoy es 0
            int i1=i<s1.length()?s1.charAt(s1.length()-i-1)-'0':0; 
            int i2=i<s2.length()?s2.charAt(s2.length()-i-1)-'0':0;
            int suma=acarreo+i1+i2; //sumamos ambos mas el posible acarreo anterior
            acarreo=suma>=10?1:0; //Hay acarreo si la suma es es > 10
            cuenta+=acarreo;
            i++; //pasar al siguiente por la izquierda
            //terminamos si hemos sobrepasado la longitud de alguna de las dos cifras y no hay acarreos
            terminado=!(acarreo>0) && (i>=s1.length() || i>s2.length());
        }
        return cuenta;
    }

}