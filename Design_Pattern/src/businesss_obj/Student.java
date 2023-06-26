/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesss_obj;

/**
 *
 * @author PC
 */
public class Student extends Person{
    private String email;

    public Student(String email, String name, int id) {
        super(name, id);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Email: %s",id,name,email ); 
    }
    
}
