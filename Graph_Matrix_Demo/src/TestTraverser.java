
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class TestTraverser {
    
    public static Graph_Matrix loadGraph(String fname)throws Exception{
        Graph_Matrix g=null;
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine().trim();
        g=new Graph_Matrix(line);
        int size = line.length();
        int[][]m=new int [size][size];
        StringTokenizer stk;
        for (int i = 0; i < size; i++) {
            line = br.readLine().trim();
            stk = new StringTokenizer(line, ",");
            for (int j = 0; j < size; j++) {
                m[i][j]=Integer.parseInt(stk.nextToken().trim());
            }
        }
        br.close();
        fr.close();
        g.setAdjMatrix(m);
        return g;
    }
    public static void main(String[] args)throws Exception{
        String source = "graph01.txt";
        String BF_fname1="BF_fname1.txt";
        String BF_fnameAll="BF_fnameAll.txt";
        String DF_fname2="DF_fname2.txt";
        String DF_fnameAll="DF_fnameAll.txt";
        Graph_Matrix g = loadGraph(source);
        g.displayAdjMatrix();
        System.out.println();
        System.out.println("\nBF traversal a component from B: ");
        g.BF_traverseComponent(1);
        System.out.println("\nBF traversal all component from A: ");
        g.BF_traverseAll();
        System.out.println("\nDF traversal a component from C: ");
        g.DF_traverseComponent(2);
        System.out.println("\nDF traversal all component from A: ");
        g.DF_traverseAll();
        
        g.BF_traverserseComponent_F(BF_fname1, 1);
        g.BF_traverseAll_F(BF_fnameAll);
        g.DF_traverseComponent_F(DF_fname2, 2);
        g.DF_traverseAll_F(DF_fnameAll);
        System.out.println();  
    }
}
