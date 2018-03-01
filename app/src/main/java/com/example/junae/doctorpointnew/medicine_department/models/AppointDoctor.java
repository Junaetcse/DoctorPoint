package com.example.junae.doctorpointnew.medicine_department.models;

/**
 * Created by USER on 11/9/2017.
 */

public class AppointDoctor {

    private String doctorId;
    private String patientSerial;
    private String patientName;
    private String patientAddress;
    private String patientNumber;
    private String patientDate;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientSerial() {
        return patientSerial;
    }

    public void setPatientSerial(String patientSerial) {
        this.patientSerial = patientSerial;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientDate() {
        return patientDate;
    }

    public void setPatientDate(String patientDate) {
        this.patientDate = patientDate;
    }
}
