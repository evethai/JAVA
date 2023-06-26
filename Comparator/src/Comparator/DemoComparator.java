/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC
 */
public class DemoComparator {
    public static void main(String[] args) {
        ArrayList <Employee> arraylist= new ArrayList<Employee>();
        arraylist.add(new Employee("0004", "cha", 25));
        arraylist.add(new Employee("003", "Ra", 28));
        arraylist.add(new Employee("0001", "Ajs", 25));
        System.out.println("Sorting on IDs ascending");
        Collections.sort(arraylist);
        for(Employee str: arraylist){
            System.out.println(str);
        }
        System.out.println("Sort on descending Salary then ascending IDs");
        Collections.sort(arraylist,Employee.compareEmployee);
        for(Employee str : arraylist){
            System.out.println(str);
        }
    }
}
