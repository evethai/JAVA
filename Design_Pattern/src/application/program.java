/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import action_service.Service;
import businesss_obj.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public class program {
    static void printList(List<Student>list){
        for(var student :list){
            System.out.println(student);
        }
    }
    public static void main(String[] args) {
        Service service = new Service();
        System.out.println("***********STUDENT LIST**********");
        printList(service.getAllStudents());
        System.out.println("********UPDATE STUDENT*********");
        var student = service.getStudent(1);
        student.setName("David");
        service.updateStudent(student);
        printList(service.getAllStudents());
        System.out.println("**********DLATE STUDENT********");
        service.delelteStudent(student);
        printList(service.getAllStudents());
    }
}
