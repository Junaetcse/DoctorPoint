package com.example.junae.doctorpointnew.medicine_department.models;

/**
 * Created by USER on 11/16/2017.
 */

public class DataSet {
    String patientId;
    String patient_name;
    String patient_address;
    String patient_date;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getPatient_date() {
        return patient_date;
    }

    public void setPatient_date(String patient_date) {
        this.patient_date = patient_date;
    }
}
