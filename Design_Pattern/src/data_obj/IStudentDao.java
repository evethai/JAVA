/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data_obj;

import businesss_obj.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IStudentDao {
    public List<Student>getAllStudents();
    public Student  getStudent(int id);
    public void updateStudent (Student student);
    public void deleteStudent(Student student);
}
