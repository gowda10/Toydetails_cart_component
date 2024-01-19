package com.kidzoo.toydetails.dto.user;


import javax.validation.constraints.NotNull;

public class UserDetailsDto {

    private Integer uNo;

    private @NotNull String firstName;

    private @NotNull String lastName;

    private @NotNull String email;

    private @NotNull String billAdd;

    private @NotNull String shipAdd;

    public UserDetailsDto(String firstName, String lastName, String email, String billAdd, String shipAdd) {
        this.uNo = uNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.billAdd = billAdd;
        this.shipAdd = shipAdd;
    }

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
