import java.util.*;

public class P450 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int departments = s.nextInt();
        s.nextLine();
        List<Person> l = new ArrayList<Person>();

        for (int i=0; i<departments; i++){

            String department = s.nextLine().trim();
            String line = s.nextLine();
            while (!line.trim().isEmpty()){

                String [] person = line.trim().split(",");
                Person p = new Person();
                
                p.title = person[0];
                p.firstName = person[1];
                p.lastName = person[2];
                p.address = person[3];
                p.homePhone = person[4];
                p.workPhone = person[5];
                p.campusBox = person[6];
                p.department = department;

                l.add(p);

                if (s.hasNextLine()){
                    line = s.nextLine();
                } else break;

            }

        }

        Collections.sort(l);

        for (int i=0; i<l.size(); i++){
            System.out.println(l.get(i));
        }

    }
    
}

class Person implements Comparable<Person> {

    String title;
    String firstName;
    String lastName;
    String address;
    String department;
    String homePhone;
    String workPhone;
    String campusBox;

    public int compareTo(Person o){
        return this.lastName.compareTo(o.lastName);
    }

    public String toString(){

        return "----------------------------------------\n" + 
                this.title + " " + this.firstName + " " + this.lastName + "\n" + 
                this.address + "\n" + "Department: " + this.department + "\n" + 
                "Home Phone: " + this.homePhone + "\nWork Phone: " + this.workPhone + 
                "\nCampus Box: " + this.campusBox;
    }

}