package com.kidzoo.toydetails.controller;


import com.kidzoo.toydetails.dto.ResponseDto;
import com.kidzoo.toydetails.dto.user.*;
import com.kidzoo.toydetails.exception.AuthenticationFailException;
import com.kidzoo.toydetails.exception.CustomException;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.repository.UserRepository;
import com.kidzoo.toydetails.service.AuthenticationService;
import com.kidzoo.toydetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/toydetails/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

//    @PostMapping("/updateUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//        authenticationService.authenticate(token);
//        return userService.u(token, userUpdateDto);
//    }


    @PostMapping("/createUser")
    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
            throws CustomException, AuthenticationFailException {
        authenticationService.authenticate(token);
        return userService.createUser(token, userCreateDto);
    }
}
