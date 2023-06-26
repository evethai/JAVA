/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vector;

import java.util.Vector;

/**
 *
 * @author PC
 */
public class UseVector {
    public static void main(String[] args) {
        Vector v= new Vector();
        v.add(15);
        v.add("hello");
        v.add(new Point());
        v.add(new Point(5,-7));
        System.out.println(v);
        v.remove(2);//can lam 
        System.out.println(v);
        for (int i=0;i<v.size();i++) System.out.print(v.get(i)+",");
        System.out.println();
        
    }
}
class Point{
    int x,y;
    Point(){
        x=0;
        y=0;
    }
    Point(int xx,int yy){
        x=xx;
        y=yy;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}

