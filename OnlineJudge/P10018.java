import java.util.*;

public class P10018 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();

        for (int i = 0; i < cases; i++) {
            long num = s.nextLong();
            num += reverse(num + "");

            int iterations = 1;

            while (!isPalindrome(num + "", 0)) {

                num += reverse(num + "");
                iterations++;

            }

            System.out.println(iterations + " " + num);
        }

    }

    public static long reverse(String num) {

        StringBuilder sb = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) {
            sb.append(num.charAt(i));
        }

        return Long.parseLong(sb.toString());

    }

    public static boolean isPalindrome(String num, int i) {

        if (i >= num.length())
            return true;
        if (num.charAt(i) == num.charAt(num.length() - 1 - i))
            return isPalindrome(num, i + 1);
        else
            return false;

    }

}