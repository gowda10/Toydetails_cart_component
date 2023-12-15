package com.kidzoo.toydetails.dto.user;


public class UserDetailsDto {

    private Integer uNo;

    private  String firstName;

    private  String lastName;

    private  String email;

    private  String billAdd;

    private  String shipAdd;

    public Integer getuNo() {
        return uNo;
    }

    public UserDetailsDto setuNo(Integer uNo) {
        this.uNo = uNo;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDetailsDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetailsDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDetailsDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBillAdd() {
        return billAdd;
    }

    public UserDetailsDto setBillAdd(String billAdd) {
        this.billAdd = billAdd;
        return this;
    }

    public String getShipAdd() {
        return shipAdd;
    }

    public UserDetailsDto setShipAdd(String shipAdd) {
        this.shipAdd = shipAdd;
        return this;
    }
}
