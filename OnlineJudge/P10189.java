import java.util.Scanner;

public class P10189{

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean cont = true;

        int field = 1;

        while(cont){

            int rows = s.nextInt();
            int columns = s.nextInt();

            if (rows == 0 && columns == 0) cont = false;
            else {
                s.nextLine();

                int [][] val = new int[rows][columns];
    
                for (int i=0; i<rows; i++){

                    String row = s.nextLine();

                    for (int j=0; j<columns; j++){

                        char ficha = row.charAt(j);

                        // System.out.println(table[i][j]);

                        if (ficha=='*'){
                            val[i][j] = Integer.MIN_VALUE;
                            try { val[i+1][j]++;   }      catch (Exception e) {} 
                            try { val[i+1][j+1]++; }      catch (Exception e) {} 
                            try { val[i+1][j-1]++; }      catch (Exception e) {} 
                            try { val[i][j+1]++;   }      catch (Exception e) {} 
                            try { val[i][j-1]++;   }      catch (Exception e) {} 
                            try { val[i-1][j]++;   }      catch (Exception e) {} 
                            try { val[i-1][j+1]++; }      catch (Exception e) {} 
                            try { val[i-1][j-1]++; }      catch (Exception e) {} 
                        }
                    }
                }
    
                if (field>1) System.out.println();
                System.out.println("Field #" + (field++) + ":");

                for (int i=0; i<rows; i++){
                    for (int j=0; j<columns; j++){
                        if (val[i][j]<0){
                            System.out.print('*');
                        }
                        else {
                            System.out.print(val[i][j]);
                        }
                    }
                    System.out.println();
                }
                
            }

        }

    }

}