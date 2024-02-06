package com.kidzoo.toydetails.controller;

import com.kidzoo.toydetails.dto.personalDetails.PersonalDetailsDto;
import com.kidzoo.toydetails.exception.AuthenticationFailException;
import com.kidzoo.toydetails.exception.CustomException;
import com.kidzoo.toydetails.model.PersonalDetails;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.service.AuthenticationService;
import com.kidzoo.toydetails.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toydetails/v1/personal-details")
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService personalDetailsService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/")
    public PersonalDetails addPersonalDetails(@RequestBody PersonalDetailsDto personalDetailsDto, @RequestHeader("token")String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        PersonalDetails personalDetails = personalDetailsService.addPersonalDetails(user, personalDetailsDto);
        return personalDetails;
    }
}