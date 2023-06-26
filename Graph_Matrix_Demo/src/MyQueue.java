
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MyQueue {
    LinkedList<Integer>t;

    public MyQueue() {
    t= new LinkedList();
    }
    boolean isEmpty(){
        return(t.isEmpty());
    }
    void enqueue(int x){
        t.add(x);
    }
    int dequeue(){
        return (t.removeFirst());
    }
    
}
