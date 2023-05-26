
package model;

import java.io.Serializable;
/**
 * The Nurse class represents a nurse in hospital.
 * It extends the Person class and implement Serializable
 * @author tahoa
 */
public class Nurse extends Person implements Serializable{
    
    String staffID, department, shift;
    double salary;
    
    /**
    * Default constructor for the Nurse class.
    */
    
    public Nurse() {
        
    }
    /**
    * Parameterized constructor for the Nurse class.
    * @param staffID
    * @param department
    * @param shift
    * @param salary 
    */
    public Nurse(String staffID, String department, String shift, double salary) {
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }
    
    /**
     * Parameterized constructor for the Nurse class.
     * @param staffID
     * @param name
     * @param age
     * @param gender
     * @param address
     * @param phone
     * @param department
     * @param shift
     * @param salary 
     */   
    public Nurse(String staffID, String name, int age, String gender, String address, String phone, String department, String shift, double salary) {
        super(name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }
    
    /**
     * Parameterized constructor for the Nurse class.
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param address
     * @param phone
     * @param staffID
     * @param department
     * @param shift
     * @param salary 
     */
    public Nurse(String id, String name, int age, String gender, String address, 
            String phone, String staffID, String department, String shift, double salary) {
        super(id, name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        
    }

    /**
    * Get the staffID of the nurse.
    * @return the staffID of the nurse.
    */
    public String getStaffID() {
        return staffID;
    }

    /**
     * Get the department where the nurse works.
     * @return the department where the nurse works.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Get the shift of the nurse.
     * @return the shift of the nurse.
     */
    public String getShift() {
        return shift;
    }
    
    /**
     * Get the salary of the nurse.
     * @return the salary of the nurse.
     */
    public double getSalary() {
        return salary;
    }
    
    /**
     * Set the staffID of the nurse.
     * @param staffID the staff ID to get.
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    
    /**
     * Set the department where the nurse works.
     * @param department the department to get. 
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
    /**
     * Set the shift of the nurse.
     * @param shift the shift to get.
     */
    public void setShift(String shift) {
        this.shift = shift;
    }

    /**
     * Set the salary of the nurse.
     * @param salary the salary to get.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Get a string to representation of the Person project.
     * @return a string to representation of the Person project.
     */
    @Override
    public String toString() {
        return this.staffID + "," + super.name + "," + super.age + "," + super.address + "," + super.phone + "," + this.department + "," + this.shift + "," + this.salary;
    }


    
}
