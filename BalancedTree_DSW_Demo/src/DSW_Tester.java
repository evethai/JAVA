/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class DSW_Tester {
    public static Integer[] createIntArr(int max){
        Integer[] a = new Integer[max];
        for (int i = 0; i < max; i++) {
            a[i]=max-i;
        }
        return a;
    }
    public static void main(String[] args) {
        BST tree = new BST();
        int max = 14;
        Integer a[]= createIntArr(max);
        tree.add_Array(a);
        System.out.println("\nInitial tree:\n");
        tree.printAligned();
        tree.DSW_Balance();
        System.out.println("\nBalanced tree:\n");
        tree.printAligned();
    }
}
