package com.kidzoo.toydetails.service;

import com.kidzoo.toydetails.dto.bankDetails.BankDetailsDto;
import com.kidzoo.toydetails.model.BankDetails;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDetailsService {

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    public BankDetails getBankDetailsByUser(User user) {
        return bankDetailsRepository.findByUser(user);
    }

    public BankDetails saveBankDetails(User user, BankDetailsDto bankDetailsDto) {
        BankDetails bankDetails = new BankDetails();
        bankDetails.setBankName(bankDetailsDto.getBankName());
        bankDetails.setAccountHolderName(bankDetailsDto.getAccountHolderName());
        bankDetails.setAccountNumber(bankDetailsDto.getAccountNumber());
        bankDetails.setIFSCCode(bankDetailsDto.getIFSCCode());
        bankDetails.setUser(user);
        return bankDetailsRepository.save(bankDetails);
    }

    public void deleteBankDetails(BankDetails bankDetails) {
        bankDetailsRepository.delete(bankDetails);
    }
}