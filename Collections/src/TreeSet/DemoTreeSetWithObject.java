/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author PC
 */
public class DemoTreeSetWithObject {
    public static void main(String[] args) {
        Set<Customer> list = new TreeSet();
        list.add(new Customer("A", 3));
        list.add(new Customer("B", 1));
        list.add(new Customer("C", 2));
        list.add(new Customer("D", 4));
        list.add(new Customer("C", 2));
        
        for (Customer s :list){
            System.out.println(s);
        }
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            Customer c=(Customer)iter.next();
            System.out.println("ID: "+c.getId()+"Name: "+c.getName());
        }
       
    }
    
}
class Customer implements Comparable{
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", id=" + id + '}';
    }
    //sap xep theo id 
    /*public int compareTo(Object o){
        Customer s= (Customer)o;
        
        //return id-s.id (cai nay la viet tac cua 3 cai duoi nhung dieu kien la name k dc trung nhau
        
        if(id>s.getId()){//neu ID lon hon thi sap 
            return 1;
        }
        else if(id==s.getId()){//neu ID ban thi giu nguyen vi tri 
            return 0;
        }
        else return -1;//neu ID be hon thi nguoc lai
    }*/
    
    //sap xep theo name
    public int compareTo(Object o){
        Customer s=(Customer)o;
        if(name.compareTo(s.getName())>0){
            return -1;
        }
        else if(name.compareTo(s.getName())==0){
            return id-s.id;
        }
        else return 1;
    }
}