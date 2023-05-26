
package business;

import controller.HospitalManagement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import model.Nurse;
import model.Patient;
import util.Validation;

/**
 * This class represents 
 * 
 */
public class NurseList extends HashMap<String, Nurse> implements Serializable{
    HospitalManagement hospital = new HospitalManagement();
    
    /**
     * Create a new nurse and add it to the nurse list.
     * @param nurseList the nurse list.
     * @return The updated nurse list.
     * @throws Exception If an error occurs during creating a nurse.
     */
    public NurseList createNurse(NurseList nurseList) throws Exception {
        
        String staffID = Validation.checkString("Please enter staffID of Nurse: ");
        
        if(nurseList.containsKey(staffID)) {
            System.out.println("Dupclicate");
        }
        else {
            String name = Validation.checkString("Please enter Name of Nurse:");     
            int age = Validation.checkInt("Please enter Age of Nurse: ");        
            String gender = Validation.checkString("Please enter Gender of Nurse: ");       
            String address = Validation.checkString("Please enter Address of Nurse: ");        
            String phone = Validation.checkPhone("Please enter Phone of Nurse: ");        
            String department = Validation.checkStringLength("Please enter Department of Nurse: ");        
            String shift = Validation.checkString("Please enter Shift of Nurse: ");        
            double salary = Validation.checkDouble("Plese enter Salary of Nurse: ");
            
            nurseList.put(staffID, new Nurse(staffID, name, age, gender, address, phone, department, shift, salary));
            
            System.out.println("Success"); 
            
        }
        
        return nurseList;
    }
    /**
     * Find nurses in nurse list by their name.
     * @param nurseList The nurse list to search in.
     * @throws Exception If an error occurs during finding the nurse.
     */
    public void findNurse(NurseList nurseList) throws Exception {
        
        String name = Validation.checkString("Enter the name of Nurse you want to find:");
        
        if(!(name.isEmpty())) {
            ArrayList<Nurse> nurses = new ArrayList<>();
            for (Entry<String, Nurse> entry : nurseList.entrySet()) {
                
                Nurse value = entry.getValue();
                if(value.getName().trim().contains(name.trim())) {
                    nurses.add(value);
                }
                
            }
            if(nurses.size() > 0) {
                for(int i=0; i < nurses.size(); i++) {
                    System.out.println(nurses.get(i));
                }
            }
            else
                System.out.println("The nurse does not exist");
        }
        else
            System.out.println("Error");
        
       
//        for(Nurse nurse: nurseList.values()) {
//            if(nurse.getName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
//                System.out.println(nurse.toString());
//                
//            }
//            else
//                System.out.println("Have an error");
//                
//        
//        }

    }
    
    /**
     * Updates the nurse have in 
     * @param nurse nurse to update.
     * @param nurseList
     * @throws Exception 
     */
    public void updateNurse(Nurse nurse, NurseList nurseList) throws Exception {
        String staffID = Validation.checkString("Please enter the StaffID of Nurse you want to update: ");
        
        nurse = nurseList.get(staffID);
        if(nurse != null) {
            int choice = 0;
            System.out.println("Which information you want to change( 1 -> 7): ");
            do {                    
                System.out.println("1.Name   2.Age   3.Address   4.Phone   5.Department");
                System.out.println("6.Shift  7.Salary");
                choice = Validation.checkInt("Enter your choice: ");
                switch(choice) {
                    case 1:       
                        String name  = Validation.checkString("Please enter name to update: ");
                        nurseList.get(staffID).setName(name);
                        System.out.println("Add successed");
                        break;
                    case 2:
                        int age =  Validation.checkInt("Please enter age to update: ");
                        nurseList.get(staffID).setAge(age);
                        System.out.println("Add successed");
                        break;
                    case 3:
                        String address = Validation.checkString("Please enter address to update: ");
                        nurseList.get(staffID).setAddress(address);
                        System.out.println("Add successed");
                        break;
                    case 4:
                        String phone =  Validation.checkString("Please enter phone to update: ");
                        nurseList.get(staffID).setPhone(phone);
                        System.out.println("Add successed");
                        break;
                    case 5:
                        String department = Validation.checkString("Please enter department to update: ");
                        nurseList.get(staffID).setDepartment(department);
                        System.out.println("Add successed");
                        break;
                    case 6:
                        String shift = Validation.checkString("Please enter shift to update: ");
                        nurseList.get(staffID).setShift(shift);
                        System.out.println("Add successed");
                        break;
                    case 7:
                        double salary = Validation.checkDouble("Please enter salary to update: ");
                        nurseList.get(staffID).setSalary(salary);
                        System.out.println("Add successed");
                        break;
                }
            } while ((choice > 0) && (choice < 8));
            
       
        } else {
            System.out.println("The nurse does not exist");
        }
        
        
        
        
            
        
    }
    
//    public void deleteNurse(NurseList nurseList, PatientList patientList) {
//        String staffID = Validation.checkString("Enter the StaffID of Nurse you want to delete: ");
//        try {
//            nurseList.remove(staffID);
//            System.out.println("Success");
//            if(staffID.isEmpty()) {
//                throw new Exception("Please enter StaffID!");
//            }
//            if(!(nurseList.containsKey(staffID))) {
//                throw new Exception("The nurse does not exist");
//            }
//            if(checkNurseWorking(staffID, nurseList, patientList) == false) {
//                throw new Exception("Nurse is working, can not delete");
//            }
//            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//        
//    }
    
    public void deleteNurse(NurseList nurseList, PatientList patientList) {
        String staffID = Validation.checkString("Enter the staffID of Nurse you want to delete: ");
        if(nurseList.get(staffID) == null) {
            System.out.println("The nurse doesn't exist");
        }
        if(checkNurseWorking(staffID, nurseList, patientList) == false) {
            System.out.println("The nurse is working, can't delete.");
        }
        else
            nurseList.remove(staffID);
        System.out.println("Success");
    }
    
    public boolean checkNurseWorking(String staffID, NurseList nurseList, PatientList patientList) {
        int check=0;
             
            for (Entry<String, Patient> entry : patientList.entrySet()) {
                Patient patient = entry.getValue();
                for (int i = 0; i < patient.getNurseAssigned().size(); i++) {
                    if(staffID.equalsIgnoreCase(patient.getNurseAssigned().get(i))) {
                        check++;
                    }
                }
                
            }
        return check != 0;
  
    }
    
    public boolean checkNurseMaximum(String staffID, NurseList nurseList, PatientList patientList) {
        int check=0;
        
        for(Entry<String, Patient> entry: patientList.entrySet()) {
            Patient patient = entry.getValue();
            for(int i=0; i < patient.getNurseAssigned().size(); i++) {
                if(staffID.equalsIgnoreCase(patient.getNurseAssigned().get(i))) {
                    check++;
                }
            }
        }
        return check < 2;
           
    }
        
    
}
                        