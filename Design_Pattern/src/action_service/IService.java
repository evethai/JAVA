/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package action_service;

import businesss_obj.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IService {
    //single interface to all "rapostories"
    //student Repository
    void delelteStudent(Student student);
    List<Student>getALLStudents();
    Student getStudent(int id);
    void updateStudent(Student student);
    //the other repositories
}
