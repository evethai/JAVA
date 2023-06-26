/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreeSet;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author PC
 */
public class DemoTreeCompare {
    public static void main(String[] args) {
        int id;
        Random r= new Random();
        TreeSet myset= new TreeSet();
        for (int i=1;i<10;i++){
            id=r.nextInt(100);
            Student st= new Student("student"+i, id);
            myset.add(st);
        }
        //USing Iterator
        Iterator iter = myset.iterator();
        while (iter.hasNext()){
            Student st=(Student)iter.next();
            System.out.println("ID: "+st.getId()+","+"Name: "+st.getName());
        }
    }
}
class Student implements Comparable{
    private String name;
    private int id;

    public Student(String name, int id) {
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
        return "Student{" + "name=" + name + ", id=" + id + '}';
    }
    public int compareTo(Object o){
        Student s= (Student)o;
        
        //return id-s.id
        
        if(id>s.getId()){
            return 1;
        }
        else if(id==s.getId()){
            return 0;
        }
        else return -1;
    }
}