package com.kidzoo.toydetails.controller;

import com.kidzoo.toydetails.dto.bankDetails.BankDetailsDto;
import com.kidzoo.toydetails.exception.CustomException;
import com.kidzoo.toydetails.model.BankDetails;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.service.AuthenticationService;
import com.kidzoo.toydetails.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toydetails/v1/bankDetails")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public BankDetails addBankDetails(@RequestHeader("token") String token, @RequestBody BankDetailsDto bankDetailsDto) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        BankDetails bankDetails = bankDetailsService.saveBankDetails(user, bankDetailsDto);
        return bankDetails;
    }

    @GetMapping("/getBankDetails")
    public BankDetails getBankDetailsByUser(@RequestHeader("token") String token) {
        User user = authenticationService.getUser(token);
        BankDetails bankDetails = bankDetailsService.getBankDetailsByUser(user);
        if (bankDetails == null) {
            throw new CustomException("Bank details not found for user with id: " + token);
        }

        return bankDetails;
    }

    @DeleteMapping("/deleteBankDetails")
    public void deleteBankDetailsByUser(@RequestHeader("token") String token) {
        User user = authenticationService.getUser(token);
        BankDetails bankDetails = bankDetailsService.getBankDetailsByUser(user);
        if (bankDetails == null) {
            throw new CustomException("Bank details not found for user with id: " + token);
        }
        bankDetailsService.deleteBankDetails(bankDetails);
    }
}