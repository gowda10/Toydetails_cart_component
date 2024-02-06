package com.kidzoo.toydetails.dto.personalDetails;


import javax.validation.constraints.NotNull;

public class personalDetailsDto {
    private @NotNull String firstName;

    private @NotNull String lastName;

    private @NotNull String email;

    private @NotNull String billAdd;

    private @NotNull String shipAdd;

    public personalDetailsDto(String firstName, String lastName, String email, String billAdd, String shipAdd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.billAdd = billAdd;
        this.shipAdd = shipAdd;
    }

    public String getFirstName() {
        return firstName;
    }

    public personalDetailsDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public personalDetailsDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public personalDetailsDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBillAdd() {
        return billAdd;
    }

    public personalDetailsDto setBillAdd(String billAdd) {
        this.billAdd = billAdd;
        return this;
    }

    public String getShipAdd() {
        return shipAdd;
    }

    public personalDetailsDto setShipAdd(String shipAdd) {
        this.shipAdd = shipAdd;
        return this;
    }
}
