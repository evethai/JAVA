
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class Employee implements Comparable {

    private String id;
    private String name;
    private int salary;
    private Date dateOfBirth;

    public Employee(String id, String name, int salary, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dob = sdf.format(dateOfBirth);
        return "Employee{" + "id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfBirth=" + dateOfBirth + '}';
    }

    public int compareTo(Object o) {
        return id.compareTo(((Employee) o).id);
        //obj o, id de so sanh "."compareTo(((name of class to compare)obj).doi tuong so sanh);
    }
    //public static Comparator "name of class" = new Comparator();
    
    public static Comparator compareBySalary = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee)o1;
            Employee e2 = (Employee)o2;
            int d = Integer.compare(e1.salary, e2.salary);
            if(d>0) return -1;
            if(d==0)return e1.id.compareTo(e2.id);
            return 1;
        }
        
    };
    
    public static Comparator compareByDateofBirth = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            //int d= e1.salary - e2.salary;
            //the value 0 if the agrument Date is equal tothis date;
            //the value less than 0 if this Date is before the Date agrumnet
            //and a value greater than 0 if  this Date is after the Date agrument
            int d = e1.dateOfBirth.compareTo(e2.dateOfBirth);
            if (d > 0) {
                return -1;//sap xep giam dan (khi e1 sau e2)
            }
            if (d == 0) {
                return 0;
            }
            return 1;
        }
    };
    public static Comparator compareByName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee)o1;
            Employee e2 = (Employee)o2;
            int d = e1.name.compareTo(e2.name);
            if(d>0) return -1;
            if(d==0)return 0;
            return 1;
        }
    };
   
}
