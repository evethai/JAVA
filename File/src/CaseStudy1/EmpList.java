/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaseStudy1;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class EmpList extends Vector<Employee>{
    Scanner sc = new Scanner(System.in);
    public EmpList(){super();}
    
    public void AddFromFile(String fName){
        try{
            File f= new File (fName);//check file
            if(!f.exists())return ;
            FileReader fr = new FileReader(f); //read()
            BufferedReader  bf= new BufferedReader(fr);//readLine()
            String details;//ID,Name,Salary
            while ((details=bf.readLine())!=null){
                //splitting data into elements
                StringTokenizer stk = new StringTokenizer(details,",");
                String code = stk.nextToken().toUpperCase();
                String name= stk.nextToken().toUpperCase();
                int salary= Integer.parseInt(stk.nextToken());
                //create an employee
                Employee emp = new Employee(code, name, salary);
                this. add(emp);//adding this employee to the list
            }bf.close();fr.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void saveTofile(String fName){
        if(this.size()==0){
            System.out.println("Empty list");
            return;
        }
        try{
            File f= new File(fName);
            FileWriter fw = new FileWriter(f);//wtite 
            PrintWriter  pw = new PrintWriter(fw);//printlf()
            for (Employee x: this){
                pw.println(x.getCode()+","+x.getName()+","+x.getSalary());
            }
            pw.close();fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //find an emloyee code
    private int find (String acode){
        for (int i=0; i<this.size();i++)
            if(this.get(i).getCode().equals(acode))return i;
        return -1;
    }
    //add new employee
    public void addNewEmp(){
        String newCode, newName;
        int salary;
        int pos;
        boolean valid=true;
        System.out.println("Enter new Employee Detail: ");
        do{
            System.out.println("Code E000:");
            newCode = sc.nextLine().toUpperCase();
            pos= find(newCode);
            valid = newCode.matches("^E\\d{3}$");//pattern: E and 3 digits
            if(pos>=0)System.out.println("The code is Duppicated!");
            if(!valid)System.out.println("The code : E and 3 digits.");
        }while(pos>=0 || (!valid));
        System.out.println("Name: ");
        newName = sc.nextLine().trim().toUpperCase();
        System.out.println("Salary : ");
        salary=Integer.parseInt(sc.nextLine());
        this.add(new Employee(newCode, newName, salary));
        System.out.println("New Employee has been added");
    }
    //Remove an Employee
    public void removeEmp(){
        String code;
        System.out.println("Enter the code of remove Employee: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos<0)System.out.println("this code is not exist!");
        else{
            this.remove(pos);
            System.out.println("the Employee"+code+"has be reomoved.");
        } 
    }
    //promote a salary
    public void promote(){
        String code;
        System.out.println("Enter the code of promote employee: ");
        code= sc.nextLine().toUpperCase();
        int pos= find(code);
        if(pos<0)System.out.println("this code not exist! ");
        else {
            int oldSalary= this.get(pos).getSalary();
            int newSalary;
            do{
                System.out.println("oldSalary"+oldSalary+"NewSalary: ");
                newSalary= Integer.parseInt(sc.nextLine());
            }while(newSalary<oldSalary);
            this.get(pos).setSalary(newSalary);
            System.out.println("The employee "+code+"has been updated.");
        }
    }
    //print the list
    /*public void print(){
        if(this.size()==0){
            System.out.println("Empty List.");
            return;
        }
        Collections.sort(this);
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("----------------");
        for (Employee x: this)x.print();
    } */
    public void print(){
        for(int i=0;i<this.size();i++){
            System.out.println(get(i));
        }
    }
    
}
