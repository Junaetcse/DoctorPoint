package com.example.junae.doctorpointnew.favorite_doctor;

/**
 * Created by junae on 12/4/2017.
 */

public class SqliteModel  {
    private String id;
    private String name;
    private String qualification;
    private String Designation;
    private String expertise;
    private String organization;
    private String chamber;
    private String visiting_Hours;
    private String location;
    private String phone;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getVisiting_Hours() {
        return visiting_Hours;
    }

    public void setVisiting_Hours(String visiting_Hours) {
        this.visiting_Hours = visiting_Hours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SqliteModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", Designation='" + Designation + '\'' +
                ", expertise='" + expertise + '\'' +
                ", organization='" + organization + '\'' +
                ", chamber='" + chamber + '\'' +
                ", visiting_Hours='" + visiting_Hours + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
