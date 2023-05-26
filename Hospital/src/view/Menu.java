
package view;

public class Menu {
    public static void hospitalMenu(Object[] options) {
        int choice = 0;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                          HOSPITAL MANAGEMENT                  |");
        System.out.println("-----------------------------------------------------------------");
        printChoice(options);
        System.out.println("|                                                               |");
        System.out.println("-----------------------------------------------------------------");
        
        
        
    }
    public static void showMenu() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                          HOSPITAL MANAGEMENT                  |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| 1. Nurse                                                      |");
        System.out.println("| 2. Patient                                                    |");
        System.out.println("| 3. Save data                                                  |");
        System.out.println("| 4. Load data                                                  |");
        System.out.println("| 5. Quit                                                       |");
        System.out.println("|                                                               |");
        System.out.println("-----------------------------------------------------------------");
    }
    public static void showNurseMenu() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                          NURSE'S MENU                         |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| 1. Create a Nurse                                             |");
        System.out.println("| 2. Find a Nurse                                               |");
        System.out.println("| 3. Update a Nurse                                             |");
        System.out.println("! 4. Delete a Nurse                                             |");
        System.out.println("| 5. Quit                                                       |");
        System.out.println("|                                                               |");
        System.out.println("-----------------------------------------------------------------");
    }
    public static void showPatientMenu() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                          PATIENT'S MENU                       |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| 1. Add a Patient                                              |");
        System.out.println("| 2. Dispaly Patients                                           |");
        System.out.println("| 3. Sort Patients                                              |");
        System.out.println("| 4. Quit                                                       |");
        System.out.println("|                                                               |");
        System.out.println("-----------------------------------------------------------------");
    }
    
    public static void showSortPatientMenu(String sortedField, String sortPatient) {

        System.out.println("\nLIST OF PATIENTS");
        System.out.println("Sorted by: patient's " + sortedField);
        System.out.println("Sort order: " + sortPatient);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-12s | %-14s | %-20s | %12s | %-14s |\n", "No.", "Patient Id", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public static void printChoice(Object[] options) {
        for (int i=0; i < options.length; i++) {
            System.out.printf("| %2d. %-58s| \n ",(i+1),options[i]);
        }
    }
    
    public static void menuChoice(String[] options) {
        System.out.println("---------------------");
        for (int i=0; i < options.length; i++) {
            System.out.printf("| %2d. %-58s| \n ",(i+1),options[i]);
        }
        System.out.println("---------------------");
        
    }
}
