import java.util.*;

public class P101 {

    public static void init(Stack<Integer> [] v, Map<Integer, Integer> m, int b){

        for (int i = 0; i < b; i++){
            v[i] = new Stack<Integer>();
            v[i].push(i);
            m.put(i, i);
        }
    
    }
    
    public static void print_stack(Stack<Integer> [] v){
    
        for (int i=0; i<v.length; i++){
            
            if (!v[i].empty()){
                System.out.print(i + ": ");

                StringBuilder sb = new StringBuilder();

                while (!v[i].empty()){
                    sb.insert(0, v[i].peek() + " ");
                    v[i].pop();
                }
        
                System.out.println(sb.toString().trim());
            } else {
                System.out.println(i + ":");
            }

        }
    
    }

    @SuppressWarnings("unchecked")
    public static void main(String [] args){
    
        Scanner s = new Scanner(System.in);

        int blocks = s.nextInt();
        s.nextLine();
    
        Stack<Integer> [] data = new Stack [blocks];
        Map<Integer, Integer> stackNo = new HashMap<Integer, Integer>();
    
        String cmd1, cmd2;
        int x, y;
    
        init(data, stackNo, blocks);

        while (s.hasNext()){
    
            cmd1 = s.next().trim();

            if (cmd1.equals("quit"))
                break;
            
            x = Integer.parseInt(s.next());
            cmd2 = s.next().trim();
            y = Integer.parseInt(s.next());
            s.nextLine();
    
            if (x != y && stackNo.get(x) != stackNo.get(y)){

                int posA = stackNo.get(x);
                int posB = stackNo.get(y);

                Stack<Integer> sA = data[posA];
                Stack<Integer> sB = data[posB];

                if (cmd1.equals("move")){
    
                    if (cmd2.equals("onto")){    // move x onto y
    
                        // get pos of x and y
                        // iterate stack until reaching a and b, returning elements to original positions
                        // move x to y
    
                        int n = sA.peek();
                        while (!sA.empty() && n != x){
                            data[n].push(n);
                            stackNo.put(n, n);
                            sA.pop();
                            n = sA.peek();
                        }
    
                        n = sB.peek();
                        while (!sB.empty() && n != y){
                            data[n].push(n);
                            stackNo.put(n, n);
                            sB.pop();
                            n = sB.peek();
                        }
    
                        sA.pop();
                        sB.push(x);
                        stackNo.put(x, posB);
    
                    } else {                // move x over y
    
                        // get pos of x and y
                        // iterate stack until reaching x, returning elements to original positions
                        // move x to y
    
                        int n = sA.peek();
                        while (!sA.empty() && n != x){
                            data[n].push(n);
                            stackNo.put(n, n);
                            sA.pop();
                            n = sA.peek();
                        }
    
                        sA.pop();
                        sB.push(x);
                        stackNo.put(x, posB);
    
                    }
    
                } else {
    
                    Stack<Integer> aux = new Stack<Integer>();

                    if (cmd2.equals("onto")){    // pile x onto y
    
                        // take all blocks above b and return to original positions
                        // take all blocks above a, and pile them above b
    
                        int n = sB.peek();
                        while (!sB.empty() && n != y){
                            data[n].push(n);
                            stackNo.put(n, n);
                            sB.pop();
                            n = sB.peek();
                        }

                        n = sA.peek();
                        while (!sA.empty() && n != x){
                            aux.push(n);
                            stackNo.put(n, posB);
                            sA.pop();
                            n = sA.peek();
                        }
                        sA.pop();
                        stackNo.put(n, posB);
                        aux.push(n);
    
                    } else {                // pile x over y
    
                        // take all blocks above a, and pile them above b

                        int n = sA.peek();
                        while (!sA.empty() && n != x){
                            aux.push(n);
                            stackNo.put(n, posB);
                            sA.pop();
                            n = sA.peek();
                        }
                        sA.pop();
                        stackNo.put(n, posB);
                        aux.push(n);
    
                    }

                    while (!aux.empty()){
                        sB.push(aux.pop());
                    }
    
                }
    
            }
    
        }
    
        print_stack(data);

    }

}