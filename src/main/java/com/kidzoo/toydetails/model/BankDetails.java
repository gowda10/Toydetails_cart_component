package com.kidzoo.toydetails.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Bank_Details")
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String IFSCCode;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public BankDetails() {
    }

    public BankDetails(Integer id, String accountHolderName, String accountNumber, String bankName, String IFSCCode, User user) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.IFSCCode = IFSCCode;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public BankDetails setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public BankDetails setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankDetails setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public BankDetails setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public BankDetails setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
        return this;
    }

    public User getUser() {
        return user;
    }

    public BankDetails setUser(User user) {
        this.user = user;
        return this;
    }
}
