
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class DemoPrintWriter {
    public static void main(String[] args) throws IOException {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("File name");
            String filename= in.readLine();
            PrintWriter out = new PrintWriter(new FileWriter(filename));
            
            System.out.println("Enter some wordings : [Enter 'stop' top quit]");
            String textLine = in.readLine();
            while (!textLine.equals("stop")){
                out.println(textLine);
                textLine = in.readLine();
            }
            out.close();
            in.close();
            
        }catch(IOException error){
            System.out.println("Error making file: ");
            System.out.println("\t"+error);
        }
    }
}
