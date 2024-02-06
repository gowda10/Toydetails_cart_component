package com.kidzoo.toydetails.service;


import com.kidzoo.toydetails.dto.personalDetails.PersonalDetailsDto;
import com.kidzoo.toydetails.model.PersonalDetails;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalDetailsService {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;


    public PersonalDetails getPersonalDetailsByUser(User user){
        return personalDetailsRepository.findByUser(user);
    }
    public PersonalDetails addPersonalDetails(User user, PersonalDetailsDto personalDetailsDto) {
           PersonalDetails personalDetails = new PersonalDetails();
           personalDetails.setUser(user);
           personalDetails.setFirstName(personalDetailsDto.getFirstName());
           personalDetails.setLastName(personalDetailsDto.getLastName());
           personalDetails.setEmail(personalDetailsDto.getEmail());
           personalDetails.setPhoneNumber(personalDetailsDto.getPhoneNumber());
           personalDetails.setAddress(personalDetailsDto.getAddress());
        return personalDetailsRepository.save(personalDetails);
        }
}