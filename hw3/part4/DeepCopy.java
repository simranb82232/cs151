package part4;

import java.util.*;

public class DeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee Bob = new Employee(111,"Bob");
        Employee Tom = new Employee(222,"Tom");
        Employee Max = new Employee(333,"Max");
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(Bob);
        employeeList.add(Tom);
        employeeList.add(Max);
        ArrayList<Employee> clonedList = new ArrayList<>();
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext()) {
            clonedList.add((Employee) employeeIterator.next().clone());
        }  
        Collections.sort(clonedList, new Sorter());
    }   
}
