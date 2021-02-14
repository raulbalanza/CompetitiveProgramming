import java.util.*;

public class ProblemE {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int cases = Integer.parseInt(s.nextLine());

        String[] places = new String[cases];
        double[] minNumbers = new double[cases];
        double[] maxNumbers = new double[cases];
        
        double minT = 0;
        double maxT = 0;

        for (int i = 0; i < cases; i++) {

            String[] line = s.nextLine().trim().split("\\s+");
            places[i] = line[0];
            double num = Integer.parseInt(line[1]);

            minNumbers[i] = Math.max(0, num - 0.5);
            maxNumbers[i] = Math.min(100, num + 0.49);

            minT += minNumbers[i];
            maxT += maxNumbers[i];

        }

        if (minT > 100 || maxT < 100) {
            System.out.println("IMPOSSIBLE");
        } else {

            for (int m = 0; m < places.length; m++) {

                double realMin = Math.max(minNumbers[m], maxNumbers[m] - (maxT - 100));
                double realMax = Math.min(maxNumbers[m], minNumbers[m] + (100 - minT));

                System.out.printf("%s %.2f %.2f\n", places[m], realMin, realMax);

            }
        }

    }

}