/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaseStudy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class Menu extends Vector<Item> {

    public Menu() {
        super();
    }

    public static List<String> MenuOption() {
        List list = new ArrayList<>();
        list.add("Add new Item");
        list.add("Remove an Item");
        list.add("Update an item");
        list.add("Print the list");
        list.add("Save to files");
        list.add("Quit");
        return list;
    }

    int getUserchoice(List<String> options) {
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
