
package view;

import business.NurseList;
import controller.Hospital;
import java.util.ArrayList;
import java.util.Scanner;
import model.Nurse;

public class Main {
    public static void main(String[] args) throws Exception {
        final String filePath1 = "src\\output\\patients.dat";
        
        NurseList nurseList = new NurseList();
        Hospital hospital = new Hospital();
        
        Nurse nurse = new Nurse();
       
        
        nurseList.deleteNurse();
        
        
//        nurseList.createNurse(nurse);
        
//        ArrayList<Nurse> nurses = new ArrayList<>();
//        System.out.println("Enter name: ");
//        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine();
//        nurses = nurseList.findNurse(name);
//        for(Nurse n: nurses) {
//            System.out.println(n.toString());
//        }



        
    }
}
