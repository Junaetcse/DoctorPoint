package com.example.junae.doctorpointnew.ambulance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by junae on 11/23/2017.
 */

public class AmbulanceModel {

    @SerializedName("hospital_name")
    @Expose
    private String hospitalName;
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
