/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaseStudy2;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ItemManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String filename = "items.txt";
        
        Menu menu = new Menu();
        List<String> options = Menu.MenuOption();
        
        int choice;
        NewItems item = new NewItems();
        item.loadStorecode(filename);//load initial data
        do {
            System.out.println("ITEM MANAGER");
            choice = menu.getUserchoice(options);
            switch (choice) {
                case 1:
                    item.addNewItem();
                    break;
                case 2:
                    item.removeItem();

                    break;
                case 3:
                    item.updateItem();

                    break;
                case 4:
                    item.print();
                    break;
                case 5:
                    item.appenToFile(filename);
                    break;

            }

        } while (choice > 0 && choice < 6);
    }
}
