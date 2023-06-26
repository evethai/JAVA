/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LowLevelStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final char BLANK = 32;
        final String filename = "LStream.txt";
        int[] a = {1, 2, 3, 4, 5};
        char n = '5';
        try {
            FileOutputStream os = new FileOutputStream(filename);
            os.write(n);//begin writing
            os.write(BLANK);
            for (int i = 0; i < 5; i++) {
                os.write(Character.forDigit(a[i], 10));
                os.write(BLANK);
            }
            for (int i = 0; i < filename.length(); i++) {
                os.write(filename.charAt(i));
            }
            os.close();
            FileInputStream is = new FileInputStream(filename);
            int count = is.available();//lenh gi v
            System.out.println("the size  of file is " + count + "bytes");
            
            System.out.println("the content of file: ");
            //read first char
            byte[] bytes = new byte[1];
            is.read(bytes);
            System.out.println(new String(bytes));
            //read blank
            is.read(bytes);
            System.out.println(new String(bytes));
            //read int number
            for (int i = 0; i < 5; i++) {
                int tmp = is.read();//read blank
                is.read(bytes);//read number
                System.out.println(tmp + new String(bytes));

            }
            bytes = new byte[11];
            is.read(bytes);
            System.out.println(new String(bytes));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
