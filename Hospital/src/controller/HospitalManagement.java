
package controller;

import business.NurseList;
import business.PatientList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The HospitalManagement class represents a hospital and provides methods to read and write NurseList and PatientList objects to/from files.
 * It implements Serializable.
 */
public class HospitalManagement implements Serializable{
    
    /**
     * Reads a NurseList object from the specified file.
     * @param path The path of the file where to read the NurseList object.
     * @return The NurseList object read from the file.
     * @throws Exception If an error occurs during file reading.
     */
    public NurseList readNurseFromFile(String path) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        NurseList nl = (NurseList) objectInputStream.readObject();
        
        return nl;
    }
    
    /**
     * Writes a NurseList object to the specified file.
     * @param path The path of the file where the NurseList object should be written.
     * @param nurseList The NurseList object to write to a file.
     * @throws Exception If an error occurs during file writing.
     */
    public void writeNurseToFile(String path, NurseList nurseList) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(nurseList);
        
    } 
    
    /**
     * Reads a NurseList object from the specified file.
     * @param path The path of the file where to read the PatientList object.
     * @return The PatientList object read from the file.
     * @throws Exception If an error occurs during file reading.
     */
    public PatientList readPatientFromFile(String path) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        PatientList pt = (PatientList) objectInputStream.readObject();
        
        return pt;
    }
    
    /**
     * Writes a PatienList object to the specified file.
     * @param path The path of the where the PatientList object should be written.
     * @param patientList The PatientList object to write to a file.
     * @throws Exception If an error occurs during file writing. 
     */
    public void writePatientToFile(String path, PatientList patientList) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(patientList);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());   
        }
        
    }
    
}
