/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaseStudy2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class NewItems extends Vector<Item> {

    Scanner sc = new Scanner(System.in);
    Vector<String> storeCode = new Vector<>();

    public NewItems() {
        super();
    }

    //load stored code before loading file
    public void loadStorecode(String fName) {
        //clear stored code befor loading
        if (storeCode.size() > 0) {
            storeCode.clear();
        }
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String code, name, priceStr;
            while ((code = bf.readLine()) != null
                    && (name = bf.readLine()) != null
                    && (priceStr = bf.readLine()) != null) {
                storeCode.add(code);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean valid(String aCode) {
        //check it in stored codes
        for (int i = 0; i < storeCode.size(); i++) {
            if ((aCode.equals(storeCode.get(i)))) {
                return false;
            }
        }
        for (int i = 0; i < this.size(); i++) {
            if (aCode.equals(this.get(i).getCode())) {
                return false;
            }
        }
        return true;
    }

    private int find(String aCode){
         for (int i = 0; i <this.size(); i++) {
            if(this.get(i).getCode().equals(aCode)) return i;
        }return -1;
    }
    public void appenToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {//append new items to the file
            boolean append = true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(fName, append);
            PrintWriter pw = new PrintWriter(fw);
            for (Item x : this) {
                pw.print(x.getCode());
                pw.print(x.getName());
                pw.print(x.getPrice());
                pw.flush();
            }
            pw.close();
            fw.close();
            this.loadStorecode(fName);
            this.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addNewItem(){
        String newcode, newName;
        int price;
        boolean duplicated= false,matched = true;
        System.out.println("Enter new Item details: ");
        do{
            System.out.println("code (format i000):");
            newcode= sc.nextLine().toUpperCase();
            duplicated=!valid(newcode);
            matched= newcode.matches("^I\\d{3}$");
            if(duplicated)System.out.println("the code is duplicated!");
            if(!matched) System.out.println("the code : I and 3 digits");
        }while(duplicated||(!matched));
        System.out.println("name: ");
        newName=sc.nextLine().toUpperCase();
        System.out.println("price: ");
        price=Integer.parseInt(sc.nextLine());
        this.add(new Item(newcode, newName, price));
        System.out.println("Added.");
    }
    public void removeItem(){
        String code;
        System.out.println("Enter code to remove: ");
        code=sc.nextLine().toUpperCase();
        int pos= find(code);
        if(pos<0){
            System.out.println("code dose not exit!");
        }else{
            this.remove(pos);
            System.out.println("the item "+code+"has removed.");
        }
    }
    public void updateItem(){
        String code;
        System.out.println("Enter code to update: ");
        code=sc.nextLine().toUpperCase();
        int pos=find(code);
        if(pos<0){
            System.out.println("code dose not exit!");
        }
        else{
            String newName;int newprice;
            System.out.println("Enter new name of item: ");
            newName=sc.nextLine();
            System.out.println("Enter new price: ");
            newprice=Integer.parseInt(sc.nextLine());
            this.get(pos).setName(newName);
            this.get(pos).setPrice(newprice);
            System.out.println("Item "+code+"has been updated.");
        }
    }
    public void print(){
        for (int  i = 0;  i < this.size();  i++) {
            System.out.println(this.get(i));
        }
    }
}
