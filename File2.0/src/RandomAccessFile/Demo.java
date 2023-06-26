/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RandomAccessFile;

import java.io.RandomAccessFile;

/**
 *
 * @author PC
 */
public class Demo {
    public static void main(String[] args) {
        String fName="RandomAccessFileDemo.txt";
        String S1= "Mat nai";
        boolean b= true;
        int n =1234;
        double x= 37.456;
        String S2="Hoang Anh Tuan";
        byte[]ar=new byte[100];//for reading Accii charaters
        try{
            RandomAccessFile f = new RandomAccessFile(fName, "rw");
            //write data, position 0,1,2,3,4
            f.writeUTF(S1);f.writeBoolean(b);f.writeInt(n);
            f.writeDouble(x);f.writeBytes(S2);
            //read data
            f.seek(0);//seek to bof
            System.out.println(f.readUTF());
            System.out.println(f.readBoolean());
            System.out.println(f.readInt());
            System.out.println(f.readDouble());
            f.read(ar);
            System.out.println(new String (ar));
            System.out.println("File length: "+f.length());
            f.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
