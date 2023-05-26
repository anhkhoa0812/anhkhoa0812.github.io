/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import model.Patient;
import util.Validation;
import view.Menu;

/**
 *
 * @author tahoa
 */
public class PatientList extends HashMap<String, Patient> implements Serializable{
    
    public Patient addPatient(PatientList patientList, NurseList nurseList) {
        
        String id = Validation.checkString("Please enter the ID of Patient: ");
        if(patientList.containsKey(id)) {
            do {                
  
            System.out.println("Duplicate!");
            id = Validation.checkString("Enter the ID of Patient again: ");
            } while (patientList.containsKey(id));
        }
        
            String name = Validation.checkString("Plese enter the name of Patient:");
            int age = Validation.checkInt("Please enter the age of Patient:");
            String gender = Validation.checkString("Please enter the gender of Patient:");
            String address = Validation.checkString("Plese enter the address of Patient: ");
            String phone = Validation.checkString("Please enter the phone of Patient: ");
            String diagnosis = Validation.checkString("Please enter the diagnosis of Patient: ");
            String addmissionDate = Validation.checkDate("Please enter the addmisson date of Patient: ");
            String dischargeDate = Validation.checkDate("Please enter the discharge date of Patient: ");
            
            ArrayList<String> nurseAssigned = new ArrayList<>();
            
            String staffID1 = Validation.checkString("Enter the first Nurse Assigned: ");
//            if(nurseList.get(staffID1)  == null) {
//                do {                    
//                System.out.println("The nurse doesn't exist");
//                staffID1 = Validation.checkString("Enter the first Nurse Assigned again: ");
//                } while (true);
//            }
            
            String staffID2 = Validation.checkString("Enter the second Nurse Assigned: ");
             
//           if(nurseList.get(staffID2) == null) {
//                do {                                        
//                System.out.println("The nurse doesn't exist");
//                staffID2 = Validation.checkString("Enter the second Nurse Assigned again: ");
//                } while (true);
//            }
            
            if(nurseList.checkNurseMaximum(staffID1, nurseList, patientList) == false) {
                System.out.println("The nurse can't take more patient.");
            }
            if(nurseList.checkNurseMaximum(staffID2, nurseList, patientList) == false) {
                System.out.println("The nurse can't take more patient.");
            }
            nurseAssigned.add(staffID1);
            nurseAssigned.add(staffID2);
        
        Patient patient = new Patient(id, name, age, gender, address, phone, diagnosis, addmissionDate, dischargeDate, nurseAssigned);
        patientList.put(id, patient);
        return patient;
        

    }
    
    /**
     * Displays the list of patients within a specified date range.
     * @param patientList The patient list.
     * @throws Exception If an error occurs during displaying patients.
     */
    public void displayPatients(PatientList patientList) throws Exception {
        String startdateString = Validation.checkDate("Enter the Start Date of Patient: ");
        String endDateString = Validation.checkDate("Enter the End Date of Patient: ");
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse(startdateString);
        Date endDate = sdf.parse(endDateString);
        
        System.out.println("LIST OF PATIENTS");
        System.out.println("Start date: " + startDate);
        System.out.println("End date: " + endDate);
        System.out.println("-------------------------------------------------------------------------------------------------");       
        System.out.printf("| %-5s | %-12s | %-14s | %-20s | %12s | %-15s |\n", "No.", "Patient Id", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.println("-------------------------------------------------------------------------------------------------"); 
        
        for (PatientList.Entry<String, Patient> entry : patientList.entrySet()) {
            Patient patient = entry.getValue();
            
            Date patientDate = sdf.parse(patient.getAdmissionDate());
            if(patientDate.before(endDate) && patientDate.after(startDate)) {
                System.out.printf(patient.print());
                System.out.println("-------------------------------------------------------------------------------------------------"); 
                
            }
            
        }
    }
    
    /**
     * Sorts the patients in the patient list based on specified field within name or id of patients.
     * @param patientList the patient list.
     */
    public void sortPatients(PatientList patientList) {
        ArrayList<Patient> patients = new ArrayList<>(patientList.values());
        if(patients.isEmpty()) {
            System.out.println("No patient in hospital");
        }
        else {
            String sortedField = Validation.checkString("Enter the sorted field(id or name): ");
            String sortPatient = Validation.checkString("Enter the sort patient(ASC or DESC): ");
            Menu.showSortPatientMenu(sortedField, sortPatient);
            
            if(sortedField.equalsIgnoreCase("id") && sortPatient.equalsIgnoreCase("ASC")) {
                Comparator<Patient> comparator = new Comparator<Patient>() {
                    @Override
                    public int compare(Patient o1, Patient o2) {
                        return o2.getId().compareTo(o1.getId());
                    }
                };
                Collections.sort(patients, comparator);
                
                for(int i=0; i < patients.size(); i++) {
                    
                    System.out.print(patients.get(i).print());
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
               
            }
            
            if(sortedField.equalsIgnoreCase("id") && sortPatient.equalsIgnoreCase("DESC")) {
                Comparator comparator = new Comparator<Patient>() {
                    @Override
                    public int compare(Patient o1, Patient o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                };
                Collections.sort(patients, comparator);
                for(int i=0;i< patients.size(); i++) {
                    System.out.print(patients.get(i).print());
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
            }
            
            if(sortedField.equalsIgnoreCase("name") && sortPatient.equalsIgnoreCase("ASC")) {
                Comparator comparator = new Comparator<Patient>() {
                    @Override
                    public int compare(Patient o1, Patient o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                };
                Collections.sort(patients, comparator);
                for(int i=0; i < patients.size(); i++) {
                    System.out.print(patients.get(i).print());
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
            }
            
            if(sortedField.equalsIgnoreCase("name") && sortPatient.equalsIgnoreCase("DESC")) {
                Comparator comparator = new Comparator<Patient>() {
                    @Override
                    public int compare(Patient o1, Patient o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
                Collections.sort(patients, comparator);
                for(int i=0; i < patients.size(); i++) {
                    System.out.print(patients.get(i).print());
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
            
            }
            
        }
            
                
            
    }

    

        
            
        
        
        
       
        
        
        
        
        
    
}
