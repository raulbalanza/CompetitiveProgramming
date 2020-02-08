import java.util.Scanner;
import java.util.Arrays;

public class MePilloElToro {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean next = true;

        while (next){

            int n = Integer.parseInt(s.nextLine());

            if (n==0) { next = false; }
            else {

                String [] users = new String [n];
                int [] marks = new int [n];
    
                int pos = 0;
    
                for (int i=0; i<n; i++){
    
                        String user = s.nextLine();
                        String mark = s.nextLine();
    
                        int diff = (mark.equals("CORRECTO")) ? 1 : -1;
    
                        int e = exists(users, user);
    
                        if (e==-1){
                            users[pos] = user;
                            marks[pos] += diff;
                        
                            pos++;
                        }
                        else {
                            marks[e] += diff;
                        }  
    
                }
    
                printResults(users, marks);

            }

        }

    }

    public static int exists(String [] v, String s){

        for (int i=0; i<v.length; i++){
            if (v[i]!=null && v[i].equals(s)) return i;
        }

        return -1;

    }

    public static void printResults(String [] u, int [] m){

        int nonZero = 0;

        for (int i=0; i<m.length; i++){
            if (m[i]!=0) nonZero++;
        }

        String [] p = new String [nonZero];

        for (int i=0, j=0; i<u.length; i++){

            if (m[i]!=0){
                p[j++] = u[i] + ", " + m[i];
                //System.out.println(p[j-1]);
            } 
            
        }
        
        Arrays.sort(p);

        for (int i=0; i<p.length; i++){

            System.out.println(p[i]);

        }

        System.out.println("---");

    }

}