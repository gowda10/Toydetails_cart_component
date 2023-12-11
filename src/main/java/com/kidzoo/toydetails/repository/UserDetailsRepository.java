package com.kidzoo.toydetails.repository;

import com.kidzoo.toydetails.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails , Integer> {
}
