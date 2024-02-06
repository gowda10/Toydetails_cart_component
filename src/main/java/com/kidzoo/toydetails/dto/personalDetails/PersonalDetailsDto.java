package com.kidzoo.toydetails.dto.personalDetails;


import javax.validation.constraints.NotNull;

public class PersonalDetailsDto {
    private @NotNull String firstName;

    private @NotNull String lastName;

    private @NotNull String email;

    private @NotNull String phoneNumber;

    private @NotNull String address;

    public PersonalDetailsDto() {
    }

    public PersonalDetailsDto(String firstName, String lastName, String email, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonalDetailsDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonalDetailsDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonalDetailsDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PersonalDetailsDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonalDetailsDto setAddress(String address) {
        this.address = address;
        return this;
    }
}
