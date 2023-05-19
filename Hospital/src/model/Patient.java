
package model;

public class Patient extends Person {
    
    String diagnosis, addmissionDate, dischargeDate, nurseAssigned;

    public Patient(String id, String name, int age, String gender, String address, 
            String phone, String diagnosis, String addmissionDate, String dischargeDate, String nurseAssigned) {
        super(id, name, age, gender, address, phone);
        this.diagnosis = diagnosis;
        this.addmissionDate = addmissionDate;
        this.dischargeDate = dischargeDate;
        this.nurseAssigned = nurseAssigned;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getAddmissionDate() {
        return addmissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public String getNurseAssigned() {
        return nurseAssigned;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setAddmissionDate(String addmissionDate) {
        this.addmissionDate = addmissionDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public void setNurseAssigned(String nurseAssigned) {
        this.nurseAssigned = nurseAssigned;
    }

    @Override
    public String toString() {
        return super.id + ", " + super.name + ", " + super.age + ", " + super.gender + ", " + super.address
            + ", " + super.phone + ", " + diagnosis + ", " + addmissionDate + ", " + dischargeDate + ", " + nurseAssigned;
    }
    
    
    
}
