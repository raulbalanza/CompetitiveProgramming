import java.util.*;

class P10142 {

    public static Scanner       s = new Scanner(System.in);
    public static String []     candidates = new String[21];
    public static int [][]      votes = new int [1001][21];
    public static int []        noVotes = new int [21];
    public static boolean []    eliminated = new boolean [21];

    public static void main(String [] args){

        int casos = s.nextInt();
        int count = 0;

        while (count < casos){
            processCase();
            if (count != casos-1) System.out.println();
            count++;
        }

    }

    public static void processCase(){

        int noCandidates = s.nextInt();
        s.nextLine();

        for (int i=0; i<noCandidates; i++){

            candidates[i] = s.nextLine().trim();
            eliminated[i] = false;

        }

        boolean cont = true;
        int i = 0;
        while ( s.hasNext() && cont ) {

            String token = s.nextLine().trim();

            if (token.isEmpty()){
                cont = false;
            } else {
                String [] papel = token.split("\\s+");
                for (int j=0; j<papel.length; j++){
                    votes[i][j]=Integer.parseInt(papel[j])-1;
                }
                i++;
            }
        }

        //if ( noCandidates > 0 ) {

            boolean exec = true;
            while (exec){
                exec = countVotes(i, noCandidates);
            }
        /*} else {
            System.out.println();
        }*/

        

        // print(candidates);
        // print(votes);

    }

    public static boolean countVotes(int papeletas, int noCandidates){

        noVotes = new int[21];

        for (int i=0; i<papeletas; i++){
            int slide = 0;
            while (true){
                if (eliminated[ votes[i][slide] ] == false){
                    noVotes[ votes[i][slide] ]++;
                    break;
                } else {
                    slide++;
                    if (slide>=noCandidates) throw new Error("PANIC");
                }
            }
            
        }

        int maxVotes = 0;
        int ident = -1;

        int lowVotes = papeletas;

        for (int i=0; i<noCandidates; i++){

            if (!eliminated[i]){

                if (noVotes[i]>maxVotes){
                    maxVotes = noVotes[i];
                    ident = i;
                }
                if (noVotes[i]<lowVotes){
                    lowVotes = noVotes[i];
                }

            }

        }

        if (/*papeletas == 0 || */ maxVotes == lowVotes){
            for (int i=0; i<noCandidates; i++){
                if (eliminated[i]==false){
                    System.out.println(candidates[i]);
                }
            }
            return false;
        } else if (2*maxVotes > papeletas){
            System.out.println(candidates[ident]);
            return false;
        } else {
            for (int i=0; i<noCandidates; i++){
                if (noVotes[i]==lowVotes){
                    eliminated[i]=true;
                }
            }
            return true;
        }
        
    }

    public static void print(String [] a){

        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
            if (a[i]==null) break;
        }
        
    }

    public static void print(int [][] a){

        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[0].length; j++){
                System.out.print(a[i][j] + " ");
                if(a[i][j]==0) break;
            }
        }
        
    }

}