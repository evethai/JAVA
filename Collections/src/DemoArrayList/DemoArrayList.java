/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoArrayList;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DemoArrayList {
    public static void main(String[] args) {
         MyArrayList arr= new MyArrayList();
         arr.add(new Product(1, "coffee"));
         arr.add(new Product(2, "Milk"));
         arr.add(new Product(3, "Coca"));
         System.out.println("*****print product list*********");
         arr.printAllProduct();
         System.out.println("********get product by id*********");
         Product p=arr.getProdcutById(1);
         System.out.println(p);
         System.out.println("Remove product : "+p.getName());
         arr.removeProduct(p);
         System.out.println("*****Printf product list*******");
         arr.printAllProduct();
    }
} 

class Product{
    private int id;
    private String name;
    public Product(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + '}';
    }  
}
interface IProduct{
    void printAllProduct();
    void addProduct(Product p);
    void removeProduct(Product p);
    Product getProdcutById(int id);
}
class MyArrayList extends ArrayList<Product> implements IProduct{

    @Override
    public void printAllProduct() {
        for (Product p :this){
            System.out.println(p);
        }
    }

    @Override
    public void addProduct(Product p) {
        this.add(p);
    }

    @Override
    public void removeProduct(Product p) {
        this.remove(p);
    }

    @Override
    /*public Product getProdcutById(int id) {
        for(Product p: this){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    } */ 
    
    public Product getProdcutById(int id) {
       Product pro = this.stream()
               .filter(p->p.getId()==id)
               .findAny()
               .orElse(null);
       return pro;
    }
}
