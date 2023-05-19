
package business;

import controller.Hospital;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import model.Nurse;
import util.Validation;

public class NurseList extends HashMap<String, Nurse> implements Serializable{
    Hospital hospital = new Hospital();
    
    public void createNurse(Nurse nurse) throws Exception {
        String staffID = Validation.checkString("Please enter staffID of Nurse");
        
        if(this.containsKey(staffID)) {
            System.out.println("Dupclicate");
        }
        else {
            String name = Validation.checkString("Please enter Name of Nurse:");     
            int age = Validation.checkInt("Please enter Age of Nurse: ");        
            String gender = Validation.checkString("Please enter Gender of Nurse: ");       
            String address = Validation.checkString("Please enter Address of Nurse: ");        
            String phone = Validation.checkString("Please enter Phone of Nurse: ");        
            String department = Validation.checkString("Please enter Department of Nurse: ");        
            String shift = Validation.checkString("Please enter Shift of Nurse: ");        
            double salary = Validation.checkDouble("Plese enter Salary of Nurse: ");
            this.put(nurse.getStaffID(), new Nurse(staffID, name, age, gender, address, phone, department, shift, salary));
            
            System.out.println("Success"); 
            hospital.writeNurseToFile("src\\output\\nurses.dat", nurse);
        }
        
        
    }
    public void findNurse(HashMap<String, Nurse> nurseMap) throws Exception {
        
        String name = Validation.checkString("Enter the name of Nurse you want to find");
        
       
        for(Nurse nurse: this.values()) {
            if(!(nurse.getName().toLowerCase().trim().contains(name))) {
                System.out.println("Have an error");
                
            }
            else
                System.out.println(nurse.toString());
                
        
        }
    }
    
    public void updateNurse(Nurse nurse) throws Exception {
        String staffID = Validation.checkString("Please enter the StaffID of Nurse you want to update: ");
        
         nurse = this.get(staffID);
        if(nurse == null) {
            throw new Exception("The nurse is not exist");
        }
        String name  = Validation.checkString("Please enter name to update: ");
        nurse.setName(name);
        int age =  Validation.checkInt("Please enter age to update: ");
        nurse.setAge(age);
        String address = Validation.checkString("Please enter address to update: ");
        nurse.setAddress(address);
        String phone =  Validation.checkString("Please enter phone to update: ");
        nurse.setPhone(phone);
        String department = Validation.checkString("Please enter department to update: ");
        nurse.setDepartment(department);
        String shift = Validation.checkString("Please enter shift to update: ");
        nurse.setShift(shift);
        double salary = Validation.checkDouble("Please enter salary to update: ");
        nurse.setSalary(salary);
        
        System.out.println(nurse.toString());
        
        
            
        
    }
    
    public void deleteNurse() {
        String staffID = Validation.checkString("Enter the staffID of Nurse you want to delete: ");
        if(this == null || this.isEmpty()) {
            System.out.println("This is empty.");
        }
    }
}
