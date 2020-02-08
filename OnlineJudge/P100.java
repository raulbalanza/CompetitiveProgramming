import java.util.Scanner;

class P100 {

    public static void main(String [] args){

        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            int n1 = s.nextInt();
            int n2 = s.nextInt();

            int i = Math.min(n1, n2);
            int j = Math.max(n1, n2);

            int max = 0;

            while(i<=j){

                int aux = algorithm(i);

                if (aux>max) max=aux;

                i++;

            }

            System.out.printf("%d %d %d\n", n1, n2, max);

        }

    }

    public static int algorithm(int n){

        int l = 1;

        while ( n != 1 ) {
            if ( n % 2 == 1 ) n = 3 * n + 1;
            else n /= 2;
            l++;
        }

        return l;

    }

}
