import java.util.*;

public class ProblemA {

    public static void main(String[] args) {

        int N, k, i, off, maxOff = 0;
        boolean found = false;
        Scanner s = new Scanner(System.in);
        
        N = s.nextInt();
        k = s.nextInt();
    
        N++;
    
        int [] lights = new int[N];
    
        while ((k--) > 0){
            off = 0;
            i = s.nextInt();
            for(int j=1; (j*i)<N; j++){ // First light is number one
                if (lights[j*i] == 0)   lights[j*i] = 1;
                else                    lights[j*i] = 0;
            }
    
            for (int j=1; j<N; j++){
                if (lights[j] == 1){
                    off++;
                }
            }
    
            if (off == N){
                System.out.println(N);
                found = true;
            } else if (off > maxOff){
                maxOff = off;
            }
        }
    
        if (!found)
            System.out.println(maxOff);
    
    }

}