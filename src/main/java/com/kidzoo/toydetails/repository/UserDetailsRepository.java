package com.kidzoo.toydetails.repository;

import com.kidzoo.toydetails.model.personalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<personalDetails, Integer> {
}
