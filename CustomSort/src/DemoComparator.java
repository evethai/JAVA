
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class DemoComparator {
    static void printList(List<Employee>1){
        for (Employee emp :1){
            System.out.println(emp);
        }
    }
    static Date getDateFromString(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d= null;
        try{
            d=sdf.parse(date);
        }catch (ParseException ex){
            System.out.println(ex.getMessage());
        }
        return d;
    }
    public static void main(String []args){
        ArrayList<Employee> arraylist = new ArrayList();
        arraylist.add(new Employee("ID002","thai", 20, getDateFromString("12/10/1990")));
        arraylist.add(new Employee("ID001", "hi", 30, getDateFromString("20/2/2001")));
        System.out.println("sort on ID ");
        Collections.sort(arraylist);
        printList(arraylist);
        System.out.println("sort on des dateofbirth: ");
        Collections.sort(arraylist,Employee.compareByDateofBirth);
        printList(arraylist);
        System.out.println("sort on dec by salary using Lamda");
        Collections.sort(arraylist,(Employee e1, Employee e2)->{
            return e2.getSalary()-(e1.getSalary());
        });
        printList(arraylist);
    }
}
