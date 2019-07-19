package com.gwazasoftwares.uhcregistration.models;

public class RegData {

    private  String fullName;
    private  String dob;
    private  String id;
    private  String gender;
    private  String county;
    private  String employer;

    public RegData() {
    }

    public RegData(String fullName, String dob, String id, String gender, String county, String employer) {
        this.fullName = fullName;
        this.dob = dob;
        this.id = id;
        this.gender = gender;
        this.county = county;
        this.employer = employer;
    }

    public RegData(String fullName, String gender, String county) {
        this.fullName = fullName;
        this.gender = gender;
        this.county = county;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
}
