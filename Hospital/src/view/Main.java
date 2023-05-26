
package view;

import business.NurseList;
import business.PatientList;
import controller.HospitalManagement;
import java.util.ArrayList;
import java.util.HashMap;
import model.Nurse;
import model.Patient;
import util.Validation;

public class Main {
    public static void main(String[] args) throws Exception {
        final String filePath1 = "src\\output\\nurses.dat";
        final String filePath2 = "src\\output\\patients.dat";
        
        
        HospitalManagement hospital = new HospitalManagement();
        NurseList nurseList = new NurseList();
       
        Nurse nurse1 = new Nurse("SE173070", "khoaa", 23, "nam", "erqwerqw", "qrqrqqrq", "fasdfasdf", "adfsdfasdfasdf", 214141);
        Nurse nurse2 = new Nurse("SE1770", "minh", 20, "nam", "qewrqwer", "qưerqwer", "ưqerasdf", "gádasdss", 234242342);
        Nurse nurse3 = new Nurse("SE174470", "beo", 123, "nu", "dgdfh", "sdfds", "jfgjf", "tfgd", 5656744);
        
        
        Nurse nurse = new Nurse();
        nurseList.put(nurse1.getStaffID(), nurse1);
        nurseList.put(nurse2.getStaffID(), nurse2);
        nurseList.put(nurse3.getStaffID(), nurse3);
        
        PatientList patientList = new PatientList();
        ArrayList<String> nurseAssigned = new ArrayList<>();
        nurseAssigned.add("SE173070");
        nurseAssigned.add("SE1770");
        
        ArrayList<String> nurseAssigned1 = new ArrayList<>();
        nurseAssigned1.add("SE1770");
        nurseAssigned1.add("SE174470");
        Patient patient1 = new Patient("P0006", "Cir Smith", 20, "Men", "USA", "0914174213", "Flu", "11/04/2023", "15/04/2023", nurseAssigned );
        Patient patient2 = new Patient("P0007", "Bill Jamie", 25, "Women", "Canada", "0914242213", "Fever", "12/04/2023", "15/04/2023", nurseAssigned1);
//        Patient patient3 = new Patient("P0008", "Ann Smith", 20, "Men", "England", "0914171246", "Cough", "13/04/2023", "15/04/2023", "khoa");
        patientList.put(patient1.getId(), patient1);
        patientList.put(patient2.getId(), patient2);
//        patientList.put(patient3.getId(), patient3);
        
//        patientList.displayPatients(patientList);
        
        
        
        int choice;
        do {  
            String[] hospitalOptions = {"Nurse","Patient","Save data","Load data","Quit"};
            Menu.hospitalMenu(hospitalOptions);
            choice = Validation.checkInt("Enter your choice(1->5): ");
            
            switch(choice) {
                case 1: 
                    Menu.showNurseMenu();
                    int nurseChoice = Validation.checkInt("Enter your choice(1->5): ", 5);
                    switch(nurseChoice) {
                        case 1:
                            while(true) {                                                                
                            nurseList.createNurse(nurseList);
                            String choice1 = Validation.confirmYesOrNo("Do you want to continue(Y/N): ");
                            if(choice1.equalsIgnoreCase("Y")) {
                                nurseList.createNurse(nurseList);
                            }
                            if(choice1.equalsIgnoreCase("N")) {
                                System.out.println("End!!!!!");
                                break;
                            }  
                            }
                            
                        case 2:
                            nurseList.findNurse(nurseList);
                            break;
                        case 3:
                            nurseList.updateNurse(nurse, nurseList);
                            break;
                        case 4: 
                            nurseList.deleteNurse(nurseList, patientList);
                            break;
                        default:
                            System.out.println("From 1-> 4");
                            
                    }
                case 2:
                    Menu.showPatientMenu();
                    int patientChoice = Validation.checkInt("Enter your choice(1->4)", 4);
                    switch(patientChoice) {
                        case 1:
                            patientList.addPatient(patientList, nurseList);
                            break;
                        case 2: 
                            patientList.displayPatients(patientList);
                            break;
                        case 3:
                            patientList.sortPatients(patientList);
                            break;
                        case 4:
                        
                    }
                case 3:
                    
            }
        } while (true);
       

        
        


        

    }
}
