package com.example.ahmed.sfa.models;

/**
 * Created by DELL on 3/11/2017.
 */

public class Tr_NewCustomer{

    private String newCustomerID;
    private String customerName;
    private  String address;
    private  String contactNo;
    private  int uploadedStatus;
    private  int approvedStatus;


    public String getNewCustomerID() {
        return newCustomerID;
    }

    public void setNewCustomerID(String newCustomerID) {
        this.newCustomerID = newCustomerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getUploadedStatus() {
        return uploadedStatus;
    }

    public void setUploadedStatus(int uploadedStatus) {
        this.uploadedStatus = uploadedStatus;
    }

    public int getApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(int approvedStatus) {
        this.approvedStatus = approvedStatus;
    }
}
