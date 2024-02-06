package com.kidzoo.toydetails.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Details")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "U_No")
    private Integer uNo;
    @Column(name = "first_name")
    private @NotNull String firstName;

    @Column(name = "last_name")
    private @NotNull String lastName;

    @Column(name = "email")
    private @NotNull String email;

    @Column(name = "phone_number")
    private @NotNull String phoneNumber;

    @Column(name = "address")
    private @NotNull String address;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public User getUser() {
        return user;
    }

    public PersonalDetails setUser(User user) {
        this.user = user;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonalDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonalDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonalDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PersonalDetails setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonalDetails setAddress(String address) {
        this.address = address;
        return this;
    }

}
