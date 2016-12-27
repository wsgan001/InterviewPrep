package org.practice.javaFundas.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Walmart hackerearth question: Arrange employee based on their salary. If salary is equal, arrange based on alphabetical order of name.
//Output should be salary and name
/*Input:
id:1,2,3,4,5
name:robin,harry,lily,tom,jack
mgrId:2,3,4,0,2
salary:1000.00,1000.00,3000.00,5000.00,1500.00
functionality:1
*/

public class ArrangeEmployee {
    private int id;
    private String name;
    private int mngrId;
    private double salary;

    ArrangeEmployee( int id, String name, int mngrId, double salary) {
        this.id = id;
        this.name = name;
        this.mngrId = mngrId;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMngrId() {
        return mngrId;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String tempId[] = line1.split(":");
        String[] id = tempId[1].split(",");

        String line2 = br.readLine();
        String tempName[] = line2.split(":");
        String[] name = tempName[1].split(",");

        String line3 = br.readLine();
        String tempmgr[] = line3.split(":");
        String[] mngrId = tempmgr[1].split(",");

        String line4 = br.readLine();
        String tempSalary[] = line4.split(":");
        String[] salary = tempSalary[1].split(",");

        String line5 = br.readLine();
        String func[] = line5.split(":");

        Integer functionality = Integer.parseInt(func[1]);

        List<ArrangeEmployee> list = new ArrayList<ArrangeEmployee>();
        for(int i =0; i < id.length; i++) {
            ArrangeEmployee ob = new ArrangeEmployee(Integer.parseInt(id[i]), name[i], Integer.parseInt(mngrId[i]),
                                Double.parseDouble(salary[i]));
            list.add(ob);
        }

       Collections.sort(list, new Comparator<ArrangeEmployee>() {
            @Override
            public int compare(ArrangeEmployee o1, ArrangeEmployee o2) {
                int res=  Double.compare(o1.getSalary(), o2.getSalary());
                if(res == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return res;
            }
        });

       switch(functionality) {
            case 1:
                for(ArrangeEmployee employee: list) {
                    System.out.print(employee.getSalary() + " " + employee.getName());
                    System.out.println();
                }
            break;
           default:
           break;
       }

    }


}
