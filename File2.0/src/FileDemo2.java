
import java.io.File;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class FileDemo2 {
    public static void main(String[] args) throws IOException{
        {
            File f = new File("D:\\CodeJava\\File2.0");
            String S=f.isDirectory()?"thu muc":"tap tin";
            System.out.println("File: "+S);
            String L[]=f.list();
            System.out.println("Noi dung thu muc: ");
            for (int i = 0; i < L.length; i++) {
                File f2 = new File(f,L[i]);
                System.out.println(L[i]+" "+(f2.isFile()? "tap tin":"thu muc"));
            }
        }
    }
}
