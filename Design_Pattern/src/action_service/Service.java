/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action_service;

import businesss_obj.Student;
import data_obj.DaoFactory;
import data_obj.IDaofactory;
import data_obj.IStudentDao;
import java.util.List;

/**
 *
 * @author PC
 */
public class Service implements IService {

    static final IDaofactory factory = new DaoFactory();
    static final IStudentDao studentDao = factory.studentDao();

    @Override
    public void delelteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> getALLStudents() {
        return getALLStudents();
    }
    

}
