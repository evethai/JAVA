
import java.io.File;
import java.io.IOException;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class FileDemo {
    public static void main(String[] args) throws IOException{
        {
            File  f= new File("f1.txt");
            System.out.println("Ten file la: "+f.getName());
            System.out.println("ten file tuyet doi la: "+f.getAbsoluteFile());
            System.out.println("duong dan tuyet doi la: "+f.getAbsolutePath());
            System.out.println("Path chuyen la : "+f.getCanonicalPath());
            System.out.println("Ngay cap nhat cuoi cung la: "+new Date(f.lastModified()));
            System.out.println("thuoc tinh hidden: "+f.isHidden());
            System.out.println("thuoc tinh can-read: "+f.canRead());
            System.out.println("thuoc tinh can write: "+f.canWrite());
            System.out.println("kich thuoc: "+f.length()+"bytes");
        }
    }
}
