/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_obj;

import businesss_obj.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentDao implements IStudentDao{
    List<Student> students;
    public StudentDao(){
        students = new ArrayList<Student>();
        Student Robert = new Student("Robert@gmail.com","Robert", 1);
        Student John = new Student("John@gmail.com", "John", 2);
        students.add(Robert);
        students.add(John);
        
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student);
        System.out.println("Student ID : "+student.getId()+", delate form database");
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int id) {
        Student student = students.stream()
                .filter(s->s.getId()==id)
                .findAny()
                .orElse(null);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        var std = getStudent(student.getId());
        std= student;
        System.out.println("Student : ID"+student.getId()+", update into the database");
    }
    
    
    
    
    
}
