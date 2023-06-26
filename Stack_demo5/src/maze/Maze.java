/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class Maze {
    char entryChar = 'E', destChar ='M';
    char emptyChar ='0', blockedChar='1';
    int rows =0, cols=0;//size of maze
    Cell[][] cells=null;//map of the maze
    Cell entryCell = null;//entry position of the maze
    Cell destCell=null;//exit cell or destination cell
    boolean completed = false;//solving completed or not
    boolean succeeded = false;//solving succeeded or not

    public Maze() {
    }
    
    public Maze(char  entryChar, char dsetChar, char emptrChar, char blockedChar){
        this.entryChar= entryChar;
        this.destChar=destChar;
        this.emptyChar=emptyChar;
        this.blockedChar=blockedChar;   
    }
    public void print(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].value);
            }
            System.out.println();
        }
    }
    //test wherther a position is valid or not
    private boolean isValid(int row, int col){
        return row>=0 && row< rows &&
                col>=0 && col<cols &&
                cells[row][col].canbeVisited();//can be moved to 
    }
    
    private ArrayList<Cell> getAdjs (Cell curCell){
        ArrayList<Cell> adjs = new ArrayList();
        int row = curCell.row, col = curCell.col;
        if(isValid (row-1,col)){
            cells[row-1][col].previous=curCell;
            adjs.add(cells[row-1][col]);
        }
        if(isValid (row+1,col)){
            cells[row+1][col].previous=curCell;
            adjs.add(cells[row+1][col]);
        }
        if(isValid (row,col-1)){
            cells[row][col-1].previous=curCell;
            adjs.add(cells[row][col-1]);
        }
        if(isValid (row,col+1)){
            cells[row][col+1].previous=curCell;
            adjs.add(cells[row][col+1]);
        }
        return adjs;
    }
    
    public boolean loadFomFile(String filename){
        File f= new File(filename);
        if(!f.exists()){
            System.out.println("The file "+ filename +"dose not existed!");
            System.exit(0);
        }
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList();
            String line;
            while((line=bf.readLine())!=null){
                line = line.trim();
                if(line.length()>0) list.add(line.toUpperCase());
            }
            bf.close();
            fr.close();
            
            this.rows= list.size();
            this.cols=list.get(0).length();
            this.cells = new Cell[rows][cols];
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i);
                for (int j = 0; j < cols; j++) {
                    char ch = line.charAt(j);
                    cells[i][j]= new Cell(i , j, ch);
                    if(ch==blockedChar)cells[i][j].setBlock();
                    //deter the entry and destiantion of the maze
                    else  if (ch==entryChar) this.entryCell=cells[i][j];
                    else if (ch==destChar) this.destCell= cells[i][j];
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return true;
    }
    //solving the maze
    public boolean solve(){
        LinkedList<Cell> stack = new LinkedList();
        Cell curCell = this.entryCell;
        while(!completed){
            curCell.vistited=true;
            if(curCell==this.destCell)
                completed = succeeded=true;
            else{
                ArrayList<Cell> adjs= getAdjs(curCell);
                if(adjs.size()>0){
                    curCell=adjs.get(0);
                    for (int i = 0; i < adjs.size(); i++) {
                        stack.addFirst(adjs.get(i));
                    }
                }
                else if(!stack.isEmpty())
                    curCell=stack.removeFirst();
                else{
                    completed=true;
                    succeeded=false;
                }
            }
        }
        return completed;
    }
    //get the path of solution
    public LinkedList<Cell> getPath(){
        if(!succeeded) return null;
        LinkedList<Cell> path = new LinkedList();
        Cell cell = this.destCell;
        while(cell!=null){
            path.addFirst(cell);
            cell= cell.previous;
        }
        return path;
    }
    
}
