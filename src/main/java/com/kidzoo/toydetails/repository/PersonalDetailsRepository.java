package com.kidzoo.toydetails.repository;

import com.kidzoo.toydetails.model.PersonalDetails;
import com.kidzoo.toydetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {
    PersonalDetails findByUser(User user);
}
