package part4;

import java.util.*;

public class Employee implements Cloneable{

    private int id;
    private String name;
    
    public Employee(int idNum, String eName) {
        super();
        id = idNum;
        name = eName;
    }
    
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setName(String eName) {
        name = eName;
    }
    
    public void setId(int idNum) {
        id = idNum;
    }
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Employee clone = null;
        try {
            clone = (Employee) super.clone();
        }
        catch(CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }
        return clone;
    }
}