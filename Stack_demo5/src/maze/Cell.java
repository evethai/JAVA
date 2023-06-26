/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

/**
 *
 * @author PC
 */
public class Cell {
    int row, col;
    char value;
    boolean blocked=false;
    boolean vistited=false;
    Cell previous= null;

    public Cell(int row, int col, char value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
    
    public void setBlock(){
        this.blocked=true;
    }
    public boolean canbeVisited(){
        return !blocked && !vistited;
    }

    @Override
    public String toString() {
        return "("+row+","+col+","+value+")";
    }
    
}
