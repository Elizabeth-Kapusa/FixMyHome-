package com.example.image;

import android.widget.EditText;

public class User {
    private String fullname;
    private String region;
    private String city;
    private String physicalAddress;
    private String contactNumber;
    private String complaintInfo;

    public User(EditText fullname, EditText regionn, EditText cityy, EditText physicalAddresss, EditText contactNo, EditText complaintInformation) {
        this.fullname = this.fullname;
        this.region = region;
        this.city = city;
        this.physicalAddress = physicalAddress;
        this.contactNumber = contactNumber;
        this.complaintInfo = complaintInfo;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getComplaintInfo() {
        return complaintInfo;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setComplaintInfo(String complaintInfo) {
        this.complaintInfo = complaintInfo;
    }
}
