
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Patient class represents a patient in hospital.
 * It extends the Person class and implements Serializable.
 */
public class Patient extends Person implements Serializable{
    private String diagnosis, admissionDate, dischargeDate;
    private ArrayList<String> nurseAssigned;

    /** 
     * Default constructor for the Patient class.
     */
    public Patient() {
    }
    
    /**
     * Parameterized constructor for the Patient class.
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param address
     * @param phone
     * @param diagnosis
     * @param addmissionDate
     * @param dischargeDate
     * @param nurseAssigned 
     */
    
    /**
     * Parameterized constructor for the Patient class.
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param address
     * @param phone
     * @param diagnosis
     * @param addmissionDate
     * @param dischargeDate
     * @param nurseAssigned 
     */
    public Patient(String id, String name, int age, String gender, String address,
            String phone, String diagnosis, String addmissionDate, String dischargeDate, ArrayList<String> nurseAssigned) {
        super(id, name, age, gender, address, phone);
        this.diagnosis = diagnosis;
        this.admissionDate = addmissionDate;
        this.dischargeDate = dischargeDate;
        this.nurseAssigned = nurseAssigned;
    }

    /**
     * Get the diagnosis of the patient.
     * @return the diagnosis of the patient.
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Set the diagnosis of the patient.
     * @param diagnosis the diagnosis to get.
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Get the Admission date of the patient.
     * @return the Admission date of the patient.
     */
    public String getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Set the Admission date of the patient.
     * @param admissionDate the Admission date to get.
     */
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * Get the Discharge date of the patient.
     * @return the Discharge date of the patient.
     */
    public String getDischargeDate() {
        return dischargeDate;
    }

    /**
     * Set the Discharge date of the patient.
     * @param dischargeDate the Discharge date to get.
     */
    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    
    public ArrayList<String> getNurseAssigned() {
        return nurseAssigned;
    }

    public void setNurseAssigned(ArrayList<String> nurseAssigned) {
        this.nurseAssigned = nurseAssigned;
    }

    /**
     * Get a string to representation of the Patient project.
     * @return a string to representation of the Patient project.
     */
    @Override
    public String toString() {
        return super.id + ", " + super.name + ", " + super.age + ", " + super.gender + ", " + super.address 
                + ", " + super.phone + ", " + diagnosis + ", " + admissionDate + 
                ", " + dischargeDate + ", " + nurseAssigned;
    }
    /**
     * Get a formatted string representation of the Patient object.
     * @return a formatted string representation of the Patient object.
     */
    public String print() {
        return String.format("| %-5s | %-12s | %-14s | %-20s | %12s | %-14s |\n", "No.", id, admissionDate, name, phone, diagnosis);
    }
    
    
    
    
    
    
}
