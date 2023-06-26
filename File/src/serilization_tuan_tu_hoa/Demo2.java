/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serilization_tuan_tu_hoa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author PC
 */
class SalePerson implements Serializable{
    String lastName;
    String firstName;
    double sal;
}
public class Demo2 {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileOutputStream fOut= null;
        ObjectInputStream oIn = null;
        ObjectOutputStream oOut = null;
        try{
            String fileName = "Salaperson.bin";
            fOut = new FileOutputStream(fileName);
            oOut = new ObjectOutputStream(fOut);
            SalePerson e = new SalePerson();
            e.lastName="Smith";
            e.firstName="John";
            e.sal = 5000.00;
            oOut.writeObject(e);
            oOut.close();
            fOut.close();
            fIn= new FileInputStream(fileName);
            oIn= new ObjectInputStream(fIn);
            //de-serializing 
            SalePerson emp = (SalePerson) oIn.readObject();
            System.out.println("First Name: "+emp.firstName);
            System.out.println("Last Name: "+emp.lastName);
            System.out.println("Salary: "+emp.sal);
            
            fIn.close();
            oIn.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e ){
            e.printStackTrace();
        }
    }
}
