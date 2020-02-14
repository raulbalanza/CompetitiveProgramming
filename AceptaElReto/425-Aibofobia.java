import java.util.*;

public class Aibofobia {

    public static int [][] memo = new int[110][110];
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()){

            for (int[] row: memo)
                Arrays.fill(row, -1);

            char [] st = s.nextLine().trim().toCharArray();
            int res = palindromo(st, 0, st.length-1);
            System.out.println(st.length-res);

        }

    }

    public static int palindromo(char [] palabra, int i, int j){

        if (i > j) return 0;
        if (i == j) return 1;

        if (memo[i][j] != -1) return memo[i][j];

        int res;

        if (palabra[i] == palabra[j]) { res = 2 + palindromo(palabra, i+1, j-1); }
        else res = Math.max(palindromo(palabra, i, j-1), palindromo(palabra, i+1, j));

        memo[i][j] = res;

        return res;

    }

}