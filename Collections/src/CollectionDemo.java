
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        for(int i=101;i<=110;i++){
            ar.add(i);
        }
        for (int i=0;i<ar.size();i++){
            System.out.println(ar.get(i));
        }
        //OR using Iterator
       /* Iterator iter = ar.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        */
        Vector v = new Vector();
        Random rd = new  Random();
        for (int i=0;i<=10;i++){
            ar.add(rd.nextInt(30));
            v.add(rd.nextInt(30));
        }
        System.out.println("ar="+ar);
        System.out.println("v="+v);
        
        //tra ve true khi khong co phan tu chung
        boolean dis = Collections.disjoint(ar,v);
        System.out.println("ar and v disjunct: "+dis);
        
        Collections.addAll(v,ar.toArray());
        System.out.println("After adding, v= "+v);
        
        int minVal = (int)Collections.min(v);
        int maxVal = (int)Collections.max(v);
        
        System.out.println("min="+minVal+", max="+maxVal);
        int fre = Collections.frequency(v, 8);
        System.out.println("Occurences of 8 : "+fre);
        
        Collections.sort(v);
        System.out.println("After sorting : "+v);
        
        int pos= Collections.binarySearch(v, 8);
        System.out.println("position of 8: "+pos);
        
        Collections.shuffle(v);
        System.out.println("After shuffling,v= "+v);
        
        Collections.fill(v, 9);
        System.out.println("After replacing, v="+v);
        
        
    }//chua hieu gi
}
