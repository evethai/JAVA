/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaseStudy1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class Menu extends Vector<String> {

    public Menu() {
        super();
    }
    Scanner sc = new Scanner(System.in);

    public static List<String> addMenuItem() {
        List<String> list= new ArrayList<>();
        list.add("add new employee");
        list.add("remove an employee");
        list.add("promoting the employee's salary");
        list.add("print List");
        list.add("save to file");
        list.add("Quit");
        return list;
    }

        public static int getUserChoice(List<String> options) {
        int response;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "-" + options.get(i));
        }
        while (true)
           try {
            System.out.print("Please choose an option 1..." + options.size() + ": ");
            response = Integer.parseInt(sc.nextLine());
            break;
        } catch (Exception e) {
            System.out.println("Option is number. Please enter again!!");
        }
        return response;
    }
}
