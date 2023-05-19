
package model;

import java.io.Serializable;

public class Nurse extends Person implements Serializable{
    
    String staffID, department, shift;
    double salary;

    public Nurse() {
        
    }

    public Nurse(String staffID, String department, String shift, double salary) {
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }
    
    public Nurse(String staffID, String name, int age, String gender, String address, String phone, String department, String shift, double salary) {
        super(name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }
    
    public Nurse(String id, String name, int age, String gender, String address, 
            String phone, String staffID, String department, String shift, double salary) {
        super(id, name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        
    }


    public String getStaffID() {
        return staffID;
    }

    public String getDepartment() {
        return department;
    }

    public String getShift() {
        return shift;
    }

    public double getSalary() {
        return salary;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.staffID + "," + super.name + "," + super.age + "," + super.address + "," + super.phone + "," + this.department + "," + this.shift + "," + this.salary;
    }

    public void put(String staffID, Nurse nurse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
