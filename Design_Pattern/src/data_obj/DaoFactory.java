/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_obj;

/**
 *
 * @author PC
 */
public class DaoFactory implements IDaofactory{

    @Override
    public IStudentDao studentDao() {
        return new StudentDao();
    }
    
}
