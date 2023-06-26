/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

/**
 *
 * @author PC
 */
public class MyMaze {
    public static void main(String[] args) {
        String filename ="maze01.txt";
        Maze maze = new Maze('E', 'M', '0', '1');
        maze.loadFomFile(filename);
        maze.print();
        maze.solve();
        if(maze.succeeded){
            System.out.println("Result path: ");
            System.out.println(maze.getPath());
        }else{
            System.out.println("Failed!");
        }
    }
}
