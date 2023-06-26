
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class DateIOTextFileDemoByFileReadWriterClass {
    public static void main(String[] args) throws IOException {
        try{
            File file = new File ("Example.txt");
            //Tao file
            BufferedWriter output= new BufferedWriter(new FileWriter(file));
            output.write("hello world");
            output.newLine();
            output.write("Java SE");
            output.close();
            //Doc file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            while ((s=reader.readLine())!=null){
            System.out.println(s);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
