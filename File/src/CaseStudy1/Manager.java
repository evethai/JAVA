/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaseStudy1;

import java.awt.FileDialog;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Manager {

    public static void main(String[] args) {
        String filename = "emloyees.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        
        List<String> option = Menu.addMenuItem();
        
        int userChoice;
        boolean changed = false;
        EmpList list = new EmpList();
        list.AddFromFile(filename);
        
        do {
            System.out.println("\nEMPLOYEE MANAGER");
            userChoice=menu.getUserChoice(option);
            switch (userChoice) {
                case 1:
                    list.addNewEmp();
                    changed = true;
                    break;
                case 2:
                    list.removeEmp();
                    changed = true;
                    break;
                case 3:
                    list.promote();
                    changed = true;
                    break;
                case 4:
                    list.print();
                    break;
                case 5:
                    list.saveTofile(filename);
                    changed = false;
                default:
                    if (changed) {
                        System.out.print("Save changes Y/N?");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {
                                
                                }
                                
                    }
            }
        } while (userChoice > 0 && userChoice < 6);
    }
}
