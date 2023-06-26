/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serilization_tuan_tu_hoa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author PC
 */
public class Demo1 {

    public static void main(String[] args) {
        String s = "Hello World";
        byte[] b = {'E', 'x', 'a', 'm', 'p', 'l', 'e'};
        try {
            String filename = "data.bin";
            //create a new file with objoutputStream
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            //write 
            oout.writeObject(s);
            oout.writeObject(b);
            oout.flush();
            //create an objInputStream for file
            FileInputStream in = new FileInputStream(filename);
            ObjectInputStream ios = new ObjectInputStream(in);
            //read and print
            System.out.println("" + (String) ios.readObject());

            byte[] read = (byte[]) ios.readObject();
            String s2 = new String(read);
            System.out.println("" + s2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
