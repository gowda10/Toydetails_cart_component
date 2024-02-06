package com.kidzoo.toydetails.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Details")
public class personalDetails {

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

    public personalDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public personalDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public personalDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBillAdd() {
        return billAdd;
    }

    public personalDetails setBillAdd(String billAdd) {
        this.billAdd = billAdd;
        return this;
    }

    public String getShipAdd() {
        return shipAdd;
    }

    public personalDetails setShipAdd(String shipAdd) {
        this.shipAdd = shipAdd;
        return this;
    }

}
