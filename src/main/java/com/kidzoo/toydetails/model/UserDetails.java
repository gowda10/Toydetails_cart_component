package com.kidzoo.toydetails.model;

import com.kidzoo.toydetails.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Details")
public class UserDetails {

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

    @Column(name = "billing_address")
    private @NotNull String billAdd;

    @Column(name = "shipping_address")
    private @NotNull String shipAdd;





    public String getFirstName() {
        return firstName;
    }

    public UserDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBillAdd() {
        return billAdd;
    }

    public UserDetails setBillAdd(String billAdd) {
        this.billAdd = billAdd;
        return this;
    }

    public String getShipAdd() {
        return shipAdd;
    }

    public UserDetails setShipAdd(String shipAdd) {
        this.shipAdd = shipAdd;
        return this;
    }

}
