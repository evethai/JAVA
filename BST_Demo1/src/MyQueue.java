
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
    LinkedList<BST_Node>L;

    public MyQueue() {
        L = new LinkedList();
    }
    public boolean isEmpty(){
        return L.isEmpty();
    }
    public void enqueue(BST_Node node){
        L.addLast(node);
    }
    public BST_Node dequeue(){
        return L.removeFirst();
    }
    
}
