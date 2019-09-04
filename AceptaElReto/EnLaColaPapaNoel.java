import java.util.*;

public class EnLaColaPapaNoel {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        
        int cases = s.nextInt();
        int count = 0;

        while (count<cases){
            process();
            count++;
        }

    }

    public static void process(){

        int n = s.nextInt();
        int a = s.nextInt()-1;

        Queue<Integer> child = new LinkedList<Integer>();

        for (int i=0; i<n; i++){
            child.add(s.nextInt());
        }

        int size = child.size();

        int totalMin = 0;

        while (true){

            int v = child.remove();
            size--;
            totalMin+=2;

            v--;

            if (a==0 && v==0) break;

            a--;
            if (a<0) { a = size; }

            if (v>0) {
                child.add(v);
                size++;
            }

        }

        System.out.println(totalMin);

    }

    
}