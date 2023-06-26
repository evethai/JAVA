/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author PC
 */
public class UseTreeSet {//treeSet la mang tu sap xep,loai bo trung nhau  VD: add(4);add(2);add(12)=>2,4,12
    public static void main(String[] args) {
       TreeSet t= new TreeSet();
       t.add(5);t.add(2);t.add(9);t.add(30);t.add(9);
        System.out.println(t);
        t.remove(9);//xoa phan tu "9"
        System.out.println(t);
        Iterator it =t.iterator();
        while(it.hasNext())//xet phan tu trong day or mang or set
            System.out.println(it.next()+",");//next la goi tung phan tu 
        System.out.println();
    }
}
